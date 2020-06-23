package com.example.employeecrud;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EmployeeArrayAdapter extends ArrayAdapter<Employee> {
    Context con;
    int res;
    ArrayList<Employee> employees;
    LayoutInflater layoutInflater;
    public EmployeeArrayAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Employee> objects) {
        super(context, resource, objects);
        con=context;
        res=resource;
        employees=objects;
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView=layoutInflater.inflate(R.layout.list_item_layout,parent,false);
        TextView eName=(TextView)convertView.findViewById(R.id.txtName);
        TextView eID=(TextView)convertView.findViewById(R.id.txtID);
        Employee emp=employees.get(position);
        eName.setText(emp.getName());
        eID.setText(Integer.toString(emp.getID()));
        return convertView;
    }
}
