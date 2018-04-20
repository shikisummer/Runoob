package com.example.yiweishi.runoob;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ToolUtil {

    public static void showToast(Context context,String str){


        Toast toast = Toast.makeText(context,str,Toast.LENGTH_SHORT);

        toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL,0,0);
        toast.show();

    }
}