package com.yuyuereading.presenter.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.yuyuereading.model.bean.BookInfo;
import com.yuyuereading.model.bean._User;
import com.yuyuereading.presenter.activity.BookListActivity;
import com.yuyuereading.R;
import com.yuyuereading.presenter.utils.HttpUtils;
import com.yuyuereading.presenter.utils.SearchFromDouban;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import cn.bmob.v3.BmobUser;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private View view;
    private Button Allanbooklist;
    private Button Oscarbooklist;
    private Button Maobooklist;
    private Button Nobelbooklist;
    List<BookInfo> bookInfos = new ArrayList<>();
    List<BookInfo> bookInfoList = new ArrayList<>();

    ImageView perRem1, perRem2;
    TextView perRem11, perRem22;
    volatile boolean flag = false;

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

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_home, container, false);

        initView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addRec();
    }

    private void addRec() {
        _User bmobUser = BmobUser.getCurrentUser(_User.class);
        final long userID = Long.parseLong(bmobUser.getUsername());
        HttpUtils.doGetAsy(mHandler, "http://139.196.36.97:8080/sbDemo/v2/personalization-management/booklists?userid=" + userID, new HttpUtils.CallBack() {
            @Override
            public void onRequestComplete(String result) {
                try {
                    JSONArray jsonArray = JSONArray.parseArray(result);
                    bookInfoList = SearchFromDouban.parsingBookInfoPerson(jsonArray);
                    Random random = new Random();
                    if (bookInfoList == null || bookInfoList.size() == 0) {
                        return;
                    }
                    int index = random.nextInt(bookInfoList.size() - 2);
                    bookInfos.add(bookInfoList.get(index));
                    bookInfos.add(bookInfoList.get(index + 1));

                    if (bookInfos.size()>=2) {
                        Glide.with(HomeFragment.this).load(bookInfos.get(0).getBook_image()).into(perRem1);
                        Glide.with(HomeFragment.this).load(bookInfos.get(1).getBook_image()).into(perRem2);

                        perRem11.setText(bookInfos.get(0).getBook_name());
                        perRem22.setText(bookInfos.get(1).getBook_name());
                    }
                    flag = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    private void initView() {
        perRem1 = view.findViewById(R.id.perRecom1);
//        Bitmap bm1 = BitmapFactory.decodeFile("https://img1.doubanio.com/view/subject/l/public/s2611329.jpg");
//        perRem1.setImageBitmap(bm1);
        perRem11 = view.findViewById(R.id.perRecom11);
        perRem11.setText("一个陌生女人的来信");

        perRem2 = view.findViewById(R.id.perRecom2);
        perRem22 = view.findViewById(R.id.perRecom22);
//        perRem2.setImageURI(Uri.parse("https://img1.doubanio.com/view/subject/l/public/s3668327.jpg"));
//        perRem22=view.findViewById(R.id.perRecom22);
        perRem22.setText("牧羊少年奇幻之旅");

        Allanbooklist = view.findViewById(R.id.Allan_book_list);
        Oscarbooklist = view.findViewById(R.id.Oscar_book_list);
        Maobooklist = view.findViewById(R.id.Mao_book_list);
        Nobelbooklist = view.findViewById(R.id.Nobel_book_list);

        Allanbooklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte type = 1;
                HttpUtils.doGetAsy(mHandler, "http://139.196.36.97:8080/sbDemo/v2/booklist-management/booklists?type=" + type, new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {
                        try {
                            JSONArray jsonArray = JSONArray.parseArray(result);
                            List<BookInfo> bookInfos = SearchFromDouban.parsingBookInfo(jsonArray);
                            Intent intent = new Intent(getActivity(), BookListActivity.class);
                            intent.putExtra("type", "search");
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("bookInfos", (Serializable) bookInfos);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        Oscarbooklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte type = 2;
                HttpUtils.doGetAsy(mHandler, "http://139.196.36.97:8080/sbDemo/v2/booklist-management/booklists?type=" + type, new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {
                        try {
                            JSONArray jsonArray = JSONArray.parseArray(result);
                            List<BookInfo> bookInfos = SearchFromDouban.parsingBookInfo(jsonArray);
                            Intent intent = new Intent(getActivity(), BookListActivity.class);
                            intent.putExtra("type", "search");
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("bookInfos", (Serializable) bookInfos);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        Maobooklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte type = 3;
                HttpUtils.doGetAsy(mHandler, "http://139.196.36.97:8080/sbDemo/v2/booklist-management/booklists?type=" + type, new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {
                        try {
                            JSONArray jsonArray = JSONArray.parseArray(result);
                            List<BookInfo> bookInfos = SearchFromDouban.parsingBookInfo(jsonArray);
                            Intent intent = new Intent(getActivity(), BookListActivity.class);
                            intent.putExtra("type", "search");
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("bookInfos", (Serializable) bookInfos);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        Nobelbooklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte type = 4;
                HttpUtils.doGetAsy(mHandler, "http://139.196.36.97:8080/sbDemo/v2/booklist-management/booklists?type=" + type, new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {
                        try {
                            JSONArray jsonArray = JSONArray.parseArray(result);
                            List<BookInfo> bookInfos = SearchFromDouban.parsingBookInfo(jsonArray);
                            Intent intent = new Intent(getActivity(), BookListActivity.class);
                            intent.putExtra("type", "search");
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("bookInfos", (Serializable) bookInfos);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        TextView date = view.findViewById(R.id.date);
        Time t = new Time();
        t.setToNow(); // 取得系统时间。
        int year = t.year;
        int month = t.month + 1;
        int day = t.monthDay;
        int weekDay = t.weekDay;
        String weekDayZh;
        switch (weekDay) {
            case 1:
                weekDayZh = "一";
                break;
            case 2:
                weekDayZh = "二";
                break;
            case 3:
                weekDayZh = "三";
                break;
            case 4:
                weekDayZh = "四";
                break;
            case 5:
                weekDayZh = "五";
                break;
            case 6:
                weekDayZh = "六";
                break;
            default:
                weekDayZh = "日";
                break;
        }
        date.setText(year + "年" + month + "月" + day + "日   星期" + weekDayZh);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
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
