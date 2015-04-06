package com.example.viewpagerfragmentdemo;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnClickListener
{

	private ViewPager viewPager;
	private TextView tab1;
	private TextView tab2;
	private TextView tab3;
	private ImageView mark;
	private int width = 0;
	private int currentPage = 0; // 当前页
	private ArrayList<Fragment> list;
	private int beforePosition = 0; // 上一次位置

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	/**
	 * 
	 * @author：Frj 功能:初始化控件 使用方法：
	 */
	private void init()
	{
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		tab1 = (TextView) findViewById(R.id.tab1);
		tab2 = (TextView) findViewById(R.id.tab2);
		tab3 = (TextView) findViewById(R.id.tab3);
		mark = (ImageView) findViewById(R.id.mark);

		tab1.setOnClickListener(this);
		tab2.setOnClickListener(this);
		tab3.setOnClickListener(this);
		OnPageChangeListener listener = new OnPageChangeListener_mark();
		viewPager.setOnPageChangeListener(listener);
		WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		width = wm.getDefaultDisplay().getWidth() / 3;
		Log.e("error", String.valueOf(width));
		LayoutParams layoutParams = mark.getLayoutParams();
		layoutParams.width = width;
		mark.setLayoutParams(layoutParams);
		initData();
	}

	/**
	 * 
	 * @author：Frj 功能:初始化数据 使用方法：
	 */
	private void initData()
	{
		list = new ArrayList<Fragment>();
		Tab1Fragment tab1_fragment = new Tab1Fragment();
		Tab2Fragment tab2_fragment = new Tab2Fragment();
		Tab3Fragment tab3_fragment = new Tab3Fragment();
		list.add(tab1_fragment);
		list.add(tab2_fragment);
		list.add(tab3_fragment);
		ViewPagerFragmentAdapter adapter = new ViewPagerFragmentAdapter(
				getSupportFragmentManager(), list);
		viewPager.setAdapter(adapter);
		viewPager.setCurrentItem(currentPage);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View v)
	{

	}

	class OnPageChangeListener_mark implements OnPageChangeListener
	{

		@Override
		public void onPageScrollStateChanged(int arg0)
		{

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2)
		{
			Log.e("error", "arg1=" + arg1);
			Log.e("error", "arg0=" + arg0);
			TranslateAnimation anima = null;
			if (arg0 == currentPage) // 往右滑的时候arg0的值为当前的项的值
			{
				anima = new TranslateAnimation(beforePosition,
						(int) currentPage * width + width * arg1, 0, 0);
				beforePosition = (int) (currentPage * width + width * arg1);
				anima.setFillAfter(true);
				anima.setDuration(500);
				mark.startAnimation(anima);

			}
			else if (arg0 + 1 == currentPage) // 往左滑的时候arg0的值为前一项的值
			{
				anima = new TranslateAnimation(beforePosition, (int) arg0
						* width + width * arg1, 0, 0);
				beforePosition = (int) (arg0 * width + width * arg1);
				anima.setFillAfter(true);
				anima.setDuration(500);
				mark.startAnimation(anima);
			}
		}

		@Override
		public void onPageSelected(int arg0)
		{
			// TranslateAnimation anima = new TranslateAnimation(currentPage
			// * width, arg0 * width, 0, 0);
			// anima.setFillAfter(true);
			// anima.setDuration(500);
			// mark.startAnimation(anima);
			currentPage = arg0;
		}

	}

}
