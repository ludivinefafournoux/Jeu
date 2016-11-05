package com.example.fl406883.jeu;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by laura on 01/10/2016.
 */

// page de jeu
public class JeuFragment extends Fragment {

    public static final String MesPreferences = "MesPreferences";
    View view;
    SharedPreferences preferences;
    SharedPreferences.Editor editeur;
    JeuView jeu;

    public JeuFragment() {
        // Required empty public constructor
    }

    // déclaration variable
    //OnActionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) { // obligatoire pour un fragment

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_jeu, container, false);

        preferences = getActivity().getSharedPreferences(MesPreferences, Context.MODE_PRIVATE);
        JeuView jeu = (JeuView) view.findViewById(R.id.jeuView);



        /*final NumberPicker nbpicker = (NumberPicker) viewFragment.findViewById(R.id.numberPicker); // récupération de l'id du numberpicker

        nbpicker.setMaxValue(10); // valeur max du numberpicker
        nbpicker.setMinValue(0); // valeur min du numberpicker

        nbpicker.setValue(0); // valeur par défaut du numberpicker

        nbpicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                mListener.onAction(newVal);
            }
        });*/


        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        // Make sure that we are currently visible
        if (this.isVisible()) {
            // If we are becoming invisible, then...
            if (isVisibleToUser) {
                jeu.setNombreOccurence(preferences.getInt("nbPoint", 1));
                jeu.setVitesse(preferences.getInt("nbPicker", 1));
                jeu.setCouleur(preferences.getInt("Couleur", 1));
                jeu.init();
            }
        }
    }

}

