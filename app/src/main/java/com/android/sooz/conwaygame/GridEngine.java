package com.android.sooz.conwaygame;


public class GridEngine {

    public GridEngine(){}

    public static Cell[][] gameGrid;

    //after debugging, checked Amy Cohen's code and this method is needed to assign value to cell
    //before neighbor check to avoid out of bounds exceptions
    public boolean getCellValue(boolean[][] cells, int row, int col) {

        //avoid out of bounds exception
        if (row < 0 || col < 0 || row >= cells.length || col >= cells[row].length) {
            return false;
        }

        //return the cell value
        return cells[row][col];
    }

    //Based on Amy Cohen's solution code and revisit of Whiteboard 4 to check values
    public int checkNeighborNumbers(boolean[][] gameGrid, int row, int col) {
        int count = 0;

        // check right
        boolean hasCell = getCellValue(gameGrid,row,col + 1);
        if (hasCell) {
            count++;
        }

        //check bottom right
        hasCell = getCellValue(gameGrid,row + 1, col + 1);
        if (hasCell) {
            count++;
        }

        //check bottom
        hasCell = getCellValue(gameGrid,row + 1, col);
        if (hasCell) {
            count++;
        }

        //check bottom left
        hasCell= getCellValue(gameGrid,row+1, col-1);
        if (hasCell) {
            count++;
        }

        //check left
        hasCell = getCellValue(gameGrid,row, col-1);
        if(hasCell){
            count++;
        }

        //check upper left
        hasCell = getCellValue(gameGrid,row-1,col-1);
        if(hasCell){
            count++;
        }

        //check above
        hasCell = getCellValue(gameGrid,row-1,col);
        if(hasCell){
            count++;
        }

        //check upper right
        hasCell = getCellValue(gameGrid,row-1,col+1);
        if(hasCell){
            count++;
        }

        return count;
    }

}
