package com.android.sooz.conwaygame;

//help fromhttps://dzone.com/articles/recreate-the-conways-game-of-life-on-android
public class Cell {

    public float xx, yy;
    public boolean alive;

    public Cell(float xx, float yy, boolean alive){
        this.xx = xx;
        this.yy = yy;
        this.alive = alive;

    }

    public void reborn (){
        alive = true;
    }

    public void die(){
        alive = false;
    }

}
