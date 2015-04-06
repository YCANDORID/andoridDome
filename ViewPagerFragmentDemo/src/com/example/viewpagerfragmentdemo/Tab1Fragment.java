/**
 * <Title:Tab1Fragment.java>
 * <Description:>
 * <Company:杭州手趣科技有限公司>
 * <Author:>
 * <Mender:2014-8-26>
 * <Version:>
 */
package com.example.viewpagerfragmentdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 功能：Tab1
 */
public class Tab1Fragment extends Fragment
{

	private TextView tab1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_tab1, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		tab1 = (TextView) getView().findViewById(R.id.tab1);
		tab1.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				tab1.setTextColor(Color.BLUE);
			}
		});
	}
}
