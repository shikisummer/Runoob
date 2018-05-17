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
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity {

    private TextView text1;
    private Button button_toast;
    private Button button_show;
    private Button button_dialog;

    private Context mContext;
    private NotificationManager mNManger;
    private PendingIntent pit;
    private Intent noit;

    Bitmap  LargeBitmap = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        mContext = MessageActivity.this;
        LargeBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.run);
        mNManger = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);



        //获取main文本
        text1 = (TextView)findViewById(R.id.text1);
        Intent it = getIntent();
        final String message = it.getStringExtra("itmessage");
        text1.setText("登陆信息："+message);

        button_toast = (Button) findViewById(R.id.button_toast);
        button_show = (Button) findViewById(R.id.button_show);
        button_dialog = (Button) findViewById(R.id.button_dialog);

        //状态栏
        button_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //获取通知栏管理

                NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(mContext);

                Intent noit = new Intent(mContext, NotifshowActivity.class);
                PendingIntent pit = PendingIntent.getActivity(mContext, 0, noit, 0);

                mbuilder.setContentTitle("RUN")
                        //.setAutoCancel(true) //点击后自动消失
                        .setContentText(message)
                        .setSmallIcon(R.mipmap.run)
                        .setLargeIcon(LargeBitmap)
                        .setContentIntent(pit);

                Notification notification = mbuilder.build();

                int id = 0;

                mNManger.notify(id, notification);
            }
        });

        //显示来自网页图片长按显示原图片
        Intent intent = getIntent();
        final String  imageURL = intent.getStringExtra("imgUrl");

        TextView text2 = (TextView)findViewById(R.id.text2);
        text2.setText("图片地址："+imageURL);


        Bitmap bitmap = BitmapFactory.decodeFile(imageURL);
        ImageView showWebViewPic = (ImageView)findViewById(R.id.showWebViewPic);
        showWebViewPic.setImageBitmap(bitmap);


    }
}
