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

import java.util.List;
import java.util.Random;


public class BanCo {
     private QuanCo quanXeDo1, quanXeDo2, quanMaDo1, quanMaDo2, quanTuongDo1, quanTuongDo2, quanSiDo1, quanSiDo2, quanSoaiDo,
             quanTotDo1, quanTotDo2, quanTotDo3, quanTotDo4, quanTotDo5, quanPhaoDo1, quanPhaoDo2;
     private QuanCo quanXeDen1, quanXeDen2, quanMaDen1, quanMaDen2, quanTuongDen1, quanTuongDen2, quanSiDen1, quanSiDen2, quanSoaiDen,
             quanTotDen1, quanTotDen2, quanTotDen3, quanTotDen4, quanTotDen5, quanPhaoDen1, quanPhaoDen2;
     private ToaDo[][] mangToaDo = new ToaDo[10][9];

     private Phe pheDuoiBanCo = Phe.PHE_DEN;

     public void setPheDuoiBanCo(Phe pheDuoiBanCo) {
          this.pheDuoiBanCo = pheDuoiBanCo;
     }

     public Phe getPheDuoiBanCo() {
          return pheDuoiBanCo;
     }

     public ToaDo getToaDoQuanSoai(Phe phe) {
          if (phe.equals(pheDuoiBanCo)) {
               for (int i = 7; i < 10; i++) {
                    for (int j = 3; j < 6; j++) {
                         if (mangToaDo[i][j].getQuanCo() instanceof QuanSoai) {
                              return mangToaDo[i][j];
                         }
                    }
               }
          } else {
               for (int i = 0; i < 3; i++) {
                    for (int j = 3; j < 6; j++) {
                         if (mangToaDo[i][j].getQuanCo() instanceof QuanSoai) {
                              return mangToaDo[i][j];
                         }
                    }
               }
          }
          return null;
     }

