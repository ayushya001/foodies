package com.example.foodies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    EditText nw,cf;
    Button done;
    database db;
    forget_password fp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        nw = findViewById(R.id.nw);
        cf = findViewById(R.id.cf);
        done = findViewById(R.id.done);
        fp = new forget_password();
        db = new database(this);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pp1 = nw.getText().toString();
                String pp2 = cf.getText().toString();
                if (pp1.equals("")||pp2.equals("")){
                    Toast.makeText(MainActivity4.this, "Enter all fields", Toast.LENGTH_SHORT).show();
                }else{
                    if (pp1.equals(pp2)){
                        boolean checkUpdatePassword = db.updatepassword(pp1);
                        if (checkUpdatePassword == true){
                            Toast.makeText(MainActivity4.this, "Password upgated successfully!!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),MainActivity3.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivity4.this, "Password Not updated successfully!!", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(MainActivity4.this, "passwords doesn't match", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });


    }
}