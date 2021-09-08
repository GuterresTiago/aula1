package com.example.aula1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class Tela_todos extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONArray> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_selecao);

        RequestQueue queue = Volley.newRequestQueue(this);


        JsonArrayRequest request =new JsonArrayRequest(Request.Method.GET,"https://jsonplaceholder.typicode.com/todos",null,this,this);
        queue.add(request);
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(), "Deu Error"+error.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONArray response) {
        Toast.makeText(getApplicationContext(), "Deu Exito"+response.toString(), Toast.LENGTH_LONG).show();
        EditText edit =findViewById(R.id.Resultado);

        edit.setText(response.toString());


    }


}