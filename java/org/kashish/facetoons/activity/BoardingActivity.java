package org.kashish.facetoons.activity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import org.kashish.facetoons.Adapter.SlidePagerAdapter;
import org.kashish.facetoons.R;
import org.kashish.facetoons.boarding_fragment.OnBoardingFragment1;
import org.kashish.facetoons.boarding_fragment.OnBoardingFragment2;
import org.kashish.facetoons.boarding_fragment.OnBoardingFragment3;

import java.util.ArrayList;
import java.util.List;

public class BoardingActivity extends AppCompatActivity {

    private ViewPager pager ;
    private PagerAdapter adapter;
    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boarding);

        List<Fragment> list = new ArrayList<>();
        list.add(new OnBoardingFragment1());
        list.add(new OnBoardingFragment2());
        list.add(new OnBoardingFragment3());

        pager = findViewById(R.id.pager);
        adapter = new SlidePagerAdapter(getSupportFragmentManager(),list);

        pager.setAdapter(adapter);
        
        //Animation fade in page change
        anim = AnimationUtils.loadAnimation(this,R.anim.o_b_anim);
        pager.startAnimation(anim);
    }
}