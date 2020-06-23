package com.example.employeecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
String myFile;
public static ArrayList<Employee> employees=new ArrayList<Employee>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myFile=getFilesDir().getPath()+"/"+"myEFile.dat";
        ReadFromFile();
    }

    public void btnAddClick(View view) {
        Intent i=new Intent(this,AddEmp.class);
        startActivity(i);
    }

    public void btnFindClick(View view) {
        Intent i=new Intent(this,ViewEmp.class);
        startActivity(i);
    }

    public void btnViewAllClick(View view) {
        Intent j=new Intent(this,ViewAllEmp.class);
        startActivity(j);
    }

    @Override
    protected void onStop() {
        super.onStop();
        WriteToFile();
    }

    public void ReadFromFile(){
        try{
            FileInputStream fis=new FileInputStream(myFile);
            ObjectInputStream ois=new ObjectInputStream(fis);
            employees=(ArrayList<Employee>)ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this,"Exception occurred in reading file",Toast.LENGTH_LONG).show();
        }
    }
    public void WriteToFile(){
        try{
            FileOutputStream fos=new FileOutputStream(myFile,false);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
           oos.writeObject(employees);
            oos.close();
            fos.close();
        }
        catch(Exception e){
            e.printStackTrace();
            Toast.makeText(this,"Exception occurred in writing file",Toast.LENGTH_LONG).show();
        }
    }
}
