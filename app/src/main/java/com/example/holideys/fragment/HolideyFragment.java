package com.example.holideys.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.holideys.MainActivity;
import com.example.holideys.R;
import com.example.holideys.adapter.HolideyAdapter;
import com.example.holideys.network.API;
import com.example.holideys.network.Constance;
import com.example.holideys.network.HolideyClient;
import com.example.holideys.network.holidey.Holiday1;
import com.example.holideys.network.holidey.HolyBaseResponce;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HolideyFragment extends Fragment {

    private RecyclerView recyclerView;
    private HolideyAdapter adapter;
    private List<Holiday1> models = new ArrayList<>();

    public static final String KEY = "text";
    public static final String KEY1 = "text1";
    public static final String KEY2= "text2";
    public static final String KEY3 = "text3";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_holidey, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        getData();
    }

    private void initView(View view){
        recyclerView =view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
    }

    private void getData(){
        String textFromActivity = getArguments().getString(KEY);
        String textFromActivity1 = getArguments().getString(KEY1);
        String textFromActivity2 = getArguments().getString(KEY2);
        String textFromActivity3 = getArguments().getString(KEY3);
        API api = HolideyClient.getInstance().create(API.class);
        Call<HolyBaseResponce> call = api.getHolidey(Constance.HOLY_KEY,textFromActivity ,"2019", textFromActivity2 + "",textFromActivity3 + "");

        call.enqueue(new Callback<HolyBaseResponce> () {
            @Override
            public void onResponse(Call<HolyBaseResponce>  call, Response<HolyBaseResponce>  response) {
                Log.d("TESTING","ok"+response.message());
                models.addAll(response.body().getHolidays());
                adapter = new HolideyAdapter(models);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<HolyBaseResponce>  call, Throwable t) {
                Log.d("TESTING","fail"+t.getMessage());
            }
        });
    }
}
