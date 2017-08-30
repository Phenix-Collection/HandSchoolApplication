package com.example.handschoolapplication.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.handschoolapplication.R;
import com.example.handschoolapplication.base.BaseActivity;
import com.example.handschoolapplication.fragment.ClassConditionFragment;
import com.example.handschoolapplication.fragment.ClassCourseFragment;
import com.example.handschoolapplication.fragment.ClassInfoFragment;
import com.example.handschoolapplication.fragment.ClassTeacherFragment;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.handschoolapplication.R.id.bg_tearcher_line;

public class ClassActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.iv_grade)
    ImageView ivGrade;
    @BindView(R.id.tv_bg_info_line)
    TextView tvBgInfoLine;
    @BindView(R.id.bg_condition_line)
    TextView bgConditionLine;
    @BindView(bg_tearcher_line)
    TextView bgTearcherLine;
    @BindView(R.id.bg_course_line)
    TextView bgCourseLine;

    private int mIndex=0;

    private Fragment[] fragments;
    private ClassInfoFragment classInfoFragment;
    private ClassConditionFragment classConditionFragment;
    private ClassTeacherFragment classTeacherFragment;
    private ClassCourseFragment classCourseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragments();
    }

    private void initFragments() {

        classInfoFragment = new ClassInfoFragment();
        classConditionFragment = new ClassConditionFragment();
        classTeacherFragment = new ClassTeacherFragment();
        classCourseFragment = new ClassCourseFragment();

        fragments=new Fragment[]{
            classInfoFragment,classConditionFragment,classTeacherFragment,classCourseFragment
        };

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fl_fragment,fragments[0]).commit();
        setIndexSelected(0);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_class;
    }

    @OnClick({R.id.rl_back, R.id.iv_menu, R.id.ll_love, R.id.ll_share, R.id.ll_info, R.id.ll_condition, R.id.ll_tearcher, R.id.ll_course})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                break;
            case R.id.iv_menu:
                break;
            case R.id.ll_love:
                break;
            case R.id.ll_share:
                break;
            case R.id.ll_info:
                tvBgInfoLine.setBackgroundResource(R.color.blue);
                bgConditionLine.setBackgroundColor(Color.WHITE);
                bgTearcherLine.setBackgroundColor(Color.WHITE);
                bgCourseLine.setBackgroundColor(Color.WHITE);

                setIndexSelected(0);
                break;
            case R.id.ll_condition:
                bgConditionLine.setBackgroundResource(R.color.blue);
                tvBgInfoLine.setBackgroundColor(Color.WHITE);
                bgTearcherLine.setBackgroundColor(Color.WHITE);
                bgCourseLine.setBackgroundColor(Color.WHITE);
                setIndexSelected(1);
                break;
            case R.id.ll_tearcher:
                bgTearcherLine.setBackgroundResource(R.color.blue);
                tvBgInfoLine.setBackgroundColor(Color.WHITE);
                bgConditionLine.setBackgroundColor(Color.WHITE);
                bgCourseLine.setBackgroundColor(Color.WHITE);
                setIndexSelected(2);
                break;
            case R.id.ll_course:
                bgCourseLine.setBackgroundResource(R.color.blue);
                tvBgInfoLine.setBackgroundColor(Color.WHITE);
                bgConditionLine.setBackgroundColor(Color.WHITE);
                bgTearcherLine.setBackgroundColor(Color.WHITE);

                setIndexSelected(3);
                break;
        }
    }

    private void setIndexSelected(int index){

        if (mIndex==index){
            return;
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.hide(fragments[mIndex]);
        if (!fragments[index].isAdded()){
            ft.add(R.id.fl_fragment,fragments[index]);
        }else {
            ft.show(fragments[index]);
        }

        ft.commit();
        mIndex=index;
    }
}
