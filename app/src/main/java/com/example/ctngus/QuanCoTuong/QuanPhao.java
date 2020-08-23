package com.example.ctngus.QuanCoTuong;


import com.example.ctngus.TroChoi.BanCo;
import com.example.ctngus.TroChoi.ToaDo;

public class QuanPhao extends QuanCo {

    @Override
    public void duDoanNuocDi(BanCo banCo, ToaDo toaDo) {
        ToaDo[][] mangToaDo = banCo.getMangToaDo();
        int i = toaDo.getY();
        int j = toaDo.getX();
        int di = 1;
        int dj = 1;
        boolean coBiChan = false;
        while (i + di < 10) {
            ToaDo toaDoDangXet = mangToaDo[i + di][j];
            if (toaDoDangXet.getQuanCo() != null) {
                if(coBiChan)
                {
                    if (!getPhe().equals(toaDoDangXet.getQuanCo().getPhe())) {
                        toaDoDangXet.setLaDiemGoiY(true);
                    }
                    break;
                }
                else {
                    coBiChan = true;
                }
            } else {
                if(!coBiChan) {
                    toaDoDangXet.setLaDiemGoiY(true);
                }
            }
            di++;

        }
        di = 1;
        coBiChan = false;
        while (i - di >= 0) {
            ToaDo toaDoDangXet = mangToaDo[i - di][j];
            if (toaDoDangXet.getQuanCo() != null) {
                if(coBiChan)
                {
                    if (!getPhe().equals(toaDoDangXet.getQuanCo().getPhe())) {
                        toaDoDangXet.setLaDiemGoiY(true);
                    }
                    break;
                }
                else {
                    coBiChan = true;
                }
            } else {
                if(!coBiChan) {
                    toaDoDangXet.setLaDiemGoiY(true);
                }
            }
            di++;
        }
        coBiChan = false;
        while (j + dj < 9) {
            ToaDo toaDoDangXet = mangToaDo[i][j + dj];
            if (toaDoDangXet.getQuanCo() != null) {
                if(coBiChan)
                {
                    if (!getPhe().equals(toaDoDangXet.getQuanCo().getPhe())) {
                        toaDoDangXet.setLaDiemGoiY(true);
                    }
                    break;
                }
                else {
                    coBiChan = true;
                }
            } else {
                if(!coBiChan) {
                    toaDoDangXet.setLaDiemGoiY(true);
                }
            }
            dj++;
        }
        dj = 1;
        coBiChan = false;
        while (j - dj >= 0) {
            ToaDo toaDoDangXet = mangToaDo[i][j - dj];
            if (toaDoDangXet.getQuanCo() != null) {
                if(coBiChan)
                {
                    if (!getPhe().equals(toaDoDangXet.getQuanCo().getPhe())) {
                        toaDoDangXet.setLaDiemGoiY(true);
                    }
                    break;
                }
                else {
                    coBiChan = true;
                }
            } else {
                if(!coBiChan) {
                    toaDoDangXet.setLaDiemGoiY(true);
                }
            }
            dj++;
        }

    }

    public QuanPhao(Phe phe) {
        super(phe);
    }
}
