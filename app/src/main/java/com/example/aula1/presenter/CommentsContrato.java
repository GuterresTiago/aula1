package com.example.aula1.presenter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public class CommentsContrato {   public interface view {
    public void preparaRecylerView(RecyclerView.Adapter adapter);
    public void limpaRecycler();
    public Context getContexto();
}
interface presenter {
    public void buscaJsonss();
}
}

