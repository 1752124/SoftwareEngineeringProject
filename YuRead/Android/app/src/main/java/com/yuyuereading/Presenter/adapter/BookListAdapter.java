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

import com.bumptech.glide.Glide;
import com.willy.ratingbar.ScaleRatingBar;
import com.yuyuereading.model.bean.BookInfo;
import com.yuyuereading.presenter.activity.BookInfoActivity;
import com.yuyuereading.presenter.activity.ReadingActivity;
import com.yuyuereading.presenter.activity.SeenActivity;
import com.yuyuereading.presenter.activity.WantReadActivity;
import com.yuyuereading.R;

import java.util.List;

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
                        Intent intent = new Intent(mContext, ReadingActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("bookInfo", bookInfo);
                        intent.putExtras(bundle);
                        mContext.startActivity(intent);
                        //overridePendingTransition(R.anim.slide_right_in,R.anim.slide_left_out);
                    }
                });
                break;
            case "reading":
                holder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(mContext, SeenActivity.class);
                        mContext.startActivity(intent);
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