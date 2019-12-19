package com.yuyuereading.Presenter.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.yuyuereading.Model.bean.BookComment;
import com.yuyuereading.R;

public class CommentActivity extends AppCompatActivity {
    Button returnButton;

    TextView title,finishTime,pageUpdate,readReview;

    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        initView();
        //从上一页面获取评论信息类，来填充控件
        getCommentInfo();
        //点击事件
        onClick();
    }

    @SuppressLint("SetTextI18n")
    private void getCommentInfo() {
        Intent intent = this.getIntent();
        BookComment bookComment = (BookComment) intent.getSerializableExtra("bookComment");
        finishTime.setText(bookComment.getFinish_time());
        pageUpdate.setText(bookComment.getPage_update());
        readReview.setText(bookComment.getRead_review());
    }

    private void initView() {
        returnButton = findViewById(R.id.book_info_return);
        title = findViewById(R.id.title);
        scrollView = findViewById(R.id.scrollView);
        finishTime=findViewById(R.id.finishTime);
        pageUpdate=findViewById(R.id.pageUpdate);
        readReview=findViewById(R.id.readReview);
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

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
