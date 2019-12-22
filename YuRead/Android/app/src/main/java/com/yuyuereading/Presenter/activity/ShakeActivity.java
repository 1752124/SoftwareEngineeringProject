package com.yuyuereading.Presenter.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yuyuereading.R;

public class ShakeActivity extends AppCompatActivity {

    private Button back;

    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.today_sentence);
        initView();
    }
    private void initView() {
        back=findViewById(R.id.sentence_return);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}