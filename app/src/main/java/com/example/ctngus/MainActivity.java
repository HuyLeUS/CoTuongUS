package com.example.ctngus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

     private Button btnStart;


     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);



          btnStart = (Button) findViewById(R.id.btnStart);

     }


     public void batDau(View view) {

          Intent intent = new Intent(this, BanCoActivity.class);
          startActivity(intent);

     }
}
