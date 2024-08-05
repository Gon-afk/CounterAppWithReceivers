package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerView_Adapter.MyViewHolder>
        {
            Context context;
            ArrayList<DisplayRyclerView> DisplayRyclerView;
            public RecyclerView_Adapter(Context context, ArrayList<DisplayRyclerView> DisplayRyclerView) {
                this.context = context;
                this.DisplayRyclerView = DisplayRyclerView;
            }

            @NonNull
            @Override
            public RecyclerView_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                // inflating the layout
                LayoutInflater inflater = LayoutInflater.from(context);
                View view = inflater.inflate(R.layout.activity_second2, parent, false);
                return new RecyclerView_Adapter.MyViewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView_Adapter.MyViewHolder holder, int position) {
                // assign values to the screen
                holder.textView1.setText(DisplayRyclerView.get(position).getDisplayRyclerView());
            }

            @Override
            public int getItemCount() {
                return DisplayRyclerView.size();
            }
            public static class MyViewHolder extends  RecyclerView.ViewHolder{
                TextView textView1;
                //grab the views from the layout file
                public MyViewHolder(@NonNull View itemView) {
                    super(itemView);
                    textView1 = itemView.findViewById(R.id.textView3);
                }
            }
        }
