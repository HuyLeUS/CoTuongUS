package com.example.ctngus.TroChoi;

import com.example.ctngus.QuanCoTuong.Phe;
import com.example.ctngus.QuanCoTuong.QuanCo;

public class TroChoi {
     private Phe luot;
     private GiaiDoan giaiDoan = GiaiDoan.CHON_QUAN_CO;
     private BanCo banCo;
     private NguoiChoi nguoiChoiDen = new NguoiChoi(Phe.PHE_DEN);
     private NguoiChoi nguoiChoiDo = new NguoiChoi(Phe.PHE_DO);
     private ToaDo toaDoDaChon = null;

     public void setGiaiDoan(GiaiDoan giaiDoan) {
          this.giaiDoan = giaiDoan;
     }

     public GiaiDoan getGiaiDoan() {
          return giaiDoan;
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
               if(toaDoDaChon != null)
               {
                    giaiDoan = GiaiDoan.DA_CHON_QUAN_CO;
               }
          } else {
               //Đã chọn quân

               if(giaiDoan.equals(GiaiDoan.DA_CHON_QUAN_CO)) {
                    QuanCo quanCo = toaDo.getQuanCo();
                    if(quanCo != null) {
                         if (quanCo.getPhe().equals(luot)) { // Đổi quân
                              toaDoDaChon = nguoiDangChoi.chonToaDo(banCo, toaDo);
                              return;
                         }
                    }
                    //Đánh cờ
                    boolean result = nguoiDangChoi.danhCo(banCo, toaDoDaChon, toaDo);
                    if(result) {
                         //Đánh thành công thì đổi lượt
                         toaDoDaChon = toaDo;
                         giaiDoan = GiaiDoan.DANH_CO;
                         luot = Phe.values()[(luot.ordinal() + 1) % 2];
                    }

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
