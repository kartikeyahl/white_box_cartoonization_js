package org.kashish.facetoons.boarding_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.kashish.facetoons.R;
import org.kashish.facetoons.activity.LoginActivity;

public class OnBoardingFragment3 extends Fragment {

    FloatingActionButton next;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInsranceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_on_boarding3, container, false);

        next = root.findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener(){
            @NonNull
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }

        });

        return root;
    }
}
