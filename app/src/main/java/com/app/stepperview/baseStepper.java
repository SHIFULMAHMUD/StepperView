package com.app.stepperview;

import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class baseStepper {


    private ViewPager mViewPager;
    private FragmentStateCurrentPageAdapter fragmentAdapter;
    public int CURRENT_PAGE = 0;
    public int TOTAL_PAGE = 0;

    public baseStepper(ViewPager viewPager, List<Class> mStepperFragment, FragmentManager fm) {

        mViewPager = viewPager;

        fragmentAdapter = new FragmentStateCurrentPageAdapter(fm);
        fragmentAdapter.setFragments(mStepperFragment);
        mViewPager.setAdapter(fragmentAdapter);

        TOTAL_PAGE = mStepperFragment.size();
    }

    protected void onNextButtonClicked(){
        CURRENT_PAGE = mViewPager.getCurrentItem();
        if(resolveNavigation()) {
            stepperFragment current = (stepperFragment) fragmentAdapter.getItem(CURRENT_PAGE);
            if (current != null && current.onNextButtonHandler()) {
                CURRENT_PAGE = CURRENT_PAGE + 1;
                mViewPager.setCurrentItem(CURRENT_PAGE);
            }
        }
    }

    protected boolean resolveNavigation(){
        return CURRENT_PAGE != (TOTAL_PAGE - 1);
    }

    protected void onBackButtonClicked(){
        CURRENT_PAGE =  CURRENT_PAGE - 1;
        mViewPager.setCurrentItem(CURRENT_PAGE);

    }



}
