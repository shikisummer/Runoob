package com.example.yiweishi.runoob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        //webView实现
        final WebView mWebView = (WebView)findViewById(R.id.message_webView);
        mWebView.loadUrl("http://www.sina.com.cn");
        //允许使用JS
        mWebView.getSettings().setJavaScriptEnabled(true);
        /** * LOAD_CACHE_ONLY: 不使用网络，只读取本地缓存数据
         * * LOAD_DEFAULT: （默认）根据cache-control决定是否从网络上取数据。
         * * LOAD_NO_CACHE: 不使用缓存，只从网络获取数据.
         * * LOAD_CACHE_ELSE_NETWORK，只要本地有，无论是否过期，或者no-cache，都使用缓存中的数据。 */
        //不使用缓存只从网路获取
        //mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        //使页面在本页面显示而非系统浏览器
        mWebView.setWebViewClient(new WebViewClient());
        //后退监听
        mWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction()==KeyEvent.ACTION_DOWN){
                    if(keyCode==KeyEvent.KEYCODE_BACK && mWebView.canGoBack()){
                        mWebView.goBack();
                        return true;
                    }
                }
                return false;
            }
        });
    }

}
