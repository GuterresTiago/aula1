package com.example.aula1.adaapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula1.Model.Todo;
import com.example.aula1.R;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    private List<Todo> dados;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public TodoAdapter(List<Todo>todos)
    {
        this.dados=todos;
    }

    @NonNull
    @Override
    public TodoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoAdapter.ViewHolder holder, int position) {
        Todo todo = dados.get(position);
        TextView tv = holder.view.findViewById(R.id.tvTodoTitulo);
        tv.setText(todo.getTitle());
        tv = holder.view.findViewById(R.id.tvTodoUser);
        tv.setText(""+todo.getUser_id());
        Switch sw = holder.view.findViewById(R.id.swTodo);
        sw.setChecked(todo.isCompleted());

    }

    @Override
    public int getItemCount() {
        return dados.size();
    }
}
