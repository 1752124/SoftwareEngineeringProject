package com.yuyuereading.Presenter.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.yuyuereading.Model.bean.BookInfo;
import com.yuyuereading.Presenter.adapter.BookListAdapter;
import com.yuyuereading.Presenter.utils.ShakeListener;
import com.yuyuereading.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookListActivity extends AppCompatActivity {
    private Context mContext = BookListActivity.this;
    private ShakeListener mShakeListener;
    private RecyclerView bookListView;
    private Button back;
    private ArrayList<BookInfo> bookInfoList = new ArrayList<>();
    private BookListAdapter adapter;
    private String type;
    private LinearLayoutManager mLayoutManager;

    private BookInfo[] allanBookList = {new BookInfo("https://img1.doubanio.com/view/subject/l/public/s29636258.jpg","坠落之前","2017-12","7.5","[美] 诺亚·霍利","天津人民出版社","1"),
            new BookInfo("https://img3.doubanio.com/view/subject/l/public/s29440931.jpg","梅赛德斯先生","2017-5-1","8.5"," [美] 斯蒂芬·金","人民文学出版社","1"),
            new BookInfo("https://img3.doubanio.com/view/subject/l/public/s29460010.jpg","夜色人生","2016-10-15","8.1","[美] 丹尼斯·勒翰","江苏凤凰文艺出版社","1")};

    private BookInfo[] oscarBookList = {new BookInfo("https://img3.doubanio.com/view/subject/l/public/s28281251.jpg","了不起的盖茨比","2013-9-1","8.5","[美] 弗·司各特·菲茨杰拉德","南海出版公司","1"),
            new BookInfo("https://img9.doubanio.com/view/subject/l/public/s29350294.jpg","杀死一只知更鸟","2017-2","8.1","[美] 哈珀·李","译林出版社","1"),
            new BookInfo("https://img3.doubanio.com/view/subject/l/public/s4571103.jpg","傲慢与偏见","2010-6-1","9.0","[英] 简·奥斯汀","译林出版社","1")};

    private BookInfo[] maoBookList = {new BookInfo("https://img1.doubanio.com/view/subject/l/public/s31307038.jpg","繁花","2019-1-1","8.4","金宇澄","人民文学出版社","1"),
            new BookInfo("https://img3.doubanio.com/view/subject/l/public/s33450235.jpg","额尔古纳河右岸","2019-6-1","8.8"," 迟子建","人民文学出版社","1"),
            new BookInfo("https://img3.doubanio.com/view/subject/l/public/s31301402.jpg","尘埃落定","2019-1-1","9.1","阿来","人民文学出版社","1")};

    private BookInfo[] nobelBookList = {new BookInfo("https://img3.doubanio.com/view/subject/l/public/s8492855.jpg","切尔诺贝利的回忆","2012-1","8.5","S·A·阿列克谢耶维奇","凤凰出版社","1"),
            new BookInfo("https://img3.doubanio.com/view/subject/l/public/s29040872.jpg","逃离","2016-10-1","8.5"," [加拿大] 艾丽丝·门罗","北京十月文艺出版社","1"),
            new BookInfo("https://img3.doubanio.com/view/subject/l/public/s29249760.jpg","红高粱家族","2017-1","8.8","莫言","浙江文艺出版社","1")};

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
        switch (type){
            case "allan":
                bookInfoList.addAll(Arrays.asList(allanBookList));
                break;
            case "oscar":
                bookInfoList.addAll(Arrays.asList(oscarBookList));
                break;
            case"mao":
                bookInfoList.addAll(Arrays.asList(maoBookList));
                break;
            case"nobel":
                bookInfoList.addAll(Arrays.asList(nobelBookList));
                break;
            default:
                searchBookList=(ArrayList<BookInfo>)getIntent().getSerializableExtra("bookInfos");
                bookInfoList.addAll(searchBookList);
                break;
        }
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
