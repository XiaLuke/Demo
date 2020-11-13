package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private String hobby;
    private TextView hobbittext;
    private ProgressBar progress_bar_h;
    //输入框中数据
    private EditText editText;
    //展示数据
    private TextView TextValueText;
    //兴趣复选框
    private CheckBox hobbit1;
    private CheckBox hobbit2;
    private CheckBox hobbit3;
    //性别
    RadioGroup viewById;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainMethod();
        SubmitMethod();
        jindutiao();
    }

    private void SubmitMethod() {
        //页面上方按钮，没有作用
        Button submit = findViewById(R.id.submitval);
        editText = findViewById(R.id.edittext);
        TextValueText = findViewById(R.id.textvaluetext);
        //使用匿名内部内
        /*submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
        submit.setOnClickListener(this);
    }

    private void MainMethod() {
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "you clicked Button1", Toast.LENGTH_SHORT).show();
            }
        });

        /**
         * RadioGroup1
         * */
        viewById = findViewById(R.id.rgid);
        final TextView textid = findViewById(R.id.textid);
        viewById.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioid) {
                    Toast.makeText(MainActivity.this, "您所选择的性别为：男", Toast.LENGTH_SHORT).show();
                    textid.setText("您所选择的性别为：男");
                } else {
                    textid.setText("您所选择的性别为：女");
                    Toast.makeText(MainActivity.this, "您所选择的性别为：女", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /**
         * CheckBox
         * */
        hobbit1 = findViewById(R.id.hobbit1);
        hobbit2 = findViewById(R.id.hobbit2);
        hobbit3 = findViewById(R.id.hobbit3);
        hobbit1.setOnCheckedChangeListener(this);
        hobbit2.setOnCheckedChangeListener(this);
        hobbit3.setOnCheckedChangeListener(this);
        hobbittext = findViewById(R.id.hobbittext);
        hobby = new String();
    }

    //进度条点击增加与减少
    private void jindutiao() {
        progress_bar_h = findViewById(R.id.progress_bar_h);
        Button jiabtn = findViewById(R.id.jianbtn);
        Button jianbtn = findViewById(R.id.jiabtn);
        jiabtn.setOnClickListener(this);
        jianbtn.setOnClickListener(this);
    }

    //setOnCheckChangeListener(this)调用的方法
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String notify = buttonView.getText().toString();
        if (isChecked) {
            if (!hobby.contains(notify)) {
                hobby = hobby + notify;
                Toast.makeText(MainActivity.this, hobby, Toast.LENGTH_SHORT).show();
                hobbittext.setText(hobby);
            }
        } else {
            if (hobby.contains(notify)) {
                hobby = hobby.replace(notify, "");
                hobbittext.setText(hobby);
            }
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.jiabtn:
                setEditText(true);
                break;
            case R.id.jianbtn:
                setEditText(false);
                break;
            case R.id.submitval:
//                Toast.makeText(MainActivity.this,"1111111111111111111111",Toast.LENGTH_SHORT).show();
                submitmethod();
                break;
            default:
                break;
        }
    }

    /*点击提交展示出的弹出框*/
    private void submitmethod() {
        AlertDialog dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("title")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("走吧")
                .setPositiveButton("sure", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        getEditVlaue();
//                        Toast.makeText(MainActivity.this,"aaaaa",Toast.LENGTH_SHORT).show();
                        //直接退出应用
//                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        dialog = builder.create();
        dialog.show();

    }

    /*弹出框点击提交*/
    private void getEditVlaue() {
        hobbit1 = findViewById(R.id.hobbit1);
        hobbit2 = findViewById(R.id.hobbit2);
        hobbit3 = findViewById(R.id.hobbit3);
//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append("ssss+${hobbit1}");
        //获取输入框中数据
        String text = editText.getText().toString();
        //获取单选框中数据
        String single = "";
        //获取多选框数据
        String more = "";
        for (int i = 0; i < viewById.getChildCount(); i++) {
            RadioButton childAt = (RadioButton) viewById.getChildAt(i);
            if (childAt.isChecked()) {
                single = childAt.getText().toString();
                break;
            }
        }
        if (hobbit1.isChecked())
            more += hobbit1.getText().toString();
        if (hobbit2.isChecked())
            more += hobbit2.getText().toString();
        if (hobbit3.isChecked())
            more += hobbit3.getText().toString();

        TextValueText.setText(text + single + "选中的为：" + more);
    }

    private void setEditText(boolean b) {
        int progress = progress_bar_h.getProgress();
        if (b) {
            progress += 10;
            if (progress > 100) {
                progress = 100;
            }
        } else {
            progress -= 10;
            if (progress < 0) {
                progress = 0;
            }
        }
        progress_bar_h.setProgress(progress);
    }
}