package com.example.aula1;

import androidx.appcompat.app.AppCompatActivity;

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

import org.json.JSONArray;

import java.io.InputStream;

public class Tela_images extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONArray> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_images);

        RequestQueue queue1 = Volley.newRequestQueue(this);


        JsonArrayRequest request1 =new JsonArrayRequest(Request.Method.GET,"https://jsonplaceholder.typicode.com/photos",null,this,this);
        queue1.add(request1);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(), "Deu Error"+error.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONArray response) {
        //Toast.makeText(getApplicationContext(), "Deu Exito"+response.toString(), Toast.LENGTH_LONG).show();
        //edit =findViewById(R.id.Resultado);
        //edit.setText(response.toString());



       /* public static Drawable LoadImageFromWebOperations(String url) {
            try {
                InputStream is = (InputStream) new URL(url).getContent();
                Drawable d = Drawable.createFromStream(is, "src name");
                return d;
            } catch (Exception e) {
                return null;
            }
        }*/

    }
}