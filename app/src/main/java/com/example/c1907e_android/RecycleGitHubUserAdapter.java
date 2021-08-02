package com.example.c1907e_android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c1907e_android.Models.UserGitHub;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class RecycleGitHubUserAdapter extends RecyclerView.Adapter<RecycleGitHubUserAdapter.ViewHolder> {
    private List<UserGitHub> userGitHubList;
    private Context context;


    public RecycleGitHubUserAdapter(List<UserGitHub> userGitHubList, Context context) {
        this.context = context;
        this.userGitHubList = userGitHubList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_github_user, parent, false);

        return new RecycleGitHubUserAdapter.ViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserGitHub userGitHub = userGitHubList.get(position);

        holder.login.setText(String.format("Username: %s", userGitHub.getLogin()));
        holder.type.setText(String.format("Type: %s", userGitHub.getType()));
        holder.id.setText(String.format("ID: %d", userGitHub.getId()));
        Picasso.get().load(userGitHub.getAvatar_url()).into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return userGitHubList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView login;
        TextView type;
        TextView id;
        ImageView avatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            login = itemView.findViewById(R.id.txtUsernameGithub);
            type = itemView.findViewById(R.id.txtTypeGithub);
            avatar = itemView.findViewById(R.id.imgAvatarGithub);
            id = itemView.findViewById(R.id.txtIdGitHub);
        }
    }
}
