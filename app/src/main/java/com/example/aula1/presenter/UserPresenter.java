package com.example.aula1.presenter;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.aula1.Model.Todo;
import com.example.aula1.Model.User;
import com.example.aula1.Tela_Botao;
import com.example.aula1.adaapter.UserAdapter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class UserPresenter implements UserPresenterContrato.presenter,
        Response.ErrorListener{

    private List<User> users = new ArrayList<>();
    private UserPresenterContrato.view activity;
    private int adp = 1;
    private String urlBase;

    public UserPresenter(UserPresenterContrato.view act, String urBase) {
        this.activity = act;
        this.urlBase = urBase;
    }
    public void buscaJsonsUser() {
        RequestQueue queue = Volley.newRequestQueue(activity.getContexto());

        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET,
                urlBase+"/users", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        onResponseTodo(response);
                    }
                }, this);
        queue.add(requisicao);
    }

    public void onResponseTodo(JSONArray response) {
        //ScrollView sv = findViewById(R.id.scroll);
        //LinearLayout ll = findViewById(R.id.leiauteVertical);
        users.clear();

        try {
            for (int x = 0; x <30; x++) {
                for (int i = 0; i < response.length(); i++) {
                    users.add(new User(response.getJSONObject(i)));
                }
            }
            RecyclerView.Adapter adapter;
            adapter = new UserAdapter(users);
            if (adp == 1) {
                adapter = new UserAdapter(users);
                adp = 2;
            }else {
                adapter = new UserAdapter(users);
                adp = 1;
            }

            activity.preparaRecylerView(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public void onResponsePosts(JSONArray response) {
        users.clear();

        try {
           // for (int x = 0; x <30; x++) {
                for (int i = 0; i < response.length(); i++) {
                    users.add(new User(response.getJSONObject(i)));
                }
           // }
            RecyclerView.Adapter adapter;
            adapter = new UserAdapter(users);
            if (adp == 1) {
                adapter = new UserAdapter(users);
                adp = 2;
            }else {
                adapter = new UserAdapter(users);
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
        //ed.setText(error.getMessage());

    }


    }
