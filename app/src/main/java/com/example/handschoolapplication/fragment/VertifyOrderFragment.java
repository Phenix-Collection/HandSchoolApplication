package com.example.handschoolapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.handschoolapplication.R;
import com.example.handschoolapplication.adapter.OrderAdapter;
import com.example.handschoolapplication.base.BaseFragment;
import com.example.handschoolapplication.bean.OrderBean;
import com.example.handschoolapplication.utils.Internet;
import com.example.handschoolapplication.utils.SPUtils;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class VertifyOrderFragment extends BaseFragment {

    @BindView(R.id.lv_vertify_order)
    ListView lvVertifyOrder;
    Unbinder unbinder;
    private View view;
    private List<OrderBean.DataBean> mOrderList = new ArrayList<>();
    private String user_id;


    public VertifyOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = super.onCreateView(inflater, container, savedInstanceState);
        user_id = (String) SPUtils.get(getActivity(), "userId", "");
        initDataView();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    private void initDataView() {
        OkHttpUtils.post()
                .url(Internet.ORDERSTATE)
                .addParams("user_id", user_id)
                .addParams("order_state", "1")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("aaa",
                                "(AllOrderFragment.java:7373待确认)" + response);
                        Gson gson = new Gson();
                        mOrderList.clear();
                        try {
                            mOrderList.addAll(gson.fromJson(response, OrderBean.class).getData());
                        } catch (Exception e) {
                        }
                        OrderAdapter orderAdapter = new OrderAdapter(getActivity(), mOrderList);
                        lvVertifyOrder.setAdapter(orderAdapter);
                    }
                });
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_vertify_order;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onResume() {
        super.onResume();
        initDataView();
    }
}
