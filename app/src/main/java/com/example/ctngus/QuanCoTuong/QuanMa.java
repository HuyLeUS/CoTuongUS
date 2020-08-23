package com.example.ctngus.QuanCoTuong;


import com.example.ctngus.TroChoi.BanCo;
import com.example.ctngus.TroChoi.ToaDo;

public class QuanMa extends QuanCo {

     @Override
     public void duDoanNuocDi(BanCo banCo, ToaDo toaDo) {
          int i = toaDo.getY();
          int j = toaDo.getX();
          ToaDo[][] mangToaDo = banCo.getMangToaDo();
          if(i - 2 >= 0)
          {
               if(mangToaDo[i - 1][j].getQuanCo() == null)
               {
                    if(j - 1 >= 0) {
                         goiY(mangToaDo[i - 2][j - 1]);
                    }
                    if(j + 1 < 9)
                    {
                         goiY(mangToaDo[i - 2][j + 1]);
                    }
               }
          }
          if(i + 2 < 10)
          {
               if(mangToaDo[i + 1][j].getQuanCo() == null)
               {
                    if(j - 1 >= 0) {
                         goiY(mangToaDo[i + 2][j - 1]);
                    }
                    if(j + 1 < 9)
                    {
                         goiY(mangToaDo[i + 2][j + 1]);
                    }
               }
          }
          if(j + 2 < 9)
          {
               if(mangToaDo[i][j + 1].getQuanCo() == null)
               {
                    if(i - 1 >= 0) {
                         goiY(mangToaDo[i - 1][j + 2]);
                    }
                    if(i + 1 < 10)
                    {
                         goiY(mangToaDo[i + 1][j + 2]);
                    }
               }
          }
          if(j - 2 >= 0) {
               if (mangToaDo[i][j - 1].getQuanCo() == null) {
                    if (i - 1 >= 0) {
                         goiY(mangToaDo[i - 1][j - 2]);
                    }
                    if (i + 1 < 10) {
                         goiY(mangToaDo[i + 1][j - 2]);
                    }
               }
          }
     }
     private void goiY(ToaDo toaDo)
     {
          if(toaDo.getQuanCo() != null) {
               if (!getPhe().equals(toaDo.getQuanCo().getPhe())) {
                    toaDo.setLaDiemGoiY(true);
               }
          }
          else
          {
               toaDo.setLaDiemGoiY(true);
          }
     }
     public QuanMa(Phe phe) {
          super(phe);
     }
}
