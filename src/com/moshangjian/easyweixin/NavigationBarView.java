package com.moshangjian.easyweixin;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class NavigationBarView extends LinearLayout {

	public NavigationBarView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}
	
	public NavigationBarView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}
	
	public NavigationBarView(Context context) {
		super(context);
		init(context);
	}
	
	private void init(Context context){
		setOrientation(LinearLayout.HORIZONTAL);
		setBackgroundColor(Color.parseColor("#fcfcfc"));
		LayoutInflater inflater = LayoutInflater.from(context);
		inflater.inflate(R.layout.navigation_bar, this);
		
	}
	
	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		one = (BottomSingleView) findViewById(R.id.nav_one);
		two = (BottomSingleView) findViewById(R.id.nav_two);
		three = (BottomSingleView) findViewById(R.id.nav_three);
		four = (BottomSingleView) findViewById(R.id.nav_four);
	}
	
	public void setViewPager(ViewPager mViewPager){
		mViewPager.setOnPageChangeListener(listener);
	}

	
   private OnPageChangeListener listener = new OnPageChangeListener(){
	   @Override
	   public void onPageScrollStateChanged(int arg0) {
	   }
	   @Override
	   public void onPageScrolled(int position, float positionOffset, int arg2) {
		   setChildProgress(position, 1 - positionOffset);
		   setChildProgress(position + 1, positionOffset);
	   }
	   @Override
	   public void onPageSelected(int arg0) {
	   }
  };
  
  
  
  private  void setChildProgress(int position , float progress){
	  switch (position) {
		case 0 :
			one.setProgress(progress);
			break;
		case 1:
			two.setProgress(progress);
				break;
		case 2 :
			three.setProgress(progress);
			break;
		case 3 :
			four.setProgress(progress);
			break;
	}
  }
private BottomSingleView one;
private BottomSingleView two;
private BottomSingleView three;
private BottomSingleView four;
}
