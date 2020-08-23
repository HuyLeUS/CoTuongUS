package com.example.ctngus.QuanCoTuong;

import com.example.ctngus.TroChoi.BanCo;
import com.example.ctngus.TroChoi.ToaDo;

public class QuanSi extends QuanCo {


    @Override
    public void duDoanNuocDi(BanCo banCo, ToaDo toaDo) {
        int i = toaDo.getY();
        int j = toaDo.getX();
        ToaDo[][] mangToaDo = banCo.getMangToaDo();
        //Nằm ở bàn cờ dưới
        if (getPhe().equals(banCo.getPheDuoiBanCo())) {
            if (i + 1 < 10 && j + 1 < 6) {
                mangToaDo[i + 1][j + 1].setLaDiemGoiY(true);
                if (mangToaDo[i + 1][j + 1].getQuanCo() != null) {
                    if (mangToaDo[i + 1][j + 1].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i + 1][j + 1].setLaDiemGoiY(false);
                    }
                }
            }
            if (i - 1 >= 7 && j + 1 < 6) {
                mangToaDo[i - 1][j + 1].setLaDiemGoiY(true);
                if (mangToaDo[i - 1][j + 1].getQuanCo() != null) {
                    if (mangToaDo[i - 1][j + 1].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i - 1][j + 1].setLaDiemGoiY(false);
                    }
                }
            }
            if (i + 1 < 10 && j - 1 >= 3) {
                mangToaDo[i + 1][j - 1].setLaDiemGoiY(true);
                if (mangToaDo[i + 1][j - 1].getQuanCo() != null) {
                    if (mangToaDo[i + 1][j - 1].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i + 1][j - 1].setLaDiemGoiY(false);
                    }
                }
            }
            if (i - 1 >= 7 && j - 1 >= 3) {
                mangToaDo[i - 1][j - 1].setLaDiemGoiY(true);
                if (mangToaDo[i - 1][j - 1].getQuanCo() != null) {
                    if (mangToaDo[i - 1][j - 1].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i - 1][j - 1].setLaDiemGoiY(false);
                    }
                }
            }
            //Nằm ở bàn cờ trên
        } else {
            if (i + 1 < 3 && j + 1 < 6) {
                mangToaDo[i + 1][j + 1].setLaDiemGoiY(true);
                if (mangToaDo[i + 1][j + 1].getQuanCo() != null) {
                    if (mangToaDo[i + 1][j + 1].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i + 1][j + 1].setLaDiemGoiY(false);
                    }
                }
            }
            if (i - 1 >= 0 && j + 1 < 6) {
                mangToaDo[i - 1][j + 1].setLaDiemGoiY(true);
                if (mangToaDo[i - 1][j + 1].getQuanCo() != null) {
                    if (mangToaDo[i - 1][j + 1].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i - 1][j + 1].setLaDiemGoiY(false);
                    }
                }
            }
            if (i + 1 < 3 && j - 1 >= 3) {
                mangToaDo[i + 1][j - 1].setLaDiemGoiY(true);
                if (mangToaDo[i + 1][j - 1].getQuanCo() != null) {
                    if (mangToaDo[i + 1][j - 1].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i + 1][j - 1].setLaDiemGoiY(false);
                    }
                }
            }
            if (i - 1 >= 0 && j - 1 >= 3) {
                mangToaDo[i - 1][j - 1].setLaDiemGoiY(true);
                if (mangToaDo[i - 1][j - 1].getQuanCo() != null) {
                    if (mangToaDo[i - 1][j - 1].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i - 1][j - 1].setLaDiemGoiY(false);
                    }
                }
            }
        }
    }

    public QuanSi(Phe phe) {
        super(phe);
    }
}
