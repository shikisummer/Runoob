package com.example.yiweishi.runoob;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {

    private TextView text1;
    private Button imagebutton;
    private Button button_show;
    private Button button_close;

    private Context mContext;
    private NotificationManager mNManger;
    private Notification notify1;
    Bitmap  LargeBitmap = null;
    private static final int NOTIFYID_1 = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        mContext = MessageActivity.this;
        imagebutton = (Button)findViewById(R.id.button_image);
        text1 = (TextView)findViewById(R.id.text1);
        Intent it = getIntent();
        String message = it.getStringExtra("itmessage");
        text1.setText(message);

        //通知栏大图标

        LargeBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.run);

        //获取通知栏管理
        mNManger = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);


        button_show = (Button)findViewById(R.id.button_show);
        button_close = (Button)findViewById(R.id.button_close);

        button_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //实例化通知栏
                Notification.Builder mBuilder = new Notification.Builder(mContext);

                mBuilder.setContentTitle("Run")
                        .setContentText("Run to wo")
                        .setLargeIcon(LargeBitmap);
                        //.setContentIntent(pit);

                //Intent it = new Intent(mContext,NotifshowActivity.class);
                //PendingIntent pit = PendingIntent.getActivity(mContext,0,it,0);



                notify1 = mBuilder.build();
                mNManger.notify(NOTIFYID_1,notify1);

            }
        });
        //button_close.setOnClickListener(this);

    }

    private void bindView(){
        }


/*
    public void onClick(View v){
        switch (v.getId()){

            case R.id.button_show:
                break;

        }
    }
*/

}
