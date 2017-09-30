package com.example.handschoolapplication.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.handschoolapplication.R;
import com.example.handschoolapplication.view.CommonPopupWindow;
import com.example.handschoolapplication.view.MyPopupWindow;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/20.
 */

public abstract class BaseActivity extends AppCompatActivity{


    private Unbinder bind;
    private static CommonPopupWindow menuWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(getContentViewId());
        bind = ButterKnife.bind(this);
        Log.e(getClass().getSimpleName(), "--->onCreate: " );
    }
    public abstract int getContentViewId();

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(getClass().getSimpleName(), "--->onStart: " );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(getClass().getSimpleName(), "--->onStop: " );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(getClass().getSimpleName(), "--->onRestart: " );
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.e(getClass().getSimpleName(), "--->onpause: " );
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e(getClass().getSimpleName(), "--->onResume: " );
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
        Log.e(getClass().getSimpleName(), "--->onDestroy: " );
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    public static void setMenu(Activity context){
        View view = View.inflate(context, R.layout.menu_style,null);
        MyPopupWindow myPopupWindow = new MyPopupWindow(context, view);
        myPopupWindow.setHeight(500);
        myPopupWindow.showAtLocation(view,Gravity.BOTTOM, 0, 0);
    }

    //向下弹出
    public static void showMenuPop(final Context context, View view) {
        if (menuWindow != null && menuWindow.isShowing()) return;
        menuWindow = new CommonPopupWindow.Builder(context)
                .setView(R.layout.menu_style)
                .setWidthAndHeight(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                .setAnimationStyle(R.style.AnimDown)
                .setViewOnclickListener(new CommonPopupWindow.ViewInterface() {
                    @Override
                    public void getChildView(View view, int layoutResId) {
                        Toast.makeText(context, "sadsadasdasdsad", Toast.LENGTH_SHORT).show();
                    }
                })
                .setOutsideTouchable(true)
                .create();
        menuWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        menuWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        menuWindow.showAsDropDown(view, 0, 50);
    }

}
