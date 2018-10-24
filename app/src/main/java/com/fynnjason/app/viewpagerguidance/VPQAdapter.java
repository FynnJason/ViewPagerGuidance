package com.fynnjason.app.viewpagerguidance;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by FynnJason.
 * Function：TabLayout与ViewPager联动适配器
 */
public class VPQAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList;

    public VPQAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        mFragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

}
