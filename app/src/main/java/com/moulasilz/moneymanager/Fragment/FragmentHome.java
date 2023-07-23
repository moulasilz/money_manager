package com.moulasilz.moneymanager.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.moulasilz.moneymanager.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentHome extends Fragment {
    View view;
    int color;
    @SuppressWarnings("unused")
    public static FragmentHome newInstance(){
        return new FragmentHome(R.color.transparent);
    }
    @SuppressWarnings("unused")
    public static FragmentHome newInstance(int color){
        return new FragmentHome(color);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        view.setBackgroundColor(color);
        return view;
    }

    public FragmentHome(int color){
        super();
        this.color = color;
    }
}
