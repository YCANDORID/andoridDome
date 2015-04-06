/**
 * <Title:Tab2Fragment.java>
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
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * 功能：Tab2
 */
public class Tab2Fragment extends Fragment
{
	private TextView tab2;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_tab2, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		tab2 = (TextView) getView().findViewById(R.id.tab2);
		tab2.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				tab2.setTextColor(Color.CYAN);
			}
		});
	}

}
