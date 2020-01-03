package com.yuyuereading.presenter.activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yuyuereading.R;
import com.yuyuereading.view.CircleImageView;

import java.io.Serializable;

public class UserInfoActivity extends AppCompatActivity {
    Context mContext = UserInfoActivity.this;
    private CircleImageView portrait;
    private TextView nickname;
    private TextView sumBook;
    private TextView sumDay;
    private TextView sumSeen;
    private TextView sumRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        initView();
        getData();
        nickname=findViewById(R.id.nickname);
        portrait=findViewById(R.id.user_info_icon);
        nickname.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"点击事件", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UserInfoActivity.this, NicknameActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("nickname", (Serializable) nickname);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        portrait.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"点击事件", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getData() {
        sumBook.setText("13本");
        sumRecord.setText("50条");
        sumDay.setText("86天");
        sumSeen.setText("8本");
    }
    private void initView() {
        sumBook=findViewById(R.id.sum_book);
        sumDay=findViewById(R.id.sum_days);
        sumSeen=findViewById(R.id.seen_book);
        sumRecord=findViewById(R.id.sum_record);
    }

}
