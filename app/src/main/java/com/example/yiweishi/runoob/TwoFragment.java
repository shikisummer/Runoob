package com.example.yiweishi.runoob;



import android.os.Bundle;


import android.support.v4.app.Fragment;
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

        //mWebView.getSettings().setJavaScriptEnabled(true);
        //mWebView.setWebViewClient(new WebViewClient());

        return view;
    }

}
