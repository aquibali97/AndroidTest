package com.example.androiddevelopmenttestt.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddevelopmenttestt.R;

import java.util.List;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.DataObjectHolder> {


    Context context;

    public TrendingAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public TrendingAdapter.DataObjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_tranding_list, parent, false);
        TrendingAdapter.DataObjectHolder dataObjectHolder = new TrendingAdapter.DataObjectHolder(view);

        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingAdapter.DataObjectHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder{

        public DataObjectHolder(@NonNull View itemView) {
            super(itemView);
        }


    }


}
