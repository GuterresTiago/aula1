package com.example.aula1.adaapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.aula1.Model.Commeents;
import com.example.aula1.R;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {
    private List<Commeents> commeent;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }
    public CommentsAdapter(List<Commeents> comes) {
        this.commeent = comes;
    }



    @NonNull
    @Override
    public CommentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comments_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsAdapter.ViewHolder holder, int position) {
        Commeents come = commeent.get(position);
        TextView tvs = holder.view.findViewById(R.id.tvCid);
        tvs.setText(come.getPost_id());
        tvs = holder.view.findViewById(R.id.tvCname);
        tvs.setText(come.getName());
        tvs = holder.view.findViewById(R.id.tvCbody);
        tvs.setText(come.getBody());


    }

    @Override
    public int getItemCount() {
        return commeent.size();
    }

}
