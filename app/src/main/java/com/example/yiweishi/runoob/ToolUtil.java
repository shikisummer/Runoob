package com.example.yiweishi.runoob;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ToolUtil {

    public static void showToast(Context context,String str){


        Toast toast = Toast.makeText(context,str,Toast.LENGTH_SHORT);

        toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL,0,0);
        toast.show();

    }
}

