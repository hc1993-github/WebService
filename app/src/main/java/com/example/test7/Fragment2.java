package com.example.test7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Fragment2 extends Fragment implements View.OnClickListener {
    Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_frag2,container,false);
        button = view.findViewById(R.id.button2);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Fragment3 fragment3 = new Fragment3();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.hide(this);
        ft.add(R.id.framelayout,fragment3);
        ft.addToBackStack(null);
        ft.commit();
    }
}
