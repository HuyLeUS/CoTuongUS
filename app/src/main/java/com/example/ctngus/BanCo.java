package com.example.ctngus;

import android.opengl.Matrix;

import com.example.ctngus.QuanCoTuong.Phe;
import com.example.ctngus.QuanCoTuong.QuanCo;
import com.example.ctngus.QuanCoTuong.QuanMa;
import com.example.ctngus.QuanCoTuong.QuanPhao;
import com.example.ctngus.QuanCoTuong.QuanSi;
import com.example.ctngus.QuanCoTuong.QuanSoai;
import com.example.ctngus.QuanCoTuong.QuanTot;
import com.example.ctngus.QuanCoTuong.QuanTuong;
import com.example.ctngus.QuanCoTuong.QuanXe;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BanCo {
    private QuanCo quanXeDo1, quanXeDo2, quanMaDo1, quanMaDo2, quanTuongDo1, quanTuongDo2, quanSiDo1, quanSiDo2, quanSoaiDo,
            quanTotDo1, quanTotDo2, quanTotDo3, quanTotDo4, quanTotDo5, quanPhaoDo1, quanPhaoDo2;
    private QuanCo quanXeDen1, quanXeDen2, quanMaDen1, quanMaDen2, quanTuongDen1, quanTuongDen2, quanSiDen1, quanSiDen2, quanSoaiDen,
            quanTotDen1, quanTotDen2, quanTotDen3, quanTotDen4, quanTotDen5, quanPhaoDen1, quanPhaoDen2;
    private OCo[][] mangOCo = new OCo[10][9];

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
                mangOCo[i][j] = new OCo(new ToaDo(i, j), null);
            }
        }
    }

    public void xepCo() {
        mangOCo[0][0].setQuanCo(quanXeDen1);
        mangOCo[0][1].setQuanCo(quanMaDen1);
        mangOCo[0][2].setQuanCo(quanTuongDen1);
        mangOCo[0][3].setQuanCo(quanSiDen1);
        mangOCo[0][4].setQuanCo(quanSoaiDen);
        mangOCo[0][5].setQuanCo(quanSiDen2);
        mangOCo[0][6].setQuanCo(quanTuongDen2);
        mangOCo[0][7].setQuanCo(quanMaDen2);
        mangOCo[0][8].setQuanCo(quanXeDen2);
        mangOCo[2][1].setQuanCo(quanPhaoDen1);
        mangOCo[2][7].setQuanCo(quanPhaoDen1);
        mangOCo[3][0].setQuanCo(quanTotDen1);
        mangOCo[3][2].setQuanCo(quanTotDen2);
        mangOCo[3][4].setQuanCo(quanTotDen3);
        mangOCo[3][6].setQuanCo(quanTotDen4);
        mangOCo[3][8].setQuanCo(quanTotDen5);

        mangOCo[9][0].setQuanCo(quanXeDo1);
        mangOCo[9][1].setQuanCo(quanMaDo1);
        mangOCo[9][2].setQuanCo(quanTuongDo1);
        mangOCo[9][3].setQuanCo(quanSiDo1);
        mangOCo[9][4].setQuanCo(quanSoaiDo);
        mangOCo[9][5].setQuanCo(quanSiDo2);
        mangOCo[9][6].setQuanCo(quanTuongDo2);
        mangOCo[9][7].setQuanCo(quanMaDo2);
        mangOCo[9][8].setQuanCo(quanXeDo2);
        mangOCo[7][1].setQuanCo(quanPhaoDo1);
        mangOCo[7][7].setQuanCo(quanPhaoDo1);
        mangOCo[6][0].setQuanCo(quanTotDo1);
        mangOCo[6][2].setQuanCo(quanTotDo2);
        mangOCo[6][4].setQuanCo(quanTotDo3);
        mangOCo[6][6].setQuanCo(quanTotDo4);
        mangOCo[6][8].setQuanCo(quanTotDo5);
    }
}