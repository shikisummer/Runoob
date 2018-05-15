package com.example.yiweishi.runoob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        //webView实现
        WebView mWebView = (WebView)findViewById(R.id.message_webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("http://www.baidu.com/");
    }
}
