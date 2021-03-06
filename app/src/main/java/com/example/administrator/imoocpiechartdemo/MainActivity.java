package com.example.administrator.imoocpiechartdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

private String mJson="[{\"date\":\"2016年5月\",\"obj\":[{\"title\":\"外卖\",\"value\":34}," +
        "{\"title\":\"娱乐\",\"value\":21},{\"title\":\"其他\",\"value\":45}]},\" +" +
        "\"{\"date\":\"2016年6月\",\"obj\":[{\"title\":\"外卖\",\"value\":32},\" +" +
        "\"{\"title\":\"娱乐\",\"value\":22},{\"title\":\"其他\",\"value\":42}]},\" +" +
        "\"{\"date\":\"2016年7月\",\"obj\":[{\"title\":\"外卖\",\"value\":34},\" +" +
        "\"{\"title\":\"娱乐\",\"value\":123},{\"title\":\"其他\",\"value\":24}]},\" +" +
        "\"{\"date\":\"2016年8月\",\"obj\":[{\"title\":\"外卖\",\"value\":145},\" +" +
        "\"{\"title\":\"娱乐\",\"value\":123},{\"title\":\"其他\",\"value\":124}]}]";
    private ViewPager vpMain;
    private ArrayList<MonthBean> mData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vpMain = ((ViewPager) findViewById(R.id.vp_main));
        initData();
        initView();

    }

    private void initData() {
        Gson gson=new Gson();
       mData=gson.fromJson(mJson,new TypeToken<ArrayList<MonthBean>>(){}.getType());
    }

    private void initView() {
        vpMain.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return PieFragment.newInstance(position+"");
            }

            @Override
            public int getCount() {
                return 4;
            }
        });
    }
}
