package com.yuyuereading.Presenter.activity;

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

public class AddBookActivity extends AppCompatActivity {
    Button finishEdit,returnButton;
    TextView book_name,author_name,isbn,public_name,title;
    EditText input_book_name,input_author_name,input_isbn,input_public_name;
    ScrollView scrollView;

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

                Toast.makeText(AddBookActivity.this, "录入成功", Toast.LENGTH_SHORT).show();
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
