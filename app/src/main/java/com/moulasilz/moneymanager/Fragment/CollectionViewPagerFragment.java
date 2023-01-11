package com.moulasilz.moneymanager.Fragment;

import android.os.Bundle;

import androidx.annotation.*;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.moulasilz.moneymanager.Adapter.FragmentStateViewAdapter;
import com.moulasilz.moneymanager.R;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CollectionViewPagerFragment newInstance} factory method to
 * create an instance of this fragment.
 */
public class CollectionViewPagerFragment extends Fragment {

    FragmentStateViewAdapter demoCollectionAdapter;
    ViewPager2 viewPager;
    TabLayout tabLayout;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_collection_viewpager, container, false);
        mapping();
        initComponents();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    private void mapping(){
        viewPager = view.findViewById(R.id.mainViewPager);
        tabLayout = view.findViewById(R.id.mainTabLayout);
    }

    private static class tabElement{
        String Name;
        int IconID;

        public tabElement(String name, int iconID) {
            Name = name;
            IconID = iconID;
        }
    }

    private void initComponents() {

        HashMap<Integer, tabElement> list = new HashMap<>();

        list.put(0, new tabElement("Home", R.drawable.ic_baseline_home_24));
        list.put(1, new tabElement("Transactions", R.drawable.ic_baseline_account_balance_wallet_24));
        list.put(2, new tabElement("Account", R.drawable.ic_baseline_person_24));
        list.put(3, new tabElement("More", R.drawable.ic_baseline_more_horiz_24));

        demoCollectionAdapter = new FragmentStateViewAdapter(this);
        demoCollectionAdapter.addFragment(FragmentHome.newInstance(R.color.transparent), "");
        demoCollectionAdapter.addFragment(FragmentTransaction.newInstance(), "");
        demoCollectionAdapter.addFragment(FragmentHome.newInstance(R.color.transparent), "");
        demoCollectionAdapter.addFragment(FragmentHome.newInstance(R.color.transparent), "");
        viewPager.setAdapter(demoCollectionAdapter);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) ->
                    tab.setText(list.get(position).Name).setIcon(list.get(position).IconID)
        ).attach();
    }
}
