package com.moshangjian.easyweixin;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    private NavigationBarView mNavBarView;
	private ViewPager mViewPager;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mViewPager = (ViewPager) findViewById(R.id.main_viewpager);
        mNavBarView = (NavigationBarView) findViewById(R.id.main_navigation_bar);
        
        mNavBarView.setViewPager(mViewPager);
        
        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        
    }
	
	
	

}
