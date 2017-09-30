package com.example.handschoolapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.handschoolapplication.R;
import com.example.handschoolapplication.bean.Teacher;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/31.
 */

public class TeacherAdapter extends BaseAdapter {

    private Context context;
    private List<Teacher> mList;
    private int size = 0;

    public TeacherAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Teacher> mList){
        this.mList = mList;
    }

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
            view = View.inflate(context, R.layout.item_teacher_lv, null);
            holder=new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }

        return view;

    }

    static class ViewHolder {
        @BindView(R.id.iv_teacher)
        ImageView ivTeacher;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_edu_bg)
        TextView tvEduBg;
        @BindView(R.id.tv_profession)
        TextView tvProfession;
        @BindView(R.id.tv_experience)
        TextView tvExperience;
        @BindView(R.id.tv_say)
        TextView tvSay;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
