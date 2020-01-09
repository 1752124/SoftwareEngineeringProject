package com.yuyuereading.presenter.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.yuyuereading.R;
import com.yuyuereading.model.bean._User;
import com.yuyuereading.presenter.activity.NicknameActivity;
import com.yuyuereading.presenter.utils.HttpUtils;
import com.yuyuereading.view.AnnularChartView;
import com.yuyuereading.view.CircleImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import cn.bmob.v3.BmobUser;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UserFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserFragment extends Fragment {
    UserFragment userFragment;

    private View view;
    private CircleImageView portrait;
    private TextView nickname;
    private TextView sumBook;
    private TextView sumDay;
    private TextView sumSeen;
    private TextView sumRecord;
    private String name;
    private int sum_book;
    private int sum_day;
    private int sum_seen;
    private int sum_record;
    private AnnularChartView annularChartView;
    private String mParam1;
    private String mParam2;

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
        view = inflater.inflate(R.layout.activity_user_info, container, false);
        initView();
        return view;
    }

    public void onResume() {
        super.onResume();
        getData();
    }

    private void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final _User bmobUser = BmobUser.getCurrentUser(_User.class);
                long phoneNumber= Long.parseLong(bmobUser.getUsername());
                HttpUtils.doGetAsy(mHandler,"http://139.196.36.97:8080/sbDemo/v2/user-management/users?id="+phoneNumber, new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {
                        JSONObject jsonObject = JSONObject.parseObject(result);
                        name = jsonObject.getString("name");
                        //final Bitmap image = getBitmap(jsonObject.getString("portrait"));
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                initView();
                                nickname.setText(name);
                                //portrait.setImageBitmap(image);
                            }
                        });
                    }
                    /*private Bitmap getBitmap(String path) {
                        try {
                            URL url = new URL(path);
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setConnectTimeout(5000);
                            conn.setRequestMethod("GET");
                            if (conn.getResponseCode() == 200) {
                                InputStream inputStream = conn.getInputStream();
                                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                                return bitmap;
                            }
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        return null;
                    }*/
                });
                HttpUtils.doGetAsy(mHandler,"http://139.196.36.97:8080/sbDemo/v2/statistic-management/statistics?userid="+phoneNumber, new HttpUtils.CallBack(){
                    @Override
                    public void onRequestComplete(String result) {
                        JSONObject jsonObject = JSONObject.parseObject(result);
                        sum_book = Integer.parseInt(jsonObject.getString("sumBook"));
                        sum_day = Integer.parseInt(jsonObject.getString("sumDay"));
                        sum_seen = Integer.parseInt(jsonObject.getString("sumRead"));
                        sum_record = Integer.parseInt(jsonObject.getString("sumNote"));
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                initView();
                                sumBook.setText(sum_book+"本");
                                sumDay.setText(sum_day+"天");
                                sumSeen.setText(sum_seen+"本");
                                sumRecord.setText(sum_record+"条");
                                annularChartView.setData(new float[]{sum_book-sum_seen, sum_seen});
                            }
                        });
                    }
                });
            }
        }).start();
    }

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    private void initView() {
        sumBook = view.findViewById(R.id.sum_book);
        sumDay = view.findViewById(R.id.sum_days);
        sumSeen = view.findViewById(R.id.seen_book);
        sumRecord = view.findViewById(R.id.sum_record);
        nickname = view.findViewById(R.id.nickname);
        portrait = view.findViewById(R.id.user_info_icon);
        annularChartView = view.findViewById(R.id.annularChartView);
    }

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
        portrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    /**
     * 通过handler将数据回调在主线程执行
     */
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
}
