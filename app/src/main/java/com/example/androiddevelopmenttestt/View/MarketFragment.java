package com.example.androiddevelopmenttestt.View;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.androiddevelopmenttestt.Adapters.HotDealsAdapter;
import com.example.androiddevelopmenttestt.Adapters.PostsAdapter;
import com.example.androiddevelopmenttestt.Adapters.TrendingAdapter;
import com.example.androiddevelopmenttestt.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarketFragment extends Fragment {

    @BindView(R.id.trendingRecyclerView)
    RecyclerView trendingRecyclerView;

    @BindView(R.id.hotDealsRecyclerView)
    RecyclerView hotDealsRecyclerView;


    private int mCurCheckPosition;
    private Context context;
    private TrendingAdapter trendingAdapter;
    private HotDealsAdapter hotDealsAdapter;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_market, container, false);
        view = inflater.inflate(R.layout.fragment_market, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore last state for checked position.
            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if (!getUserVisibleHint()) {
            return;
        }


        init();
    }

    public void init(){

        context = getContext();

        LinearLayoutManager linearTrending = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        trendingRecyclerView.setLayoutManager(linearTrending);

        LinearLayoutManager linearHotDeals = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        hotDealsRecyclerView.setLayoutManager(linearHotDeals);

        setTredingAdapter();
        setHotDealsAdapter();

//        ((HomeActivity)getActivity()).updateStatusBarColor("#FFFFFFFF");

    }


    public void setTredingAdapter(){

        trendingAdapter = new TrendingAdapter(context);
        trendingRecyclerView.setAdapter(trendingAdapter);

    }

    public void setHotDealsAdapter(){

        hotDealsAdapter = new HotDealsAdapter(context);
        hotDealsRecyclerView.setAdapter(hotDealsAdapter);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", 0);
    }

}