package com.yuyuereading.presenter.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.yuyuereading.R;
import com.yuyuereading.model.bean._User;
import com.yuyuereading.presenter.utils.HttpUtils;

import java.util.HashMap;
import java.util.Map;

import cn.bmob.v3.BmobUser;

public class PortraitActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portrait);

    }
}
