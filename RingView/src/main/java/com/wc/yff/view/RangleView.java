package com.wc.yff.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.wc.yff.R;

/**
 * yff
 * Created by yff on 2016/7/18.
 */
public class RangleView extends View {

    private Paint paint;
    private Context context;
    private int num;
    private int[] values;
    private int [] colorsMy=new int[]{
            getResources().getColor(R.color.green),
            getResources().getColor(R.color.blue),
            getResources().getColor( R.color.orange)
    };

    private RectF rect;
    public RangleView(Context context) {
        this(context,null);
    }

    public RangleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        this.paint=new Paint();
        paint.setAntiAlias(true); //消除锯齿
//        paint.setStyle(Paint.Style.STROKE);//绘制空心圆

//        canvas.drawText("画线及斜线：",40,40,paint); //x ,y
//        paint.setColor(Color.GREEN);
//        canvas.drawLine(80,60,180,60,paint); //startX startY stopX stopY
//        canvas.drawLine(80,60,100,100,paint);//startX startY stopX stopY
//
//        canvas.drawText("画圆：",40,120,paint); //x Y
//        paint.setColor(context.getResources().getColor(R.color.orange));
//        paint.setStyle(Paint.Style.FILL);
//        canvas.drawCircle(180,180,50,paint);   //画圆
//        paint.setColor(context.getResources().getColor(R.color.white));
//        canvas.drawCircle(180,180,30,paint);
//
//
//        //画渐变色圆
//        Shader shader=new LinearGradient(0,0,100,100,new int[]{Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW},null,Shader.TileMode.REPEAT);
//        paint.setShader(shader);
//        canvas.drawCircle(250,250,50,paint);




        int totalNum=0;
        for(int i=0;i<getNum();i++){
            totalNum+=getValues()[i];
        }



        int startRad=0;
        for(int i=0;i<getNum();i++){
            int radios=(int)( ((float)getValues()[i]/totalNum )*360);
            //画扇形
            paint.setShader(null);
            paint.setColor(getColorsMy()[i]);
            canvas.drawArc(getRect(),startRad,radios,true,paint);
            startRad+=radios;
        }


        //画白色的圆
        paint.setColor(context.getResources().getColor(R.color.white));
        canvas.drawCircle((getRect().right+getRect().left)/2,(getRect().bottom+getRect().top)/2,(getRect().right-getRect().left)/2-20,paint);

    }


    public int[] getColorsMy() {
        return colorsMy;
    }

    public void setColorsMy(int[] colorsMy) {
        this.colorsMy = colorsMy;
    }

    public RectF getRect() {
        return rect;
    }

    public void setRect(RectF rect) {
        this.rect = rect;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }
}
