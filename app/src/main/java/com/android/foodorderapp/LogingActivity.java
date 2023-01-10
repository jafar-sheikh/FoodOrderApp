package com.android.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LogingActivity extends AppCompatActivity {
    private Button btn,btn2;
    private EditText uname,pass;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loging);
        btn = (Button) findViewById(R.id.loginbutton);
        btn2 = (Button) findViewById(R.id.singup);
        uname = (EditText) findViewById(R.id.uname);
        pass = (EditText) findViewById(R.id.password);
        db = new DBHelper(this);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            login();
//
//            }
//        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(LogingActivity.this,singupactivity.class);
                startActivity(intent2);

            }
        });

//    }
//
//    public  void  login(){
//        String user = uname.getText().toString().trim();
//        String password = pass.getText().toString().trim();
//        if (user.equals("asik") && password.equals("123")){
//
//            Intent intent1 = new Intent(LogingActivity.this,SplashActivity.class);
//            startActivity(intent1);
//            Toast.makeText(this, "Welcome AZ-MART", Toast.LENGTH_SHORT).show();
//
//        }
//        else {
//            Toast.makeText(this, "Does not match", Toast.LENGTH_SHORT).show();
//        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = uname.getText().toString();
                String password = pass.getText().toString();
                if(email.equals("")||password.equals(""))
                    Toast.makeText(LogingActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else {
                    boolean checkUserpp = db.checkEamilandPass(password,email);
                    if(checkUserpp==true){
                        Intent intent1 = new Intent(LogingActivity.this,SplashActivity.class);
                        startActivity(intent1);
                        Toast.makeText(LogingActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(LogingActivity.this, "Does not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}