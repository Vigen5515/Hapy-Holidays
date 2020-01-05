package com.example.holideys.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.holideys.R;
import com.example.holideys.network.holidey.Holiday1;

import java.util.List;

public class HolideyAdapter extends RecyclerView.Adapter<HolideyAdapter.HoliderViewHolder> {

    private List<Holiday1> model;
    public HolideyAdapter(List<Holiday1> model) {
        this.model = model;
    }

    @NonNull
    @Override
    public HoliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_holi, parent, false);
        return new HoliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HoliderViewHolder holder, int position) {

        holder.edtNAme.setText(model.get(position).getName());
        holder.edtDate.setText(model.get(position).getDate().substring(5));
        holder.edtStart.setText(model.get(position).getWeekday().getDate().getName());



    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class HoliderViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView edtDate;
        private AppCompatTextView edtStart;
        private AppCompatTextView edtNAme;


        public HoliderViewHolder(@NonNull View itemView) {
            super(itemView);

            edtDate = itemView.findViewById(R.id.txt_data);
            edtStart = itemView.findViewById(R.id.txt_start);

            edtNAme = itemView.findViewById(R.id.txt_name);

        }
    }
}
