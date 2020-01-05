package com.example.holideys.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import com.example.holideys.R;


public class HomeFragment extends Fragment {
    private AppCompatEditText countryName;
    private AppCompatTextView countryDate;
    private Spinner countrymounth;
    private Spinner countryDay;
    private AppCompatButton btnSave;
    private OnFragment1DataListener mListener;
    private String country = "";
    private String mounth = "";
    private String day = "";
    private String year = "";





    public interface OnFragment1DataListener {

        void onOpenFragment2(String string, String year,String mounth,String day);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            if (context instanceof OnFragment1DataListener) {
                mListener = (OnFragment1DataListener) context;
            }else {
                throw new RuntimeException(context.toString());
            }
        }catch (ClassCastException e){
            e.printStackTrace();
        }}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        spinner();
        btnSave();
    }

    private void initView(View view){
        countryName = view.findViewById(R.id.country_name);
        countryDate = view.findViewById(R.id.test_id);
        countryDay = view.findViewById(R.id.country_day);
        btnSave = view.findViewById(R.id.btn_save);
        countrymounth = view.findViewById(R.id.country_mount);
    }

    private void btnSave(){
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (countryName.getText().length() == 0){
                    countryName.setError("Please enter Country code");

                }else {
                country = countryName.getText().toString();
                year = countryDate.getText().toString();
                if (countryDay.getSelectedItem().toString().equals("set day")) {
                    day = "";

                }
                else {
                    day = countryDay.getSelectedItem().toString();
                }
                if (countrymounth.getSelectedItem().toString().equals("set mounth")){
                    mounth = "";
                }else {

                    mounth = countrymounth.getSelectedItem().toString();
                }
                    if (countryDay.getSelectedItem().toString()!= "set day" && countrymounth.getSelectedItem().toString().equals("set mounth")){
                        day = "";
                    }
                mListener.onOpenFragment2(country,year,mounth,day);
                }

            }
        });
    }

    private void spinner(){
        String[] mount1 = {"set mounth","01","02","03","04","05","06","07","08","09","10","11","12"};
        String[] day1 = {"set day","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19"
                ,"20","21","22","23","24","24","26","27","28","29","30","31"
        };
        ArrayAdapter<String> adapterMounth = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,mount1);
        ArrayAdapter<String> adapterDay = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,day1);
        adapterMounth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrymounth.setAdapter(adapterMounth);
        countryDay.setAdapter(adapterDay);

    }


}
