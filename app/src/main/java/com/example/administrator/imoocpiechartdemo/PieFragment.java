package com.example.administrator.imoocpiechartdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/7/20.
 */

public class PieFragment extends Fragment {
    private static String datakey="piefragment_data_key";
    private String mData;

    public static PieFragment newInstance(String data) {

        Bundle args = new Bundle();
        
        args.putString(datakey,data);
        PieFragment fragment = new PieFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle argments=getArguments();
        if (argments != null) {
            mData = argments.getString(datakey);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textview=new TextView(getContext());
        textview.setText(mData);
        return textview;
    }
}
