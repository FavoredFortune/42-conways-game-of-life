package com.android.sooz.conwaygame;

public class Square {

    private int SIZE = 20;

    private float x0;
    private float y0;
    private float x1 = x0+SIZE;
    private float y1 = y0+SIZE;

    private int color;


    public Square (float x0, float y0, float x1, float y1){

    }

    public boolean contains(float xx, float yy){
        float dx = this.x0 - xx;
        float dy = this.y0 - yy;

        double inside = Math.sqrt(dx * dx + dy * dy);

        return inside < SIZE;
    }
}
