package com.example.tableorder.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tableorder.Orders;
import com.example.tableorder.Products;
import com.example.tableorder.R;
import com.example.tableorder.Tables;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Customer_OrderAdapter extends RecyclerView.Adapter<Customer_OrderAdapter.ExampleViewHolder> {
        private List<Products> productsList;
        Context context;
        int table, floor;
        String category;
   // Customer_OrderAdapter(allProducts,getApplicationContext(),tble,flor,food);
        public Customer_OrderAdapter(List<Products> exampleList, Context contex,int tble,int flor,String foodCategoryo){
            productsList=exampleList;
            this.context=context;
            this.floor=flor;
            this.table=tble;
            this.category=foodCategoryo;
        }
        @NonNull
        @Override
        public Customer_OrderAdapter.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_order_resource,parent,false);
            Customer_OrderAdapter.ExampleViewHolder evh=new Customer_OrderAdapter.ExampleViewHolder(v);
            return evh;

        }

        @Override
        public void onBindViewHolder(@NonNull Customer_OrderAdapter.ExampleViewHolder holder, int position) {
            Products currentProduct=productsList.get(position);

          //  holder.imageeView.setImageResource(currentTable.getImage());
            holder.name.setText(currentProduct.getName());
            holder.price.setText(String.valueOf(currentProduct.getPrice()));
            holder.discount.setText(String.valueOf(currentProduct.getDiscount()));
            holder.size.setText(currentProduct.getSize());
            List<Orders> myList = new ArrayList<>();
           // holder.size.setOnClickListener();

            {
              //  (String name, int price, String type, int table, int floor, int status,String size)
            //    Orders newProduct = new Orders(floor, table, Category, typ, holder.price.getText(), false, siz);


                     //   myList.add(newProduct);
            }

          //  return myList;






        }

        @Override
        public int getItemCount() {
            return productsList.size();
        }

        public static class ExampleViewHolder extends RecyclerView.ViewHolder {
            public ImageView imageeView;
            public TextView name;
            public TextView price;
            public TextView discount;
            public TextView size;

            public ExampleViewHolder(@NonNull View itemView) {
                super(itemView);
                name=itemView.findViewById(R.id.productName);
                price=itemView.findViewById(R.id.price);
                discount=itemView.findViewById(R.id.discount);
                size=itemView.findViewById(R.id.productSizee);
              //  floorView=itemView.findViewById(R.id.FloorNo);
            }
        }
    }

