package com.example.fl406883.jeu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Random;

import static android.R.attr.bitmap;
import static com.example.fl406883.jeu.R.id.couleur;
import static com.example.fl406883.jeu.R.id.imageView;

/**
 * Created by laura on 05/11/2016.
 */

public class JeuView extends View implements View.OnTouchListener {

    protected Paint paint;
    private int vitesse = 1;
    private  int couleur;
    private int nombreOccurence ;

    private float posX = 50;
    private float posY = 20;

    protected int screenWidth;
    protected int screenHeight;

    public JeuView (Context context) {
        super(context);
        init();
    }

    public int getVitesse() { return vitesse;}
    public void setVitesse(int unevitesse){this.vitesse = unevitesse;}

    public int getCouleur() {return couleur;}
    public void setCouleur (int uneCouleur){this.couleur = uneCouleur;}

    public int getNombreOccurence() {
        return nombreOccurence;
    }
    public void setNombreOccurence(int unNbOccurence){
        nombreOccurence = unNbOccurence;
    }




    public JeuView (Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    // initialiser valeur (taille, couleur,..)
    public void init() {

        paint = new Paint();
        post(animator);

        //paint.setTextSize(50);
        paint.setColor(couleur);


    }

    // creer objet dans canvas
    @Override
    protected void onDraw(Canvas canvas) {

        Resources res = getResources();
        Bitmap b = BitmapFactory.decodeResource(res, R.drawable.croix);

        canvas.drawBitmap(b, posX, posY, paint);
        //tempCanvas.drawText("test", 100, 50, paint);
    }

    // fait bouger l'objet
    private Runnable animator = new Runnable() {

        @Override
        public void run() {

            long now = AnimationUtils.currentAnimationTimeMillis();
            update();
            invalidate();

            // vitesse
            postDelayed(this, 300);
        }
    };

    // modifie coordonnées image
    public void update() {

        /*posX+=5;
        posY+=10;*/

        Random random = new Random();

        posX = (float)random.nextInt(screenWidth - 160);
        posY = (float)random.nextInt(screenHeight - 160);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        if(motionEvent.getAction() == MotionEvent.ACTION_UP)
            return true;
        return false;
    }

    // obtenir dimension vue
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {

        super.onLayout(changed, left, top, right, bottom);
        screenWidth = getWidth();
        screenHeight = getHeight();
    }
}