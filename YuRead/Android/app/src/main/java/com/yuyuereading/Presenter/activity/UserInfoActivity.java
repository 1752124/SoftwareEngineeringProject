package com.yuyuereading.presenter.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yuyuereading.R;

public class UserInfoActivity extends AppCompatActivity {
    Context context=UserInfoActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        findView();
        onClick();
    }

    private void onClick() {

    }

    private void findView() {

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public static class CommentActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_comment);
        }
    }
}
