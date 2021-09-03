package com.example.aula1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class Tela_inicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);




        Timer t = new Timer();
        TimerTask tt =new TimerTask(){
                                 @Override
                                 public void run() {
                                     Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                     startActivity(intent);

                                 }
                             };
        t.schedule(tt,5000);
    }


}