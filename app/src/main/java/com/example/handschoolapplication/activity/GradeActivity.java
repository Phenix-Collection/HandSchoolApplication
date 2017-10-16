package com.example.handschoolapplication.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.handschoolapplication.R;
import com.example.handschoolapplication.base.BaseActivity;
import com.example.handschoolapplication.bean.IntegralBean;
import com.example.handschoolapplication.utils.Internet;
import com.example.handschoolapplication.utils.SPUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class GradeActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_jewel1)
    ImageView ivJewel1;
    @BindView(R.id.iv_jewel2)
    ImageView ivJewel2;
    @BindView(R.id.iv_jewel3)
    ImageView ivJewel3;
    @BindView(R.id.iv_jewel4)
    ImageView ivJewel4;
    @BindView(R.id.iv_jewel5)
    ImageView ivJewel5;
    @BindView(R.id.tv_integral_num)
    TextView tvIntegralNum;
    @BindView(R.id.lv_integral)
    ListView lvIntegral;

    private List<IntegralBean> mList;
    private MyAdapter myAdapter;
    private String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvTitle.setText("等级详情");
        user_id = (String) SPUtils.get(this, "userId", "");
        initData();
    }

    private void initData() {
        myAdapter = new MyAdapter();
        lvIntegral.setAdapter(myAdapter);
        OkHttpUtils.post()
                .url(Internet.INTEGRALRECORD)
                .addParams("user_id", user_id)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {

                        Log.e("aaa",
                                "(GradeActivity.java:73)" + response);
                    }
                });
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_grade;
    }

    @OnClick({R.id.rl_back, R.id.iv_menu, R.id.ll_integral_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.iv_menu:
                break;
            case R.id.ll_integral_more:
                break;
        }
    }

    class MyAdapter extends BaseAdapter {

        int size = 0;

        @Override
        public int getCount() {
            if (mList != null) {
                size = mList.size();
            }
            return size;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            ViewHolder holder = null;
            if (view == null) {
                view = View.inflate(GradeActivity.this, R.layout.item_integral_lv, null);
                holder = new ViewHolder(view);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }

            return view;
        }

        class ViewHolder {
            @BindView(R.id.tv_hour)
            TextView tvHour;
            @BindView(R.id.tv_day)
            TextView tvDay;
            @BindView(R.id.tv_num)
            TextView tvNum;
            @BindView(R.id.tv_content)
            TextView tvContent;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}
