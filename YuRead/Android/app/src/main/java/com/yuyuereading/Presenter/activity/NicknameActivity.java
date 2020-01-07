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

public class NicknameActivity extends AppCompatActivity {
    private Button finishEdit;
    private Button returnButton;
    private TextView title;
    private EditText nickname;
    private String name;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
        initView();
        //点击事件
        onClick();
    }

    private void initView() {
        scrollView = findViewById(R.id.scrollView);
        title=findViewById(R.id.title);
        returnButton=findViewById(R.id.nickname_return);
        finishEdit=findViewById(R.id.editCom);
        nickname=findViewById(R.id.nickname);
    }

    //监听事件
    private void onClick() {
        //scrollView从顶部显示
        scrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //直接置顶，瞬间回到顶部，没有滚动过程
                scrollView.scrollTo(0,0);
            }
        });
        finishEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //保存数据入数据库
                name=nickname.getText().toString();
                _User bmobUser = BmobUser.getCurrentUser(_User.class);
                long userID= Long.parseLong(bmobUser.getUsername());
                Map<String,String> map = new HashMap<>();
                map.put("name", name);
                //转成JSON数据
                final String json = JSON.toJSONString(map,true);
                HttpUtils.doPutAsy("http://139.196.36.97:8080/sbDemo/v1/user-management/names?id="+userID+"&name="+name, json,new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(final String result) {
                        final int sus= Integer.parseInt(result);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(sus==1){
                                    Toast.makeText(NicknameActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            }
                        });
                    }
                });
            }
        });
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
