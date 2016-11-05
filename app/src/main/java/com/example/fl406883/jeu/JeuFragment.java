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
        jeu = (JeuView) view.findViewById(R.id.jeuView);

        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        // Make sure that we are currently visible
        if (this.isVisible()) {
            // If we are becoming invisible, then...
            if (isVisibleToUser) {
                //jeu.setNombreOccurence(preferences.getInt("nbPicker", 1));
                jeu.setVitesse(preferences.getInt("nbPicker", 1));
               // jeu.setCouleur(preferences.getString("Couleur", "#FFB6C1"));
                jeu.init();
            }
        }
    }

}

