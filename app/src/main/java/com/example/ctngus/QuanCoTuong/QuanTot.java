package com.example.ctngus.QuanCoTuong;


import com.example.ctngus.TroChoi.BanCo;
import com.example.ctngus.TroChoi.ToaDo;

import java.util.ArrayList;
import java.util.List;

public class QuanTot extends QuanCo {


    @Override
    public List<ToaDo> duDoanNuocDi(BanCo banCo, ToaDo toaDo) {
        List<ToaDo> danhSachCacNuocDi = new ArrayList<>();
        int i = toaDo.getY();
        int j = toaDo.getX();
        ToaDo[][] mangToaDo = banCo.getMangToaDo();
        if (getPhe().equals(banCo.getPheDuoiBanCo())) {
            if (i - 1 >= 0) {
                danhSachCacNuocDi.add(mangToaDo[i - 1][j]);
            }
            if (i < 5) {
                if (j + 1 < 9) {
                    danhSachCacNuocDi.add(mangToaDo[i][j + 1]);
                }
                if (j - 1 >= 0) {
                    danhSachCacNuocDi.add(mangToaDo[i][j - 1]);
                }
            }
        } else {
            if (i + 1 < 10) {
                danhSachCacNuocDi.add(mangToaDo[i + 1][j]);
            }
            if (i > 4) {
                if (j + 1 < 9) {
                    danhSachCacNuocDi.add(mangToaDo[i][j + 1]);
                }
                if (j - 1 >= 0) {
                    danhSachCacNuocDi.add(mangToaDo[i][j - 1]);
                }
            }

        }
        return danhSachCacNuocDi;
    }

    public QuanTot(Phe phe) {
        super(phe);
    }
}
