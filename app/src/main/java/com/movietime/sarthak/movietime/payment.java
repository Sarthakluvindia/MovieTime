package com.movietime.sarthak.movietime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class payment extends AppCompatActivity {
EditText card,exp,post,sec;
TextView pay;
ImageButton payment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        card=(EditText)findViewById(R.id.card);
        exp=(EditText)findViewById(R.id.expDate);
        post=(EditText)findViewById(R.id.postcode);
        sec=(EditText)findViewById(R.id.sec);
        pay=(TextView)findViewById(R.id.amount);
        pay.setText(pay.getText().toString()+": "+Double.parseDouble(SeatSelection.seats)*280);
        payment=(ImageButton)findViewById(R.id.payme);
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card.setText("");
                exp.setText("");
                post.setText("");
                sec.setText("");
                Toast.makeText(com.movietime.sarthak.movietime.payment.this,"You have successfully paid. Thank You :)",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
