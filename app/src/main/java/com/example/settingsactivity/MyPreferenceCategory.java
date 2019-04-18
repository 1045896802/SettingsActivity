package com.example.settingsactivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.preference.PreferenceCategory;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

//自定义PreferenceCategory类，可以设置PreferenceCategory的title的字体大小、颜色，控制大小写等。
public class MyPreferenceCategory extends PreferenceCategory {

    public MyPreferenceCategory(Context context) {
        super(context);
    }

    public MyPreferenceCategory(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyPreferenceCategory(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        if (view instanceof TextView) {
            TextView tv = (TextView) view;
            tv.setTextColor(Color.parseColor("#458B00"));// 字体颜色
            tv.setSingleLine(true);
            tv.setPadding(tv.getPaddingLeft(), 0, tv.getPaddingLeft(), 0);
            tv.setGravity(Gravity.CENTER_VERTICAL);
            tv.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.NORMAL));// 字体风格
            tv.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
        }
    }

}

