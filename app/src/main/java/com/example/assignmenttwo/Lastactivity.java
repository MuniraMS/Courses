package com.example.assignmenttwo;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Lastactivity extends AppCompatActivity {
TextView hellouser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lastactivity);
        hellouser = (TextView) findViewById(R.id.hello);
        Bundle extras = getIntent().getExtras();
        String username=null;
        if (extras!=null){
            username=extras.getString("username");
            hellouser.setText("Welcome "+ username);

        }
        Button button2 = (Button) findViewById(R.id.button8);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                gotologinactivity();
            }
        });
        Button button3 = (Button) findViewById(R.id.button9);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                gotoStudentinfo();
            }
        });

    }
     private void gotologinactivity(){
        Intent intent = new Intent (this,LoginActivity.class);
        startActivity(intent);
    }
    private void gotoStudentinfo(){
        Intent intent = new Intent (this,StudentInfo.class);
        startActivity(intent);
    }
}
