package com.example.ctngus.TroChoi;

import android.util.Log;

import com.example.ctngus.QuanCoTuong.Phe;
import com.example.ctngus.QuanCoTuong.QuanCo;

public class TroChoi {
     private Phe luot;
     //Một lượt chơi gồm 3 giai đoạn:
     //1: Chọn quân cờ
     //2: đã chọn quân cờ
     //3: đánh cờ
     private GiaiDoan giaiDoan = GiaiDoan.CHON_QUAN_CO;
     private BanCo banCo;
     private NguoiChoi nguoiChoiDen = new NguoiChoi(Phe.PHE_DEN);
     private NguoiChoi nguoiChoiDo = new NguoiChoi(Phe.PHE_DO);
     private ToaDo toaDoDaChon = null;
     private CheDoChoi cheDoChoi = CheDoChoi.OFFLINE_HAI_NGUOI;
     private boolean dangDau = true;
     public void setGiaiDoan(GiaiDoan giaiDoan) {
          this.giaiDoan = giaiDoan;
     }



     public GiaiDoan getGiaiDoan() {
          return giaiDoan;
     }

     public Phe kiemTraPheThang()
     {
          if(banCo.biChieuBi(Phe.PHE_DEN))
          {
               dangDau = false;
               return Phe.PHE_DO;
          }
          if(banCo.biChieuBi(Phe.PHE_DO)) {
               dangDau = false;
               return Phe.PHE_DEN;
          }
          return null;
     }

     public void xuLySuKienTroChoi(ToaDo toaDo) {
          NguoiChoi nguoiDangChoi;
          //Tìm ra người đang chơi
          if (luot.equals(nguoiChoiDen.getPhe())) {
               nguoiDangChoi = nguoiChoiDen;
          } else {
               nguoiDangChoi = nguoiChoiDo;
          }
          //chưa chọn quân cờ
          if (giaiDoan.equals(GiaiDoan.CHON_QUAN_CO)) {
               //Thực hiện chọn tọa độ
               toaDoDaChon = nguoiDangChoi.chonToaDo(banCo, toaDo);
               if (toaDoDaChon != null) {
                    giaiDoan = GiaiDoan.DA_CHON_QUAN_CO;
               }
          } else {
               //Đã chọn quân

               if (giaiDoan.equals(GiaiDoan.DA_CHON_QUAN_CO)) {
                    QuanCo quanCo = toaDo.getQuanCo();
                    if (quanCo != null) {
                         if (quanCo.getPhe().equals(luot)) { // Đổi quân
                              toaDoDaChon = nguoiDangChoi.chonToaDo(banCo, toaDo);
                              return;
                         }
                    }
                    //Đánh cờ
                    boolean result = nguoiDangChoi.danhCo(banCo, toaDoDaChon, toaDo);
                    if (result) {
                         //Đánh thành công thì đổi lượt
                         toaDoDaChon = toaDo;
                         giaiDoan = GiaiDoan.DANH_CO;
                         luot = Phe.values()[(luot.ordinal() + 1) % 2];
                         Log.d("Chiếu", String.valueOf(banCo.biChieu(luot)));
                         Log.d("Chiếu bí", String.valueOf(banCo.biChieuBi(luot)));
                    }

               }


          }
     }

     public ToaDo getToaDoDaChon() {
          return toaDoDaChon;
     }

     public TroChoi(CheDoChoi cheDoChoi) {
          luot = Phe.PHE_DEN;
          banCo = new BanCo();
          this.cheDoChoi = cheDoChoi;
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

     public boolean isDangDau() {
          return dangDau;
     }
}
