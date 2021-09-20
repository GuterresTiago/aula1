package com.example.aula1.presenter;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.aula1.Model.Commeents;
import com.example.aula1.Model.User;
import com.example.aula1.adaapter.CommentsAdapter;
import com.example.aula1.adaapter.TodoAdapter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class CommentsPresenter implements CommentsContrato.presenter, Response.ErrorListener {
    private List<Commeents> come=new ArrayList<>();
    private CommentsContrato.view activity;
    private int adp = 1;
    private String urlBase;

    public CommentsPresenter(CommentsContrato.view act, String urlBase) {
        this.activity = act;
        this.urlBase = urlBase;
    }

    @Override
    public void buscaJsonss() {
        RequestQueue queue = Volley.newRequestQueue(activity.getContexto());

        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET,
                urlBase + "/comments", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        onResponseComments(response);
                    }
                }, this);
        queue.add(requisicao);
    }

    public void onResponseComments(JSONArray response) {
        come.clear();
        try {

            for (int x = 0; x <30; x++) {
                for (int i = 0; i < response.length(); i++) {
                    come.add(new Commeents(response.getJSONObject(i)));
                }
            }
            RecyclerView.Adapter adapter;
            if (adp == 1) {
                adapter = new CommentsAdapter(come);
                adp = 2;
            }else {
                adapter = new CommentsAdapter(come);
                adp = 1;
            }

            activity.preparaRecylerView(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void onResponsePosts(JSONArray response) {
        come.clear();
        try {


                for (int i = 0; i < response.length(); i++) {
                    come.add(new Commeents(response.getJSONObject(i)));
                }
            RecyclerView.Adapter adapter;
            if (adp == 1) {
                adapter = new CommentsAdapter(come);
                adp = 2;
            }else {
                adapter = new CommentsAdapter(come);
                adp = 1;
            }
            activity.preparaRecylerView(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void onErrorResponse(VolleyError error) {
        //EditText ed = findViewById(R.id.resultado);
    }
}
