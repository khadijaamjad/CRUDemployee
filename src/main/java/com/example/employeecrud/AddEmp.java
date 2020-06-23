package com.example.employeecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddEmp extends AppCompatActivity {
    int empID, age; String name; float salary; boolean married;
    EditText eID,eAge,eName,eSalary;
    RadioGroup rgMarried;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_emp);

        eID=findViewById(R.id.empID);
        eAge=findViewById(R.id.empAge);
        eName=findViewById(R.id.empName);
        eSalary=findViewById(R.id.empSalary);
        rgMarried=findViewById(R.id.marriedOpt);
    }

    public void btnAddClicked(View view) {
        int m=rgMarried.getCheckedRadioButtonId();
        if(m==R.id.rbNo){
            married=false;
        }
        if(m==R.id.rbYes){
            married=true;
        }
        empID=Integer.parseInt(eID.getText().toString());
        age=Integer.parseInt(eAge.getText().toString());
        name=eName.getText().toString();
        salary=Float.parseFloat(eSalary.getText().toString());
        Employee employee=new Employee(empID,age,name,salary,married);
        for(Employee emp :MainActivity.employees){
            if(emp.matches(employee))
            {
                Toast.makeText(this,"Employee ID exists",Toast.LENGTH_LONG).show();
                return;
            }
        }
        boolean added=MainActivity.employees.add(employee);
        if(added)
        {
            Toast.makeText(this,"Employee added",Toast.LENGTH_LONG).show();
            eID.setText("");
            eAge.setText("");
            eName.setText("");
            eSalary.setText("");
            rgMarried.clearCheck();
        }
        else
        {
            Toast.makeText(this,"Employee could not be added",Toast.LENGTH_LONG).show();
        }
    }
}
