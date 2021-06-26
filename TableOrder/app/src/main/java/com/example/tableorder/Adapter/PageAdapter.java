package com.example.tableorder.Adapter;

import com.example.tableorder.Kitchen.completeFragment;
import com.example.tableorder.Kitchen.pendingFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    int tabCount;

    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new pendingFragment();
            case 1:
                return new completeFragment();
            default:
                return null;
            //break;

        }
      //  return null;
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
