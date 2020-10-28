package com.example.assignmenttwo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.content.Intent;

public class StudentInfo extends AppCompatActivity implements View.OnClickListener {
    controllerdb db= new controllerdb (this);
    SQLiteDatabase database;
    EditText name,stuid,grade;
    Button submit,show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        name = (EditText) findViewById(R.id.stuname);
        stuid = (EditText) findViewById(R.id.stuID);
        grade = (EditText) findViewById(R.id.stuGrade);
        submit = (Button) findViewById(R.id.button3);
        show = (Button) findViewById(R.id.button4);
        submit.setOnClickListener(this);
        show.setOnClickListener(this);
    }
    @Override
    public void onClick (View v) {
      if (v.getId()==R.id.button3){
          database=db.getWritableDatabase();
          database.execSQL("INSERT INTO studentInfo (Name,StuID,Grade) VALUES('"+name.getText()+"','"+stuid.getText()+"','"+grade.getText()+"')");
          Toast.makeText(this,"Data has been store into database",Toast.LENGTH_LONG).show();
          name.setText(null);
          stuid.setText(null);
          grade.setText(null);
      }
      else
      if (v.getId()==R.id.button4){

       Intent intent = new Intent (this, showstudentinfo.class );
        startActivity(intent);


      }
    }
}
