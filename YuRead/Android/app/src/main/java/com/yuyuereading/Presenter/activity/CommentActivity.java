package com.yuyuereading.presenter.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.yuyuereading.model.bean.BookComment;
import com.yuyuereading.R;
import com.yuyuereading.presenter.utils.HttpUtils;

import java.io.IOException;
import java.util.LinkedHashMap;

public class CommentActivity extends AppCompatActivity {
    private Button returnButton;
    private Button editCom;
    private Button finishEdit;
    private Button delete;
    long noteID;
    TextView title;
    private TextView finishTime;
    private TextView pageUpdate;
    private EditText readReview;

    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        initView();
        //从上一页面获取评论信息类，来填充控件
        getCommentInfo();
        //设置readReview不可编辑
        setNoEdit();
        //点击事件
        onClick();
    }

    @SuppressLint("SetTextI18n")
    private void getCommentInfo() {
        Intent intent = this.getIntent();
        BookComment bookComment = (BookComment) intent.getSerializableExtra("bookComment");
        noteID=bookComment.getNoteID();
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
        editCom=findViewById(R.id.editCom);
        finishEdit=findViewById(R.id.finishEdit);
        delete=findViewById(R.id.delete);
    }

    private void setNoEdit(){
        readReview.setFocusable(false);
        readReview.setFocusableInTouchMode(false);
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
        editCom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                readReview.setFocusable(true);
                readReview.setFocusableInTouchMode(true);
                editCom.setVisibility(View.GONE);
                delete.setVisibility(View.GONE);
                finishEdit.setVisibility(View.VISIBLE);
            }
        });
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //从数据库中删除记录
                JSONObject reqjson = new JSONObject(new LinkedHashMap());
                reqjson.put("noteid",noteID);
                final String request = reqjson.toString();
                new Thread(new Runnable(){
                    @Override
                    public void run() {
                        try {
                            HttpUtils.doDelete("http://139.196.36.97:8080/sbDemo/v1/note-management/notes?noteid="+noteID,request);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                Toast.makeText(CommentActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        finishEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //保存数据入数据库
                final String content= readReview.getText().toString();
                JSONObject reqjson = new JSONObject(new LinkedHashMap());
                reqjson.put("noteid",noteID);
                reqjson.put("content",content);
                final String request = reqjson.toString();
                new Thread(new Runnable(){
                    @Override
                    public void run() {
                        try {
                            HttpUtils.doPut("http://139.196.36.97:8080/sbDemo/v1/note-management/notes?noteid="+noteID
                                    +"&content="+content,request);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                Toast.makeText(CommentActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
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