package com.example.androiddevelopmenttestt.View;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androiddevelopmenttestt.Adapters.HotDealsAdapter;
import com.example.androiddevelopmenttestt.Adapters.PostsAdapter;
import com.example.androiddevelopmenttestt.Adapters.SliderAdapter;
import com.example.androiddevelopmenttestt.Adapters.TrendingAdapter;
import com.example.androiddevelopmenttestt.R;
import com.google.android.material.tabs.TabLayout;

import java.nio.file.attribute.PosixFileAttributes;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileFragment extends Fragment {


    private RecyclerView postRecyclerView;
    private ViewPager viewPager;
    private TabLayout indicator;
    private RelativeLayout photosLayout;

    private int mCurCheckPosition;
    private View view;
    private Button btnPosts,btnPhotos;
    private PostsAdapter postsAdapter;
    private TextView txtLogout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_profile, container, false);

        view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);
        btnPosts = view.findViewById(R.id.btnPosts);
        btnPhotos = view.findViewById(R.id.btnPhotos);
        viewPager = view.findViewById(R.id.viewPager);
        indicator = view.findViewById(R.id.indicator);
        postRecyclerView = view.findViewById(R.id.postRecyclerView);
        photosLayout = view.findViewById(R.id.layoutPhotos);
        txtLogout = view.findViewById(R.id.txtLogout);

        btnPosts.setBackgroundColor(getResources().getColor(R.color.white));

        txtLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(),"Working",Toast.LENGTH_SHORT).show();

                SharedPreferences settings = getActivity().getSharedPreferences("Development_test", Context.MODE_PRIVATE);
                settings.edit().clear().apply();

                Intent intent = new Intent(getActivity(), SignUpActivity.class);
                getActivity().finishAffinity(); // Clears the stack !
                getActivity().startActivity(intent);

            }
        });

        btnPhotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(),"Working",Toast.LENGTH_SHORT).show();


                btnPhotos.setTranslationZ(1);
                btnPhotos.setTextColor(getResources().getColor(R.color.colorPrimary));
                btnPhotos.setBackgroundColor(getResources().getColor(R.color.white));

                btnPosts.setTextColor(getResources().getColor(R.color.gray));
                btnPosts.setBackgroundColor(getResources().getColor(R.color.lightGray));

                postRecyclerView.setVisibility(View.GONE);
                photosLayout.setVisibility(View.VISIBLE);
            }
        });

        btnPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(),"Working",Toast.LENGTH_SHORT).show();

                postRecyclerView.setVisibility(View.VISIBLE);
                photosLayout.setVisibility(View.GONE);

                btnPosts.setTextColor(getResources().getColor(R.color.colorPrimary));
                btnPosts.setBackgroundColor(getResources().getColor(R.color.white));

                btnPhotos.setTextColor(getResources().getColor(R.color.gray));
                btnPhotos.setBackgroundColor(getResources().getColor(R.color.lightGray));

            }
        });

        init();

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
//        ((HomeActivity)getActivity()).updateStatusBarColor("#069C6D");

        init();
    }

    public void init(){

        LinearLayoutManager linearPosts = new LinearLayoutManager(getContext());
        postRecyclerView.setLayoutManager(linearPosts);

        setPosts();
        setPhotos();
    }


    public void setPhotos(){

        viewPager.setAdapter(new SliderAdapter(getContext()));
        indicator.setupWithViewPager(viewPager, true);
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new SliderTimer(), 500, 6000);

    }

    public void setPosts(){

        postsAdapter = new PostsAdapter(getContext());
        postRecyclerView.setAdapter(postsAdapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", 0);
    }


    private class SliderTimer extends TimerTask {
        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() < 3) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }

}