package org.kashish.facetoons.Adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.kashish.facetoons.boarding_fragment.LoginTabFragment;
import org.kashish.facetoons.boarding_fragment.SignupTabFragment;

public class LoginApapter extends FragmentPagerAdapter {

    private Context context;
    int totalTabs;

    public LoginApapter(FragmentManager fm, Context context, int totalTabs){
        super(fm);
        this.context=context;
        this.totalTabs=totalTabs;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

    public Fragment getItem(int position){
        switch(position){
            case 0:
                LoginTabFragment loginTabFragment = new LoginTabFragment();
                return loginTabFragment;
            case 1:
                SignupTabFragment signupTabFragment = new SignupTabFragment();
                return signupTabFragment;
            default:
                return null;

        }
    }
}
