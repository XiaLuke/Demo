package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class GroupLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grouplayout_activity);
        final TextView textval = findViewById(R.id.textval);
        RadioGroup place = findViewById(R.id.visit_group);
        place.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.place){
                    textval.setText("地点一");
                }else if (checkedId == R.id.place1){
                    textval.setText("地点二");
                }else if (checkedId == R.id.place2){
                    textval.setText("地点三");
                }else if (checkedId == R.id.place3){
                    textval.setText("地点四");
                }else if (checkedId == R.id.place4){
                    textval.setText("地点五");
                }

            }
        });
    }
}