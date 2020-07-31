package com.example.ctngus.TroChoi;

import com.example.ctngus.QuanCoTuong.Phe;
import com.example.ctngus.QuanCoTuong.QuanCo;

public class TroChoi {
     private Phe luot;
     private BanCo banCo;
     private NguoiChoi nguoiChoiDen = new NguoiChoi(Phe.PHE_DEN);
     private NguoiChoi nguoiChoiDo = new NguoiChoi(Phe.PHE_DO);
     private ToaDo toaDoDaChon = null;

     public void xuLySuKienTroChoi(ToaDo toaDo) {
          NguoiChoi nguoiDangChoi;
          if (luot.equals(nguoiChoiDen.getPhe())) {
               nguoiDangChoi = nguoiChoiDen;
          } else {
               nguoiDangChoi = nguoiChoiDo;
          }
          if (toaDoDaChon == null) {
               toaDoDaChon = nguoiDangChoi.chonToaDo(banCo, toaDo);
          } else {
               QuanCo quanCo = toaDo.getQuanCo();
               if(quanCo != null) {
                    if (quanCo.getPhe().equals(luot)) {
                         toaDoDaChon = nguoiDangChoi.chonToaDo(banCo, toaDo);
                         return;
                    }
               }
               boolean result = nguoiDangChoi.danhCo(banCo, toaDoDaChon, toaDo);
               toaDoDaChon = null;
               if(result) {
                    luot = Phe.values()[(luot.ordinal() + 1) % 2];
               }
          }
     }

     public ToaDo getToaDoDaChon() {
          return toaDoDaChon;
     }

     public TroChoi() {
          luot = Phe.PHE_DEN;
          banCo = new BanCo();
     }

     public TroChoi(Phe luot, BanCo banCo) {
          this.luot = luot;
          this.banCo = banCo;
     }

     public BanCo getBanCo() {
          return banCo;
     }

     public void choiMoi() {
          banCo.xepCo();
     }
}
