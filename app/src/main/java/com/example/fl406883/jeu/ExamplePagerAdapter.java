package com.example.fl406883.jeu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by laura on 30/09/2016.
 */

// gestion des onglets
public class ExamplePagerAdapter extends FragmentStatePagerAdapter {

    Fragment jeu;
    Fragment parametres;

    public ExamplePagerAdapter(FragmentManager fm) // constructeur
    {
        super(fm);
        jeu = new JeuFragment();
        parametres = new ParametresFragment();
    }

    @Override
    public Fragment getItem(int position)
    {
        Fragment fragment =  null;

        switch (position) // change de classe en fonction de l'onglet
        {
            case 0:
                fragment = parametres; // onglet texte
                break;
            case 1:
                fragment = jeu; // onglet numberpicker
                break;
        }

        return fragment;
    }

    @Override
    public int getCount()
    {
        // compte le nombre d’onglet
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return "myFrag";
    }
}