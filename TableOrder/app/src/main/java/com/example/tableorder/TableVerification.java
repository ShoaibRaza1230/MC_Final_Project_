package com.example.tableorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tableorder.Adapter.Customer_OrderAdapter;
import com.example.tableorder.Adapter.Customer_TableDataAdapter;
import com.example.tableorder.AdminDB.TableDBHelper;

import java.util.List;

public class TableVerification extends AppCompatActivity {
    EditText code;
    Button enter, back;
    TableDBHelper tableDB;
    List<Tables> allTable;
    String codee;
    int flor,tble,cap,img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_verification);
        code=findViewById(R.id.tableCodeET);
        enter=findViewById(R.id.tableCodeEnterBtn);
        back=findViewById(R.id.tableCodeBackBtn);
        Intent intent = getIntent();
        tble = intent.getIntExtra("tables",0);
        flor = intent.getIntExtra("floors",0);
         cap = intent.getIntExtra("capacities",0);
         img = intent.getIntExtra("imageNames",0);
        codee=intent.getStringExtra("code");

        tableDB = new TableDBHelper(this);
        allTable = tableDB.getAllTable();

    }

    public void verifyCode(View view) {
        int j=0;
            for(int i=0;i<allTable.size();i++)
            {
                if(code.getText().toString().equals(codee) && flor==allTable.get(i).getFloorNo() && tble==allTable.get(i).getTableNo())
                {
                    Intent intent=new Intent(TableVerification.this, FoodCatagory.class);
                    intent.putExtra("imageNames",img);
                    intent.putExtra("floors",flor);
                    intent.putExtra("tables",tble);
                    intent.putExtra("capacities",cap);
                    intent.putExtra("code",codee);
                    j=1;
                    startActivity(intent);

                }
            }
            if(j==0)
            {
                Toast.makeText(this,"Not Matched",Toast.LENGTH_LONG).show();
            }
    }
    public void back(View view) {
        Intent intent=new Intent(TableVerification.this, MainActivity.class);
        startActivity(intent);
    }
}