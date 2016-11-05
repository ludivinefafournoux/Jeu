package com.example.fl406883.jeu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewFragment;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.larswerkman.holocolorpicker.ColorPicker;

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




        NumberPicker numberpick = (NumberPicker) viewFragment.findViewById(R.id.numberPicker2);
        ImageView image1 = (ImageView) viewFragment.findViewById(R.id.imageView);
        ImageView image2 = (ImageView) viewFragment.findViewById(R.id.imageView2);
        ImageView image3 = (ImageView) viewFragment.findViewById(R.id.imageView3);

        ColorPicker picker = (ColorPicker) viewFragment.findViewById(R.id.picker);

        //Set the minimum value of NumberPicker
        numberpick.setMinValue(0);
        //Specify the maximum value/number of NumberPicker
        numberpick.setMaxValue(15);
        numberpick.setValue(0);

        picker.setShowOldCenterColor(false);

       // numberpick.setWrapSelectorWheel(true);
        return viewFragment;
    }



    public void changeTextNumber(int nbpicker){

        TextView myTextView = (TextView) viewFragment.findViewById(R.id.textView);
        myTextView.setText(Integer.toString(nbpicker));

    }

}
