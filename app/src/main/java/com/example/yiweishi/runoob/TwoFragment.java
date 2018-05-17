package com.example.yiweishi.runoob;



import android.os.Bundle;


import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewFragment;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment {


    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two,container,false);
/*
        TextView textViewTwoPager =(TextView)view.findViewById(R.id.frameTwo);
        textViewTwoPager.setText("Two pager");*/

        //WebViewFragment mWebView = (WebViewFragment)getActivity().findViewById(R.id.two_webview)

        //
        return view;
    }
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState ){
        super.onViewCreated(view,savedInstanceState);
        final WebView fwebView =(WebView)getActivity().findViewById(R.id.two_webview);
        fwebView.getSettings().setJavaScriptEnabled(true);
        fwebView.setWebViewClient(new WebViewClient());
        fwebView.loadUrl("http://www.sina.com.cn");
        //后退监听返回上一次浏览的页面
        fwebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction()==KeyEvent.ACTION_DOWN){
                    if(keyCode==KeyEvent.KEYCODE_BACK && fwebView.canGoBack()){
                        fwebView.goBack();
                        return true;
                    }
                }
                return false;
            }
        });
    }

}
