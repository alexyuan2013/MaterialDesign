package com.example.alex.materialdesign.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.alex.materialdesign.R;
import com.example.alex.materialdesign.adapter.ViewPagerAdapter;

/**
 * TabLayout的使用
 * TabLayout需要配合ViewPager试用，即需要adapter
 * Created by alex on 2015/12/4.
 */
public class TabsActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        //需要配合Manifest文件中parentActivityName属性试用，执行向上返回的操作
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //设置ViewPager
        mViewPager = (ViewPager)findViewById(R.id.viewPager);
        //绑定Fragment到ViewPager
        setupViewPager(mViewPager);

        //绑定ViewPager到TabLayout上
        mTabLayout = (TabLayout)findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    //绑定Fragment到ViewPager
    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "ONE");
        adapter.addFragment(new TwoFragment(),"TWO");
        adapter.addFragment(new ThreeFragment(), "THREE");
        viewPager.setAdapter(adapter);
    }


}
