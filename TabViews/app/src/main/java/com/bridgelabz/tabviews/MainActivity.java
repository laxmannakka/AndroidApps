package com.bridgelabz.tabviews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {


    ViewPager viewpager;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager = (ViewPager) findViewById(R.id.pager);
        fragmentManager = getSupportFragmentManager();
        viewpager.setAdapter(new MyAdapter(fragmentManager));
    }


}

class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        if (position == 0) {
            fragment = new Fragment_A();
        }
        if (position == 1) {
            fragment = new Fragment_B();
        }
        if (position == 2) {
            fragment = new Fragment_c();
        }


        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return "TAB_1";
        }
        if (position == 1) {
            return "TAB_2";
        }
        if (position == 2) {
            return "TAB_3";
        }

        return null;
    }
}


