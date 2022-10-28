package com.moulasilz.moneymanager.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.moulasilz.moneymanager.Adapter.*;
import com.moulasilz.moneymanager.Fragment.*;
import com.moulasilz.moneymanager.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toast mToast;
    private long backPressTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        initComponents();
    }
    @Override
    public void onBackPressed() {
        if (backPressTime + 2000 > System.currentTimeMillis()){
            mToast.cancel();
            Intent intent = new Intent(getApplicationContext(), StartUpActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("EXIT", true);
            startActivity(intent);
            finish();
            System.exit(0);
        }else {
            mToast = Toast.makeText(MainActivity.this, "Ấn lần nữa để thoát", Toast.LENGTH_SHORT);
            mToast.show();
        }
        backPressTime = System.currentTimeMillis();
    }

    private void mapping(){
        viewPager = findViewById(R.id.mainViewPager);
        tabLayout = findViewById(R.id.mainTabLayout);
    }

    private void initComponents() {
        FragmentViewPagerAdaper viewPagerAdaper = new FragmentViewPagerAdaper(getSupportFragmentManager());
        viewPagerAdaper.addFragment(new FragmentHomepage(R.color.transparent), "");
        viewPagerAdaper.addFragment(new FragmentHomepage(R.color.transparent), "");
        viewPagerAdaper.addFragment(new FragmentHomepage(R.color.transparent), "");
        viewPagerAdaper.addFragment(new FragmentHomepage(R.color.transparent), "");
        viewPager.setAdapter(viewPagerAdaper);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Home").setIcon(R.drawable.ic_baseline_home_24);
        tabLayout.getTabAt(1).setText("Home").setIcon(R.drawable.ic_baseline_person_24);
        tabLayout.getTabAt(2).setText("Home").setIcon(R.drawable.ic_baseline_home_24);
        tabLayout.getTabAt(3).setText("Home").setIcon(R.drawable.ic_baseline_person_24);

        tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                super.onTabSelected(tab);
                int tabIconColor = ContextCompat.getColor(tab.view.getContext(), R.color.light_green);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                super.onTabUnselected(tab);
                int tabIconColor = ContextCompat.getColor(tab.view.getContext(), R.color.black);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                super.onTabReselected(tab);

            }
        });
//        tabLayout.getTabAt(0).setCustomView(R.layout.custom_tablayout_item1);
//        tabLayout.getTabAt(1).setCustomView(R.layout.custom_tablayout_item2);
//        tabLayout.getTabAt(2).setCustomView(R.layout.custom_tablayout_item1);
//        tabLayout.getTabAt(3).setCustomView(R.layout.custom_tablayout_item2);
    }
}