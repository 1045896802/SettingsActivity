# 实现设置Activity

## 一. 实验内容

使用PrefereceFragment实现设置页面

1.基本要求：实现如下两个图拼接而成的设置界面

![Image text](https://github.com/1045896802/SettingsActivity/blob/master/img/1y.png)


2.设置项说明

总共四组设置项

(1)In-line preferences

CheckBoxPreference

(2)Dialog-based preferences:

EditTextPreference

ListPreference

(3)Launch preferences

PreferenceScreen: 跳转到另一个PreferenceScreen

PreferenceScreen: 启动一个网页

(4)Preference attributes

CheckBox: 父选项

CheckBox: 子选项，当父选项勾选时呈现

3.界面截图

![Image text](https://github.com/1045896802/SettingsActivity/blob/master/img/2y.png)

![Image text](https://github.com/1045896802/SettingsActivity/blob/master/img/3y.png)

![Image text](https://github.com/1045896802/SettingsActivity/blob/master/img/4y.png)

![Image text](https://github.com/1045896802/SettingsActivity/blob/master/img/5y.png)

![Image text](https://github.com/1045896802/SettingsActivity/blob/master/img/6y.png)

4.参考文献

https://developer.android.google.cn/guide/topics/ui/settings.html

## 二. 关键代码

自定义PreferenceCategory

MyPreferenceCategory.java

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

MainActivity.java

    package com.example.settingsactivity;

    import android.os.Bundle;
    import android.preference.PreferenceActivity;

    public class MainActivity extends PreferenceActivity {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }

preferences.xml

    <?xml version="1.0" encoding="utf-8"?>
    <PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android">
        <com.example.settingsactivity.MyPreferenceCategory android:title="@string/title_in_line_perferences">
            <CheckBoxPreference
                android:defaultValue="true"
                android:key="checkBox"
                android:summary="@string/summary_checkBox"
                android:title="@string/title_checkBox" />

        </com.example.settingsactivity.MyPreferenceCategory>

        <com.example.settingsactivity.MyPreferenceCategory android:title="@string/title_dialog_based_perferences">
            <EditTextPreference
                android:dialogTitle="@string/dialogTitle_EditTextPreference"
                android:key="animal_edit"
                android:summary="@string/summary_editTextPreference"
                android:title="@string/title_editTextPreference" />

            <!--单选-->
            <ListPreference
                android:dialogTitle="@string/dialogTitle_ListPreference"
                android:entries="@array/options_ListPreference"
                android:entryValues="@array/options_value_ListPreference"
                android:key="listPreference"
                android:summary="@string/summary_ListPreference"
                android:title="@string/title_ListPreference"></ListPreference>
        </com.example.settingsactivity.MyPreferenceCategory>

        <com.example.settingsactivity.MyPreferenceCategory android:title="@string/title_launch_perferences">
            <PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android"
                android:key="embed_preference_screen"
                android:summary="@string/summary_embed_preference_screen"
                android:title="@string/title_embed_preference_screen">
                <CheckBoxPreference
                    android:defaultValue="true"
                    android:key="embed_checkBox"
                    android:summary="@string/summary_embed_checkBox"
                    android:title="@string/title_embed_checkBox" />
            </PreferenceScreen>
            <Preference android:title="@string/title_intent_Preference"
                android:summary="@string/summary_intent_Preference">
                <intent
                    android:action="android.intent.action.VIEW"
                    android:data="http://www.baidu.com" />
            </Preference>
        </com.example.settingsactivity.MyPreferenceCategory>

        <com.example.settingsactivity.MyPreferenceCategory android:title="@string/title_perference_attributes">
            <CheckBoxPreference
                android:defaultValue="true"
                android:key="parent_checkBox"
                android:summary="@string/summary_parent_checkBox"
                android:title="@string/title_parent_checkBox" />
            <CheckBoxPreference
                android:defaultValue="false"
                android:dependency="parent_checkBox"
                android:key="child_checkBox"
                android:summary="@string/summary_child_checkBox"
                android:title="@string/title_child_checkBox" />
        </com.example.settingsactivity.MyPreferenceCategory>

    </PreferenceScreen>

## 三. 实验结果及截图

![Image text](https://github.com/1045896802/SettingsActivity/blob/master/img/1r.png)

![Image text](https://github.com/1045896802/SettingsActivity/blob/master/img/2r.png)

![Image text](https://github.com/1045896802/SettingsActivity/blob/master/img/3r.png)

![Image text](https://github.com/1045896802/SettingsActivity/blob/master/img/4r.png)

![Image text](https://github.com/1045896802/SettingsActivity/blob/master/img/5r.png)

![Image text](https://github.com/1045896802/SettingsActivity/blob/master/img/6r.png)
