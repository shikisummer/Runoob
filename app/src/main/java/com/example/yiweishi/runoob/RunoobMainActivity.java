package com.example.yiweishi.runoob;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class RunoobMainActivity extends AppCompatActivity {

    private Button clickbutton;
    private EditText run_message;
    private Button toastbutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runoob_main);

        clickbutton = (Button)findViewById(R.id.click_button);
        run_message = (EditText)findViewById(R.id.run_message);
        toastbutton = (Button)findViewById(R.id.toast_message);

        clickbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = run_message.getText().toString().trim();

                if (message.equals("11")) {
                    ToolUtil.showToast(RunoobMainActivity.this, "输入11");
                } else {
                    Intent it = new Intent(RunoobMainActivity.this, MessageActivity.class);
                    it.putExtra("itmessage", message);
                    startActivity(it);
                }
            }
        });
    }

}

