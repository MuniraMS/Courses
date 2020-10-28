package com.example.assignmenttwo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText edtUsername;
    EditText edtPassword;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = (Button) findViewById(R.id.button2);
        edtUsername = (EditText) findViewById(R.id.editText);
        edtPassword = (EditText) findViewById(R.id.editText2);
        databaseHelper = new DatabaseHelper(LoginActivity.this);
        btnLogin.setOnClickListener(new View.OnClickListener (){
        @Override
        public void onClick (View v) {
            boolean isExist = databaseHelper.checkUserExist(edtUsername.getText().toString(), edtPassword.getText().toString());
            if (isExist){
                Intent intent = new Intent (LoginActivity.this ,Lastactivity.class);
                intent.putExtra("username", edtUsername.getText().toString());
                startActivity(intent);
            }
            else {
                edtPassword.setText(null);
                edtUsername.setText(null);
                Toast.makeText(LoginActivity.this, "Login failed. Invalid username or password",Toast.LENGTH_SHORT).show();

            }
        }

        });
    }
}
