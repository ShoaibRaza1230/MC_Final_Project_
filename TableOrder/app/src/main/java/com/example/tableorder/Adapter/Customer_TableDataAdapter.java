package com.example.tableorder.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tableorder.FoodCatagory;
import com.example.tableorder.R;
import com.example.tableorder.TableVerification;
import com.example.tableorder.Tables;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Customer_TableDataAdapter extends RecyclerView.Adapter<Customer_TableDataAdapter.ExampleViewHolder> {
    private List<Tables> tableList;
    Context context;
    public Customer_TableDataAdapter(List<Tables> exampleList, Context context){
        tableList=exampleList;
        this.context=context;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_table_resource,parent,false);
        ExampleViewHolder evh=new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {

        Tables currentTable=tableList.get(position);

        holder.imageeView.setImageResource(currentTable.getImage());
        holder.tableView.setText(String.valueOf(currentTable.getTableNo()));
        holder.capacityView.setText(String.valueOf(currentTable.getCapacity()));
        holder.floorView.setText(String.valueOf(currentTable.getFloorNo()));
        holder.imageeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, TableVerification.class);
                intent.putExtra("imageNames",currentTable.getImage());
                intent.putExtra("floors",currentTable.getFloorNo());
                intent.putExtra("tables",currentTable.getTableNo());
                intent.putExtra("capacities",currentTable.getCapacity());
                intent.putExtra("code",currentTable.getTableCode());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tableList.size();
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageeView;
        public TextView floorView;
        public TextView tableView;
        public TextView capacityView;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageeView=itemView.findViewById(R.id.Table);
            tableView=itemView.findViewById(R.id.TableNo);
            capacityView=itemView.findViewById(R.id.Capacity);
            floorView=itemView.findViewById(R.id.FloorNo);
        }
    }
}
