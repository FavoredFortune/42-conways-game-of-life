package com.android.sooz.conwaygame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.widget.ImageView;

import butterknife.BindView;

public class GridEngine {
    @BindView(R.id.imageView)
    public ImageView imageView;
    public Bitmap mBitmap;
    public Canvas mCanvas;

    public GridEngine(){}

    public Cell cell;


    boolean[][] cells;

    public static Cell[][] gameGrid;


    public void clear(){

        //if statement makes sure if someone hits button before canvas draw won't error out
        if (mCanvas != null) {
            Log.d("CANVAS", "clear");
            //drawColor is basically a fill method
            //with .white don't need "PorterDuff.Mode.CLEAR"
            mCanvas.drawColor(Color.WHITE);
        }
    }

    //Based on Amy Cohen's solution code and revisit of Whiteboard 4 to check values
    public int checkNeighborNumbers(boolean[][] gameGrid, int row, int col) {
        boolean cell = gameGrid[row][col];
        int count = 0;

        // check right
        boolean hasCell = gameGrid[row][col+1];
        if (hasCell) {
            count++;
        }

        //check bottom right
        hasCell= gameGrid[row+1][col+1];
        if (hasCell) {
            count++;
        }

        //check bottom
        hasCell= gameGrid[row+1][col];
        if (hasCell) {
            count++;
        }

        //check bottom left
        hasCell= gameGrid[row+1][col-1];
        if (hasCell) {
            count++;
        }

        //check left
        hasCell = gameGrid[row][col-1];
        if(hasCell){
            count++;
        }

        //check upper left
        hasCell = gameGrid[row-1][col-1];
        if(hasCell){
            count++;
        }

        //check above
        hasCell = gameGrid[row-1][col];
        if(hasCell){
            count++;
        }

        //check upper right
        hasCell = gameGrid[row-1][col+1];
        if(hasCell){
            count++;
        }

        return count;
    }

    public void toggleTick(boolean[][] drawGrid) {
        for (int row = 0; row < drawGrid.length; row++) {
            for (int col = 0; col < drawGrid[row].length; col++) {
                int neighbors = checkNeighborNumbers(drawGrid, row, col);
                if (neighbors < 2) {
                    cell.die();
                } else if (neighbors == 2 || neighbors == 3) {
                    cell.reborn();
                } else if (neighbors > 3) {
                    cell.die();
                } else if (neighbors == 3) {
                    cell.reborn();
                }
            }
        }
    }

}
