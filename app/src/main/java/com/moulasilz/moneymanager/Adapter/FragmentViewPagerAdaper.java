package com.moulasilz.moneymanager.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class FragmentViewPagerAdaper extends FragmentStatePagerAdapter {

    private final ArrayList<Fragment> Fragments = new ArrayList<>();
    private final ArrayList<String> arrayTitle = new ArrayList<>();

    public FragmentViewPagerAdaper(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return Fragments.get(position);
    }

    @Override
    public int getCount() {
        return Fragments.size();
    }
    public void addFragment(Fragment fragment, String title){
        Fragments.add(fragment);
        arrayTitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arrayTitle.get(position);
    }
}
