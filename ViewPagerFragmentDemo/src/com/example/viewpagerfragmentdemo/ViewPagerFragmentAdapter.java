/**
 * <Title:ViewPagerFragmentAdapter.java>
 * <Description:>
 * <Company:杭州手趣科技有限公司>
 * <Author:>
 * <Mender:2014-8-26>
 * <Version:>
 */
package com.example.viewpagerfragmentdemo;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * 功能：ViewPager+Fragment适配器
 */
public class ViewPagerFragmentAdapter extends FragmentPagerAdapter
{

	private ArrayList<Fragment> list;

	/**
	 * @param fm
	 */
	public ViewPagerFragmentAdapter(FragmentManager fm, ArrayList<Fragment> list)
	{
		super(fm);
		this.list = list;
	}

	@Override
	public Fragment getItem(int arg0)
	{
		return list.get(arg0);
	}

	@Override
	public int getCount()
	{
		return list.size();
	}

}
