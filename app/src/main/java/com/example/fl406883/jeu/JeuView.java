package com.example.fl406883.jeu;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.larswerkman.holocolorpicker.ColorPicker;

import java.util.Random;

import static android.R.attr.bitmap;
import static com.example.fl406883.jeu.R.id.imageView;

/**
 * Created by laura on 05/11/2016.
 */

public class JeuView extends View implements View.OnTouchListener {

    private Paint paint;
    int vitesse = 1;
    String couleur = "#FFB6C1";
    //int nombreOccurence = 1 ;

    private float posX = 50;
    private float posY = 20;

    protected int screenWidth;
    protected int screenHeight;

    private int i;

    private Vibrator v;

    ColorPicker picker;

    public int getVitesse() { return vitesse;}
    public void setVitesse(int unevitesse){this.vitesse = unevitesse;}

    public String getCouleur() {return couleur;}
    public void setCouleur (String uneCouleur){this.couleur = uneCouleur;}

   /* public int getNombreOccurence() {
      return nombreOccurence;
    }
    public void setNombreOccurence(int unNbOccurence){
        nombreOccurence = unNbOccurence; }*/

    public JeuView (Context context) {
        super(context);
        init();
    }

    public JeuView (Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    // initialiser valeur (taille, couleur,..)
    public void init() {

        paint = new Paint();

        v = (Vibrator) this.getContext().getSystemService(Activity.VIBRATOR_SERVICE);

        super.setOnTouchListener(this);

        paint.setColor(Color.parseColor(couleur));


        removeCallbacks(animator);

        post(animator);


        //paint.setTextSize(50);
        //paint.setColor(111);
    }

    // creer objet dans canvas
    @Override
    protected void onDraw(Canvas canvas) {

        Resources res = getResources();
        Bitmap b = BitmapFactory.decodeResource(res, R.drawable.fleche);

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
            postDelayed(this, vitesse+400);
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

        float x = motionEvent.getX();
        float y = motionEvent.getY();

        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

            if (x >= posX && x <= posY  && y >= posX && y <= posY) {
                // star wars vibration
                v.vibrate(new long[]{0, 500, 110, 500, 110, 450, 110, 200, 110, 170, 40, 450, 110, 200, 110, 170, 40, 500}, -1);
                return true;

            }
            else {
                return false;
            }

        }
        else {
            return false;
        }

    }

    // obtenir dimension vue
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {

        super.onLayout(changed, left, top, right, bottom);
        screenWidth = getWidth();
        screenHeight = getHeight();
    }
}

