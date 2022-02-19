package com.example.foodies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class forget_password extends AppCompatActivity {
    TextView ff2;
    EditText number;
    Button sumbit;
    database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        ff2 = findViewById(R.id.ff2);
        number = findViewById(R.id.ff1);
        sumbit = findViewById(R.id.button);
        db = new database(this);

        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String no= number.getText().toString();
                if (no.equals("")){
                    Toast.makeText(forget_password.this, "Enter mobile number", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkphone = db.checkphone(no);
                    if (checkphone==true){
                        Toast.makeText(forget_password.this, "you are verified", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity4.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(forget_password.this, "You are not registered", Toast.LENGTH_SHORT).show();
                        ff2.setText("Register now");
                    }
                }

            }
        });
        ff2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent df = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(df);
            }
        });
    }
}