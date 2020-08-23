package com.example.ctngus.QuanCoTuong;

import com.example.ctngus.TroChoi.BanCo;
import com.example.ctngus.TroChoi.ToaDo;

import java.util.ArrayList;
import java.util.List;

public class QuanXe extends QuanCo {


    @Override
    public List<ToaDo> duDoanNuocDi(BanCo banCo, ToaDo toaDo) {
        List<ToaDo> danhSachCacNuocDi = new ArrayList<>();
        ToaDo[][] mangToaDo = banCo.getMangToaDo();
        int i = toaDo.getY();
        int j = toaDo.getX();
        int di = 1;
        int dj = 1;
        while (i + di < 10) {
            ToaDo toaDoDangXet = mangToaDo[i + di][j];
            danhSachCacNuocDi.add(toaDoDangXet);
            if(toaDoDangXet.getQuanCo() != null)
            {
                break;
            }
            di++;

        }
        di = 1;
        while (i - di >= 0) {
            ToaDo toaDoDangXet = mangToaDo[i - di][j];
            danhSachCacNuocDi.add(toaDoDangXet);
            if(toaDoDangXet.getQuanCo() != null)
            {
                break;
            }
            di++;
        }
        while (j + dj < 9) {
            ToaDo toaDoDangXet = mangToaDo[i][j + dj];
            danhSachCacNuocDi.add(toaDoDangXet);
            if(toaDoDangXet.getQuanCo() != null)
            {
                break;
            }
            dj++;
        }
        dj = 1;
        while (j - dj >= 0) {
            ToaDo toaDoDangXet = mangToaDo[i][j - dj];
            danhSachCacNuocDi.add(toaDoDangXet);
            if(toaDoDangXet.getQuanCo() != null)
            {
                break;
            }
            dj++;
        }

        return danhSachCacNuocDi;
    }

    public QuanXe(Phe phe) {
        super(phe);
    }
}
