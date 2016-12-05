package com.example.fl406883.jeu;

import io.realm.RealmObject;

/**
 * Created by fl406883 on 05/12/2016.
 */

public class Score extends RealmObject{

    private int score;

    public int getScore(){return score;}
    public void setScore(int score){this.score = score;}
}
