package com.example.holideys.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;

import com.example.holideys.R;
import com.google.android.material.navigation.NavigationView;

public class Fragment_navigation_view extends Fragment implements View.OnClickListener {

    private HomeCallBack callback;
    private NavigationView navigationView;

    private LinearLayoutCompat newyear;
    private LinearLayoutCompat holi;
    private LinearLayoutCompat hanami;
    private LinearLayoutCompat internet;
    private LinearLayoutCompat harvey;
    private LinearLayoutCompat friday;
    public static final String NEW_YEAR_TYPE = "chempions";
    public static final String HOLI_TYPE = "holi";
    public static final String Hanami_TYPE = "hanami";
    public static final String INTERNET_EDAY_TYPE = "internet";
    public static final String HARVEY_DAY_TYPE = "harvey";
    public static final String BLACK_FRIDAY_TYPE = "friday";



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback=(HomeCallBack) context;
        }catch (ClassCastException e){
            e.printStackTrace();
        }}



    public interface HomeCallBack{
        void sendType(String type);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_navigation_view, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view){
        newyear = view.findViewById(R.id.New_year_navi_view);
        newyear.setOnClickListener(this);
        navigationView = view.findViewById(R.id.navigation_view);
        holi = view.findViewById(R.id.holi_view);
        holi.setOnClickListener(this);
        hanami = view.findViewById(R.id.hanami_view);
        internet = view.findViewById(R.id.internet_day_view);
        internet.setOnClickListener(this);
       harvey = view.findViewById(R.id.Harvey_Ball_view);
       friday = view.findViewById(R.id.Black_Friday_view);
        harvey.setOnClickListener(this);
        friday.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.New_year_navi_view:
                callback.sendType(NEW_YEAR_TYPE);
                break;
            case R.id.holi_view:
                callback.sendType(HOLI_TYPE);
                break;
            case R.id.hanami_view:
                callback.sendType(Hanami_TYPE);
                break;
            case R.id.internet_day_view:
                callback.sendType(INTERNET_EDAY_TYPE);
                break;
            case R.id.Harvey_Ball_view:
                callback.sendType(HARVEY_DAY_TYPE);
                break;
            case R.id.Black_Friday_view:
                callback.sendType(BLACK_FRIDAY_TYPE);
                break;



        }

    }
}
