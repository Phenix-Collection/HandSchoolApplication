package com.example.handschoolapplication.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.handschoolapplication.R;
import com.example.handschoolapplication.activity.AllCourseActivity;
import com.example.handschoolapplication.activity.GradeActivity;
import com.example.handschoolapplication.activity.LearningActivity;
import com.example.handschoolapplication.activity.MyBroswerActivity;
import com.example.handschoolapplication.activity.MyDiscountcouponActivity;
import com.example.handschoolapplication.activity.MyInformationActivity;
import com.example.handschoolapplication.activity.MyLoveActivity;
import com.example.handschoolapplication.activity.MyOrderActivity;
import com.example.handschoolapplication.activity.SettingsActivity;
import com.example.handschoolapplication.base.BaseFragment;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends BaseFragment {

    @BindView(R.id.civ_usericon)
    CircleImageView civUsericon;
    @BindView(R.id.tv_percent)
    TextView tvPercent;
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
    @BindView(R.id.iv_jewel6)
    ImageView ivJewel6;
    @BindView(R.id.tv_days)
    TextView tvDays;
    @BindView(R.id.tv_gold_num)
    TextView tvGoldNum;
    @BindView(R.id.ll_dengji)
    LinearLayout llDengji;
    Unbinder unbinder;

    private View view;
    private int REQUEST_CODE;


    public MeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = super.onCreateView(inflater, container, savedInstanceState);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_me;
    }


    @OnClick({R.id.iv_edit, R.id.ll_course_all, R.id.ll_islearning, R.id.ll_unpay, R.id.ll_isevaluate,
            R.id.tv_more, R.id.iv_more, R.id.ll_scan, R.id.ll_evaluate, R.id.ll_broswer, R.id.ll_love,
            R.id.ll_discountcoupon, R.id.iv_settings,R.id.ll_dengji,R.id.civ_usericon})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_edit://编辑
                break;
            case R.id.ll_course_all://全部课程
                startActivity(new Intent(getActivity(), AllCourseActivity.class));
                break;
            case R.id.ll_islearning://学习中
                startActivity(new Intent(getActivity(), LearningActivity.class));
                break;
            case R.id.ll_unpay://未付款
                break;
            case R.id.ll_isevaluate://待评价
                break;
            case R.id.tv_more:
            case R.id.iv_more://我的订单更多
                startActivity(new Intent(getActivity(), MyOrderActivity.class));
                break;
            case R.id.ll_scan://扫一扫
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.ll_evaluate://评价
                break;
            case R.id.ll_broswer://足迹
                startActivity(new Intent(getActivity(), MyBroswerActivity.class));
                break;
            case R.id.ll_love://收藏
                startActivity(new Intent(getActivity(), MyLoveActivity.class));
                break;
            case R.id.ll_discountcoupon://优惠券
                startActivity(new Intent(getActivity(), MyDiscountcouponActivity.class));
                break;
            case R.id.iv_settings:
                startActivity(new Intent(getActivity(), SettingsActivity.class).putExtra("type","per"));
                break;
            case R.id.ll_dengji:
                startActivity(new Intent(getActivity(),GradeActivity.class));
                break;
            case R.id.civ_usericon:
                startActivity(new Intent(getActivity(), MyInformationActivity.class));
                break;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(getActivity(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
