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

import com.yuyuereading.R;

public class NicknameActivity extends AppCompatActivity {
    private Button finishEdit;
    private Button returnButton;
    private TextView title;
    private EditText nickname;
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
        nickname = findViewById(R.id.nickname);
        finishEdit=findViewById(R.id.editCom);
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

                Toast.makeText(NicknameActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                finish();
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
