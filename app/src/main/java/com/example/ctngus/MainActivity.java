package com.example.ctngus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ctngus.TroChoi.CheDoChoi;

public class MainActivity extends AppCompatActivity {

     private Button btnStart;


     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);



          btnStart = (Button) findViewById(R.id.btnHaiNguoi);

     }


     public void batDauChoiCheDoHaiNguoi(View view) {

          Intent intent = new Intent(this, BanCoActivity.class);
          intent.putExtra("che_do", CheDoChoi.OFFLINE_HAI_NGUOI);
          startActivity(intent);

     }
}
