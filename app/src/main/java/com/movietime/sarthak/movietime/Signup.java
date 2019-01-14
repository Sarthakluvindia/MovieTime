package com.movietime.sarthak.movietime;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
EditText fname,lname,mobile,pass,rpass,email;
Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        fname=(EditText)findViewById(R.id.fname);
        lname=(EditText)findViewById(R.id.lname);
        email=(EditText)findViewById(R.id.s_email);
        pass=(EditText)findViewById(R.id.s_pass);
        rpass=(EditText)findViewById(R.id.rpass);
        mobile=(EditText)findViewById(R.id.mobile);
        signup=(Button)findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!pass.getText().toString().equals(rpass.getText().toString())) {
                    rpass.setError("Please check your password!!");
                }
                else{
                    try {
                        SQLiteDatabase db = openOrCreateDatabase("movie_signup", MODE_PRIVATE, null);
                        db.execSQL("create table if not exists signup(fname varchar, lname varchar, email varchar, pass varchar, mobile varchar)");
                        db.execSQL("insert into signup values('" + fname.getText().toString() + "','" + lname.getText().toString() + "','" + email.getText().toString() + "','" + pass.getText().toString() + "','" + mobile.getText().toString() + "')");
                        db.close();
                        Toast.makeText(Signup.this, "Congratz, Signed In", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(Signup.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    Intent in = new Intent(Signup.this, Login.class);
                    startActivity(in);
                }
            }
        });
    }
}
