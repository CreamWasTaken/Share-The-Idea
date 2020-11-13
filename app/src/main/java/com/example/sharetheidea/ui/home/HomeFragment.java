package com.example.sharetheidea.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.sharetheidea.Find;
import com.example.sharetheidea.R;
import com.example.sharetheidea.Teach;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);

        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        final Button FindTutor = (Button)root.findViewById(R.id.btn_find);
        final Button Teach =(Button)root.findViewById(R.id.btn_teach);
        RadioGroup RGGroup = (RadioGroup)root.findViewById(R.id.Subj);


        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                FindTutor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(root.getContext(), Find.class);
                        //tae
                        startActivity(i);
                    }
                });

                Teach.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      Intent in = new Intent(root.getContext(), com.example.sharetheidea.Teach.class);
                      startActivity(in);
                    }
                });



            }
        });
        return root;
    }
}
