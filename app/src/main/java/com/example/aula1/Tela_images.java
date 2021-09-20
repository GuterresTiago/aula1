package com.example.aula1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.aula1.presenter.CommentsPresenterContrato;
import com.example.aula1.presenter.CommentsPresenter;

public class Tela_images extends AppCompatActivity implements  CommentsPresenterContrato.view{

    CommentsPresenter presenter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_images);



        presenter1 = new CommentsPresenter(this,"https://jsonplaceholder.typicode.com");

        presenter1.buscaJsonss();

    }

    @Override
    public void preparaRecylerView(RecyclerView.Adapter adapter) {
        RecyclerView rv = findViewById(R.id.rvTest);
        LinearLayoutManager llm =  new LinearLayoutManager(getApplicationContext());
       // StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(7,StaggeredGridLayoutManager.HORIZONTAL);
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
    }

    @Override
    public void limpaRecycler() {
        RecyclerView rv = findViewById(R.id.rvTest);
        rv.setAdapter(null);
    }

    @Override
    public Context getContexto() {
        return this.getApplicationContext();
    }
}