package com.example.assignmenttwo;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context mContext;
    controllerdb controllerdb;
    SQLiteDatabase db;
    private ArrayList <String> ID = new ArrayList<String>();
    private ArrayList <String> name = new ArrayList<String>();
    private ArrayList <String> StuID = new ArrayList<String>();
    private ArrayList <String> Grade = new ArrayList<String>();
    public  CustomAdapter (Context context , ArrayList<String>ID, ArrayList<String>name, ArrayList<String>StuID, ArrayList<String>Grade){
        this.mContext=context;
        this.ID=ID;
        this.name=name;
        this.StuID=StuID;
        this.Grade=Grade;
    }
    @Override
    public int getCount() {
        return ID.size();
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final viewHolder holder;
        controllerdb= new controllerdb(mContext);
        LayoutInflater layoutInflater;
        if (convertView ==null) {
            layoutInflater = (LayoutInflater) mContext.getSystemService (Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.layout,null);
            holder = new viewHolder();
            holder.id = (TextView) convertView.findViewById(R.id.idTV);
            holder.name = (TextView) convertView.findViewById(R.id.nameTV);
            holder.stuID = (TextView) convertView.findViewById(R.id.stuIDTV);
            holder.grade = (TextView) convertView.findViewById(R.id.GradeTV);
            convertView.setTag(holder);
        }
        else{
            holder = (viewHolder) convertView.getTag();
        }
        holder.id.setText(ID.get(position));
        holder.name.setText(name.get(position));
        holder.stuID.setText (StuID.get(position));
        holder.grade.setText (Grade.get(position));
        return convertView;
    }
    public class viewHolder {
        TextView id;
        TextView name;
        TextView stuID;
        TextView grade;
    }
}
