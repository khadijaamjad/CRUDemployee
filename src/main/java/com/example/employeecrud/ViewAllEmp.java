package com.example.employeecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewAllEmp extends AppCompatActivity {
    ListView listEmp;
    EmployeeArrayAdapter adapter;
    int selectedEmpID=-1;
    Employee e;  //to store the object of clicked/selected employee
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_emp);

        listEmp = findViewById(R.id.lstEmp);
        adapter = new EmployeeArrayAdapter(this, R.layout.list_item_layout, MainActivity.employees);
        listEmp.setAdapter(adapter);

        listEmp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                e = adapter.getItem(position);
                selectedEmpID = e.getID();
            }
        });
    }

    public void btnUpdClick(View view) {
        if(selectedEmpID!=-1){
            Intent i=new Intent(this,UpdateEmp.class);
            i.putExtra("empl",e);
            startActivity(i);
        }
        else
            Toast.makeText(this, "Please select an employee first", Toast.LENGTH_SHORT).show();

    }

    public void bbtnDelClick(View view) {
        if(selectedEmpID!=-1){
            boolean removed=MainActivity.employees.remove(e);
            if(removed)
            {
                Toast.makeText(this,"Employee removed",Toast.LENGTH_LONG).show();
                Intent i = new Intent(ViewAllEmp.this, ViewAllEmp.class);
                finish();
                overridePendingTransition(0, 0);
                startActivity(i);
                overridePendingTransition(0, 0);
            }
            else
            {
                Toast.makeText(this,"Error occured",Toast.LENGTH_LONG).show();
            }
        }
        else
            Toast.makeText(this, "Please select an employee first", Toast.LENGTH_SHORT).show();

    }

    public void btnViewClick(View view) {
        if(selectedEmpID!=-1){
        Intent i=new Intent(this,ViewEmp.class);
        i.putExtra("empl",e);
        startActivity(i);
    }
        else
            Toast.makeText(this, "Please select an employee first", Toast.LENGTH_SHORT).show();

    }
}
