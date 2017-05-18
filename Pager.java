package com.example.xenderx.jsonvolley;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by vignesh on 09-Nov-16.
 */

public class Pager extends FragmentStatePagerAdapter {



    int tabCount;

    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        switch(position)
        {
            case 0:
                TabView1 tab1 = new TabView1();
                return tab1;
            case 1:
                TabView2 tab2 = new TabView2();
                return tab2;
            case 2:
                TabView3 tab3 = new TabView3();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}