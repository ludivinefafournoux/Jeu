package com.example.fl406883.jeu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

/**
 * Created by laura on 01/10/2016.
 */

public class NumberPickerFragment extends Fragment {

    public NumberPickerFragment() {
        // Required empty public constructor
    }

    // déclaration variable
    OnActionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) { // obligatoire pour un fragment

        // Inflate the layout for this fragment
        View viewFragment = inflater.inflate(R.layout.fragment_number_picker, container, false);

        final NumberPicker nbpicker = (NumberPicker) viewFragment.findViewById(R.id.numberPicker); // récupération de l'id du numberpicker

        nbpicker.setMaxValue(10); // valeur max du numberpicker
        nbpicker.setMinValue(0); // valeur min du numberpicker

        nbpicker.setValue(0); // valeur par défaut du numberpicker

        nbpicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                mListener.onAction(newVal);
            }
        });

        return viewFragment;
    }

    // Container Activity must implement this kind of interface
    public interface OnActionListener {
        public void onAction(int myNumber);
    }

    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);
        try {
            mListener = (OnActionListener) activity;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnActionListener");
        }
    }
}
