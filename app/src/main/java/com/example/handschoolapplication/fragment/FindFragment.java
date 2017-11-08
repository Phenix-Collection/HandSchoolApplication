package com.example.handschoolapplication.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.example.handschoolapplication.R;
import com.example.handschoolapplication.activity.BaiduMapActivity;
import com.example.handschoolapplication.activity.CourseHomePagerActivity;
import com.example.handschoolapplication.activity.SearchActivity;
import com.example.handschoolapplication.adapter.FindClassAdapter;
import com.example.handschoolapplication.adapter.FindCourseAdapter;
import com.example.handschoolapplication.base.BaseFragment;
import com.example.handschoolapplication.bean.ClassSortBean;
import com.example.handschoolapplication.bean.CourseSortBean;
import com.example.handschoolapplication.utils.InternetS;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;


/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.tv_current_location)
    TextView tvCurrentLocation;
    @BindView(R.id.lv_ff_course)
    ListView lvFfCourse;
    @BindView(R.id.map_view)
    MapView mapView;
    @BindView(R.id.rb_search_type)
    CheckBox rbSearchType;
    private View view;

    private List<CourseSortBean> findCourseList;
    private List<ClassSortBean> findClassList;
    private FindCourseAdapter findCourseAdapter;
    private FindClassAdapter findClassAdapter;
    private BaiduMap map;
    // 定位相关
    LocationClient mLocClient;
    public MyLocationListenner myListener = new MyLocationListenner();
    private double mCurrentLat = 0.0;
    private double mCurrentLon = 0.0;
    private float mCurrentAccracy;
    boolean isFirstLoc = true; // 是否首次定位
    private MyLocationData locData;
    private int mCurrentDirection = 0;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    Log.e("aaa",
                            "(FindFragment.java:86)" + "dsahjdhsadhasdasdj");
                    double[] locations = (double[]) msg.obj;
                    Log.e("aaa",
                            "(FindFragment.java:89)" + locations);
                    findCourseAdapter.setLocations(locations);
                    findCourseAdapter.notifyDataSetChanged();
                    break;
                case 1:
                    String address = (String) msg.obj;
                    tvCurrentLocation.setText(address + "");
                    break;
                case 2:
                    tvLocation.setText((String) msg.obj);
                    break;
            }
        }
    };
    private boolean isCourse;

    public FindFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = super.onCreateView(inflater, container, savedInstanceState);
        map = mapView.getMap();
        findCourseList = new ArrayList<>();
        findClassList = new ArrayList<>();
        findCourseAdapter = new FindCourseAdapter(findCourseList, getActivity());
        findClassAdapter = new FindClassAdapter(getActivity(),findClassList);
        map.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        map.setMyLocationEnabled(true);
        mLocClient = new LocationClient(getActivity());
        mLocClient.registerLocationListener(myListener);
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setScanSpan(0);
        mLocClient.setLocOption(option);
        mLocClient.start();
        initMap();
        initLvData();
        lvFfCourse.setOnItemClickListener(this);
        map.setOnMapClickListener(listener);


        rbSearchType.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isCourse = true;
                    initLvData();
                } else {
                    isCourse = false;
                    initLvClassData();
                }
            }
        });
        return view;
    }

    BaiduMap.OnMapClickListener listener = new BaiduMap.OnMapClickListener() {
        /**
         * 地图单击事件回调函数
         * @param point 点击的地理坐标
         */
        public void onMapClick(LatLng point) {
            startActivity(new Intent(getActivity(), BaiduMapActivity.class));
        }

        /**
         * 地图内 Poi 单击事件回调函数
         * @param poi 点击的 poi 信息
         */
        public boolean onMapPoiClick(MapPoi poi) {
            return false;
        }
    };

    private void initMap() {

        map.setMyLocationConfiguration(new MyLocationConfiguration(
                MyLocationConfiguration.LocationMode.FOLLOWING, true, null));
        MapStatus.Builder builder = new MapStatus.Builder();
        builder.overlook(0);
        map.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_find;
    }


    private void initLvData() {
        findCourseList.clear();
        OkHttpUtils.post()
                .url(InternetS.COURSE_RANK)
                .addParams("course_type", "")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("aaa",
                                "(FindFragment.java:136)" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("aaa",
                                "(FindFragment.java:142)" + response);
                        if (response.contains("没有信息")) {
                            Toast.makeText(getActivity(), "没有信息", Toast.LENGTH_SHORT).show();
                        } else {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                JSONArray data = jsonObject.getJSONArray("data");
                                findCourseList.addAll((Collection<? extends CourseSortBean>) new Gson().fromJson(data.toString(), new TypeToken<ArrayList<CourseSortBean>>() {
                                }.getType()));
                                lvFfCourse.setAdapter(findCourseAdapter);
                                findCourseAdapter.notifyDataSetChanged();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                });

    }
    private void initLvClassData() {
        findClassList.clear();
        OkHttpUtils.post()
                .url(InternetS.ORGANIZATION_RANK)
                .addParams("mechanism_type", "")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("aaa",
                                "(FindFragment.java:136)" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("aaa",
                                "(FindFragment.java:142)" + response);
                        if (response.contains("没有信息")) {
                            Toast.makeText(getActivity(), "没有信息", Toast.LENGTH_SHORT).show();
                        } else {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                JSONArray data = jsonObject.getJSONArray("data");
                                findClassList.addAll((Collection<? extends ClassSortBean>) new Gson().fromJson(data.toString(), new TypeToken<ArrayList<ClassSortBean>>() {
                                }.getType()));
                                lvFfCourse.setAdapter(findClassAdapter);
                                findClassAdapter.notifyDataSetChanged();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                });

    }

    @OnClick({R.id.iv_search, R.id.tv_search})
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), SearchActivity.class));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), CourseHomePagerActivity.class);
        intent.putExtra("school_id", findCourseList.get(position).getSchool_id());
        intent.putExtra("course_id", findCourseList.get(position).getCourse_id());
        intent.putExtra("schooluid", findCourseList.get(position).getUser_id());
        startActivity(intent);
    }

    /**
     * 定位SDK监听函数
     */
    public class MyLocationListenner implements BDLocationListener {


        @Override
        public void onReceiveLocation(BDLocation location) {

            Log.e("aaa",
                    "(MyLocationListenner.java:153)" + "进入定位监听接口");
            // map view 销毁后不在处理新接收的位置
            if (location == null || mapView == null) {
                return;
            }
            mCurrentLat = location.getLatitude();
            mCurrentLon = location.getLongitude();
            mCurrentAccracy = location.getRadius();
            locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(mCurrentDirection).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            map.setMyLocationData(locData);
            if (isFirstLoc) {
                isFirstLoc = false;
                LatLng ll = new LatLng(location.getLatitude(),
                        location.getLongitude());
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.target(ll).zoom(17.0f);
                map.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
            }

            String addrStr = location.getAddrStr();
            Log.e("aaa",
                    "(MyLocationListenner.java:146)" + addrStr);
            Message msg = new Message();
            msg.what = 1;
            msg.obj = addrStr;
            mHandler.sendMessage(msg);

            double latitude = location.getLatitude();
            double longitude = location.getLongitude();

            Log.e("aaa",
                    "(MyLocationListenner.java:269)" + latitude + "    " + "经度" + longitude);

            double[] locations = new double[]{latitude, longitude};

            Message message = new Message();
            message.what = 0;
            message.obj = locations;
            mHandler.sendMessage(message);

            Message message1 = new Message();
            message1.what = 2;
            message1.obj = location.getCity();
            mHandler.sendMessage(message1);
        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 退出时销毁定位
        mLocClient.unRegisterLocationListener(myListener);
        mLocClient.stop();
        // 关闭定位图层
        if (mapView != null) {
            mapView.onDestroy();
            map.setMyLocationEnabled(false);
            mapView = null;
        }

    }
}
