package com.example.handschoolapplication.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.handschoolapplication.R;
import com.example.handschoolapplication.base.BaseActivity;
import com.example.handschoolapplication.fragment.FindFragment;
import com.example.handschoolapplication.fragment.HomeFragment;
import com.example.handschoolapplication.fragment.LearnPlanFragment;
import com.example.handschoolapplication.fragment.MeComFragment;
import com.example.handschoolapplication.fragment.MeFragment;
import com.example.handschoolapplication.fragment.NewsFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.iv_home)
    ImageView ivHome;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.iv_find)
    ImageView ivFind;
    @BindView(R.id.tv_find)
    TextView tvFind;
    @BindView(R.id.iv_plan)
    ImageView ivPlan;
    @BindView(R.id.tv_plan)
    TextView tvPlan;
    @BindView(R.id.ll_plan)
    LinearLayout llPlan;
    @BindView(R.id.iv_news)
    ImageView ivNews;
    @BindView(R.id.tv_news)
    TextView tvNews;
    @BindView(R.id.iv_me)
    ImageView ivMe;
    @BindView(R.id.tv_me)
    TextView tvMe;
    @BindView(R.id.fl_fragment)
    FrameLayout flFragment;

    private HomeFragment homeFragment;
    private FindFragment findFragment;
    private NewsFragment newsFragment;
    private LearnPlanFragment planFragment;
    private MeFragment meFragment;
    private Fragment currentFragment;
    private MeComFragment meComFragment;
    private String flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        flag = getIntent().getStringExtra("flag");
        if (flag.equals("com")) {
            llPlan.setVisibility(View.GONE);
        }
        initTab();
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }


    private void initTab() {
        if (homeFragment == null) {

            /** 默认加载第一个Fragment*/
            homeFragment = new HomeFragment();
        }

        if (!homeFragment.isAdded()) {

            /** 如果第一个未被添加，则添加到管理器中*/
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fl_fragment, homeFragment).commit();

            /** 记录当前Fragment*/
            currentFragment = homeFragment;
        }
    }

    /**
     * 添加或者显示碎片
     *
     * @param manager
     * @param fragment
     */
    private void addOrShowFragment(FragmentManager manager,
                                   Fragment fragment) {
        FragmentTransaction transaction = manager.beginTransaction();
        if (currentFragment == fragment)
            return;
        if (!fragment.isAdded()) {

            // 如果当前fragment未被添加，则添加到Fragment管理器中
            transaction.hide(currentFragment)
                    .add(R.id.fl_fragment,
                            fragment).commit();
        } else {

            // 如果当前fragment已被添加，则显示即可
            transaction.hide(currentFragment).show(fragment).commit();
        }
        currentFragment = fragment;
    }


    @OnClick({R.id.ll_home, R.id.ll_find, R.id.ll_plan, R.id.ll_news, R.id.ll_me})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                tvHome.setTextColor(Color.parseColor("#27acf6"));
                ivHome.setImageResource(R.drawable.homes);
                tvFind.setTextColor(Color.parseColor("#333333"));
                ivFind.setImageResource(R.drawable.find);
                tvNews.setTextColor(Color.parseColor("#333333"));
                ivNews.setImageResource(R.drawable.news);
                tvPlan.setTextColor(Color.parseColor("#333333"));
                ivPlan.setImageResource(R.drawable.plan);
                tvMe.setTextColor(Color.parseColor("#333333"));
                ivMe.setImageResource(R.drawable.me);
                if (homeFragment == null) homeFragment = new HomeFragment();
                addOrShowFragment(getSupportFragmentManager(), homeFragment);
                break;
            case R.id.ll_find:
                tvHome.setTextColor(Color.parseColor("#333333"));
                ivHome.setImageResource(R.drawable.home);
                tvFind.setTextColor(Color.parseColor("#27acf6"));
                ivFind.setImageResource(R.drawable.finds);
                tvNews.setTextColor(Color.parseColor("#333333"));
                ivNews.setImageResource(R.drawable.news);
                tvPlan.setTextColor(Color.parseColor("#333333"));
                ivPlan.setImageResource(R.drawable.plan);
                tvMe.setTextColor(Color.parseColor("#333333"));
                ivMe.setImageResource(R.drawable.me);
                if (findFragment == null) findFragment = new FindFragment();
                addOrShowFragment(getSupportFragmentManager(), findFragment);
                break;
            case R.id.ll_news:
                tvHome.setTextColor(Color.parseColor("#333333"));
                ivHome.setImageResource(R.drawable.home);
                tvFind.setTextColor(Color.parseColor("#333333"));
                ivFind.setImageResource(R.drawable.find);
                tvNews.setTextColor(Color.parseColor("#27acf6"));
                ivNews.setImageResource(R.drawable.newss);
                tvPlan.setTextColor(Color.parseColor("#333333"));
                ivPlan.setImageResource(R.drawable.plan);
                tvMe.setTextColor(Color.parseColor("#333333"));
                ivMe.setImageResource(R.drawable.me);
                if (newsFragment == null) newsFragment = new NewsFragment();
                addOrShowFragment(getSupportFragmentManager(), newsFragment);
                break;
            case R.id.ll_plan:
                tvHome.setTextColor(Color.parseColor("#333333"));
                ivHome.setImageResource(R.drawable.home);
                tvFind.setTextColor(Color.parseColor("#333333"));
                ivFind.setImageResource(R.drawable.find);
                tvNews.setTextColor(Color.parseColor("#333333"));
                ivNews.setImageResource(R.drawable.news);
                tvPlan.setTextColor(Color.parseColor("#27acf6"));
                ivPlan.setImageResource(R.drawable.plans);
                tvMe.setTextColor(Color.parseColor("#333333"));
                ivMe.setImageResource(R.drawable.me);
                if (planFragment == null) planFragment = new LearnPlanFragment();
                addOrShowFragment(getSupportFragmentManager(), planFragment);
                break;
            case R.id.ll_me:
                tvHome.setTextColor(Color.parseColor("#333333"));
                ivHome.setImageResource(R.drawable.home);
                tvFind.setTextColor(Color.parseColor("#333333"));
                ivFind.setImageResource(R.drawable.find);
                tvNews.setTextColor(Color.parseColor("#333333"));
                ivNews.setImageResource(R.drawable.news);
                tvPlan.setTextColor(Color.parseColor("#333333"));
                ivPlan.setImageResource(R.drawable.plan);
                tvMe.setTextColor(Color.parseColor("#27acf6"));
                ivMe.setImageResource(R.drawable.mes);
                if (flag.equals("com")) {
                    if (meComFragment == null) meComFragment = new MeComFragment();
                    addOrShowFragment(getSupportFragmentManager(), meComFragment);
                } else {
                    if (meFragment == null) meFragment = new MeFragment();
                    addOrShowFragment(getSupportFragmentManager(), meFragment);
                }
                break;
        }
    }


}
