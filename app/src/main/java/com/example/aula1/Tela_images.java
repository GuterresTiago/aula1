package com.example.aula1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.aula1.presenter.CommentsContrato;
import com.example.aula1.presenter.CommentsPresenter;

import org.json.JSONArray;

import java.io.InputStream;

public class Tela_images extends AppCompatActivity implements  CommentsContrato.view{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_images);

        CommentsPresenter presenter1;

        presenter1 = new CommentsPresenter(this,"https://jsonplaceholder.typicode.com");

        presenter1.buscaJsonss();

    }

    @Override
    public void preparaRecylerView(RecyclerView.Adapter adapter) {
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