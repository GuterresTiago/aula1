package com.example.aula1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

public class Tela_users extends AppCompatActivity  implements Response.ErrorListener, Response.Listener<JSONArray> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_users);
        RequestQueue queue1 = Volley.newRequestQueue(this);


        JsonArrayRequest request1 =new JsonArrayRequest(Request.Method.GET,"https://jsonplaceholder.typicode.com/users",null,this,this);
        queue1.add(request1);
    }

    @Override
    public void onErrorResponse(VolleyError error) {


    }

    @Override
    public void onResponse(JSONArray response) {
        Toast.makeText(getApplicationContext(), "Deu Exito"+response.toString(), Toast.LENGTH_LONG).show();
        EditText edit =findViewById(R.id.UserText);
        edit.setText(response.toString());

    }
}