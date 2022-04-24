package com.app.stepperview;

import android.util.SparseArray;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class FragmentStateCurrentPageAdapter extends FragmentStatePagerAdapter implements ViewPager.OnPageChangeListener {
    int currentPage = 0;
    List<Class> mStepperFragment;

    private SparseArray<Fragment> mPageReferenceMap = new SparseArray<>();

    public FragmentStateCurrentPageAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public int getCount() {
        return mStepperFragment.size();
    }

    public void setFragments(List<Class> fragments){
        mStepperFragment = fragments;
    }

    @Override
    public final Fragment getItem(int index) {
        if(mPageReferenceMap.get(index)!=null) {
            return getItemAtIndex(index);
        }
        else
        {
            try {
                Fragment obj = (Fragment) mStepperFragment.get(index).newInstance();
                mPageReferenceMap.put(index, obj);
                return obj;
            } catch (InstantiationException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public Fragment getItemAtIndex(int index){
        return mPageReferenceMap.get(index);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        mPageReferenceMap.remove(position);
    }


    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int newPageIndex) {
        currentPage = newPageIndex;
    }

}