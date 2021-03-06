package com.yuyuereading.presenter.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.willy.ratingbar.ScaleRatingBar;
import com.yuyuereading.model.bean.ReadInfo;
import com.yuyuereading.model.bean._User;
import com.yuyuereading.model.database.OperationReadInfo;
import com.yuyuereading.R;

import java.util.List;

import cn.bmob.v3.BmobUser;

public class WantReadActivity extends AppCompatActivity {

    Boolean bmob_if_hava_read_info = false;
    Context context=WantReadActivity.this;
    Button returnButton,wantButton;
    String book_isbn,book_score;
    ScaleRatingBar bookRating;
    EditText wantReason,wantHope;
    ReadInfo readInfo,readInfo2;
    TextView book_name;
    String bookName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_read);
        //从图书详情页面获取信息
        getInfoFromBookInfo();
        //getInfoFromBmob();
        findView();
        onClick();
        //放入初始化信息
        initInfo();
    }

    private void initInfo() {
        //定义传给数据库操作类的handler
        @SuppressLint("HandlerLeak")
        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        List<ReadInfo> list = (List<ReadInfo>) msg.obj;
                        if (list.size()!=0) {
                            readInfo = list.get(0);
                            //Log.i("bmob","handler传送成功:"+readInfo.getObjectId());
                            wantReason.setText(readInfo.getRead_reason());
                            wantHope.setText(readInfo.getRead_except());
                            bmob_if_hava_read_info = true;
                        }
                        break;
                }
            }
        };
        //通过ISBN先查询一下Bmob数据库中是否有此条记录,有的话就显示出来
        _User bmobUser = BmobUser.getCurrentUser(_User.class);
        OperationReadInfo.queryReadInfo(bmobUser, book_isbn,handler);
    }

    private void onClick() {
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        wantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                final ProgressDialog progress = new ProgressDialog(context);
                progress.setMessage("正在记录...");
                progress.setCanceledOnTouchOutside(false);
                progress.show();

                Integer read_state = 0;
                String want_read_reason = wantReason.getText().toString();
                String want_read_hope = wantHope.getText().toString();
                _User bmobUser = BmobUser.getCurrentUser(_User.class);
                readInfo2 = new ReadInfo(bmobUser, book_isbn, read_state, want_read_reason, want_read_hope, new BmobDate(new Date(System.currentTimeMillis())));
                Log.i("bmob","现在ReadInfo状态:"+bmob_if_hava_read_info);
                if (!bmob_if_hava_read_info) {
                    OperationReadInfo.addReadInfo(readInfo2);
                    progress.dismiss();
                } else {
                    OperationReadInfo.updateReadInfo(readInfo2);
                    progress.dismiss();
                }*/
                finish();
            }
        });

    }

    private void getInfoFromBookInfo() {
        Bundle bundle = getIntent().getExtras();
        bookName=bundle.getString("bookName");
    }



    private void findView() {
        returnButton = findViewById(R.id.want_read_return);
        wantButton = findViewById(R.id.want_read_Button);
        bookRating =  findViewById(R.id.bookRating);
        wantReason = findViewById(R.id.want_read_reason);
        wantHope = findViewById(R.id.want_read_hope);
        book_name=findViewById(R.id.book_name);
        book_name.setText("书名："+bookName);
    }
    public void onBackPressed()
    {
        finish();
    }
}
