package com.android.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class singupactivity extends AppCompatActivity {
    private Button btn,btn2;
    private EditText uname,mail,pass;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singupactivity);
        btn = findViewById(R.id.singup);
        btn2 = (Button) findViewById(R.id.back);
        uname = findViewById(R.id.uname);
        mail = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        db = new DBHelper(this);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                    if (uname.getText().toString().equals("")|| mail.getText().toString().equals("") || pass.getText().toString().equals("")){
//                        Toast.makeText(singupactivity.this, "Try Again", Toast.LENGTH_SHORT).show();
//                    }
//                    else{
//                    Toast.makeText(singupactivity.this, "Sing up completed", Toast.LENGTH_SHORT).show();
//                    Intent intent1 = new Intent(singupactivity.this,LogingActivity.class);
//                    startActivity(intent1);}
//
//
//
//
//            }
//        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(singupactivity.this,LogingActivity.class);
                startActivity(intent2);

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = uname.getText().toString();
                String email = mail.getText().toString();
                String password = pass.getText().toString();
                if(username.equals("")||email.equals("")||password.equals(""))
                    Toast.makeText(singupactivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else {
                    boolean checkUser = db.checkUser(email);
                     if(checkUser==false){
                         boolean insert = db.insertData(username,password,email);
                         if(insert==true){
                             Toast.makeText(singupactivity.this, "Sing up Successful", Toast.LENGTH_SHORT).show();
                             Intent intent1 = new Intent(singupactivity.this,LogingActivity.class);
                             startActivity(intent1);
                         }else {
                             Toast.makeText(singupactivity.this, "Failed! Try again", Toast.LENGTH_SHORT).show();
                         }
                     }else {
                         Toast.makeText(singupactivity.this, "Already exist", Toast.LENGTH_SHORT).show();
                     }
                }
            }
        });
    }
}