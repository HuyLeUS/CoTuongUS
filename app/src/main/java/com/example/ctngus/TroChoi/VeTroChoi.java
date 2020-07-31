package com.example.ctngus.TroChoi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.ctngus.QuanCoTuong.Phe;
import com.example.ctngus.QuanCoTuong.QuanCo;
import com.example.ctngus.QuanCoTuong.QuanMa;
import com.example.ctngus.QuanCoTuong.QuanPhao;
import com.example.ctngus.QuanCoTuong.QuanSi;
import com.example.ctngus.QuanCoTuong.QuanSoai;
import com.example.ctngus.QuanCoTuong.QuanTot;
import com.example.ctngus.QuanCoTuong.QuanTuong;
import com.example.ctngus.QuanCoTuong.QuanXe;
import com.example.ctngus.R;

public class VeTroChoi extends View {

     private Paint paint = new Paint();
     private TroChoi troChoi;
     private int boardHeight;
     private int boardWidth;
     private int leftMargin;
     private int topMargin;
     private int side;
     private int radius;

     public VeTroChoi(Context context, TroChoi troChoi) {
          super(context);
          this.troChoi = troChoi;
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
          side = boardWidth / 8;
     }

     @Override
     protected void onDraw(Canvas canvas) {
          super.onDraw(canvas);

          paint.setStrokeWidth(6);

          paint.setColor(Color.parseColor("#443022"));
          canvas.drawRect(0, 0, leftMargin * 2 + 1 + boardWidth, topMargin * 2 + 1 + boardHeight, paint);
          paint.setColor(Color.parseColor("#fcaf3e"));
          canvas.drawRect((int) (leftMargin * 0.1), (int) (topMargin * 0.8), leftMargin + boardWidth + (int) (leftMargin * 0.9), topMargin + boardHeight + (int) (topMargin * 0.2), paint);

          paint.setColor(Color.BLACK);

          canvas.drawLine(leftMargin, topMargin, leftMargin + boardWidth, topMargin, paint);
          canvas.drawLine(leftMargin + boardWidth, topMargin, leftMargin + boardWidth, topMargin + boardHeight, paint);
          canvas.drawLine(leftMargin + boardWidth, topMargin + boardHeight, leftMargin, topMargin + boardHeight, paint);
          canvas.drawLine(leftMargin, topMargin + boardHeight, leftMargin, topMargin, paint);
          // Vẽ các đường ngang
          for (int i = 1; i < 9; i++) {
               canvas.drawLine(leftMargin, topMargin + side * i, leftMargin + boardWidth, topMargin + side * i, paint);
          }
          // Vẽ các đường dọc
          for (int i = 1; i < 8; i++) {
               canvas.drawLine(leftMargin + i * side, topMargin, leftMargin + i * side, topMargin + 4 * side, paint);
               canvas.drawLine(leftMargin + i * side, topMargin + 5 * side, leftMargin + i * side, topMargin + 9 * side, paint);
          }
          //Vẽ các đường chéo cấm cung
          canvas.drawLine(leftMargin + 3 * side, topMargin, leftMargin + 5 * side, topMargin + 2 * side, paint);
          canvas.drawLine(leftMargin + 5 * side, topMargin, leftMargin + 3 * side, topMargin + 2 * side, paint);

          canvas.drawLine(leftMargin + 3 * side, topMargin + 7 * side, leftMargin + 5 * side, topMargin + 9 * side, paint);
          canvas.drawLine(leftMargin + 5 * side, topMargin + 7 * side, leftMargin + 3 * side, topMargin + 9 * side, paint);
          ToaDo[][] mangToaDo = troChoi.getBanCo().getMangToaDo();
          for (int i = 0; i < 10; i++) {
               for (int j = 0; j < 9; j++) {
                    QuanCo quanCo = mangToaDo[i][j].getQuanCo();
                    if (quanCo != null) {
                         veQuanCo(canvas, quanCo, i, j);
                    }
                    if (mangToaDo[i][j].getLaDiemGoiY())
                    {
                         veDiemGoiY(canvas, mangToaDo[i][j]);
                    }
               }
          }

     }

     private void veDiemGoiY(Canvas canvas, ToaDo toaDo) {
          int red = 0x74;
          int green = 0xb9;
          int blue = 0xff;
          for (int i = 10; i > 0; i--) {
               paint.setColor(Color.argb(0xFF - i * 0x13,
                       Math.max((int) (red - red * i * 0.025), 0),
                       Math.max((int) (green - green * i * 0.025), 0),
                       Math.max((int) (blue - blue * i * 0.025), 0)));
               canvas.drawCircle(leftMargin + toaDo.getX() * side, topMargin + toaDo.getY() * side, (int) (radius * i * 0.025), paint);
          }
     }


