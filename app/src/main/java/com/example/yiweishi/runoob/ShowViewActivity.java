package com.example.yiweishi.runoob;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowViewActivity extends AppCompatActivity {

    private ViewPager vpager_one;
    private ImageView showPagerPic;
    private TextView textShowView1;
    private TextView textShowView2;
    private TextView textShowView3;

    private ArrayList<View> aList;
    private int offset = 0;
    private int currIdex = 0;
    private int bpmWidth;
    private int one = 0;
    private int two = 0;
    private Context mContext;
    private MyPagerAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_view);

        //切换界面方法
        initViews();

        //点击后切换视图
        textShowView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vpager_one.setCurrentItem(0);
            }
        });
        textShowView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vpager_one.setCurrentItem(1);
            }
        });
        textShowView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vpager_one.setCurrentItem(2);
            }
        });




        vpager_one.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                Animation animation = null;
                switch (position){

                    case 0:
                        if (currIdex ==1){
                            animation = new TranslateAnimation(one,0,0,0);
                        }else if (currIdex ==2){
                            animation = new TranslateAnimation(two,0,0,0);
                        }
                break;

                    case 1:
                        if (currIdex ==0){
                            animation = new TranslateAnimation(offset,one,0,0);//(左右移动起始，结束，上下移动起始，结束)
                        }else if (currIdex ==2){
                            animation = new TranslateAnimation(two,one,0,0);
                        }
                        break;

                    case 2:
                        if (currIdex ==0){
                            animation = new TranslateAnimation(offset,two,0,0);
                        }else if (currIdex ==1){
                            animation = new TranslateAnimation(one,two,0,0);
                        }
                        break;
                }

                currIdex = position;
                animation.setFillAfter(true);
                animation.setDuration(300);
                showPagerPic.startAnimation(animation);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initViews(){

        textShowView1 = (TextView)findViewById(R.id.textShowView1);
        textShowView2 = (TextView)findViewById(R.id.textShowView2);
        textShowView3 = (TextView)findViewById(R.id.textShowView3);
        showPagerPic = (ImageView)findViewById(R.id.showPagerPic);
        mContext = ShowViewActivity.this;

        //计算滑块移动偏移量
        bpmWidth = BitmapFactory.decodeResource(getResources(),R.mipmap.line).getWidth();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        offset = (screenW/3-bpmWidth)/2;
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset,0);
        showPagerPic.setImageMatrix(matrix);
        one = offset*2+bpmWidth;
        two =one*2;


        //获取view视图
        vpager_one = (ViewPager) findViewById(R.id.showViewPager);

        aList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.view_one,null,false));
        aList.add(li.inflate(R.layout.view_two,null,false));
        aList.add(li.inflate(R.layout.view_three,null,false));
        mAdapter = new MyPagerAdapter(aList);
        vpager_one.setAdapter(mAdapter);
        vpager_one.setCurrentItem(0);   //设置ViewPage当前页 从0计算
    }



}
