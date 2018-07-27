package com.white.www.materialdesigndemo.parallel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.white.www.materialdesigndemo.R;

/**
 * 平行空间
 */

public class MainActivity extends FragmentActivity {

	private ViewPager vp;
	private int[] layouts = {
			R.layout.welcome11,
			R.layout.welcome2,
			R.layout.welcome3
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_pager);
		vp = findViewById(R.id.vp);

		WelcomePagerAdapter adapter = new WelcomePagerAdapter(getSupportFragmentManager());
		System.out.println("offset:"+vp.getOffscreenPageLimit());
		vp.setOffscreenPageLimit(3);
		vp.setAdapter(adapter);

		WelcompagerTransformer transformer = new WelcompagerTransformer();
		vp.setPageTransformer(true, transformer);

		vp.setOnPageChangeListener(transformer);
	}

	class WelcomePagerAdapter extends FragmentPagerAdapter{

		private WelcomePagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment f = new TranslateFragment();
			Bundle bundle = new Bundle();
			bundle.putInt("layoutId", layouts[position]);
			bundle.putInt("pageIndex", position);
			f.setArguments(bundle );
			return f;
		}

		@Override
		public int getCount() {
			return 3;
		}

	}
}
