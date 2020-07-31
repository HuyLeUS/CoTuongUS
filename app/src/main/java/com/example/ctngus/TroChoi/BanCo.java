package com.example.ctngus.TroChoi;

import com.example.ctngus.QuanCoTuong.Phe;
import com.example.ctngus.QuanCoTuong.QuanCo;
import com.example.ctngus.QuanCoTuong.QuanMa;
import com.example.ctngus.QuanCoTuong.QuanPhao;
import com.example.ctngus.QuanCoTuong.QuanSi;
import com.example.ctngus.QuanCoTuong.QuanSoai;
import com.example.ctngus.QuanCoTuong.QuanTot;
import com.example.ctngus.QuanCoTuong.QuanTuong;
import com.example.ctngus.QuanCoTuong.QuanXe;

import java.util.Random;


public class BanCo {
     private QuanCo quanXeDo1, quanXeDo2, quanMaDo1, quanMaDo2, quanTuongDo1, quanTuongDo2, quanSiDo1, quanSiDo2, quanSoaiDo,
             quanTotDo1, quanTotDo2, quanTotDo3, quanTotDo4, quanTotDo5, quanPhaoDo1, quanPhaoDo2;
     private QuanCo quanXeDen1, quanXeDen2, quanMaDen1, quanMaDen2, quanTuongDen1, quanTuongDen2, quanSiDen1, quanSiDen2, quanSoaiDen,
             quanTotDen1, quanTotDen2, quanTotDen3, quanTotDen4, quanTotDen5, quanPhaoDen1, quanPhaoDen2;
     private ToaDo[][] mangToaDo = new ToaDo[10][9];

     public ToaDo[][] getMangToaDo() {
          return mangToaDo;
     }

     public BanCo() {
          quanXeDen1 = new QuanXe(Phe.PHE_DEN);
          quanMaDen1 = new QuanMa(Phe.PHE_DEN);
          quanTuongDen1 = new QuanTuong(Phe.PHE_DEN);
          quanSiDen1 = new QuanSi(Phe.PHE_DEN);
          quanSoaiDen = new QuanSoai(Phe.PHE_DEN);
          quanSiDen2 = new QuanSi(Phe.PHE_DEN);
          quanTuongDen2 = new QuanTuong(Phe.PHE_DEN);
          quanMaDen2 = new QuanMa(Phe.PHE_DEN);
          quanXeDen2 = new QuanXe(Phe.PHE_DEN);
          quanPhaoDen1 = new QuanPhao(Phe.PHE_DEN);
          quanPhaoDen2 = new QuanPhao(Phe.PHE_DEN);
          quanTotDen1 = new QuanTot(Phe.PHE_DEN);
          quanTotDen2 = new QuanTot(Phe.PHE_DEN);
          quanTotDen3 = new QuanTot(Phe.PHE_DEN);
          quanTotDen4 = new QuanTot(Phe.PHE_DEN);
          quanTotDen5 = new QuanTot(Phe.PHE_DEN);

          quanXeDo1 = new QuanXe(Phe.PHE_DO);
          quanMaDo1 = new QuanMa(Phe.PHE_DO);
          quanTuongDo1 = new QuanTuong(Phe.PHE_DO);
          quanSiDo1 = new QuanSi(Phe.PHE_DO);
          quanSoaiDo = new QuanSoai(Phe.PHE_DO);
          quanSiDo2 = new QuanSi(Phe.PHE_DO);
          quanTuongDo2 = new QuanTuong(Phe.PHE_DO);
          quanMaDo2 = new QuanMa(Phe.PHE_DO);
          quanXeDo2 = new QuanXe(Phe.PHE_DO);
          quanPhaoDo1 = new QuanPhao(Phe.PHE_DO);
          quanPhaoDo2 = new QuanPhao(Phe.PHE_DO);
          quanTotDo1 = new QuanTot(Phe.PHE_DO);
          quanTotDo2 = new QuanTot(Phe.PHE_DO);
          quanTotDo3 = new QuanTot(Phe.PHE_DO);
          quanTotDo4 = new QuanTot(Phe.PHE_DO);
          quanTotDo5 = new QuanTot(Phe.PHE_DO);

          for (int i = 0; i < 10; i++) {
               for (int j = 0; j < 9; j++) {
                    mangToaDo[i][j] = new ToaDo(j, i, null);
                    Random rng = new Random();
                    mangToaDo[i][j].setLaDiemGoiY(rng.nextBoolean());
               }
          }
     }

