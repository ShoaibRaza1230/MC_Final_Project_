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
import com.example.tableorder.Orders;
import com.example.tableorder.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class completeFragment extends Fragment {
    OrderDBHelper orderDB;
    View view;
    ListView completeLV;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_complete, container, false);
       completeLV= (ListView) view.findViewById(R.id.completeLV);

        orderDB = new OrderDBHelper(this.getActivity());
        List<Orders> allOrder = orderDB.getAllCompletedOrder();
        String str[] = new String[allOrder.size()];
        int j=0;
        if(allOrder.size()>0) {

            for (Orders order : allOrder) {
                str[j] = order.getName();
                j++;
            }
            ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, str);
            completeLV.setAdapter(listViewAdapter);
        }
        else
        {
            Toast.makeText(getActivity(),"No Completed Order",Toast.LENGTH_LONG).show();
        }
       return view;
    }
}