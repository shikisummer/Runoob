package com.example.yiweishi.runoob;



import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



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
    }




}





