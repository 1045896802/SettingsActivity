# 实现设置Activity

## 一. 实验内容

1.基本要求：实现如下两个图拼接而成的设置界面

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

![Image text](https://raw.githubusercontent.com/1045896802/HelloWorld/master/img/HelloWorld.png)


## 二. 关键代码

    <?xml version="1.0" encoding="utf-8"?>
    <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto"
      xmlns:tools="http://schemas.android.com/tools"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      tools:context=".MainActivity">

      <TextView
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:text="@string/app_name"
          app:layout_constraintBottom_toBottomOf="parent"
          app:layout_constraintLeft_toLeftOf="parent"
          app:layout_constraintRight_toRightOf="parent"
          app:layout_constraintTop_toTopOf="parent" />

    </android.support.constraint.ConstraintLayout>

## 三. 实验结果及截图
  
  ![Image text](https://raw.githubusercontent.com/1045896802/HelloWorld/master/img/HelloWorld.png)
