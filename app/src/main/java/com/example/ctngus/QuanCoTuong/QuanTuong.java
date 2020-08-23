package com.example.ctngus.QuanCoTuong;


import com.example.ctngus.TroChoi.BanCo;
import com.example.ctngus.TroChoi.ToaDo;

public class QuanTuong extends QuanCo {


    @Override
    public void duDoanNuocDi(BanCo banCo, ToaDo toaDo) {
        int i = toaDo.getY();
        int j = toaDo.getX();
        int jMatTuong = -1;
        ToaDo[][] mangToaDo = banCo.getMangToaDo();
        //Nằm ở bàn cờ dưới
        if (getPhe().equals(banCo.getPheDuoiBanCo())) {
            if (i + 2 < 10 && j + 2 < 9 && mangToaDo[i + 1][j + 1].getQuanCo() == null) {
                mangToaDo[i + 2][j + 2].setLaDiemGoiY(true);
                if (mangToaDo[i + 2][j + 2].getQuanCo() != null) {
                    if (mangToaDo[i + 2][j + 2].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i + 2][j + 2].setLaDiemGoiY(false);
                    }
                }
            }
            if (i - 2 >= 5 && j + 2 < 9 && mangToaDo[i - 1][j + 1].getQuanCo() == null) {
                mangToaDo[i - 2][j + 2].setLaDiemGoiY(true);
                if (mangToaDo[i - 2][j + 2].getQuanCo() != null) {
                    if (mangToaDo[i - 2][j + 2].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i - 2][j + 2].setLaDiemGoiY(false);
                    }
                }
            }
            if (i + 2 < 10 && j - 2 >= 0 && mangToaDo[i + 1][j - 1].getQuanCo() == null) {
                mangToaDo[i + 2][j - 2].setLaDiemGoiY(true);
                if (mangToaDo[i + 2][j - 2].getQuanCo() != null) {
                    if (mangToaDo[i + 2][j - 2].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i + 2][j - 2].setLaDiemGoiY(false);
                    }
                }
            }
            if (i - 2 >= 5 && j - 2 >= 0 && mangToaDo[i - 1][j - 1].getQuanCo() == null) {
                mangToaDo[i - 2][j - 2].setLaDiemGoiY(true);
                if (mangToaDo[i - 2][j - 2].getQuanCo() != null) {
                    if (mangToaDo[i - 2][j - 2].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i - 2][j - 2].setLaDiemGoiY(false);
                    }
                }
            }
            //Nằm ở bàn cờ trên
        } else {
            if (i + 2 < 5 && j + 2 < 9 && mangToaDo[i + 1][j + 1].getQuanCo() == null) {
                mangToaDo[i + 2][j + 2].setLaDiemGoiY(true);
                if (mangToaDo[i + 2][j + 2].getQuanCo() != null) {
                    if (mangToaDo[i + 2][j + 2].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i + 2][j + 2].setLaDiemGoiY(false);
                    }
                }
            }
            if (i - 2 >= 0 && j + 2 < 9 && mangToaDo[i - 1][j + 1].getQuanCo() == null) {
                mangToaDo[i - 2][j + 2].setLaDiemGoiY(true);
                if (mangToaDo[i - 2][j + 2].getQuanCo() != null) {
                    if (mangToaDo[i - 2][j + 2].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i - 2][j + 2].setLaDiemGoiY(false);
                    }
                }
            }
            if (i + 2 < 5 && j - 2 >= 0 && mangToaDo[i + 1][j - 1].getQuanCo() == null) {
                mangToaDo[i + 2][j - 2].setLaDiemGoiY(true);
                if (mangToaDo[i + 2][j - 2].getQuanCo() != null) {
                    if (mangToaDo[i + 2][j - 2].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i + 2][j - 2].setLaDiemGoiY(false);
                    }
                }
            }
            if (i - 2 >= 0 && j - 2 >= 0 && mangToaDo[i - 1][j - 1].getQuanCo() == null) {
                mangToaDo[i - 2][j - 2].setLaDiemGoiY(true);
                if (mangToaDo[i - 2][j - 2].getQuanCo() != null) {
                    if (mangToaDo[i - 2][j - 2].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i - 2][j - 2].setLaDiemGoiY(false);
                    }
                }
            }
        }
    }

    public QuanTuong(Phe phe) {
        super(phe);
    }
}
