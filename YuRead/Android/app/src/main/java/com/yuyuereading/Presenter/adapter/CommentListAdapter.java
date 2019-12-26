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
import android.widget.TextView;

import com.yuyuereading.model.bean.BookComment;
import com.yuyuereading.presenter.activity.CommentActivity;
import com.yuyuereading.R;

import java.util.List;


public class CommentListAdapter extends RecyclerView.Adapter<CommentListAdapter.ViewHolder>{
    private Context mContext;

    private final List<BookComment> mBookCommentList;

    //构造方法
    public CommentListAdapter(List<BookComment> bookCommentList) {
        mBookCommentList = bookCommentList;
    }

    @Override
    public CommentListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (mContext == null) {
            mContext = parent.getContext();
        }
        view = LayoutInflater.from(mContext).inflate(R.layout.comment_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(CommentListAdapter.ViewHolder holder, int position) {
        final BookComment bookComment = mBookCommentList.get(position);
        holder.finish_time.setText(bookComment.getFinish_time());
        holder.page_update.setText(bookComment.getPage_update());
        holder.read_review.setText(bookComment.getRead_review());
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //单击评论的触发事件
                Intent intent = new Intent(mContext, CommentActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("bookComment", bookComment);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBookCommentList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final CardView cardView;
        final View mItemView;
        final TextView read_review;
        final TextView page_update;
        final TextView finish_time;
        ViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            cardView = (CardView) itemView;
            read_review = itemView.findViewById(R.id.readReview);
            page_update = itemView.findViewById(R.id.pageUpdate);
            finish_time = itemView.findViewById(R.id.finishTime);
        }
    }
}
