package com.example.fl406883.jeu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by laura on 01/10/2016.
 */

public class TextFragment extends Fragment {

    public TextFragment() {
        // Required empty public constructor
    }

    View viewFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        viewFragment = inflater.inflate(R.layout.fragment_text, container, false);

        return viewFragment;
    }



    public void changeTextNumber(int nbpicker){

        TextView myTextView = (TextView) viewFragment.findViewById(R.id.textView);
        myTextView.setText(Integer.toString(nbpicker));

    }

}
