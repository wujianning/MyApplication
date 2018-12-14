package com.wjn.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wjn.myapplication.R;

import createsdkdemo.wjn.com.mylibrary.activity.OtherActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private TextView resultTextView;
    private static final int REQUESTCODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView=findViewById(R.id.activity_main_resulttextview);
        textView=findViewById(R.id.activity_main_textview);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,OtherActivity.class);
                intent.putExtra("name","17710029800");
                intent.putExtra("pwd","654321");
                startActivityForResult(intent, REQUESTCODE);
            }
        });

        ImageView imageView=findViewById(R.id.activity_main_imageview);
        String url="http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
        Glide.with(this)
                .load(url)
                .into(imageView);

    }

    /**
     * onActivityResult方法
     * */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUESTCODE ) {
            if (data != null) {
                String name=data.getStringExtra("name");
                String pwd=data.getStringExtra("pwd");
                String result=data.getStringExtra("result");
                String str="您输入的用户名："+name+"\n"+"密码："+pwd+"\n"+"登录结果："+result;
                resultTextView.setText(str);
            }
        }
    }

}
