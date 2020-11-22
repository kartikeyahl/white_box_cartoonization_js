package org.kashish.facetoons.boarding_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.kashish.facetoons.R;

public class LoginTabFragment extends Fragment {

    float v=0;
    EditText email;
    EditText pass;
    TextView forgetpass;
    Button login;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInsranceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        email = root.findViewById(R.id.editTextEmail);
        pass = root.findViewById(R.id.editTextPassword);
        forgetpass = root.findViewById(R.id.textViewForgotPassword);
        login = root.findViewById(R.id.buttonLogin);

        email.setTranslationX(800);
        pass.setTranslationX(800);
        forgetpass.setTranslationX(800);
        login.setTranslationX(800);

        email.setAlpha(v);
        pass.setAlpha(v);
        forgetpass.setAlpha(v);
        login.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgetpass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ForgetPassFragment forgetPassFragment = new ForgetPassFragment();
                FragmentTransaction transaction =getFragmentManager().beginTransaction();
                transaction.replace(R.id.constraintLayout,forgetPassFragment);
                transaction.commit();
            }
        });

        return root;
    }
}
