package com.example.yiweishi.runoob;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class RunoobMainActivity extends AppCompatActivity {

    private Button clickbutton;
    private EditText run_message;
    private Button dialogbutton;
    private Context mContext;

    private AlertDialog.Builder builder = null;
    private AlertDialog alert =null;

    private Button ViewPagerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runoob_main);

        clickbutton = (Button)findViewById(R.id.click_button);
        run_message = (EditText)findViewById(R.id.run_message);
        dialogbutton = (Button)findViewById(R.id.dialog_message);
        mContext = RunoobMainActivity.this;

        //登陆测试
        clickbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = run_message.getText().toString().trim();

                if (message.equals("11")) {
                    ToolUtil.showToast(mContext, "输入非11");
                } else {
                    Intent it = new Intent(mContext, MessageActivity.class);
                    it.putExtra("itmessage", message);
                    startActivity(it);
                }
            }
        });

        //对话框

        dialogbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                builder = new AlertDialog.Builder(mContext);

                alert = builder.setIcon(R.mipmap.run)
                                .setTitle("提示")
                                .setMessage("信息")
                                .setPositiveButton("sure", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        ToolUtil.showToast(mContext,"确定");
                                    }
                                })

                                .setNegativeButton("cancle", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        ToolUtil.showToast(mContext,"取消");
                                    }
                                })
                                .create(); //创建dialog对象

                alert.show();

            }
        });

        //View切换

        ViewPagerButton = (Button)findViewById(R.id.ViewPagerButton);
        ViewPagerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(mContext,ShowViewActivity.class);

                startActivity(it);

            }
        });


    }

}

