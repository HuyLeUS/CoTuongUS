package com.example.ctngus;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.ctngus.TroChoi.CheDoChoi;
import com.example.ctngus.TroChoi.VeTroChoi;
import com.example.ctngus.TroChoi.TroChoi;

public class BanCoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CheDoChoi cheDoChoi = (CheDoChoi) getIntent().getSerializableExtra("che_do");
        TroChoi troChoi = new TroChoi(cheDoChoi);
        troChoi.choiMoi();
        VeTroChoi drawBoard=new VeTroChoi(this, troChoi);
        drawBoard.setBackgroundColor(Color.WHITE);

        setContentView(drawBoard);

    }
}