     public boolean coBiChieu(Phe phe) {
          ToaDo toaDoQuanSoai = getToaDoQuanSoai(phe);
          int i = toaDoQuanSoai.getY();
          int j = toaDoQuanSoai.getX();
          int di = 1;
          int dj = 1;
          boolean coBiChan = false;
          //Kiểm tra tốt chiếu
          if (i + 1 < 10) {
               if (mangToaDo[i + 1][j].getQuanCo() instanceof QuanTot) {
                    if (!mangToaDo[i + 1][j].getQuanCo().getPhe().equals(phe)) {
                         return true;
                    }
               }
          }
          if (i - 1 >= 0) {
               if (mangToaDo[i - 1][j].getQuanCo() instanceof QuanTot) {
                    if (!mangToaDo[i - 1][j].getQuanCo().getPhe().equals(phe)) {
                         return true;
                    }
               }
          }
          if (j - 1 >= 0) {
               if (mangToaDo[i][j - 1].getQuanCo() instanceof QuanTot) {
                    if (!mangToaDo[i][j - 1].getQuanCo().getPhe().equals(phe)) {
                         return true;
                    }
               }
          }
          if (j + 1 < 9) {
               if (mangToaDo[i][j + 1].getQuanCo() instanceof QuanTot) {
                    if (!mangToaDo[i][j + 1].getQuanCo().getPhe().equals(phe)) {
                         return true;
                    }
               }
          }
          //Kiểm tra xe, pháo chiếu và mặt tướng
          while (i + di < 10) {
               if (mangToaDo[i + di][j].getQuanCo() != null) {
                    if (!coBiChan) {
                         coBiChan = true;
                         if (mangToaDo[i + di][j].getQuanCo() instanceof QuanXe) {
                              if (!mangToaDo[i + di][j].getQuanCo().getPhe().equals(phe)) {
                                   return true;
                              }
                         }
                         if (mangToaDo[i + di][j].getQuanCo() instanceof QuanSoai) {
                              return true;
                         }
                    } else {
                         if (mangToaDo[i + di][j].getQuanCo() instanceof QuanPhao) {
                              if (!mangToaDo[i + di][j].getQuanCo().getPhe().equals(phe)) {
                                   return true;
                              }
                         } else {
                              break;
                         }
                    }
               }
               di++;
          }
          di = 1;
          coBiChan = false;
          while (i - di >= 0) {
               if (mangToaDo[i - di][j].getQuanCo() != null) {
                    if (!coBiChan) {
                         coBiChan = true;
                         if (mangToaDo[i - di][j].getQuanCo() instanceof QuanXe) {
                              if (!mangToaDo[i - di][j].getQuanCo().getPhe().equals(phe)) {
                                   return true;
                              }
                         }
                         if (mangToaDo[i - di][j].getQuanCo() instanceof QuanSoai) {
                              return true;
                         }
                    } else {
                         if (mangToaDo[i - di][j].getQuanCo() instanceof QuanPhao) {
                              if (!mangToaDo[i - di][j].getQuanCo().getPhe().equals(phe)) {
                                   return true;
                              }
                         } else {
                              break;
                         }
                    }
               }
               di++;
          }
          coBiChan = false;
          while (j - dj >= 0) {
               if (mangToaDo[i][j - dj].getQuanCo() != null) {
                    if (!coBiChan) {
                         coBiChan = true;
                         if (mangToaDo[i][j - dj].getQuanCo() instanceof QuanXe) {
                              if (!mangToaDo[i][j - dj].getQuanCo().getPhe().equals(phe)) {
                                   return true;
                              }
                         }
                    } else {
                         if (mangToaDo[i][j - dj].getQuanCo() instanceof QuanPhao) {
                              if (!mangToaDo[i][j - dj].getQuanCo().getPhe().equals(phe)) {
                                   return true;
                              }
                         } else {
                              break;
                         }
                    }
               }
               dj++;
          }
          dj = 1;
          coBiChan = false;
          while (j + dj < 9) {
               if (mangToaDo[i][j + dj].getQuanCo() != null) {
                    if (!coBiChan) {
                         if (mangToaDo[i][j + dj].getQuanCo() instanceof QuanXe) {
                              if (!mangToaDo[i][j + dj].getQuanCo().getPhe().equals(phe)) {
                                   return true;
                              }
                         }
                    } else {
                         if (mangToaDo[i][j + dj].getQuanCo() instanceof QuanPhao) {
                              if (!mangToaDo[i][j + dj].getQuanCo().getPhe().equals(phe)) {
                                   return true;
                              }
                         } else {
                              break;
                         }
                    }
               }
               dj++;
          }
          //Kiểm tra mã chiếu
          if (i - 2 >= 0) {
               if (j - 1 >= 0) {
                    if (mangToaDo[i - 2][j - 1].getQuanCo() instanceof QuanMa) {
                         if (!mangToaDo[i - 2][j - 1].getQuanCo().getPhe().equals(phe)) {
                              if (mangToaDo[i - 1][j - 1].getQuanCo() == null) {
                                   return true;
                              }
                         }
                    }
               }
               if (j + 1 < 9) {
                    if (mangToaDo[i - 2][j + 1].getQuanCo() instanceof QuanMa) {
                         if (!mangToaDo[i - 2][j + 1].getQuanCo().getPhe().equals(phe)) {
                              if (mangToaDo[i - 1][j + 1].getQuanCo() == null) {
                                   return true;
                              }
                         }
                    }
               }
          }
          if (i + 2 < 10) {
               if (j - 1 >= 0) {
                    if (mangToaDo[i + 2][j - 1].getQuanCo() instanceof QuanMa) {
                         if (!mangToaDo[i + 2][j - 1].getQuanCo().getPhe().equals(phe)) {
                              if (mangToaDo[i + 1][j - 1].getQuanCo() == null) {
                                   return true;
                              }
                         }
                    }
               }
               if (j + 1 < 9) {
                    if (mangToaDo[i + 2][j + 1].getQuanCo() instanceof QuanMa) {
                         if (!mangToaDo[i + 2][j + 1].getQuanCo().getPhe().equals(phe)) {
                              if (mangToaDo[i + 1][j + 1].getQuanCo() == null) {
                                   return true;
                              }
                         }
                    }
               }
          }
          if (j - 2 >= 0) {
               if (i - 1 >= 0) {
                    if (mangToaDo[i - 1][j - 2].getQuanCo() instanceof QuanMa) {
                         if (!mangToaDo[i - 1][j - 2].getQuanCo().getPhe().equals(phe)) {
                              if (mangToaDo[i - 1][j - 1].getQuanCo() == null) {
                                   return true;
                              }
                         }
                    }
               }
               if (i + 1 < 10) {
                    if (mangToaDo[i + 1][j - 2].getQuanCo() instanceof QuanMa) {
                         if (!mangToaDo[i + 1][j - 2].getQuanCo().getPhe().equals(phe)) {
                              if (mangToaDo[i + 1][j - 1].getQuanCo() == null) {
                                   return true;
                              }
                         }
                    }
               }
          }
          if (j + 2 < 9) {
               if (i - 1 >= 0) {
                    if (mangToaDo[i - 1][j + 2].getQuanCo() instanceof QuanMa) {
                         if (!mangToaDo[i - 1][j + 2].getQuanCo().getPhe().equals(phe)) {
                              if (mangToaDo[i - 1][j + 1].getQuanCo() == null) {
                                   return true;
                              }
                         }
                    }
               }
               if (i + 1 < 10) {
                    if (mangToaDo[i + 1][j + 2].getQuanCo() instanceof QuanMa) {
                         if (!mangToaDo[i + 1][j + 2].getQuanCo().getPhe().equals(phe)) {
                              if (mangToaDo[i + 1][j + 1].getQuanCo() == null) {
                                   return true;
                              }
                         }
                    }
               }
          }
          return false;
     }

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
//                    Random rng = new Random();
//                    mangToaDo[i][j].setLaDiemGoiY(rng.nextBoolean());
               }
          }
     }

     public void xepCo() {
          //Lấy tất cả quân cờ ra khỏi bàn cờ
          for (int i = 0; i < 10; i++) {
               for (int j = 0; j < 9; j++) {
                    mangToaDo[i][j].setQuanCo(null);
//                    Random rng = new Random();
//                    mangToaDo[i][j].setLaDiemGoiY(rng.nextBoolean());
               }
          }
          int pheDen = pheDuoiBanCo.equals(Phe.PHE_DEN) ? 1 : 0;
          int pheDo = pheDuoiBanCo.equals(Phe.PHE_DO) ? 1 : 0;
          //Xếp cờ
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DEN) ? 9 : 0][0].setQuanCo(quanXeDen1);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DEN) ? 9 : 0][1].setQuanCo(quanMaDen1);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DEN) ? 9 : 0][2].setQuanCo(quanTuongDen1);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DEN) ? 9 : 0][3].setQuanCo(quanSiDen1);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DEN) ? 9 : 0][4].setQuanCo(quanSoaiDen);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DEN) ? 9 : 0][5].setQuanCo(quanSiDen2);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DEN) ? 9 : 0][6].setQuanCo(quanTuongDen2);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DEN) ? 9 : 0][7].setQuanCo(quanMaDen2);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DEN) ? 9 : 0][8].setQuanCo(quanXeDen2);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DEN) ? 7 : 2][1].setQuanCo(quanPhaoDen1);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DEN) ? 7 : 2][7].setQuanCo(quanPhaoDen2);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DEN) ? 6 : 3][0].setQuanCo(quanTotDen1);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DEN) ? 6 : 3][2].setQuanCo(quanTotDen2);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DEN) ? 6 : 3][4].setQuanCo(quanTotDen3);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DEN) ? 6 : 3][6].setQuanCo(quanTotDen4);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DEN) ? 6 : 3][8].setQuanCo(quanTotDen5);

          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DO) ? 9 : 0][0].setQuanCo(quanXeDo1);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DO) ? 9 : 0][1].setQuanCo(quanMaDo1);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DO) ? 9 : 0][2].setQuanCo(quanTuongDo1);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DO) ? 9 : 0][3].setQuanCo(quanSiDo1);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DO) ? 9 : 0][4].setQuanCo(quanSoaiDo);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DO) ? 9 : 0][5].setQuanCo(quanSiDo2);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DO) ? 9 : 0][6].setQuanCo(quanTuongDo2);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DO) ? 9 : 0][7].setQuanCo(quanMaDo2);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DO) ? 9 : 0][8].setQuanCo(quanXeDo2);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DO) ? 7 : 2][1].setQuanCo(quanPhaoDo1);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DO) ? 7 : 2][7].setQuanCo(quanPhaoDo2);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DO) ? 6 : 3][0].setQuanCo(quanTotDo1);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DO) ? 6 : 3][2].setQuanCo(quanTotDo2);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DO) ? 6 : 3][4].setQuanCo(quanTotDo3);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DO) ? 6 : 3][6].setQuanCo(quanTotDo4);
          mangToaDo[pheDuoiBanCo.equals(Phe.PHE_DO) ? 6 : 3][8].setQuanCo(quanTotDo5);
     }

     public void hienThiDiemGoiY(ToaDo toaDo) {
          //Sinh ra các nước có thể đi bằng cách bật cờ laDiemGoiY trong toaDo
          //Kiểm tra các nước không hợp lệ và loại bỏ
          xoaDiemGoiY();
          List<ToaDo> danhSachNuocDi = toaDo.getQuanCo().duDoanNuocDi(this, toaDo);
          for(ToaDo toaDoGoiY : danhSachNuocDi) {
               toaDoGoiY.setLaDiemGoiY(true);
               if (toaDoGoiY.getQuanCo() != null) {
                    if (toaDo.getQuanCo().getPhe().equals(toaDoGoiY.getQuanCo().getPhe())) {
                         toaDoGoiY.setLaDiemGoiY(false);
                    }
               }
               if (toaDoGoiY.getLaDiemGoiY()) {
                    QuanCo quanCoBiAn = toaDoGoiY.getQuanCo();
                    QuanCo quanCoDangXet = toaDo.getQuanCo();
                    toaDoGoiY.setQuanCo(quanCoDangXet);
                    toaDo.setQuanCo(null);
                    if (coBiChieu(quanCoDangXet.getPhe())) {
                         toaDoGoiY.setLaDiemGoiY(false);
                    }
                    toaDo.setQuanCo(quanCoDangXet);
                    toaDoGoiY.setQuanCo(quanCoBiAn);
               }
          }
     }

     //Kết quả trả về true nếu đánh được false nếu ko đánh được
     public boolean thucHienDanhCo(ToaDo toaDoDaChon, ToaDo toaDoDen) {
          //Xử lý di chuyển ăn quân địch
          QuanCo quanCo = toaDoDaChon.getQuanCo();
          if (toaDoDen.getLaDiemGoiY()) {
               toaDoDaChon.setQuanCo(null);
               toaDoDen.setQuanCo(quanCo);
               xoaDiemGoiY();
               return true;
          }
          return false;
     }

     private void xoaDiemGoiY() {
          for (int i = 0; i < 10; i++) {
               for (int j = 0; j < 9; j++) {
                    mangToaDo[i][j].setLaDiemGoiY(false);
               }
          }
     }
}
