package com.example.ctngus.QuanCoTuong;


import com.example.ctngus.TroChoi.BanCo;
import com.example.ctngus.TroChoi.ToaDo;

public class QuanSoai extends QuanCo {


    @Override
    public void duDoanNuocDi(BanCo banCo, ToaDo toaDo) {
        int i = toaDo.getY();
        int j = toaDo.getX();
        ToaDo[][] mangToaDo = banCo.getMangToaDo();
        //Nằm ở bàn cờ dưới
        if (getPhe().equals(banCo.getPheDuoiBanCo())) {
            ToaDo toaDoQuanSoaiDich = banCo.getToaDoQuanSoai(Phe.values()[(getPhe().ordinal() + 1) % 2]);
            int jMatTuong = toaDoQuanSoaiDich.getX();
            int iGioiHan = 10;
            for(int k = toaDoQuanSoaiDich.getY() + 1; k < 10; k++)
            {
                if(mangToaDo[k][toaDoQuanSoaiDich.getX()].getQuanCo() != null)
                {
                    iGioiHan = k;
                    break;
                }
            }
            if (i + 1 < 10) {
                mangToaDo[i + 1][j].setLaDiemGoiY(true);
                if (mangToaDo[i + 1][j].getQuanCo() != null) {
                    if (mangToaDo[i + 1][j].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i + 1][j].setLaDiemGoiY(false);
                    }
                }
            }
            if (i - 1 >= 7) {
                mangToaDo[i - 1][j].setLaDiemGoiY(true);
                if (mangToaDo[i - 1][j].getQuanCo() != null) {
                    if (mangToaDo[i - 1][j].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i - 1][j].setLaDiemGoiY(false);
                    }
                }
            }
            if (j + 1 < 6 && (j + 1 != jMatTuong || i > iGioiHan)) {
                mangToaDo[i][j + 1].setLaDiemGoiY(true);
                if (mangToaDo[i][j + 1].getQuanCo() != null) {
                    if (mangToaDo[i][j + 1].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i][j + 1].setLaDiemGoiY(false);
                    }
                }
            }
            if (j - 1 >= 3 && (j - 1 != jMatTuong || i > iGioiHan)) {
                mangToaDo[i][j - 1].setLaDiemGoiY(true);
                if (mangToaDo[i][j - 1].getQuanCo() != null) {
                    if (mangToaDo[i][j - 1].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i][j - 1].setLaDiemGoiY(false);
                    }
                }
            }
            //Nằm ở bàn cờ trên
        } else {
            ToaDo toaDoQuanSoaiDich = banCo.getToaDoQuanSoai(Phe.values()[(getPhe().ordinal() + 1) % 2]);
            int jMatTuong = toaDoQuanSoaiDich.getX();
            int iGioiHan = -1;
            for(int k = toaDoQuanSoaiDich.getY() - 1; k >= 0; k--)
            {
                if(mangToaDo[k][toaDoQuanSoaiDich.getX()].getQuanCo() != null)
                {
                    iGioiHan = k;
                    break;
                }
            }
            if (i + 1 < 3) {
                mangToaDo[i + 1][j].setLaDiemGoiY(true);
                if (mangToaDo[i + 1][j].getQuanCo() != null) {
                    if (mangToaDo[i + 1][j].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i + 1][j].setLaDiemGoiY(false);
                    }
                }
            }
            if (i - 1 >= 0) {
                mangToaDo[i - 1][j].setLaDiemGoiY(true);
                if (mangToaDo[i - 1][j].getQuanCo() != null) {
                    if (mangToaDo[i - 1][j].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i - 1][j].setLaDiemGoiY(false);
                    }
                }
            }
            if (j + 1 < 6 && (j + 1 != jMatTuong || i < iGioiHan)) {
                mangToaDo[i][j + 1].setLaDiemGoiY(true);
                if (mangToaDo[i][j + 1].getQuanCo() != null) {
                    if (mangToaDo[i][j + 1].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i][j + 1].setLaDiemGoiY(false);
                    }
                }
            }
            if (j - 1 >= 3 && (j - 1 != jMatTuong || i < iGioiHan)) {
                mangToaDo[i][j - 1].setLaDiemGoiY(true);
                if (mangToaDo[i][j - 1].getQuanCo() != null) {
                    if (mangToaDo[i][j - 1].getQuanCo().getPhe().equals(getPhe())) {
                        mangToaDo[i][j - 1].setLaDiemGoiY(false);
                    }
                }
            }

        }
    }

    public QuanSoai(Phe phe) {
        super(phe);
    }
}
