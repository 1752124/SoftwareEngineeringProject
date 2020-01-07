package com.yuyuereading.presenter.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.yuyuereading.model.bean.BookComment;
import com.yuyuereading.model.bean.BookInfo;
import com.yuyuereading.model.bean._User;
import com.yuyuereading.presenter.adapter.CommentListAdapter;
import com.yuyuereading.presenter.utils.HttpUtils;
import com.yuyuereading.presenter.utils.NoteGetFromDB;
import com.yuyuereading.presenter.utils.ShakeListener;
import com.yuyuereading.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import cn.bmob.v3.BmobUser;


public class BookInfoActivity extends AppCompatActivity {

    private final Context mContext = BookInfoActivity.this;
    private RecyclerView recyclerView;
    private List<BookComment> bookCommentList = new ArrayList<>();
    private String book_ISBN;
    private Button returnButton;
    private Button update;
    private TextView bookName;
    private TextView bookWriter;
    private TextView bookISBN;
    private TextView book_summary;
    TextView title;
    TextView brief;
    private TextView haveReadDay;
    private ImageView bookImage;
    private ScrollView scrollView;
    private LinearLayoutManager mLayoutManager;
    private ProgressBar readProgress;
    private CommentListAdapter adapter;

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
        addDate();
        refreshList();
        initShake();
    }

    //刷新事件
    private void refreshList() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        addDate();
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();
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
        update=findViewById(R.id.update);
    }

    //向评论adapter中添加数据
    private void addDate() {
        long userID=1;
        long bookID=Long.parseLong(book_ISBN);
        HttpUtils.doGetAsy("http://139.196.36.97:8080/sbDemo/v1/note-management/notes?userid="+userID+"&bookid="+bookID,new HttpUtils.CallBack() {
            @Override
            public void onRequestComplete(String result) {
                try {
                    JSONArray jsonArray=JSONArray.parseArray(result);
                    bookCommentList = NoteGetFromDB.parsingBookCom(jsonArray);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        adapter = new CommentListAdapter(bookCommentList);
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
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputTitleDialog();
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

    private void initShake() {
        ShakeListener mShakeListener = new ShakeListener(this);
        mShakeListener.setOnShakeListener(new ShakeListener.OnShakeListenerCallBack() {
            @Override
            public void onShake() {
                Intent intent = new Intent(mContext, ShakeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void inputTitleDialog() {
        final EditText inputServer = new EditText(this);
        inputServer.setFocusable(true);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("开始页码-结束页码").setView(inputServer).
                setNegativeButton("取消", null);
        builder.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        _User bmobUser= BmobUser.getCurrentUser(_User.class);
                        final long userID=Long.parseLong(bmobUser.getUsername());
                        String Page = inputServer.getText().toString();
                        String[] pageSplit=Page.split("-");
                        final String beginPage=pageSplit[0],
                                endPage=pageSplit[1];
                        JSONObject reqjson = new JSONObject(new LinkedHashMap());
                        reqjson.put("userid",userID);
                        reqjson.put("bookid",Long.parseLong(book_ISBN));
                        reqjson.put("beginpage",Integer.parseInt(beginPage));
                        reqjson.put("endpage",Integer.parseInt(endPage));
                        reqjson.put("content","无");
                        final String request = reqjson.toString();
                        new Thread(new Runnable(){
                            @Override
                            public void run() {
                                try {
                                    HttpUtils.doPost("http://139.196.36.97:8080/sbDemo/v1/note-management/notes?" +
                                            "&userid="+userID+"&bookid="+book_ISBN+ "&beginpage="+beginPage
                                            +"&endpage="+endPage+"&content=无",request);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();
                        finish();
                        Intent intent =new Intent();
                        intent.setClass(mContext, BookInfoActivity.class);
                    }
                });
        builder.show();
    }
}