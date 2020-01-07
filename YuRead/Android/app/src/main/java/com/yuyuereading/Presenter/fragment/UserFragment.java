package com.yuyuereading.presenter.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yuyuereading.model.bean.BookInfo;
import com.yuyuereading.model.bean._User;
import com.yuyuereading.presenter.activity.BookListActivity;
import com.yuyuereading.R;
import com.yuyuereading.presenter.activity.NicknameActivity;
import com.yuyuereading.presenter.activity.PortraitActivity;
import com.yuyuereading.presenter.utils.HttpUtils;
import com.yuyuereading.presenter.utils.SearchFromDouban;
import com.yuyuereading.view.CircleImageView;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

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
        getData();
        return view;
    }

    private void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final _User bmobUser = BmobUser.getCurrentUser(_User.class);
                long phoneNumber= Long.parseLong(bmobUser.getUsername());
                HttpUtils.doGetAsy("http://139.196.36.97:8080/sbDemo/v1/user-management/users?id="+phoneNumber, new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {
                        JSONObject jsonObject = JSONObject.parseObject(result);
                        name = jsonObject.getString("name");
                        final Bitmap image = getBitmap(jsonObject.getString("portrait"));
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                initView();
                                nickname.setText(name);
                                portrait.setImageBitmap(image);
                            }
                        });
                    }
                    private Bitmap getBitmap(String path) {
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
}
