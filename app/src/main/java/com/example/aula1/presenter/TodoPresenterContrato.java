package com.example.aula1.presenter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public interface TodoPresenterContrato {
    interface view {
        public void preparaRecylerView(RecyclerView.Adapter adapter);
        public void limpaRecycler();
        public Context getContexto();
    }
    interface presenter {
        public void buscaJsons();
    }
}
