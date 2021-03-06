package com.materialsdev.activity;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.materialsdev.R;
import com.materialsdev.activity.fragments.DashboardFragment;
import com.materialsdev.activity.fragments.HomeFragment;
import com.materialsdev.activity.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener {

    public android.app.FragmentManager fragmentManager;
    Fragment homeFragment, dashboard, profile;
    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if (homeFragment == null) homeFragment = HomeFragment.newInstance("", "");
                    fragmentManager.beginTransaction().add(homeFragment, getString(R.string.home_fragment)).commit();
                    return true;
                case R.id.navigation_dashboard:
                    if (homeFragment == null) dashboard = DashboardFragment.newInstance("", "");
                    fragmentManager.beginTransaction().add(dashboard, getString(R.string.dashboard_fragment)).commit();
                    return true;
                case R.id.navigation_profile:
                    if (homeFragment == null) profile = ProfileFragment.newInstance("", "");
                    fragmentManager.beginTransaction().add(profile, getString(R.string.profile_fragment)).commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fragmentManager = getFragmentManager();
        homeFragment = new HomeFragment();
        fragmentManager.beginTransaction().add(homeFragment, getString(R.string.home_fragment)).commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
