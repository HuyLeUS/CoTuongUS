package com.example.ctngus.TroChoi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
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
import com.example.ctngus.TroChoi.AmThanh.HieuUngAmThanh;

public class VeTroChoi extends View {

     private Paint paint = new Paint();
     private TroChoi troChoi;
     private int boardHeight;
     private int boardWidth;
     private int leftMargin;
     private int topMargin;
     private int side;
     private int radius;
     private ToaDo toaDoDaChon = null;
     private boolean isMoving = false;
     private MediaPlayer player = MediaPlayer.create(getContext(), R.raw.danh_co_sound);
     //Điểm hiện tại của quân cờ đang di chuyển trên đường đi
     private Point cachDiem = new Point(0, 0);

     public VeTroChoi(Context context, TroChoi troChoi) {
          super(context);
          this.troChoi = troChoi;
          init();
     }

     private void init() {
          paint.setAntiAlias(true);
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
                    if (mangToaDo[i][j].getLaDiemGoiY()) {
                         veDiemGoiY(canvas, mangToaDo[i][j]);
                    }
               }
          }
          if(troChoi.getGiaiDoan().equals(GiaiDoan.CHON_QUAN_CO)) {
               Phe pheThang = troChoi.kiemTraPheThang();
               if (pheThang != null) {
                    if (pheThang.equals(Phe.PHE_DEN)) {
                         veKetQua(canvas, Phe.PHE_DEN);
                    } else {
                         veKetQua(canvas, Phe.PHE_DO);
                    }
               }
          }
     }

     private void veKetQua(Canvas canvas, Phe phe) {
          paint.setColor(Color.parseColor("#2ecc71"));
          paint.setTextSize(side);
          paint.setTextAlign(Paint.Align.CENTER);
          int yThang = (int) (topMargin - side * 1.4) ;
          int yThua = topMargin + boardHeight + side * 2;
          if(phe.equals(troChoi.getBanCo().getPheDuoiBanCo())) {
               int t = yThang;
               yThang = yThua;
               yThua = t;
          }
          canvas.drawText("Thắng", leftMargin + boardWidth >> 1, yThang, paint);
          paint.setColor(Color.parseColor("#e74c3c"));
          canvas.drawText("Thua", leftMargin + boardWidth >> 1, yThua, paint);
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
                    if(troChoi.isDangDau()) {
                         int x = (int) event.getX();
                         int y = (int) event.getY();
                         Log.d("Touch x, y", x + ", " + y);
                         int j = (x - leftMargin + radius) / side;
                         int i = (y - topMargin + radius) / side;
                         if (i < 0 || j < 0 || i > 9 || j > 8)
                              return false;
                         Log.d("Touch i, j", i + ", " + j);
                         ToaDo toaDo = troChoi.getBanCo().getMangToaDo()[i][j];
                         troChoi.xuLySuKienTroChoi(toaDo);
                    }
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


          //Xác định điểm tâm để vẽ
          int x = leftMargin + j * side;
          int y = topMargin + i * side;
          int borderColor = Color.BLACK;
          //Vẽ trong giai đoạn chọn được quân cờ
          if (troChoi.getGiaiDoan().equals(GiaiDoan.DA_CHON_QUAN_CO)) {
               toaDoDaChon = troChoi.getToaDoDaChon();
               if (toaDoDaChon.getQuanCo() == quanCo) {
                    borderColor = Color.parseColor("#fedaa4");
               }
          } else {
               //Giai đoạn đánh cờ sẽ xử lý animation
               if (troChoi.getGiaiDoan().equals(GiaiDoan.DANH_CO)) {
                    final ToaDo toaDoDen = troChoi.getToaDoDaChon();
                    if (toaDoDen.getQuanCo() == quanCo) {
                         //Chưa di chuyển
                         if (!isMoving) {
                              isMoving = true;
                              //Tọa độ đã chọn hiện giờ đang là tọa độ xuất phát của quân cờ
                              int x1 = toaDoDaChon.getX();
                              int y1 = toaDoDaChon.getY();
                              //Tọa độ đến là tọa độ quân cờ vừa đi đến
                              int x2 = toaDoDen.getX();
                              int y2 = toaDoDen.getY();
                              //Tính cách điểm của hoành độ và tung độ
                              cachDiem.x = (x2 - x1) * side;
                              cachDiem.y = (y2 - y1) * side;
                              Log.d("Moving", String.valueOf(cachDiem.x) + ", " + String.valueOf(cachDiem.y));
                              final int doDoiY = cachDiem.y;
                              final int doDoiX = cachDiem.x;
                              Log.d("Moving", String.valueOf(doDoiX));
                              Log.d("Moving", String.valueOf(doDoiY));
                              //phát âm thanh khi đánh cờ
                              HieuUngAmThanh hieuUngAmThanh = new HieuUngAmThanh(player);
                              hieuUngAmThanh.run();
                              CountDownTimer timer = new CountDownTimer(90, 10) {
                                   @Override
                                   public void onTick(long millisUntilFinished) {
                                        // giảm cách điểm để quân cờ tiến dần đến tọa độ cần đến
                                        cachDiem.x = cachDiem.x - (int) ((float) doDoiX / 9);
                                        cachDiem.y = cachDiem.y - (int) ((float) doDoiY / 9);
                                        invalidate(); // Render lại
                                   }

                                   @Override
                                   public void onFinish() {
                                        //Khi kết thúc timer
                                        //Cách điểm về 0
                                        cachDiem.x = 0;
                                        cachDiem.y = 0;
                                        //Hạ cờ di chuyển
                                        isMoving = false;
                                        //Chuyển về gian đoạn chọn quân cờ
                                        troChoi.setGiaiDoan(GiaiDoan.CHON_QUAN_CO);
                                        invalidate(); // Render lại
                                   }
                              };
                              timer.start();
                         }
                         // Điều chỉnh vị trí vẽ quân cờ
                         x -= cachDiem.x;
                         y -= cachDiem.y;
                    }
               }

          }
          if (quanCo instanceof QuanSoai) {
               if(troChoi.getBanCo().biChieu(quanCo.getPhe()))
               {
                    borderColor = Color.parseColor("#e74c3c");
               }
          }
          veQuanCo(canvas, x, y, chessSymbol, chessColor, borderColor);
     }

     private void veQuanCo(Canvas canvas, int x, int y, String chessSymbol, int chessColor, int borderColor) {
          paint.setColor(borderColor);
          canvas.drawCircle(x, y, radius, paint);
          paint.setColor(Color.parseColor("#fedaa4"));
          canvas.drawCircle(x, y, (int) (radius - radius / 10), paint);
          paint.setColor(chessColor);
          canvas.drawCircle(x, y, (int) (radius - radius / 7), paint);
          paint.setColor(Color.parseColor("#fedaa4"));
          canvas.drawCircle(x, y, (int) (radius - radius / 5), paint);
          paint.setColor(chessColor);
          paint.setTextSize(radius);
          paint.setTextAlign(Paint.Align.CENTER);
          canvas.drawText(chessSymbol, x, y + (int) ((radius - radius / 5) / 2), paint);
     }
}
