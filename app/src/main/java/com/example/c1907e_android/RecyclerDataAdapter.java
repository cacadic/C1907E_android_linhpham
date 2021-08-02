package com.example.c1907e_android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c1907e_android.Models.UserWithImage;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.ViewHolder> {
    private Context context;
    private List<UserWithImage> userWithImageList;

    public RecyclerDataAdapter(Context context, List<UserWithImage> userWithImageList) {
        this.userWithImageList = userWithImageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycle_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.append(userWithImageList.get(position).getUsername());
        new AsyncCheckImage(holder.imageView, context).execute(userWithImageList.get(position).getImgLink());
    }

    @Override
    public int getItemCount() {
        return userWithImageList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.txtNameRV);
            this.imageView = itemView.findViewById(R.id.imgAnhRV);
        }
    }
}
