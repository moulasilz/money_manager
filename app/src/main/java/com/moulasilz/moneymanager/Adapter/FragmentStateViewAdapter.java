package com.moulasilz.moneymanager.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;


import java.util.ArrayList;

public class FragmentStateViewAdapter extends FragmentStateAdapter {

    private final ArrayList<Fragment> Fragments = new ArrayList<>();
    private final ArrayList<String> arrayTitle = new ArrayList<>();

    public FragmentStateViewAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }


    @Override
    public Fragment createFragment(int position) {
        return Fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return Fragments.size();
    }

    public void addFragment(Fragment fragment, String title){
        Fragments.add(fragment);
        arrayTitle.add(title);
    }

    @Nullable
    public CharSequence getPageTitle(int position) {
        return arrayTitle.get(position);
    }
}
