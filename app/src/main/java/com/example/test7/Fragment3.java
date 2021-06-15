package com.example.test7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment implements View.OnClickListener {
    Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_frag3,container,false);
        button = view.findViewById(R.id.button3);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getContext(),"fragment3点击",Toast.LENGTH_LONG).show();
    }
}
