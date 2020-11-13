package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ShopListActivity extends AppCompatActivity {
    private ListView myListView;
    //设置标题，价格，图片集合
    private String[] titles ={"桌子","苹果","水杯","餐巾","炒锅"};
    private String[] prices={"1500RMB","12RMB/KG","25RMB","12RMB","96RMB"};
    private int[] icon={};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoplist);
        myListView = findViewById(R.id.lv);
        MyBaseAdapter myBaseAdapter = new MyBaseAdapter();
        myListView.setAdapter(myBaseAdapter);
    }

    private class MyBaseAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object getItem(int position) {
            return titles[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if(convertView == null){
                convertView = View.inflate(ShopListActivity.this,R.layout.list_item,null);
                holder = new ViewHolder();
                holder.title = convertView.findViewById(R.id.title);
                holder.price = convertView.findViewById(R.id.price);
                convertView.setTag(holder);
            }else{
                holder =(ViewHolder) convertView.getTag();
            }
                holder.title.setText(titles[position]);
                holder.price.setText(prices[position]);
            return convertView;
        }
    }
}