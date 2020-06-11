package com.example.icsd14193.myapplication14;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class poikilia extends Fragment {


    public poikilia() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v8=inflater.inflate(R.layout.fragment_poikilia,container,false);



        return v8;
    }

}
