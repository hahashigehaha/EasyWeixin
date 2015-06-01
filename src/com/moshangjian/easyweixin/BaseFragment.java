package com.moshangjian.easyweixin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public abstract class BaseFragment extends Fragment {
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		TextView textView = new TextView(getActivity());
		textView.setText(getFragmentName());
		textView.setTextSize(30);
		return textView;
	}
	
	protected abstract String getFragmentName(); 
	
}
