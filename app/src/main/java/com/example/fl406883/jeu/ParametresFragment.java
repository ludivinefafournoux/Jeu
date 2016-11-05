package com.example.fl406883.jeu;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.Toast;

import com.larswerkman.holocolorpicker.ColorPicker;

import java.io.ByteArrayOutputStream;

import static android.R.attr.bitmap;
import static android.R.attr.value;
import static com.example.fl406883.jeu.R.id.picker;
import static com.example.fl406883.jeu.R.id.seekBar1;

/**
 * Created by laura on 01/10/2016.
 */

// page de parametres
public class ParametresFragment extends Fragment {

    public static final String MesPreferences = "MesPreferences";
    SeekBar vitesseBar;
    NumberPicker numberpick;
    Button valider;
    OnActionListener mListener;
    SharedPreferences preferences;
    SharedPreferences.Editor editeur;
    ColorPicker picker;

    public interface OnActionListener{
        public void OnAction(int position);
    }

    View viewFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_parametres, container, false);

        preferences = getActivity().getSharedPreferences(MesPreferences, Context.MODE_PRIVATE);

        numberpick = (NumberPicker) view.findViewById(R.id.numberPicker2);
        ImageView image1 = (ImageView) view.findViewById(R.id.imageView);
        ImageView image2 = (ImageView) view.findViewById(R.id.imageView2);
        ImageView image3 = (ImageView) view.findViewById(R.id.imageView3);
        vitesseBar = (SeekBar) view.findViewById(R.id.seekBar1);
        valider = (Button) view.findViewById(R.id.valider);

        // Color Picker
        picker = (ColorPicker) view.findViewById(R.id.picker);


        picker.setShowOldCenterColor(false);
        //picker.setOnColorChangedListener((ColorPicker.OnColorChangedListener) this);

        //Set the minimum value of NumberPicker
        numberpick.setMinValue(0);
        //Specify the maximum value/number of NumberPicker
        numberpick.setMaxValue(15);
        numberpick.setValue(0);

       // numberpick.setWrapSelectorWheel(true);

        editeur = preferences.edit();
        numberpick.setValue(preferences.getInt("nbPicker", 20));
        vitesseBar.setProgress(preferences.getInt("vitesse", 0));


        vitesseBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                editeur.putInt("vitesse", vitesseBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
            }


        });

        valider.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                editeur.putInt("nbPicker", numberpick.getValue());
                editeur.putInt("Couleur", picker.getColor());
                //editeur.putString("Image", encodeTobase64(bitmap));
                editeur.commit();

            }
            // Convertir Bitmap en base64 pour l'enregistrer dans les SharedPreferences
            private String encodeTobase64(Bitmap image) {

                Bitmap immage = image;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                immage.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] b = baos.toByteArray();
                String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);

                return imageEncoded;
            }

        });

        final Activity act = getActivity();

        image1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(act,"Vous avez cliqué sur l'image 1", Toast.LENGTH_SHORT).show();
                Bitmap b = BitmapFactory.decodeResource(view.getResources(), R.drawable.croix);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(act,"Vous avez cliqué sur l'image 2", Toast.LENGTH_SHORT).show();
                Bitmap b = BitmapFactory.decodeResource(view.getResources(), R.drawable.fleche);
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(act,"Vous avez cliqué sur l'image 3", Toast.LENGTH_SHORT).show();
                Bitmap b = BitmapFactory.decodeResource(view.getResources(), R.drawable.rond);
            }
        });



        return view;
    }

    /*public void changeTextNumber(int nbpicker){

        TextView myTextView = (TextView) viewFragment.findViewById(R.id.textView);
        myTextView.setText(Integer.toString(nbpicker));

    }*/

    public void onAttach (Activity activity){
        super.onAttach(activity);
        try {
            mListener = (OnActionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnActionListener");
        }
    }
}
