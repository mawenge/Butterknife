package com.example.administrator.butterknife;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    ValueAnimator valueAnimator ;

    @OnClick(R.id.button)
    void breake(){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivityForResult(intent, 100);

    }

    @BindView(R.id.text_display)
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this, "oncreate*************", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);

        valueAnimator = ValueAnimator.ofInt(0, 1).setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                textView.setTranslationY((1 - animation.getAnimatedFraction()) * textView.getWidth() * 10);
                System.out.println("**********************");
                System.out.println(textView.getHeight());
                System.out.println(textView.getTranslationY());
                System.out.println("**********************");

            }
        });
    }

    @OnClick(R.id.button2)
    void translate(){
        valueAnimator.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    }


    @Override
    protected void onStart() {
        super.onStart();

    }


    @Override
    protected void onStop() {
        super.onStop();

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent msg){
        textView.setText(msg.getMsg());
        System.out.println("**************************************");
    }



}
