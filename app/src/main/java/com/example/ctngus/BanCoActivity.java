package com.example.ctngus;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.ctngus.TroChoi.VeTroChoi;
import com.example.ctngus.TroChoi.TroChoi;

public class BanCoActivity extends AppCompatActivity {
    private TroChoi troChoi = new TroChoi();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        troChoi.choiMoi();
        VeTroChoi drawBoard=new VeTroChoi(this, troChoi);
        drawBoard.setBackgroundColor(Color.WHITE);

        setContentView(drawBoard);

    }
}