package com.example.ctngus.QuanCoTuong;


import com.example.ctngus.TroChoi.BanCo;
import com.example.ctngus.TroChoi.ToaDo;

public class QuanTot extends QuanCo {


    @Override
    public void duDoanNuocDi(BanCo banCo, ToaDo toaDo) {
        int i = toaDo.getY();
        int j = toaDo.getX();
        ToaDo[][] mangToaDo = banCo.getMangToaDo();
        if (getPhe().equals(banCo.getPheDuoiBanCo())) {
            if (i - 1 >= 0) {
                mangToaDo[i - 1][j].setLaDiemGoiY(true);
                if (mangToaDo[i - 1][j].getQuanCo() != null) {
                    if (mangToaDo[i - 1][j].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i - 1][j].setLaDiemGoiY(false);
                    }
                }
            }
            if (i < 5) {
                if (j + 1 < 9) {
                    mangToaDo[i][j + 1].setLaDiemGoiY(true);
                    if (mangToaDo[i][j + 1].getQuanCo() != null) {
                        if (mangToaDo[i][j + 1].getQuanCo().getPhe().equals(getPhe())) {
                            mangToaDo[i][j + 1].setLaDiemGoiY(false);
                        }
                    }
                }
                if (j - 1 >= 0) {
                    mangToaDo[i][j - 1].setLaDiemGoiY(true);
                    if (mangToaDo[i][j - 1].getQuanCo() != null) {
                        if (mangToaDo[i][j - 1].getQuanCo().getPhe().equals(getPhe())) {
                            mangToaDo[i][j - 1].setLaDiemGoiY(false);
                        }
                    }
                }
            }
        } else {
            if (i + 1 < 10) {
                mangToaDo[i + 1][j].setLaDiemGoiY(true);
                if (mangToaDo[i + 1][j].getQuanCo() != null) {
                    if (mangToaDo[i + 1][j].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i + 1][j].setLaDiemGoiY(false);
                    }
                }
            }
            if (i > 4) {
                if (j + 1 < 9) {
                    mangToaDo[i][j + 1].setLaDiemGoiY(true);
                    if (mangToaDo[i][j + 1].getQuanCo() != null) {
                        if (mangToaDo[i][j + 1].getQuanCo().getPhe().equals(getPhe())) {
                            mangToaDo[i][j + 1].setLaDiemGoiY(false);
                        }
                    }
                }
                if (j - 1 >= 0) {
                    mangToaDo[i][j - 1].setLaDiemGoiY(true);
                    if (mangToaDo[i][j - 1].getQuanCo() != null) {
                        if (mangToaDo[i][j - 1].getQuanCo().getPhe().equals(getPhe())) {
                            mangToaDo[i][j - 1].setLaDiemGoiY(false);
                        }
                    }
                }
            }

        }
    }

    public QuanTot(Phe phe) {
        super(phe);
    }
}
