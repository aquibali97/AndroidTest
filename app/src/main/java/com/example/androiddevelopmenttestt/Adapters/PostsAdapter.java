package com.example.androiddevelopmenttestt.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddevelopmenttestt.R;

public class PostsAdapter extends RecyclerView.Adapter<TrendingAdapter.DataObjectHolder> {

    Context context;

    public PostsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public TrendingAdapter.DataObjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_posts_list, parent, false);
        TrendingAdapter.DataObjectHolder dataObjectHolder = new TrendingAdapter.DataObjectHolder(view);

        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingAdapter.DataObjectHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder{

        public DataObjectHolder(@NonNull View itemView) {
            super(itemView);
        }


    }



}
