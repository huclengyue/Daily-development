package com.apkdv.largeimage.rollviewpager;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.view.Gravity;

import com.apkdv.largeimage.R;


public class TextHintView extends AppCompatTextView implements HintView {
    private int length;


    @Override
    public void initView(int length, int gravity) {
        this.length = length;
        setTextColor(Color.WHITE);
        switch (gravity) {
            case 0:
                setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
                break;
            case 1:
                setGravity(Gravity.CENTER);
                break;
            case 2:
                setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
                break;
        }

        setCurrent(0);
    }


    @Override
    public void setCurrent(int current) {
        setText(current + 1 + "/" + length);
    }


    public TextHintView(Context context) {
        super(context);
        setBackground(getContext().getResources().getDrawable(R.drawable.indicator_bg));
    }


}