package com.example.ctngus.QuanCoTuong;

import com.example.ctngus.TroChoi.BanCo;
import com.example.ctngus.TroChoi.ToaDo;

import java.util.ArrayList;
import java.util.List;

public class QuanSi extends QuanCo {


    @Override
    public List<ToaDo> duDoanNuocDi(BanCo banCo, ToaDo toaDo) {
        List<ToaDo> danhSachCacNuocDi = new ArrayList<>();
        int i = toaDo.getY();
        int j = toaDo.getX();
        ToaDo[][] mangToaDo = banCo.getMangToaDo();
        //Nằm ở bàn cờ dưới
        if (getPhe().equals(banCo.getPheDuoiBanCo())) {
            if (i + 1 < 10 && j + 1 < 6) {
                danhSachCacNuocDi.add(mangToaDo[i + 1][j + 1]);
            }
            if (i - 1 >= 7 && j + 1 < 6) {
                danhSachCacNuocDi.add(mangToaDo[i - 1][j + 1]);
            }
            if (i + 1 < 10 && j - 1 >= 3) {
                danhSachCacNuocDi.add(mangToaDo[i + 1][j - 1]);
            }
            if (i - 1 >= 7 && j - 1 >= 3) {
                danhSachCacNuocDi.add(mangToaDo[i - 1][j - 1]);
            }
            //Nằm ở bàn cờ trên
        } else {
            if (i + 1 < 3 && j + 1 < 6) {
                danhSachCacNuocDi.add(mangToaDo[i + 1][j + 1]);
            }
            if (i - 1 >= 0 && j + 1 < 6) {
                danhSachCacNuocDi.add(mangToaDo[i - 1][j + 1]);
            }
            if (i + 1 < 3 && j - 1 >= 3) {
                danhSachCacNuocDi.add(mangToaDo[i + 1][j - 1]);
            }
            if (i - 1 >= 0 && j - 1 >= 3) {
                danhSachCacNuocDi.add(mangToaDo[i - 1][j - 1]);
            }
        }
        return danhSachCacNuocDi;
    }

    public QuanSi(Phe phe) {
        super(phe);
    }
}
