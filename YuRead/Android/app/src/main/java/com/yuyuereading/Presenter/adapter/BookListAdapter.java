package com.yuyuereading.presenter.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.willy.ratingbar.ScaleRatingBar;
import com.yuyuereading.model.bean.BookInfo;
import com.yuyuereading.model.bean._User;
import com.yuyuereading.presenter.activity.BookInfoActivity;
import com.yuyuereading.presenter.activity.CommentActivity;
import com.yuyuereading.presenter.activity.ReadingActivity;
import com.yuyuereading.presenter.activity.SeenActivity;
import com.yuyuereading.presenter.activity.WantReadActivity;
import com.yuyuereading.R;
import com.yuyuereading.presenter.utils.HttpUtils;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import cn.bmob.v3.BmobUser;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder>{

    private Context mContext;

    private List<BookInfo> mBookInfoList;

    private String mStatus;

    //构造方法
    public BookListAdapter(List<BookInfo> bookInfoList,String status) {
        mBookInfoList = bookInfoList;
        mStatus = status;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (mContext == null) {
            mContext = parent.getContext();
        }
        switch (mStatus) {
            case "want":
                view = LayoutInflater.from(mContext).inflate(R.layout.want_to_read_item, parent, false);
                break;
            case "reading":
                view = LayoutInflater.from(mContext).inflate(R.layout.reading_item, parent, false);
                break;
            case "recommend":
                view = LayoutInflater.from(mContext).inflate(R.layout.book_list_item,parent,false);
                break;
            default:
                view = LayoutInflater.from(mContext).inflate(R.layout.seen_item, parent, false);
                break;
        }
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final BookInfo bookInfo = mBookInfoList.get(position);
        holder.bookName.setText(bookInfo.getBook_name());
        Glide.with(mContext)
                .load(bookInfo.getBook_image())
                .into(holder.bookImage);
        holder.authorName.setText(bookInfo.getBook_author());
        holder.publicName.setText(bookInfo.getBook_publisher());
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, BookInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("bookInfo", bookInfo);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
                //overridePendingTransition(R.anim.slide_right_in,R.anim.slide_left_out);
            }
        });

        switch (mStatus) {
            case "want":
                holder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        _User bmobUser= BmobUser.getCurrentUser(_User.class);
                        final long userID=Long.parseLong(bmobUser.getUsername());
                        final long isbn=Long.parseLong(bookInfo.getBook_isbn13());
                        JSONObject reqjson = new JSONObject(new LinkedHashMap());
                        reqjson.put("userid",userID);
                        reqjson.put("bookid",isbn);
                        reqjson.put("state",2);
                        final String request = reqjson.toString();
                        new Thread(new Runnable(){
                            @Override
                            public void run() {
                                try {
                                    HttpUtils.doPost("http://139.196.36.97:8080/sbDemo/v2/read-management/states?"
                                            +"userid="+userID+"&bookid="+isbn+"&state="+2,request);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();
                        Toast.makeText(mContext,"修改成功",Toast.LENGTH_SHORT).show();

                        //overridePendingTransition(R.anim.slide_right_in,R.anim.slide_left_out);
                    }
                });
                break;
            case "reading":
                holder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        _User bmobUser= BmobUser.getCurrentUser(_User.class);
                        final long userID=Long.parseLong(bmobUser.getUsername());
                        final long isbn=Long.parseLong(bookInfo.getBook_isbn13());
                        JSONObject reqjson = new JSONObject(new LinkedHashMap());
                        reqjson.put("userid",userID);
                        reqjson.put("bookid",isbn);
                        reqjson.put("state",3);
                        final String request = reqjson.toString();
                        new Thread(new Runnable(){
                            @Override
                            public void run() {
                                try {
                                    HttpUtils.doPost("http://139.196.36.97:8080/sbDemo/v2/read-management/states?"
                                            +"userid="+userID+"&bookid="+isbn+"&state="+3,request);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();
                        Toast.makeText(mContext,"修改成功",Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case "recommend":
                holder.simpleRatingBar.setRating(Float.parseFloat(bookInfo.getBook_rating())/2);
                holder.rating.setText(bookInfo.getBook_rating());
                holder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, WantReadActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("bookName", bookInfo.getBook_name());
                        intent.putExtras(bundle);
                        mContext.startActivity(intent);
                    }
                });
                break;
            default:
                holder.rating.setText(bookInfo.getBook_rating());
                holder.simpleRatingBar.setRating(Float.parseFloat(bookInfo.getBook_rating())/2);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mBookInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        Button button;
        View mItemView;
        ImageView bookImage;
        ScaleRatingBar simpleRatingBar;
        TextView bookName,rating,authorName,publicName;

        ViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            cardView = (CardView) itemView;
            bookImage = itemView.findViewById(R.id.book_image);
            bookName = itemView.findViewById(R.id.book_name);
            authorName = itemView.findViewById(R.id.author_name);
            publicName = itemView.findViewById(R.id.public_name);
            switch (mStatus) {
                case "want":
                    button = itemView.findViewById(R.id.button_reading);
                    break;
                case "reading":
                    button = itemView.findViewById(R.id.button_seen);
                    break;
                case "recommend":
                    rating = itemView.findViewById(R.id.rating);
                    simpleRatingBar = itemView.findViewById(R.id.simpleRatingBar);
                    button=itemView.findViewById(R.id.button_add);
                    break;
                default:
                    rating = itemView.findViewById(R.id.rating);
                    simpleRatingBar = itemView.findViewById(R.id.simpleRatingBar);
                    break;
            }
        }
    }
}