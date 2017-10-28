package com.bed.loginControl;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bed.loginControl.databinding.ActivityMainFragmentLogInBinding;

/**
 * Created by abdur on 29-Oct-17.
 */

public class LogInFragment extends Fragment {

    private static final String TAG = "Log In Fragment";
    private ActivityMainFragmentLogInBinding logInFragmentBinding;

    private int counter = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "Log In Fragment Started");
        logInFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.activity_main_fragment_log_in, container, false);
        logInFragmentBinding.logInFragmentTextId.setText("This is Log In Fragment using Data binding" + (++counter));

        logInFragmentBinding.logInFragmentButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSignUp();
            }
        });


        return logInFragmentBinding.getRoot();
    }

    private void goToSignUp() {
        ((MainActivity)getActivity()).setCurrentViewPager(MainActivity.SIGN_UP_FRAGMENT_NUMBER);
    }

    /*@Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }*/
}
