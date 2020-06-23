package com.example.employeecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ViewEmp extends AppCompatActivity {
    Employee employee;
    TextView eAge,eName,eSalary,eMarried;
    EditText eID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_emp);
        eID=findViewById(R.id.empID);
        eAge=findViewById(R.id.txtAge);
        eSalary=findViewById(R.id.txtSalary);
        eName=findViewById(R.id.txtName);
        eMarried=findViewById(R.id.txtMarried);
    }

    public void displayEmployeeData(View view) {
        int employeeID=Integer.parseInt(eID.getText().toString());
        for(Employee e :MainActivity.employees)
        {
            if(e.getID()==employeeID)
            {
                employee=e;
            }
        }
        if(employee!=null){
            eAge.setText(""+employee.getAge());
            eName.setText(employee.getName());
            eSalary.setText(""+employee.getSalary());
            if(employee.isMarried()){
                eMarried.setText("Married");
            }
            else if(!employee.isMarried()){
                eMarried.setText("Unmarried");
            }
        }
        else{
            Toast.makeText(this,"Employee not found",Toast.LENGTH_LONG).show();
        }
    }
}
