package com.example.foodies;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText phone, password, repass;
    Button insert, ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        database g = new database(this);
        SQLiteDatabase db = g.getReadableDatabase();
        insert = findViewById(R.id.signup);
        ok = findViewById(R.id.signin);
        phone = findViewById(R.id.et);
        password = findViewById(R.id.p1);
        repass = findViewById(R.id.re);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone1 = phone.getText().toString();
                String password1 = password.getText().toString();
                String repassword1 = repass.getText().toString();
                if (phone1.equals("") || password1.equals("") || repassword1.equals(""))
                    Toast.makeText(MainActivity.this, "Enters all the field", Toast.LENGTH_SHORT).show();
                else {
                    if (password1.equals(repassword1)) {
                        Boolean i = g.insert_data(phone1, password1);
                        if (i == true) {
                            Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                             Intent intent = new Intent(getApplicationContext(),MainActivity3.class);
                             startActivity(intent);
                            Toast.makeText(MainActivity.this, "WELCOME", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "FAIL", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "password and re-enter password not match", Toast.LENGTH_SHORT).show();
                    }
                }
                phone.setText("");
                password.setText("");
                repass.setText("");
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}
