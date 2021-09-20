package com.example.aula1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aula1.presenter.CommentsContrato;
import com.example.aula1.presenter.CommentsPresenter;
import com.example.aula1.presenter.TodoPresenter;
import com.example.aula1.presenter.TodoPresenterContrato;
//import com.example.aula1.presenter.UserPresenter;
import com.example.aula1.presenter.UserPresenter;
import com.example.aula1.presenter.UserPresenterContrato;

public class Tela_Botao extends AppCompatActivity implements TodoPresenterContrato.view, UserPresenterContrato.view {

    TodoPresenter presenter;
    UserPresenter presenter0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_botao);

        presenter = new TodoPresenter(this,"https://jsonplaceholder.typicode.com");
        presenter0 = new UserPresenter(this,"https://jsonplaceholder.typicode.com");



        Button todos= findViewById(R.id.Todos);
        todos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.buscaJsons();

            }
        });
        Button image= findViewById(R.id.Image);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Tela_images.class);
                startActivity(intent);
            }
        });
        Button user= findViewById(R.id.User);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter0.buscaJsonsUser();
            }
        });
    }
    public void preparaRecylerView(RecyclerView.Adapter adapter){
        RecyclerView rv = findViewById(R.id.recycleprincipal);
        LinearLayoutManager llm =  new LinearLayoutManager(getApplicationContext());
        LinearLayoutManager llm1 =  new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(7,StaggeredGridLayoutManager.HORIZONTAL);
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
    }

    @Override
    public void limpaRecycler() {
        RecyclerView rv = findViewById(R.id.recycleprincipal);
        rv.setAdapter(null);
    }

    @Override
    public Context getContexto() {
        return this.getApplicationContext();
    }


}