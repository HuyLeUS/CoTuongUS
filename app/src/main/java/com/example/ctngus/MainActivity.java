package com.example.ctngus;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.ctngus.QuanCoTuong.QuanSoai;
import com.example.ctngus.QuanCoTuong.QuanCo;
import com.example.ctngus.QuanCoTuong.QuanMa;
import com.example.ctngus.QuanCoTuong.QuanPhao;
import com.example.ctngus.QuanCoTuong.QuanSi;
import com.example.ctngus.QuanCoTuong.QuanTot;
import com.example.ctngus.QuanCoTuong.QuanTuong;
import com.example.ctngus.QuanCoTuong.QuanXe;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BanCo banCo = new BanCo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



}
