package com.example.handschoolapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.handschoolapplication.R;
import com.example.handschoolapplication.adapter.OrderDetailLvAdapter;
import com.example.handschoolapplication.base.BaseActivity;
import com.example.handschoolapplication.view.MyListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderDetailActivity extends BaseActivity {

    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    @BindView(R.id.mlv_orderdetail)
    MyListView mlvOrderdetail;
    private OrderDetailLvAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ButterKnife.bind(this);
        tvTitle.setText("订单详情");
        mAdapter = new OrderDetailLvAdapter(OrderDetailActivity.this);
        mlvOrderdetail.setAdapter(mAdapter);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_order_detail;
    }

    @OnClick({R.id.rl_back, R.id.iv_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.iv_menu:
                show(view);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
