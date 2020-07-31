package com.example.ctngus.TroChoi;

import com.example.ctngus.QuanCoTuong.Phe;
import com.example.ctngus.QuanCoTuong.QuanCo;

public class NguoiChoi {
     private Phe phe;

     public NguoiChoi(Phe phe) {
          this.phe = phe;
     }

     public Phe getPhe() {
          return phe;
     }

     public ToaDo chonToaDo(BanCo banCo, ToaDo toaDo)
     {
          QuanCo quanCo = toaDo.getQuanCo();
          if(quanCo != null)
          {
               if(quanCo.getPhe().equals(this.phe))
               {
                    //Chọn đúng quân mình
                    banCo.hienThiDiemGoiY(toaDo);
                    return toaDo;
               }
          }
          return null;
     }
     //Người chơi đánh cờ
     //Kết quả trả về true nếu đánh được false nếu ko đánh được
     public boolean danhCo(BanCo banCo, ToaDo toaDoDaChon, ToaDo toaDoDen)
     {
          return banCo.thucHienDanhCo(toaDoDaChon, toaDoDen);
     }
}
