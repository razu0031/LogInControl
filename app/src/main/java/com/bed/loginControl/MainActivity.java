package com.bed.loginControl;

import android.databinding.DataBindingUtil;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bed.loginControl.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main Activity";
    public static int LOG_IN_FRAGMENT_NUMBER = 0;
    public static int SIGN_UP_FRAGMENT_NUMBER = 1;
    private static int FRAGMENT_NUMBER;

    private ActivityMainBinding activityMainBinding;
    private ViewPager mainActivityViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityViewPager = activityMainBinding.activityMainContainerId;
        setUpViewPager(mainActivityViewPager);

        mainActivityViewPager.beginFakeDrag(); //disable going another tab by swiping
        //mainActivityViewPager.endFakeDrag();    //enable going another tab by swiping
    }

    private void setUpViewPager(ViewPager mainActivityViewPager) {
        MainActivityStatePagerAdapter adapter = new MainActivityStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LogInFragment(), "Log In" );
        adapter.addFragment(new SignUpFragment(), "Sign Up");
        mainActivityViewPager.setAdapter(adapter);
    }

    public void setCurrentViewPager(int fragmentNumber){
        mainActivityViewPager.setCurrentItem(fragmentNumber);
        FRAGMENT_NUMBER = fragmentNumber;
    }

    @Override
    public void onBackPressed() {
        if(FRAGMENT_NUMBER == SIGN_UP_FRAGMENT_NUMBER){
            setCurrentViewPager(LOG_IN_FRAGMENT_NUMBER);
            return;
        }
        super.onBackPressed();
    }
}
