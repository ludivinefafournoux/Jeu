package com.example.fl406883.jeu;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import static com.example.fl406883.jeu.R.id.imageView;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener, ParametresFragment.OnActionListener {

    // déclaration des variables
    private ViewPager mViewPager;
    private ExamplePagerAdapter mExamplePagerAdapter;
    JeuFragment jeufragment = new JeuFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        // lignes auto générées
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ActionBar actionBar = getSupportActionBar(); // barre d'onglets

        mExamplePagerAdapter = new ExamplePagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager); // page d'un onglet
        mViewPager.setAdapter(mExamplePagerAdapter); // l'adapte à notre classe

        // Specify that tabs should be displayed in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Add 2 tabs, specifying the tab’s text and TabListener
        actionBar.addTab( actionBar.newTab()
                .setText("Paramètres de jeu")
                .setTabListener(this)); // this car implements tablistener
        actionBar.addTab(
                actionBar.newTab()
                        .setText("Jeu")
                        .setTabListener(this));

        mViewPager.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        // When swiping between pages, select the corresponding tab.
                        getSupportActionBar().setSelectedNavigationItem(position);
                    } });

    }



    // méthodes de TabListener obligatoires (même si on ne mets rien dedans)
    @Override
    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void OnAction(int position) {

    }

    /*public void onClick(View v) {

        img = (ImageView) findViewById(R.id.imageView);

        //Toast.makeText(MainActivity.this, "You clicked on", Toast.LENGTH_LONG).show();

    }*/
}