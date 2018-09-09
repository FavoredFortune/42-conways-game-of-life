package com.android.sooz.conwaygame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.widget.ImageView;

import butterknife.BindView;

public class GridEngine {
    protected static Bitmap mBitmap;
    protected static Canvas mCanvas;
    public Cell cell;

    @BindView(R.id.imageView)
    public ImageView imageView;


    boolean[][] cells;

    public static Cell[][] gameGrid;

    public boolean[][] drawGrid(){

        int height = imageView.getHeight();
        int width = imageView.getWidth();

        int smallest = (Math.min(width,height));

        int SIZE = smallest/cells.length;

        float x0 = 0;
        float y0 = 0;

        float x1= SIZE;
        float y1 = SIZE;
        for(int row = 0; row <cells.length; row++){
            x0 = 0;
            x1 = SIZE;
            for(int col = 0; col<cells[row].length; col++){

                int color;

                if(cells[row][col] == true){
                    color = Color.WHITE;
                } else{
                    color = Color.BLACK;
                }

                Paint brush = new Paint(Paint.ANTI_ALIAS_FLAG);
                brush.setColor(color);

                mCanvas.drawRect(x0,y0,x1,y1,brush);

                //update to the next column
                x0 += SIZE;
                x1 += SIZE;

            }
            //update the row
            y0 += SIZE;
            y1 += SIZE;
        }

        imageView.setImageBitmap(mBitmap);
        return drawGrid();
    }

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
