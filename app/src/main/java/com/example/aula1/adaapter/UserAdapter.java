package com.example.aula1.adaapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula1.Model.Todo;
import com.example.aula1.Model.User;
import com.example.aula1.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> users;

    public UserAdapter(List<User> users)
    {
        this.users=users;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }
    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        User user = users.get(position);
        TextView tv = holder.view.findViewById(R.id.tvNameuser);
        tv.setText(user.getName());
        tv = holder.view.findViewById(R.id.tvIDuser);
        tv.setText(""+user.getId());
        tv = holder.view.findViewById(R.id.tvUsername);
        tv.setText(user.getUsername());
        tv = holder.view.findViewById(R.id.tvEmail);
        tv.setText(user.getEmail());


    }

    @Override
    public int getItemCount() {
        return users.size();
    }
    }

