package com.android.sooz.conwaygame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity
        implements ViewTreeObserver.OnGlobalLayoutListener, View.OnTouchListener{

    @BindView(R.id.imageView)
    public ImageView imageView;
    public Bitmap mBitmap;
    public Canvas mCanvas;

    @BindView(R.id.valueDisplay)
    public TextView valueDisplay;

    protected Cell cell;
    protected GridEngine engine;
    protected boolean[][] drawGrid;
    public int SIZE;

    boolean[][] cells;

    public static Cell[][] gameGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        engine = new GridEngine();

        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if(viewTreeObserver.isAlive()){
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }

    }

    @Override
    public void onGlobalLayout() {
        initBitmap();
        drawGrid();

    }

    public void initBitmap(){

        imageView.setOnTouchListener(this);

        int width = imageView.getWidth();
        int height = imageView.getHeight();

        Log.d("DIMENSIONS", "width "+ width + " x  height" + height + " y");
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        mCanvas = new Canvas(mBitmap);

    }

    @OnClick(R.id.tick)
    public void tick(){
        engine.toggleTick(drawGrid);

    }

    private float xDown;
    private float yDown;

    private float xUp;
    private float yUp;

    private float xMove;
    private float yMove;

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent){
        int action = motionEvent.getAction();
        float xx = motionEvent.getX();
        float yy = motionEvent.getY();

        //use of Math.floor based on input from classmate Amy Cohen
        String l1 ="size: " + SIZE + "x: " + ((int)Math.floor(xx)) + " y: " + ((int)Math.floor(yy));
        String l2 = "Column X: " + ((int)Math.floor(xx/SIZE) + "\nRow Y: "+ ((int)Math.floor(yy/SIZE)));


        valueDisplay.setText(l1+ "\n"+ l2);
        drawGrid();

        if(action == MotionEvent.ACTION_DOWN) {
            Log.d("ACTION", "down");
            xDown = xx;
            yDown = yy;

            cell.transform();
            return true;
        }
        return false;
    }

    public boolean[][] drawGrid(){

        int height = mCanvas.getHeight();
        int width = mCanvas.getWidth();


        int SIZE = 20;

        float x0 = 0;
        float y0 = 0;

        float x1= SIZE;
        float y1 = SIZE;
        for(int row = 0; row <height/SIZE; row++){
            x0 = 0;
            x1 = SIZE;
            for(int col = 0; col<width/SIZE; col++){

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
        return drawGrid;
    }

}
