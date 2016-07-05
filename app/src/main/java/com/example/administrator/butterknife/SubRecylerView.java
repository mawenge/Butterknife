package com.example.administrator.butterknife;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/7/3.
 */
public class SubRecylerView extends RecyclerView {
    public SubRecylerView(Context context) {
        super(context);
    }

    public SubRecylerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SubRecylerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    public View findChildViewUnder(float x, float y) {
        return super.findChildViewUnder(x, y);
    }
}
