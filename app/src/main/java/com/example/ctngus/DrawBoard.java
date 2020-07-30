package com.example.ctngus;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawBoard extends View {

    private Paint paint=new Paint();
    public DrawBoard(Context context) {
        super(context);
        init();
    }
    private  void init()
    {
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(6);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(100,100,100,1000,paint);
        canvas.drawLine(200,100,200 ,1000,paint);
        canvas.drawLine(100,100,900,100,paint);
        canvas.drawLine(100,200,900,200,paint);
        canvas.drawLine(300,100,300,1000,paint);
        canvas.drawLine(400,100 ,400 ,1000,paint);
        canvas.drawLine(100,300,900,300,paint);
        canvas.drawLine(100,400,900,400,paint);
        canvas.drawLine(500,100,500,1000,paint);
        canvas.drawLine(600,100 ,600 ,1000,paint);
        canvas.drawLine(100,500,900,500,paint);
        canvas.drawLine(100,600,900,600,paint);
        canvas.drawLine(700,100,700,1000,paint);
        canvas.drawLine(800,100 ,800 ,1000,paint);
        canvas.drawLine(100,700,900,700,paint);
        canvas.drawLine(100,800,900,800,paint);
        canvas.drawLine(100,900,900,900,paint);
        canvas.drawLine(900,100,900,1000,paint);
        canvas.drawLine(100,1000,900,1000,paint);

        canvas.drawLine(100,500,200,600,paint);
        canvas.drawLine(200,500,300,600,paint);
        canvas.drawLine(300,500,400,600,paint);
        canvas.drawLine(400,500,500,600,paint);
        canvas.drawLine(500,500,600,600,paint);
        canvas.drawLine(600,500,700,600,paint);
        canvas.drawLine(700,500,800,600,paint);
        canvas.drawLine(800,500,900,600,paint);

        canvas.drawLine(100,600,200,500,paint);
        canvas.drawLine(200,600,300,500,paint);
        canvas.drawLine(300,600,400,500,paint);
        canvas.drawLine(400,600,500,500,paint);
        canvas.drawLine(500,600,600,500,paint);
        canvas.drawLine(600,600,700,500,paint);
        canvas.drawLine(700,600,800,500,paint);
        canvas.drawLine(800,600,900,500,paint);

        canvas.drawLine(400,100,600,300,paint);
        canvas.drawLine(600,100,400,300,paint);
        canvas.drawLine(400,800,600,1000,paint);
        canvas.drawLine(600,800,400,1000,paint);
    }
}
