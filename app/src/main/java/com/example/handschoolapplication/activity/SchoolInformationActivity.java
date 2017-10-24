package com.example.handschoolapplication.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.handschoolapplication.R;
import com.example.handschoolapplication.base.BaseActivity;
import com.example.handschoolapplication.bean.SchoolInfoBean;
import com.example.handschoolapplication.utils.Internet;
import com.example.handschoolapplication.utils.MyUtiles;
import com.example.handschoolapplication.utils.SPUtils;
import com.example.handschoolapplication.utils.Utils;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

public class SchoolInformationActivity extends BaseActivity {


    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    private static final int CROP_SMALL_PICTURE = 2;
    protected static Uri tempUri;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    @BindView(R.id.tv_edit)
    TextView tvEdit;
    @BindView(R.id.iv_schoolinfo_usericon)
    ImageView ivUsericon;
    @BindView(R.id.ll_schoolinfo_logo)
    LinearLayout llSchoolinfoLogo;
    @BindView(R.id.tv_schoolinfo_schoolname)
    TextView tvSchoolinfoSchoolname;
    @BindView(R.id.ll_schoolinfo_schoolname)
    LinearLayout llSchoolinfoSchoolname;
    @BindView(R.id.tv_schoolinfo_schoolclass)
    TextView tvSchoolinfoSchoolclass;
    @BindView(R.id.ll_schoolinfo_schoolclass)
    LinearLayout llSchoolinfoSchoolclass;
    @BindView(R.id.tv_schoolinfo_shenfenrenzheng)
    TextView tvSchoolinfoShenfenrenzheng;
    @BindView(R.id.ll_schoolinfo_shenfenrenzheng)
    LinearLayout llSchoolinfoShenfenrenzheng;
    @BindView(R.id.tv_schoolinfo_qualification)
    TextView tvSchoolinfoQualification;
    @BindView(R.id.ll_schoolinfo_qualification)
    LinearLayout llSchoolinfoQualification;
    @BindView(R.id.tv_schoolinfo_schooladdress)
    TextView tvSchoolinfoSchooladdress;
    @BindView(R.id.ll_schoolinfo_schooladdress)
    LinearLayout llSchoolinfoSchooladdress;
    @BindView(R.id.btn_schoolinfo_save)
    Button btnSchoolinfoSave;
    private ImageView iv_personal_icon;
    private String user_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user_id = (String) SPUtils.get(this, "userId", "");
        tvTitle.setText("学堂资料");
        ivMenu.setVisibility(View.VISIBLE);
        initView();
    }

    //初始化数据
    private void initView() {
        OkHttpUtils.post()
                .url(Internet.USERINFO)
                .addParams("user_id", user_id)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("aaa",
                                "(SchoolInformationActivity.java:102)" + response);
                        Gson gson = new Gson();
                        SchoolInfoBean.DataBean schoolInfo = gson.fromJson(response, SchoolInfoBean.class).getData();
                        Glide.with(SchoolInformationActivity.this)
                                .load(Internet.BASE_URL + schoolInfo.getHead_photo())
                                .error(R.drawable.touxiang)
                                .centerCrop()
                                .into(ivUsericon);
                        tvSchoolinfoSchoolname.setText(schoolInfo.getMechanism_name());
                        tvSchoolinfoSchoolclass.setText(schoolInfo.getMechanism_type());
                        tvSchoolinfoShenfenrenzheng.setText(schoolInfo.getId_number());
//                        tvSchoolinfoQualification.setText(schoolInfo.getQualification_prove());
                    }
                });
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_school_information;
    }


    /**
     * 显示修改头像的对话框
     */
    protected void showChoosePicDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("设置头像");
        String[] items = {"选择本地照片", "拍照"};
        builder.setNegativeButton("取消", null);
        builder.setItems(items, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case CHOOSE_PICTURE: // 选择本地照片
                        Intent openAlbumIntent = new Intent(
                                Intent.ACTION_GET_CONTENT);
                        openAlbumIntent.setType("image/*");
                        startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
                        break;
                    case TAKE_PICTURE: // 拍照
                        Intent openCameraIntent = new Intent(
                                MediaStore.ACTION_IMAGE_CAPTURE);
                        tempUri = Uri.fromFile(new File(Environment
                                .getExternalStorageDirectory(), "image.jpg"));
                        // 指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
                        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
                        startActivityForResult(openCameraIntent, TAKE_PICTURE);
                        break;
                }
            }
        });
        builder.create().show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1 && resultCode == 11) {
//            String sex = data.getStringExtra("sex");
//            tvSex.setText(sex);
//        }
//        if (requestCode == 1 && resultCode == 22) {
//            String username = data.getStringExtra("username");
//            tvUsername.setText(username);
//        }
//        if (requestCode == 1 && resultCode == 33) {
//            String idcode = data.getStringExtra("idcode");
//            tvIdcode.setText(idcode);
//        }
//        if (requestCode == 1 && resultCode == 44) {
//            String name = data.getStringExtra("name");
//            tvName.setText(name);
//        }

        if (resultCode == RESULT_OK) { // 如果返回码是可以用的
            switch (requestCode) {
                case TAKE_PICTURE:
                    startPhotoZoom(tempUri); // 开始对图片进行裁剪处理
                    break;
                case CHOOSE_PICTURE:
                    Uri newUri = Uri.parse("file:///" + Utils.getPath(this, data.getData()));
                    startPhotoZoom(newUri); // 开始对图片进行裁剪处理
                    break;
                case CROP_SMALL_PICTURE:
                    if (data != null) {
                        setImageToView(data); // 让刚才选择裁剪得到的图片显示在界面上
                    }
                    break;
            }
        }

    }

    /**
     * 裁剪图片方法实现
     *
     * @param uri
     */
    protected void startPhotoZoom(Uri uri) {
        if (uri == null) {
            Log.i("tag", "The uri is not exist.");
        }
        tempUri = uri;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_SMALL_PICTURE);
    }

    /**
     * 保存裁剪之后的图片数据
     *
     * @param
     * @param
     */
    protected void setImageToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
