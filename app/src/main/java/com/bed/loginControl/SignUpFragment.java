package com.bed.loginControl;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bed.loginControl.databinding.ActivityMainFragmentLogInBinding;
import com.bed.loginControl.databinding.ActivityMainFragmentSignUpBinding;

/**
 * Created by abdur on 29-Oct-17.
 */

public class SignUpFragment extends Fragment {
    private static final String TAG = "Sign Up Fragment";
    private ActivityMainFragmentSignUpBinding signUpFragmentBinding;

    private int counter = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "Sign Up Fragment Started");
        signUpFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.activity_main_fragment_sign_up, container, false);
        signUpFragmentBinding.signUpFragmentTextViewId.setText("This is Sign Up Fragment using Data binding" + (++counter));

        signUpFragmentBinding.signUpButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogIn();
            }
        });

        return signUpFragmentBinding.getRoot();
    }

    private void goToLogIn() {
        ((MainActivity)getActivity()).setCurrentViewPager(MainActivity.LOG_IN_FRAGMENT_NUMBER);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }


}
