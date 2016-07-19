package com.wc.yff;

import android.app.Activity;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;

import com.wc.yff.view.RangleView;

public class MainActivity extends Activity {

    protected int TILE_HEIGHT = 200;
    LinearLayout linearLayout;
    RangleView rangleView;
    private int[] colorMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        colorMy = new int[]{
                getResources().getColor(R.color.green),
                getResources().getColor(R.color.blue),
                getResources().getColor(R.color.orange)
        };
        linearLayout = (LinearLayout) findViewById(R.id.linear);
        rangleView = new RangleView(this);
        rangleView.setNum(3);
        rangleView.setColorsMy(colorMy);
        rangleView.setValues(new int[]{15, 45, 40});
        linearLayout.addView(rangleView);


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        float right = linearLayout.getWidth();
        float bottommy = linearLayout.getHeight();
        RectF rectF = new RectF(0, 0, right, bottommy);
        rangleView.setRect(rectF);

    }
}
