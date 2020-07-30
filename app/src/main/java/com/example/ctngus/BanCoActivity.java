package com.example.ctngus;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

public class BanCoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DrawBoard drawBoard=new DrawBoard(this);
        drawBoard.setBackgroundColor(Color.WHITE);

        setContentView(drawBoard);

    }
}