//            photo = Utils.toRoundBitmap(photo, tempUri); // 这个时候的图片已经被处理成圆形的了
            ivUsericon.setImageBitmap(photo);
            uploadPic(photo);
        }
    }

    private void uploadPic(Bitmap bitmap) {
        // 上传至服务器
        // ... 可以在这里把Bitmap转换成file，然后得到file的url，做文件上传操作
        // 注意这里得到的图片已经是圆形图片了
        // bitmap是没有做个圆形处理的，但已经被裁剪了
//        asdf
        String icon64 = MyUtiles.bitmapToBase64(bitmap);
        JSONObject json = new JSONObject();
        try {
            json.put("icon", icon64);
            OkHttpUtils.post()
                    .url(Internet.CHANGEHEAD)
                    .addParams("user_id", user_id)
                    .addParams("url", json.toString())
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {

                        }

                        @Override
                        public void onResponse(String response, int id) {
                            Log.e("aaa",
                                    "(SchoolInformationActivity.java:270)" + response);
                        }
                    });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @OnClick({R.id.rl_back, R.id.iv_menu, R.id.ll_schoolinfo_logo, R.id.ll_schoolinfo_schoolclass, R.id.ll_schoolinfo_shenfenrenzheng, R.id.ll_schoolinfo_qualification, R.id.ll_schoolinfo_schooladdress, R.id.btn_schoolinfo_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.iv_menu:
                show(view);
                break;
            //学堂logo
            case R.id.ll_schoolinfo_logo:
                showChoosePicDialog();
                break;
            //学堂类别
            case R.id.ll_schoolinfo_schoolclass:
//                startActivity(new Intent(this, ClassTypeActivity.class));
                break;
            //身份认证
            case R.id.ll_schoolinfo_shenfenrenzheng:
//                startActivity(new Intent(this, IdentityCardActivity.class));
                break;
            //资质认证
            case R.id.ll_schoolinfo_qualification:
                break;
            //学堂地址
            case R.id.ll_schoolinfo_schooladdress:
                startActivity(new Intent(SchoolInformationActivity.this, SchoolAddressActivity.class));
                break;
            //保存
            case R.id.btn_schoolinfo_save:
                break;
        }
    }
}
