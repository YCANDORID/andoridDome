/**
 * <Title:ViewPagerFragmentAdapter.java>
 * <Description:>
 * <Company:������Ȥ�Ƽ����޹�˾>
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
 * ���ܣ�ViewPager+Fragment������
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
