package com.android.sooz.conwaygame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class GridEngine {
    private Bitmap mBitmap;
    private Canvas mCanvas;

    private Square currentSquare;

    public int SIZE;

    public static Canvas buildGrid(){
        boolean[][] cells;
        int cellSize = 20;
        cells = new boolean[cellSize][cellSize];
        for( int row = 0 ; row<cellSize; row++){
            for (int col = 0; col<cellSize; col++){
                cells[row][col] = Math.random()<.5;
            }
        }
        mBitmap
    }
}
