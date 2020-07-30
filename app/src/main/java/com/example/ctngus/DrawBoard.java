package com.example.ctngus;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;

public class DrawBoard extends View {

     private Paint paint = new Paint();
     private int boardHeight;
     private int boardWidth;
     private int leftMargin;
     private int topMargin;

     public DrawBoard(Context context) {
          super(context);
          init();
     }

     private void init() {
          DisplayMetrics displayMetrics = new DisplayMetrics();
          ((Activity) getContext()).getWindowManager()
                  .getDefaultDisplay()
                  .getMetrics(displayMetrics);
          boardWidth = (int) (displayMetrics.widthPixels * 0.88);
          boardHeight = (int) (boardWidth / 8 * 9);
          leftMargin = (displayMetrics.widthPixels - boardWidth) / 2;
          topMargin = (displayMetrics.heightPixels - boardHeight) / 2;
          paint.setColor(Color.GRAY);
          paint.setStrokeWidth(6);
     }

     @Override
     protected void onDraw(Canvas canvas) {
         super.onDraw(canvas);
         int side = boardWidth / 8;
         canvas.drawLine(leftMargin, topMargin, leftMargin + boardWidth, topMargin, paint);
         canvas.drawLine(leftMargin + boardWidth, topMargin, leftMargin + boardWidth, topMargin + boardHeight, paint);
         canvas.drawLine(leftMargin + boardWidth, topMargin + boardHeight, leftMargin, topMargin + boardHeight, paint);
         canvas.drawLine(leftMargin, topMargin + boardHeight, leftMargin, topMargin, paint);
         // Vẽ các đường ngang
         for (int i = 1; i < 9; i++) {
             canvas.drawLine(leftMargin, topMargin + side * i, leftMargin + boardWidth, topMargin + side * i, paint);
         }
         // Vẽ các đường dọc
         for (int i = 1; i < 8; i++)
         {
             canvas.drawLine(leftMargin + i*side, topMargin, leftMargin + i*side , topMargin+ 4 * side, paint);
             canvas.drawLine(leftMargin + i*side, topMargin + 5 * side, leftMargin + i*side , topMargin + 9 * side, paint);
         }
         //Vẽ các đường chéo cấm cung
         canvas.drawLine(leftMargin + 3 * side, topMargin, leftMargin + 5 * side, topMargin + 2 * side, paint);
         canvas.drawLine(leftMargin + 5 * side, topMargin, leftMargin + 3 * side, topMargin + 2 * side, paint);

         canvas.drawLine(leftMargin + 3 * side, topMargin + 7 * side, leftMargin + 5 * side, topMargin + 9 * side, paint);
         canvas.drawLine(leftMargin + 5 * side, topMargin + 7 * side, leftMargin + 3 * side, topMargin + 9 * side, paint);


     }
}
