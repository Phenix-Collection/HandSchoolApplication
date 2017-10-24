package com.example.handschoolapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.DistanceUtil;
import com.bumptech.glide.Glide;
import com.example.handschoolapplication.R;
import com.example.handschoolapplication.activity.CourseHomePagerActivity;
import com.example.handschoolapplication.bean.CourseBean;
import com.example.handschoolapplication.utils.Internet;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/24.
 */

public class HPCourseAdapter extends BaseAdapter {

    private List<CourseBean.DataBean> courseBeanList;
    private LayoutInflater inflater;
    private Context context;
    private int size = 0;
    private double[] locations;

    public HPCourseAdapter(List<CourseBean.DataBean> courseBeanList, Context context) {
        this.courseBeanList = courseBeanList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (courseBeanList != null) {
            size = courseBeanList.size();
        }
        return size;
    }

    @Override
    public Object getItem(int position) {
        return courseBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_hf_course_lv, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Log.e("aaa",
                "(HPCourseAdapter.java:66)" + courseBeanList.get(position).toString());
        Glide.with(context)
                .load(Internet.BASE_URL + courseBeanList.get(position).getCourse_photo())
                .centerCrop()
                .error(R.drawable.kecheng)
                .into(holder.ivCourse);
        holder.tvCourse.setText(courseBeanList.get(position).getCourse_name());
        holder.tvPrice.setText("价格： ¥" + courseBeanList.get(position).getPreferential_price());
        holder.popularity.setText("(" + courseBeanList.get(position).getCourse_name() + "人已报名)");
        if (locations != null) {

            double latitude1 = locations[0];
            double longitude1 = locations[1];
            double school_wei = courseBeanList.get(position).getSchool_wei();
            double school_jing = courseBeanList.get(position).getSchool_jing();

            double distance = DistanceUtil.getDistance(new LatLng(latitude1, longitude1), new LatLng(school_wei, school_jing));
//            Double distance = MyUtiles.Distance(latitude1, longitude1, school_wei, school_jing);
            holder.tvDistance.setText(((int)distance) + "m");
            Log.e("aaa",
                    "(HPCourseAdapter.java:92)距离计算=====" + ((int) distance) + "m");

        }else Log.e("aaa",
                "(HPCourseAdapter.java:84)"+"locations == null");

        holder.rlItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CourseHomePagerActivity.class);
                intent.putExtra("school_id", courseBeanList.get(position).getSchool_id());
                intent.putExtra("course_id", courseBeanList.get(position).getCourse_id());
                intent.putExtra("schooluid", courseBeanList.get(position).getUser_id());
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    public void setLocation(double[] locations) {
        this.locations = locations;
    }

    static class ViewHolder {
        @BindView(R.id.rl_item)
        RelativeLayout rlItem;
        @BindView(R.id.iv_course)
        ImageView ivCourse;
        @BindView(R.id.tv_course)
        TextView tvCourse;
        @BindView(R.id.tv_distance)
        TextView tvDistance;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.popularity)
        TextView popularity;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
