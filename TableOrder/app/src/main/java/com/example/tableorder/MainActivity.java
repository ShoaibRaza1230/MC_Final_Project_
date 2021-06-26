package com.example.tableorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tableorder.Adapter.Customer_TableDataAdapter;
import com.example.tableorder.AdminDB.TableDBHelper;
import com.example.tableorder.Customer.customer_order;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
     TableDBHelper tableDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_table_view);
        mRecyclerView=findViewById(R.id.recclerView);
        
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);

        tableDB = new TableDBHelper(this);
        List<Tables> allTable = tableDB.getAllTable();
        if (allTable.size() > 0) {
            mRecyclerView.setVisibility(View.VISIBLE);
           // ContactAdapter mAdapter = new ContactAdapter(this, allContacts);
            mAdapter=new Customer_TableDataAdapter(allTable,getApplicationContext());
            mRecyclerView.setAdapter(mAdapter);
        }
        else {
            mRecyclerView.setVisibility(View.GONE);
            Toast.makeText(this, "There is no Table in the database. Start adding now", Toast.LENGTH_LONG).show();
        }


    }

    public void cancel(View view) {
        Intent intent=new Intent(MainActivity.this, Welcome.class);
        startActivity(intent);
    }

    public void takeAway(View view) {
        //todo:adding takeaway options
    }
}