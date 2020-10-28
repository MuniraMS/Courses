package com.example.assignmenttwo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
            gotologinactivity();
            }

        });
    }
    private void gotologinactivity(){
        Intent intent = new Intent (this,LoginActivity.class);
        startActivity(intent);
    }
}
