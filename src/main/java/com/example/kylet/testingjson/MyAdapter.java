package com.example.kylet.testingjson;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Lab> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView lab_name, available_machines, total_machines;

        public MyViewHolder(View view){
            super(view);
            lab_name = (TextView) view.findViewById(R.id.lab_name);
            available_machines = (TextView) view.findViewById(R.id.available_machines);
            total_machines = (TextView) view.findViewById(R.id.total_machines);
        }
    }

    public MyAdapter(List<Lab> labs){
        this.mDataset = labs;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view, parent, false);
        MyViewHolder vh = new MyViewHolder(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Lab lab = mDataset.get(i);
        myViewHolder.lab_name.setText(lab.getLab_name());
        myViewHolder.available_machines.setText(String.valueOf(lab.getAvailable_machines()));
        myViewHolder.total_machines.setText(String.valueOf(lab.getTotal_machines()));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
