package com.example.ctngus.QuanCoTuong;


import com.example.ctngus.TroChoi.BanCo;
import com.example.ctngus.TroChoi.ToaDo;

import java.util.ArrayList;
import java.util.List;

public class QuanTuong extends QuanCo {


    @Override
    public List<ToaDo> duDoanNuocDi(BanCo banCo, ToaDo toaDo) {
        List<ToaDo> danhSachCacNuocDi = new ArrayList<>();
        int i = toaDo.getY();
        int j = toaDo.getX();
        ToaDo[][] mangToaDo = banCo.getMangToaDo();
        //Nằm ở bàn cờ dưới
        if (getPhe().equals(banCo.getPheDuoiBanCo())) {
            if (i + 2 < 10 && j + 2 < 9 && mangToaDo[i + 1][j + 1].getQuanCo() == null) {
                danhSachCacNuocDi.add(mangToaDo[i + 2][j + 2]);
            }
            if (i - 2 >= 5 && j + 2 < 9 && mangToaDo[i - 1][j + 1].getQuanCo() == null) {
                danhSachCacNuocDi.add(mangToaDo[i - 2][j + 2]);
            }
            if (i + 2 < 10 && j - 2 >= 0 && mangToaDo[i + 1][j - 1].getQuanCo() == null) {
                danhSachCacNuocDi.add(mangToaDo[i + 2][j - 2]);
            }
            if (i - 2 >= 5 && j - 2 >= 0 && mangToaDo[i - 1][j - 1].getQuanCo() == null) {
                danhSachCacNuocDi.add(mangToaDo[i - 2][j - 2]);
            }
            //Nằm ở bàn cờ trên
        } else {
            if (i + 2 < 5 && j + 2 < 9 && mangToaDo[i + 1][j + 1].getQuanCo() == null) {
                danhSachCacNuocDi.add(mangToaDo[i + 2][j + 2]);
            }
            if (i - 2 >= 0 && j + 2 < 9 && mangToaDo[i - 1][j + 1].getQuanCo() == null) {
                danhSachCacNuocDi.add(mangToaDo[i - 2][j + 2]);
            }
            if (i + 2 < 5 && j - 2 >= 0 && mangToaDo[i + 1][j - 1].getQuanCo() == null) {
                danhSachCacNuocDi.add(mangToaDo[i + 2][j - 2]);
            }
            if (i - 2 >= 0 && j - 2 >= 0 && mangToaDo[i - 1][j - 1].getQuanCo() == null) {
                danhSachCacNuocDi.add(mangToaDo[i - 2][j - 2]);
            }
        }
        return danhSachCacNuocDi;
    }

    public QuanTuong(Phe phe) {
        super(phe);
    }
}
