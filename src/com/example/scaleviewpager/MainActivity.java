package com.example.scaleviewpager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ClipViewPager mViewPager;
	int[] imgRes = new int[] { R.drawable.img1, R.drawable.img2,
			R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6 };
	private View mPagerLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mViewPager = (ClipViewPager) findViewById(R.id.pager);
		mPagerLayout = findViewById(R.id.pager_layout);
		mPagerLayout.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				return mViewPager.dispatchTouchEvent(event);
			}
		});
		mViewPager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.page_margin));
		mViewPager.setOffscreenPageLimit(imgRes.length);
		mViewPager.setPageTransformer(true, new PageTransformer());
		mViewPager.setAdapter(new PagerAdapter() {

			@Override
			public Object instantiateItem(View container, int position) {
				// TODO Auto-generated method stub
				View pageView = LayoutInflater.from(MainActivity.this).inflate(R.layout.pager_item_poster, null);
				ImageView imageView = (ImageView) pageView.findViewById(R.id.imageView1);
				imageView.setImageResource(imgRes[position]);
				// imageView.setLayoutParams(lp);
				mViewPager.addView(pageView);
				return pageView;
			}

			@Override
			public void destroyItem(View container, int position, Object object) {
				// TODO Auto-generated method stub
				mViewPager.removeView((View) object);
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return imgRes.length;
			}
		});

		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
//				if (mPagerLayout != null) {
//					mPagerLayout.invalidate();
//				}
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
