package com.example.tableorder.Kitchen;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tableorder.AdminDB.OrderDBHelper;
import com.example.tableorder.FoodCatagory;
import com.example.tableorder.Orders;
import com.example.tableorder.R;
import com.example.tableorder.TableVerification;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class pendingFragment extends Fragment {
    OrderDBHelper orderDB;
    View view;
    ListView pendingLV;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_pending, container, false);
        pendingLV= (ListView) view.findViewById(R.id.pendingLV);

        orderDB = new OrderDBHelper(this.getActivity());
         List<Orders> allOrder = orderDB.getAllOrder();
        String str[] = new String[allOrder.size()];
        int j=0;
        if(allOrder.size()>0) {


            for (Orders order : allOrder) {
                str[j] = order.getName();
                j++;
            }

            ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, str);
            pendingLV.setAdapter(listViewAdapter);
            pendingLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getActivity(), OrderCompleteConfirmation.class);
                    //     Orders selectedItem = (Orders) parent.getItemAtPosition(position);
                    //     getActivity().startActivity(intent);
                    int k = 0;
                    for (Orders order : allOrder) {
                        if (k == position) {
                            intent.putExtra("name", order.getName());
                            intent.putExtra("floors", order.getFloor());
                            intent.putExtra("tables", order.getTable());
                            intent.putExtra("type", order.getType());
                            intent.putExtra("size", order.getSize());
                            getActivity().startActivity(intent);
                        }
                        k++;

                    }
                }
            });
        }
        else
        {
            Toast.makeText(getActivity(),"No pending Order",Toast.LENGTH_LONG).show();
        }
        return view;
    }
}