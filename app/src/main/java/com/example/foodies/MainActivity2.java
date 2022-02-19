package com.example.foodies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText mobile,pass;
    TextView forget;
    Button done;
    database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mobile = findViewById(R.id.rephone);
        pass = findViewById(R.id.repass);
        done = findViewById(R.id.button2);
        forget = findViewById(R.id.forget);
        Log.d("ayush", "onCreate: yaha tkk horha hai");
        db= new database(this);
        // sp= new signup(this);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("ayush", "onClick: aagya yaha tkk");
                String no = mobile.getText().toString();
                String password = pass.getText().toString();

                if (no.equals("") || password.equals("")) {
                    Toast.makeText(com.example.foodies.MainActivity2.this, "Enter all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkphonepass = db.checkpassword(no, password);
                    if (checkphonepass == true) {
                        Toast.makeText(com.example.foodies.MainActivity2.this, "WELCOME", Toast.LENGTH_SHORT).show();
                        Intent home = new Intent(getApplicationContext(),MainActivity3.class);
                        startActivity(home);
                    } else {
                        Toast.makeText(com.example.foodies.MainActivity2.this, "phone and password doesn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),forget_password.class);
                startActivity(intent);
            }
        });



    }
}