     public void xepCo(Phe pheTa) {
          //Lấy tất cả quân cờ ra khỏi bàn cờ
          for (int i = 0; i < 10; i++) {
               for (int j = 0; j < 9; j++) {
                    mangToaDo[i][j].setQuanCo(null);
//                    Random rng = new Random();
//                    mangToaDo[i][j].setLaDiemGoiY(rng.nextBoolean());
               }
          }
          int pheDen = pheTa.equals(Phe.PHE_DEN) ? 1 : 0;
          int pheDo = pheTa.equals(Phe.PHE_DO) ? 1 : 0;
          //Xếp cờ
          mangToaDo[pheTa.equals(Phe.PHE_DEN) ? 9 : 0][0].setQuanCo(quanXeDen1);
          mangToaDo[pheTa.equals(Phe.PHE_DEN) ? 9 : 0][1].setQuanCo(quanMaDen1);
          mangToaDo[pheTa.equals(Phe.PHE_DEN) ? 9 : 0][2].setQuanCo(quanTuongDen1);
          mangToaDo[pheTa.equals(Phe.PHE_DEN) ? 9 : 0][3].setQuanCo(quanSiDen1);
          mangToaDo[pheTa.equals(Phe.PHE_DEN) ? 9 : 0][4].setQuanCo(quanSoaiDen);
          mangToaDo[pheTa.equals(Phe.PHE_DEN) ? 9 : 0][5].setQuanCo(quanSiDen2);
          mangToaDo[pheTa.equals(Phe.PHE_DEN) ? 9 : 0][6].setQuanCo(quanTuongDen2);
          mangToaDo[pheTa.equals(Phe.PHE_DEN) ? 9 : 0][7].setQuanCo(quanMaDen2);
          mangToaDo[pheTa.equals(Phe.PHE_DEN) ? 9 : 0][8].setQuanCo(quanXeDen2);
          mangToaDo[pheTa.equals(Phe.PHE_DEN) ? 7 : 2][1].setQuanCo(quanPhaoDen1);
          mangToaDo[pheTa.equals(Phe.PHE_DEN) ? 7 : 2][7].setQuanCo(quanPhaoDen2);
          mangToaDo[pheTa.equals(Phe.PHE_DEN) ? 6 : 3][0].setQuanCo(quanTotDen1);
          mangToaDo[pheTa.equals(Phe.PHE_DEN) ? 6 : 3][2].setQuanCo(quanTotDen2);
          mangToaDo[pheTa.equals(Phe.PHE_DEN) ? 6 : 3][4].setQuanCo(quanTotDen3);
          mangToaDo[pheTa.equals(Phe.PHE_DEN) ? 6 : 3][6].setQuanCo(quanTotDen4);
          mangToaDo[pheTa.equals(Phe.PHE_DEN) ? 6 : 3][8].setQuanCo(quanTotDen5);

          mangToaDo[pheTa.equals(Phe.PHE_DO) ? 9 : 0][0].setQuanCo(quanXeDo1);
          mangToaDo[pheTa.equals(Phe.PHE_DO) ? 9 : 0][1].setQuanCo(quanMaDo1);
          mangToaDo[pheTa.equals(Phe.PHE_DO) ? 9 : 0][2].setQuanCo(quanTuongDo1);
          mangToaDo[pheTa.equals(Phe.PHE_DO) ? 9 : 0][3].setQuanCo(quanSiDo1);
          mangToaDo[pheTa.equals(Phe.PHE_DO) ? 9 : 0][4].setQuanCo(quanSoaiDo);
          mangToaDo[pheTa.equals(Phe.PHE_DO) ? 9 : 0][5].setQuanCo(quanSiDo2);
          mangToaDo[pheTa.equals(Phe.PHE_DO) ? 9 : 0][6].setQuanCo(quanTuongDo2);
          mangToaDo[pheTa.equals(Phe.PHE_DO) ? 9 : 0][7].setQuanCo(quanMaDo2);
          mangToaDo[pheTa.equals(Phe.PHE_DO) ? 9 : 0][8].setQuanCo(quanXeDo2);
          mangToaDo[pheTa.equals(Phe.PHE_DO) ? 7 : 2][1].setQuanCo(quanPhaoDo1);
          mangToaDo[pheTa.equals(Phe.PHE_DO) ? 7 : 2][7].setQuanCo(quanPhaoDo2);
          mangToaDo[pheTa.equals(Phe.PHE_DO) ? 6 : 3][0].setQuanCo(quanTotDo1);
          mangToaDo[pheTa.equals(Phe.PHE_DO) ? 6 : 3][2].setQuanCo(quanTotDo2);
          mangToaDo[pheTa.equals(Phe.PHE_DO) ? 6 : 3][4].setQuanCo(quanTotDo3);
          mangToaDo[pheTa.equals(Phe.PHE_DO) ? 6 : 3][6].setQuanCo(quanTotDo4);
          mangToaDo[pheTa.equals(Phe.PHE_DO) ? 6 : 3][8].setQuanCo(quanTotDo5);
     }

     public void hienThiDiemGoiY(ToaDo toaDo) {
          //Sinh ra các nước có thể đi bằng cách bật cờ laDiemGoiY trong toaDo
          //Kiểm tra các nước không hợp lệ và loại bỏ

     }

     //Kết quả trả về true nếu đánh được false nếu ko đánh được
     public boolean thucHienDanhCo(ToaDo toaDoDaChon, ToaDo toaDoDen) {
          //Xử lý di chuyển ăn quân địch
          QuanCo quanCo = toaDoDaChon.getQuanCo();
          if (toaDoDen.getLaDiemGoiY()) {
               toaDoDaChon.setQuanCo(null);
               toaDoDen.setQuanCo(quanCo);
               return true;
          }
          return false;
     }
}
