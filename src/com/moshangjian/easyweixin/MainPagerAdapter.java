package com.moshangjian.easyweixin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MainPagerAdapter extends FragmentPagerAdapter {

	public MainPagerAdapter(FragmentManager fm) {
		super(fm);
	}
	
	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
			return new FirstFragment() ; 
		case 1:
			return new SecendFragment() ; 
		case 2:
			return new ThirdFragment() ; 
		case 3:
			return new FourFragment() ; 
		}
		return new FirstFragment() ;
	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 4;
	}
}
