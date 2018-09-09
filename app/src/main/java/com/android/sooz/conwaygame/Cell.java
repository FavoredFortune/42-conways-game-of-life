package com.android.sooz.conwaygame;

import android.graphics.Color;

//help from https://dzone.com/articles/recreate-the-conways-game-of-life-on-android
public class Cell {

    public float xx, yy;
    public boolean alive;
    public int color;

    public Cell(float xx, float yy, boolean alive, int color){
        this.xx = xx;
        this.yy = yy;
        this.alive = alive;
        this.color = color;

    }

    public void reborn (){

        alive = true;
        color = Color.BLACK;
    }

    public void die(){

        alive = false;
        color = Color.WHITE;
    }

    public void transform(){
        alive = !alive;
    }


    //based on looking at DZone and classmate Tyler Pearson's code
    public static Cell get(int row, int col){
        return GridEngine.gameGrid[row][col];
    }
    //Based on Amy Cohen's solution code and revisit of Whiteboard 4 to check values
    private static boolean getCellValue(boolean[][] gameGrid, int row, int col) {
        // check all bounds across board without getting null pointer exception
        if (row < 0 || col < 0 || row >= gameGrid.length || col >= gameGrid[row].length) {
            return false;
        }
        return gameGrid[row][col];
    }

}
