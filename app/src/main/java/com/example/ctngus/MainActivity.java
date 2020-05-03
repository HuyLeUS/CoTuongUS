package com.example.ctngus;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.ctngus.QuanCoTuong.QuanBo;
import com.example.ctngus.QuanCoTuong.QuanMa;
import com.example.ctngus.QuanCoTuong.QuanPhao;
import com.example.ctngus.QuanCoTuong.QuanSi;
import com.example.ctngus.QuanCoTuong.QuanTot;
import com.example.ctngus.QuanCoTuong.QuanTuong;
import com.example.ctngus.QuanCoTuong.QuanXe;

public class MainActivity extends AppCompatActivity {
    private  QuanCo mQuanXeDo1,mQuanXeDo2,mQuanMaDo1,mQuanMaDo2,mQuanBoDo1,mQuanBoDo2,mQuanSiDo1,mQuanSiDo2,mQuanTuongDo,
    mQuanTotDo1,mQuanTotDo2,mQuanTotDo3,mQuanTotDo4,mQuanTotDo5,mQuanPhaoDo1,mQuanPhaoDo2;
    private  QuanCo mQuanXeDen1,mQuanXeDen2,mQuanMaDen1,mQuanMaDen2,mQuanBoDen1,mQuanBoDen2,mQuanSiDen1,mQuanSiDen2,mQuanTuongDen,
            mQuanTotDen1,mQuanTotDen2,mQuanTotDen3,mQuanTotDen4,mQuanTotDen5,mQuanPhaoDen1,mQuanPhaoDen2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        KhoiTaoQuanCo();

    }
    public void KhoiTaoQuanCo()
    {
        mQuanXeDo1=new QuanXe(new ToaDo(0,0),1);
        mQuanXeDo2=new QuanXe(new ToaDo(8,0),1);
        mQuanMaDo1=new QuanMa(new ToaDo(1,0),1);
        mQuanMaDo2=new QuanMa(new ToaDo(7,0),1);
        mQuanBoDo1=new QuanBo(new ToaDo(2,0),1);
        mQuanBoDo2=new QuanBo(new ToaDo(6,0),1);
        mQuanSiDo1=new QuanSi(new ToaDo(3,0),1);
        mQuanSiDo1=new QuanSi(new ToaDo(5,0),1);
        mQuanTuongDo=new QuanTuong(new ToaDo(4,0),1);
        mQuanXeDen1=new QuanXe(new ToaDo(0,9),2);
        mQuanXeDen2=new QuanXe(new ToaDo(8,9),2);
        mQuanMaDen1=new QuanMa(new ToaDo(1,9),2);
        mQuanMaDen2=new QuanMa(new ToaDo(7,9),2);
        mQuanBoDen1=new QuanBo(new ToaDo(2,9),2);
        mQuanBoDen2=new QuanBo(new ToaDo(6,9),2);
        mQuanSiDen1=new QuanSi(new ToaDo(3,9),2);
        mQuanSiDen2=new QuanSi(new ToaDo(5,9),2);
        mQuanTuongDen=new QuanTuong(new ToaDo(4,9),2);
        mQuanTotDo1=new QuanTot(new ToaDo(0,3),1);
        mQuanTotDo2=new QuanTot(new ToaDo(2,3),1);
        mQuanTotDo3=new QuanTot(new ToaDo(4,3),1);
        mQuanTotDo4=new QuanTot(new ToaDo(6,3),1);
        mQuanTotDo5=new QuanTot(new ToaDo(8,3),1);
        mQuanTotDen1=new QuanTot(new ToaDo(0,6),2);
        mQuanTotDen2=new QuanTot(new ToaDo(2,6),2);
        mQuanTotDen3=new QuanTot(new ToaDo(4,6),2);
        mQuanTotDen4=new QuanTot(new ToaDo(6,6),2);
        mQuanTotDen5=new QuanTot(new ToaDo(8,6),2);
        mQuanPhaoDo1=new QuanPhao(new ToaDo(1,2),1);
        mQuanPhaoDo2=new QuanPhao(new ToaDo(7,2),1);
        mQuanPhaoDen1=new QuanPhao(new ToaDo(1,7),2);
        mQuanPhaoDen2=new QuanPhao(new ToaDo(7,7),2);
    }


}
