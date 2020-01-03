package com.yuyuereading.presenter.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.yuyuereading.model.bean.BookInfo;
import com.yuyuereading.presenter.adapter.BookListAdapter;
import com.yuyuereading.presenter.utils.ShakeListener;
import com.yuyuereading.R;

import java.util.ArrayList;
import java.util.Arrays;

public class BookListActivity extends AppCompatActivity {
    private Context mContext = BookListActivity.this;
    private ShakeListener mShakeListener;
    private RecyclerView bookListView;
    private Button back;
    private ArrayList<BookInfo> bookInfoList = new ArrayList<>();
    private BookListAdapter adapter;
    private String type;
    private LinearLayoutManager mLayoutManager;

    private ArrayList<BookInfo> searchBookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        type=getIntent().getStringExtra("type");
        initView();
        mLayoutManager = new LinearLayoutManager(mContext);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        bookListView.setLayoutManager(mLayoutManager);
        adapter = new BookListAdapter(bookInfoList,"recommend");
        bookListView.setAdapter(adapter);
        getBookInfo();
        onClick();
        initShake();
    }

    private void onClick() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView(){
        back=findViewById(R.id.book_list_return);
        bookListView= findViewById(R.id.book_list);
    }

    private void getBookInfo(){
        searchBookList=(ArrayList<BookInfo>)getIntent().getSerializableExtra("bookInfos");
        bookInfoList.addAll(searchBookList);
    }

    private void initShake(){
        mShakeListener=new ShakeListener(this);
        mShakeListener.setOnShakeListener(new ShakeListener.OnShakeListenerCallBack() {
            @Override
            public void onShake() {
                Intent intent = new Intent(mContext, ShakeActivity.class);
                startActivity(intent);
            }
        });
    }
}
