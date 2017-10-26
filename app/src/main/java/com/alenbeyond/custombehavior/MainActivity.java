package com.alenbeyond.custombehavior;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.alenbeyond.custombehavior.adapter.MyVpAdapter;


public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;
    private LinearLayout mHeader;
    private ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTab = (TabLayout) findViewById(R.id.tab);
        mHeader = (LinearLayout) findViewById(R.id.header);
        mVp = (ViewPager) findViewById(R.id.vp);
        mVp.setAdapter(new MyVpAdapter(this));
        mTab.setupWithViewPager(mVp);
    }
}
