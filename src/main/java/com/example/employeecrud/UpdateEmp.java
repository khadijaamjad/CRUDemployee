package com.example.employeecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class UpdateEmp extends AppCompatActivity {
    int empID, age; String name; float salary; boolean married;
    EditText eID,eAge,eName,eSalary;
    RadioGroup rgMarried;
    RadioButton rbYes,rbNo;
    Employee employee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_emp);

        eID=findViewById(R.id.empID);
        eAge=findViewById(R.id.empAge);
        eName=findViewById(R.id.empName);
        eSalary=findViewById(R.id.empSalary);
        rgMarried=findViewById(R.id.marriedOpt);
        rbYes=findViewById(R.id.rbYes);
        rbNo=findViewById(R.id.rbNo);
        Intent i=getIntent();
        employee= (Employee)i.getSerializableExtra("empl");
        displayEmployeeData(employee);
    }
    public void displayEmployeeData(Employee employee){
        eID.setText(""+employee.getID());
        eAge.setText(""+employee.getAge());
        eName.setText(employee.getName());
        eSalary.setText(""+employee.getSalary());
        if(employee.isMarried()){
            rbYes.setChecked(true);
        }
        else if(!employee.isMarried()){
            rbNo.setChecked(true);
        }
        eID.setEnabled(false);
    }

    public void UpdateEmployee(View view) {
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
        for(Employee e: MainActivity.employees){
            if(e!=null && empID==e.getID()){
                e.setAge(age);
                e.setMarried(married);
                e.setName(name);
                e.setSalary(salary);
                Toast.makeText(this,"Updation successful", Toast.LENGTH_LONG).show();
                break;
            }
        }
    }
}
