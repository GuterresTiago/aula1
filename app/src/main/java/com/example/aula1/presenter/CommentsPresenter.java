package com.example.aula1.presenter;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.aula1.Model.Commeents;
import com.example.aula1.adaapter.CommentsAdapter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class CommentsPresenter implements CommentsPresenterContrato.presenter, Response.ErrorListener {
    private List<Commeents> commeents =new ArrayList<>();
    private CommentsPresenterContrato.view activity;
    private String urlBase;

    public CommentsPresenter(CommentsPresenterContrato.view act, String urlBase) {
        this.activity = act;
        this.urlBase = urlBase;
    }

    public void onResponseTodo(JSONArray response) {
        commeents.clear();
        try {

            for (int i = 0; i < response.length(); i++) {
                    commeents.add(new Commeents(response.getJSONObject(i)));
                }

            RecyclerView.Adapter adapter;

                adapter = new CommentsAdapter(commeents);

            activity.preparaRecylerView(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void onResponsePosts(JSONArray response) {
        commeents.clear();
        try {

                for (int i = 0; i < response.length(); i++) {
                    commeents.add(new Commeents(response.getJSONObject(i)));
                }
            RecyclerView.Adapter adapter;

                adapter = new CommentsAdapter(commeents);

            activity.preparaRecylerView(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void onErrorResponse(VolleyError error) {
        //EditText ed = findViewById(R.id.resultado);
    }

    @Override
    public void buscaJsonss() {
        RequestQueue queue = Volley.newRequestQueue(activity.getContexto());

        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET,
                urlBase + "/comments", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        onResponseTodo(response);
                    }
                }, this);
        queue.add(requisicao);

    }
}
