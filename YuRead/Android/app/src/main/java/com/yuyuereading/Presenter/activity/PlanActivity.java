package com.yuyuereading.presenter.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yuyuereading.R;

import java.util.Timer;
import java.util.TimerTask;

public class PlanActivity extends AppCompatActivity {

    private Button back;
    /*private TextView tv_timer;
    private ImageView img_start;
    private boolean isStopCount = false;

    private boolean isPause = true;

    private Handler mHandler = new Handler();

    private long timer = 0;
    private String timeStr = "";*/
    private static String  TAG = "TimerDemo";

    private TextView mTextView = null;
    private Button mButton_start = null;
    private Button mButton_pause = null;

    private Timer mTimer = null;
    private TimerTask mTimerTask = null;

    private Handler mHandler = null;

    private static int count = 0;
    private boolean isPause = false;
    private boolean isStop = true;

    private static int delay = 1000;  //1s
    private static int period = 1000;  //1s

    private static final int UPDATE_TEXTVIEW = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        back=findViewById(R.id.plan_return);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTextView = (TextView)findViewById(R.id.mytextview);
        mButton_start = (Button)findViewById(R.id.mybutton_start);
        mButton_pause = (Button)findViewById(R.id.mybutton_pause);


        mButton_start.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (isStop) {
                    Log.i(TAG, "Start");
                    count = 0;
                } else {
                    Log.i(TAG, "Stop");
                }

                isStop = !isStop;

                if (!isStop) {
                    startTimer();
                }else {
                    stopTimer();
                }

                if (isStop) {
                    mButton_start.setText(R.string.start);
                    count = 0;
                } else {
                    mButton_start.setText(R.string.stop);
                }
            }
        });

        mButton_pause.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (isPause) {
                    Log.i(TAG, "Resume");
                } else {
                    Log.i(TAG, "Pause");
                }

                isPause = !isPause;

                if (isPause) {
                    mButton_pause.setText(R.string.resume);
                } else {
                    mButton_pause.setText(R.string.pause);
                }
            }
        });

        mHandler = new Handler(){

            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case UPDATE_TEXTVIEW:
                        updateTextView();
                        break;
                    default:
                        break;
                }
            }
        };
    }

    private void updateTextView(){
        mTextView.setText(String.valueOf(count));
    }

    private void startTimer(){
        if (mTimer == null) {
            mTimer = new Timer();
        }

        if (mTimerTask == null) {
            mTimerTask = new TimerTask() {
                @Override
                public void run() {
                    Log.i(TAG, "count: "+String.valueOf(count));
                    sendMessage(UPDATE_TEXTVIEW);

                    do {
                        try {
                            Log.i(TAG, "sleep(1000)...");
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                    } while (isPause);

                    count ++;
                }
            };
        }

        if(mTimer != null && mTimerTask != null )
            mTimer.schedule(mTimerTask, delay, period);

    }

    private void stopTimer(){

        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }

        if (mTimerTask != null) {
            mTimerTask.cancel();
            mTimerTask = null;
        }

        count = 0;

    }

    public void sendMessage(int id){
        if (mHandler != null) {
            Message message = Message.obtain(mHandler, id);
            mHandler.sendMessage(message);
        }
    }




/*    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        findViews();
        countTimer();
        back=findViewById(R.id.plan_return);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }*/


   /* private void findViews() {
        tv_timer = findViewById(R.id.tv_timer);
        img_start = findViewById(R.id.img_start);
        //img_start.setOnClickListener((View.OnClickListener) this);
    }

    //@Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_start:
                if(!isPause){
                    isPause = true;
                    isStopCount = false;
                    img_start.setImageResource(R.drawable.btn_pause);
                } else{
                    isPause = false;
                    isStopCount = true;
                    img_start.setImageResource(R.drawable.btn_start);
                }
                break;

            default:
                break;
        }
    }

    private Runnable TimerRunnable = new Runnable() {

        @Override
        public void run() {
            if(!isStopCount){
                timer += 1000;
                timeStr = TimeUtil.getFormatTime(timer);
                tv_timer.setText(timeStr);
            }
            countTimer();
        }
    };

    private void countTimer(){
        mHandler.postDelayed(TimerRunnable, 1000);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(TimerRunnable);
    }
*/


}
