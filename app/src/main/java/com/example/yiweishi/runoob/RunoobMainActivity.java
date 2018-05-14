package com.example.yiweishi.runoob;


import android.content.Context;

import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;

import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

public class RunoobMainActivity extends AppCompatActivity implements OneFragment.SendMessageCom{

    private Context mContext;

    private Toolbar toolbar;
    private ActionMenuView mActionMenuView;

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    private Button clickbutton;
    private EditText run_message;
    private Button dialogbutton;
    private Button ViewPagerButton;

    private AlertDialog.Builder builder = null;
    private AlertDialog alert =null;


    // 為了讓 Toolbar 的 Menu 有作用，這邊的程式不可以拿掉
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    //Main
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runoob_main);

        mContext = RunoobMainActivity.this;

        //设置toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("MainPager");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);//设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*使用ActionMenuView控制组件位置
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mActionMenuView = (ActionMenuView)findViewById(R.id.amv_search);
        */

        toolbar.setNavigationIcon(R.mipmap.ab_android);
        //menu点击事件
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.action_edit:
                        ToolUtil.showToast(mContext, "点击了edit");
                        break;
                }
                return true;
            }
        });
        mainviewpager();

/*      clickbutton = (Button)findViewById(R.id.click_button);
        run_message = (EditText)findViewById(R.id.run_message);
        dialogbutton = (Button)findViewById(R.id.dialog_message);
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
*/
    }
    //设置主界面切换view 将tablayout 与 viewPager关联
    public void mainviewpager(){
        mViewPager = (ViewPager) findViewById(R.id.main_view);
        mTabLayout = (TabLayout)findViewById(R.id.toolbarTab);

        List<String> titles = new ArrayList<>();
        titles.add("Page One");
        titles.add("Page Two");
        titles.add("Page Three");

        //初始化界面
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());

        //构建适配器
        Fragmentadapter adapter = new Fragmentadapter(getSupportFragmentManager(),fragments,titles);
        mViewPager.setAdapter(adapter);
        //为mTabLayout设置ViewPager
        mTabLayout.setupWithViewPager(mViewPager);
    }

    //activity里implement这个接口，并实现抽象方法
    @Override
    public void sendMessage(String msg){
        ToolUtil.showToast(mContext,msg);
    }
}

