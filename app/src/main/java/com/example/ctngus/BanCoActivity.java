package com.example.ctngus;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

public class BanCoActivity extends AppCompatActivity {
    private BanCo banCo = new BanCo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        banCo.xepCo();
        DrawBoard drawBoard=new DrawBoard(this, banCo);
        drawBoard.setBackgroundColor(Color.WHITE);

        setContentView(drawBoard);

    }
}