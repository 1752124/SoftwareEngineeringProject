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
import com.yuyuereading.presenter.utils.HttpUtils;

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
        long userId=1;
        int state=1;
//        String title= input_book_name.getText().toString();
//        String author=input_author_name.getText().toString();
//        String publicName= input_public_name.getText().toString();
//        long isbn=Long.parseLong(input_isbn.getText().toString());
        String title= "12345";
        String author="324";
        String publicName="24142";
        long isbn=12354;

        String request="userid="+userId+"&bookid="+isbn+"&state="+state+"&title="+title
                +"&author="+author+"&publisher="+publicName;
        HttpUtils.doPostAsy("http://139.196.36.97:8080/sbDemo/v1/read-management/books?",request, new HttpUtils.CallBack() {
            @Override
            public void onRequestComplete(String result){
                Toast.makeText(AddBookActivity.this, "录入成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
