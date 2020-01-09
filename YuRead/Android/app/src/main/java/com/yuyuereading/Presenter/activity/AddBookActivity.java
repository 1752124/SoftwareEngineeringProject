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

import com.alibaba.fastjson.JSONObject;
import com.yuyuereading.R;
import com.yuyuereading.presenter.utils.HttpUtils;

import java.io.IOException;
import java.util.LinkedHashMap;

public class AddBookActivity extends AppCompatActivity {
    private Button finishEdit;
    private Button returnButton;
    TextView book_name;
    TextView author_name;
    TextView isbn;
    TextView public_name;
    TextView title;
    private EditText input_book_name;
    private EditText input_author_name;
    private EditText input_isbn;
    private EditText input_public_name;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        initView();
        //点击事件
        onClick();
    }

    private void initView() {
        scrollView = findViewById(R.id.scrollView);
        title=findViewById(R.id.title);
        returnButton=findViewById(R.id.book_info_return);
        book_name = findViewById(R.id.book_name);
        author_name = findViewById(R.id.author_name);
        isbn=findViewById(R.id.isbn);
        public_name=findViewById(R.id.public_name);
        input_book_name = findViewById(R.id.input_book_name);
        input_author_name = findViewById(R.id.input_author_name);
        input_isbn=findViewById(R.id.input_isbn);
        input_public_name=findViewById(R.id.input_public_name);
        finishEdit=findViewById(R.id.finishEdit);
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
                addBook();
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

    private void addBook(){
        final long userId=1;
        final int state=1;
        final String title= input_book_name.getText().toString();
        final String author=input_author_name.getText().toString();
        final String publicName= input_public_name.getText().toString();
        final long isbn=Long.parseLong(input_isbn.getText().toString());
        JSONObject reqjson = new JSONObject(new LinkedHashMap());
        reqjson.put("userid",userId);
        reqjson.put("bookid",isbn);
        reqjson.put("state",state);
        reqjson.put("title",title);
        reqjson.put("author",author);
        reqjson.put("publisher",publicName);
        final String request = reqjson.toString();
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    HttpUtils.doPost("http://139.196.36.97:8080/sbDemo/v2/read-management/books?userid="
                            +userId+"&bookid="+isbn+"&state="+state+"&title="+title+"&author="+author+"&publisher="+publicName,request);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
