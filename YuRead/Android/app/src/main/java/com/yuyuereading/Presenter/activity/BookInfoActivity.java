package com.yuyuereading.Presenter.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yuyuereading.Model.bean.BookComment;
import com.yuyuereading.Model.bean.BookInfo;
import com.yuyuereading.Presenter.adapter.CommentListAdapter;
import com.yuyuereading.R;

import java.util.ArrayList;
import java.util.List;



public class BookInfoActivity extends AppCompatActivity {

    private Context mContext = BookInfoActivity.this;

    private RecyclerView recyclerView;

    private BookComment[] bookComments = {
            new BookComment("1.20","1-20","无"),
            new BookComment("1.23","21-50","《芳华》涵盖了严歌苓的青春与成长期，她在四十余年后回望这段经历，笔端蕴含了饱满的情感。青春荷尔蒙冲动下的少男少女的懵懂激情，由激情犯下的过错，由过错生出的懊悔，还有那个特殊的时代背景，种种，构成了《芳华》对一段历史、一群人以及潮流更替、境遇变迁的复杂感怀。"),
            new BookComment("1.24","51-87","无"),
            new BookComment("1.25","88-125","无"),
            new BookComment("1.28","126-142","无"),
            new BookComment("1.30","143-180","无")
    };

    private List<BookComment> bookCommentList = new ArrayList<>();

    String book_ISBN;

    Button returnButton;

    TextView bookName,bookWriter,bookISBN,book_summary,title, brief,haveReadDay;

    ImageView bookImage;

    ScrollView scrollView;

    LinearLayoutManager mLayoutManager;

    ProgressBar readProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);
        initView();
        //从上一页面获取图书信息类，来填充控件
        getBookInfo();
        //点击事件
        onClick();
        mLayoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(mLayoutManager);
        //获取评论信息
        initList();
        addDate();
    }

    @SuppressLint("SetTextI18n")
    private void getBookInfo() {
        Intent intent = this.getIntent();
        BookInfo bookInfo = (BookInfo) intent.getSerializableExtra("bookInfo");
        bookName.setText(bookInfo.getBook_name());
        book_ISBN = String.valueOf(bookInfo.getBook_isbn13());
        bookWriter.setText(bookInfo.getBook_author());
        bookISBN.setText("ISBN:"+ bookInfo.getBook_isbn13());
        Glide.with(mContext)
                .load(bookInfo.getBook_image())
                .into(bookImage);
        book_summary.setText(bookInfo.getBook_summary());
        haveReadDay.setText("5天");
    }

    private void initView() {
        returnButton = findViewById(R.id.book_info_return);
        bookName = findViewById(R.id.bookName);
        bookWriter = findViewById(R.id.bookWriter);
        bookISBN = findViewById(R.id.bookISBN);
        bookImage = findViewById(R.id.bookImage);
        book_summary = findViewById(R.id.book_summary);
        title = findViewById(R.id.title);
        recyclerView = findViewById(R.id.recycler_comment);
        brief =findViewById(R.id.brief);
        haveReadDay=findViewById(R.id.haveReadDay);
        scrollView = findViewById(R.id.scrollView);
        readProgress=findViewById(R.id.readProgress);
        recyclerView.setNestedScrollingEnabled(false);
    }

    //获取评论信息
    private void initList() {
        bookCommentList.clear();
        for (int i = 0; i < bookComments.length;i++) {
            bookCommentList.add(bookComments[i]);
        }
    }

    //向评论adapter中添加数据
    private void addDate() {
        CommentListAdapter adapter = new CommentListAdapter(bookCommentList);
        recyclerView.setAdapter(adapter);
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


    public void onBackPressed() {
        finish();
    }

}