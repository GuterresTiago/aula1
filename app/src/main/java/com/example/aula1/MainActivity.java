package com.example.aula1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button botao= findViewById(R.id.btnHello);
        Button botaoCa= findViewById(R.id.btnCadas);
        botaoCa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Tela_cadastro.class);
                startActivity(intent);
            }
        });
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                view.setVisibility(view.INVISIBLE);
                EditText edit = findViewById(R.id.ETextNome);
                TextView tv= findViewById(R.id.textView);
                tv.setText("programa em producao Sem saida hauhuah");
            }
        });
    }
}