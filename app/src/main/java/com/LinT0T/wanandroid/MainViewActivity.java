package com.LinT0T.wanandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainViewActivity extends AppCompatActivity {

    private TextView mtv_title;
    private ViewPager viewPager;
    private List<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);
        mtv_title = findViewById(R.id.tv_title);
        viewPager = findViewById(R.id.vp_main);

        MyFragment fragment = new MyFragment();
        list.add(fragment);
        MyFragment2 fragment2 = new MyFragment2();

        list.add(fragment2);

        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    mtv_title.setText("首页精选");
                }
                if (position == 1) {
                    mtv_title.setText("我的");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setListenrs();


    }

    private void setListenrs() {
        OnClick onClick = new OnClick();

    }

    private class OnClick implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {

            }

        }
    }

}
