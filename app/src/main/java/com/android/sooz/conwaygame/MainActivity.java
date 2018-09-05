package com.android.sooz.conwaygame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.android.sooz.conwaygame.GridEngine.buildGrid;

public class MainActivity extends AppCompatActivity
        implements ViewTreeObserver.OnGlobalLayoutListener, View.OnTouchListener{

    @BindView(R.id.canvasView)
    public ImageView imageView;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    private GridEngine engine;

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

    }

    public void initBitmap(){

        imageView.setOnTouchListener(this);


        int width = imageView.getWidth();
        int height = imageView.getHeight();

        Log.d("DIMENSIONS", ""+ width + " x " + height + " y");
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        mCanvas = new Canvas(mBitmap);

        buildGrid();
    }

    @OnClick(R.id.tick)
    public void tick(){
        //logic to change grid squares based on # of neighbors
            //Any live cell with fewer than two live neighbors dies, as if by under population.
            //Any live cell with two or three live neighbors lives on to the next generation.
            //Any live cell with more than three live neighbors dies, as if by overpopulation.
            //Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
