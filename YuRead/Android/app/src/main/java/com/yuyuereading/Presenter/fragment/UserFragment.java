package com.yuyuereading.presenter.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yuyuereading.R;
import com.yuyuereading.presenter.activity.AddBookActivity;
import com.yuyuereading.presenter.activity.BookListActivity;
import com.yuyuereading.presenter.activity.NicknameActivity;
import com.yuyuereading.presenter.activity.UserInfoActivity;
import com.yuyuereading.view.CircleImageView;

import java.io.Serializable;

public class UserFragment extends Fragment {
    UserFragment userFragment;

    private View view;
    private CircleImageView portrait;
    private TextView nickname;
    private TextView sumBook;
    private TextView sumDay;
    private TextView sumSeen;
    private TextView sumRecord;
    private String mParam1;
    private String mParam2;
    private static final float mStartAngle = -90;
    private int mRingColor = Color.parseColor("#F05A4A");
    private int mSectorColor = Color.parseColor("#29AB91");
    private float mEndAngle = mStartAngle;
    private float mSweepAngle = 0;
    private float mCircleWidth = 0;
    private float mDotRadius = 6f;
    private float mTextSize = 23.5f;
    private String reminderText = "剩余";
    private String progressText = "已读";
    private float centerX;
    private float centerY;
    private float mOuterRadius;
    private float mInnerRadius;
    private Paint mPaint;
    private Paint mTextPaint;
    private Path mPath;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    public static UserFragment newInstance(String param1, String param2) {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_user_info, container, false);
        //initView();
        //getData();
        sumBook=view.findViewById(R.id.sum_book);
        sumDay=view.findViewById(R.id.sum_days);
        sumSeen=view.findViewById(R.id.seen_book);
        sumRecord=view.findViewById(R.id.sum_record);
        nickname=view.findViewById(R.id.nickname);
        portrait=view.findViewById(R.id.user_info_icon);
       /* nickname.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NicknameActivity.class);
                startActivity(intent);
               *//* Bundle bundle = new Bundle();
                bundle.putSerializable("nickname", (Serializable) nickname);
                intent.putExtras(bundle);*//*
            }
        });*/
        portrait.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"点击事件", Toast.LENGTH_SHORT).show();
            }
        });
        sumBook.setText("13本");
        sumDay.setText("86天");
        sumSeen.setText("8本");
        sumRecord.setText("50条");
        return view;
    }

    /*@RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    private void initView() {
        sumBook=view.findViewById(R.id.sum_book);
        sumDay=view.findViewById(R.id.sum_days);
        sumSeen=view.findViewById(R.id.seen_book);
        sumRecord=view.findViewById(R.id.sum_record);
        nickname=view.findViewById(R.id.nickname);
        portrait=view.findViewById(R.id.user_info_icon);
    }*/
/*    private void getData() {
        sumBook.setText("13本");
        sumRecord.setText("50条");
        sumDay.setText("86天");
        sumSeen.setText("8本");
    }*/
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        nickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NicknameActivity.class);
                startActivity(intent);
            }
        });
    }
}
