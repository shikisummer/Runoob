package com.example.yiweishi.runoob;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 *
 */



public class OneFragment extends Fragment {

    private SendMessageCom sendMessage;

    //用于传递事件给activity 接口
    public interface SendMessageCom{
        void sendMessage(String msg);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        /*ToolUtil.showToast(getActivity(), "欢迎来到简明现代魔法～");*/

        return inflater.inflate(R.layout.fragment_one,container,false);
        /*TextView textViewOnePager =(TextView)view.findViewById(R.id.frameOne);
        textViewOnePager.setText("One pager");*/
    }
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        sendMessage =(SendMessageCom) activity;
    }

    //使用接口实现需求
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Button diabutton = (Button)getActivity().findViewById(R.id.dialog_message);
        diabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage.sendMessage("欢迎来到简明现代魔法～");
            }
        });



        //使用非接口方法实现需求
        //登陆测试
        Button clickbutton = (Button)getActivity().findViewById(R.id.click_button);
        final EditText run_message = (EditText)getActivity().findViewById(R.id.run_message);
        clickbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = run_message.getText().toString().trim();
                if (message.equals("11")) {
                    ToolUtil.showToast(getActivity(), "输入非11");
                } else {
                    Intent it = new Intent(getActivity(), MessageActivity.class);
                    it.putExtra("itmessage", message);
                    startActivity(it);
                }
            }
        });

        //跳转至WebView
        Button WebViewButton = (Button)getActivity().findViewById(R.id.WebViewButton);
        WebViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), WebViewActivity.class);
                startActivity(it);

            }
        });

    }




}





