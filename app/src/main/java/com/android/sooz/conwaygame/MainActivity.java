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
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity
        implements ViewTreeObserver.OnGlobalLayoutListener, View.OnTouchListener{

    @BindView(R.id.imageView)
    public ImageView imageView;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    @BindView(R.id.valueDisplay)
    public TextView valueDisplay;

    private Cell cell;
    private GridEngine engine;
    private boolean[][] drawGrid;
    public int SIZE;

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

        engine.drawGrid();
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
        engine.drawGrid();

        if(action == MotionEvent.ACTION_DOWN) {
            Log.d("ACTION", "down");
            xDown = xx;
            yDown = yy;

            cell.transform();
            return true;
        }
        return false;
    }
}
