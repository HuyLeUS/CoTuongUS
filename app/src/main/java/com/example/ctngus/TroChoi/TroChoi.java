package com.example.ctngus.TroChoi;

import com.example.ctngus.QuanCoTuong.Phe;

public class TroChoi {
     private Phe luot;
     private BanCo banCo;
     private NguoiChoi nguoiChoiDen = new NguoiChoi(Phe.PHE_DEN);
     private NguoiChoi nguoiChoiDo = new NguoiChoi(Phe.PHE_DO);
     private ToaDo toaDoDaChon = null;

     public void xuLySuKienTroChoi(ToaDo toaDo)
     {
          NguoiChoi nguoiDangChoi;
          if(luot.equals(nguoiChoiDen.getPhe()))
          {
               nguoiDangChoi = nguoiChoiDen;
          }
          else
          {
               nguoiDangChoi = nguoiChoiDo;
          }
          if(toaDoDaChon == null)
          {
               nguoiDangChoi.chonToaDo(banCo, toaDo);
          }
          else
          {
               nguoiDangChoi.danhCo(banCo, toaDoDaChon, toaDo);
               toaDoDaChon = null;
          }
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

     public void choiMoi()
     {
          banCo.xepCo();
     }
}
