package com.example.administrator.butterknife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.imageView)
    void post(){
        System.out.println("---------------------------------------");
        EventBus.getDefault().post(new MessageEvent("这是从Main2Activity发来的消息!"));
    }
}
