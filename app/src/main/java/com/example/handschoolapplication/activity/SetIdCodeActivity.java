package com.example.handschoolapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.handschoolapplication.R;
import com.example.handschoolapplication.base.BaseActivity;
import com.example.handschoolapplication.utils.Internet;
import com.example.handschoolapplication.utils.SPUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

public class SetIdCodeActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_idcode)
    EditText etIdcode;
    private String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvTitle.setText("身份证");
        user_id = (String) SPUtils.get(this, "userId", "");
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_set_id_code;
    }


    @OnClick({R.id.rl_back, R.id.iv_menu, R.id.tv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.iv_menu:
                show(view);
                break;
            case R.id.tv_save:
                final String idcode = etIdcode.getText().toString().trim();
                OkHttpUtils.post()
                        .url(Internet.USERIDCARD)
                        .addParams("user_id", user_id)
                        .addParams("idnum", idcode)
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e, int id) {

                            }

                            @Override
                            public void onResponse(String response, int id) {
                                Log.e("aaa",
                                        "(SetUserNameActivity.java:64)" + response);
                                if (response.contains("成功")) {
                                    Toast.makeText(SetIdCodeActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                                }
                                setResult(33, new Intent().putExtra("idcode", idcode));
                                finish();
                            }
                        });
                break;
        }
    }
}