     @SuppressLint("ClickableViewAccessibility")
     @Override
     public boolean onTouchEvent(MotionEvent event) {
          int pointerIndex = event.getActionIndex();
          int action = event.getAction();
          switch (action) {
               case MotionEvent.ACTION_DOWN: {
                    int x = (int) event.getX();
                    int y = (int) event.getY();
                    Log.d("Touch x, y", x + ", " + y);
                    int j = (x - leftMargin + radius) / side;
                    int i = (y - topMargin + radius) / side;
                    Log.d("Touch i, j", i + ", " + j);
                    ToaDo toaDo = troChoi.getBanCo().getMangToaDo()[i][j];
                    troChoi.xuLySuKienTroChoi(toaDo);
                    break;
               }
          }
          invalidate();
          return true;
     }

     private void veQuanCo(Canvas canvas, QuanCo quanCo, int i, int j) {
          String chessSymbol = "";
          if (quanCo instanceof QuanXe) {
               if (quanCo.getPhe().equals(Phe.PHE_DEN)) {
                    chessSymbol = getResources().getString(R.string.quan_xe_den);
               } else {
                    chessSymbol = getResources().getString(R.string.quan_xe_do);
               }
          }
          if (quanCo instanceof QuanMa) {
               if (quanCo.getPhe().equals(Phe.PHE_DEN)) {
                    chessSymbol = getResources().getString(R.string.quan_ma_den);
               } else {
                    chessSymbol = getResources().getString(R.string.quan_ma_do);
               }
          }
          if (quanCo instanceof QuanTuong) {
               if (quanCo.getPhe().equals(Phe.PHE_DEN)) {
                    chessSymbol = getResources().getString(R.string.quan_tuong_den);
               } else {
                    chessSymbol = getResources().getString(R.string.quan_tuong_do);
               }
          }
          if (quanCo instanceof QuanSi) {
               if (quanCo.getPhe().equals(Phe.PHE_DEN)) {
                    chessSymbol = getResources().getString(R.string.quan_si_den);
               } else {
                    chessSymbol = getResources().getString(R.string.quan_si_do);
               }
          }
          if (quanCo instanceof QuanSoai) {
               if (quanCo.getPhe().equals(Phe.PHE_DEN)) {
                    chessSymbol = getResources().getString(R.string.quan_soai_den);
               } else {
                    chessSymbol = getResources().getString(R.string.quan_soai_do);
               }
          }
          if (quanCo instanceof QuanPhao) {
               if (quanCo.getPhe().equals(Phe.PHE_DEN)) {
                    chessSymbol = getResources().getString(R.string.quan_phao_den);
               } else {
                    chessSymbol = getResources().getString(R.string.quan_phao_do);
               }
          }
          if (quanCo instanceof QuanTot) {
               if (quanCo.getPhe().equals(Phe.PHE_DEN)) {
                    chessSymbol = getResources().getString(R.string.quan_tot_den);
               } else {
                    chessSymbol = getResources().getString(R.string.quan_tot_do);
               }
          }
          int chessColor = Color.BLACK;
          if (quanCo.getPhe().equals(Phe.PHE_DO)) {
               chessColor = Color.RED;
          }

          radius = (int) (0.45 * side);
          ToaDo toaDoDaChon = troChoi.getToaDoDaChon();
          paint.setColor(Color.BLACK);
          if (toaDoDaChon != null) {
               if (toaDoDaChon.getQuanCo() == quanCo) {
                    paint.setColor(Color.parseColor("#fedaa4"));
               }
          }
          canvas.drawCircle(leftMargin + j * side, topMargin + i * side, radius, paint);
          paint.setColor(Color.parseColor("#fedaa4"));
          canvas.drawCircle(leftMargin + j * side, topMargin + i * side, (int) (radius - radius / 10), paint);
          paint.setColor(chessColor);
          canvas.drawCircle(leftMargin + j * side, topMargin + i * side, (int) (radius - radius / 7.5), paint);
          paint.setColor(Color.parseColor("#fedaa4"));
          canvas.drawCircle(leftMargin + j * side, topMargin + i * side, (int) (radius - radius / 5), paint);
          paint.setColor(chessColor);
          paint.setTextSize(radius);
          paint.setTextAlign(Paint.Align.CENTER);
          canvas.drawText(chessSymbol, leftMargin + j * side, topMargin + i * side + (int) ((radius - radius / 5) / 2), paint);
     }

}
