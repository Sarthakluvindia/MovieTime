package com.movietime.sarthak.movietime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Details extends AppCompatActivity {
TextView name,date,time,seats,city,price;
Button paynow;
Double pay=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        name=(TextView) findViewById(R.id.mov_name);
        date=(TextView) findViewById(R.id.mov_date);
        time=(TextView) findViewById(R.id.mov_time);
        seats=(TextView) findViewById(R.id.no_of_seats);
        price=(TextView) findViewById(R.id.price);
        city=(TextView) findViewById(R.id.mov_city);
        name.setText(SelectPage.movie);
        date.setText(SelectPage.day+"/"+SelectPage.month+"/"+SelectPage.year);
        time.setText("11:15 am");
        city.setText(SelectPage.city);
        seats.setText("You have booked "+SeatSelection.seats+" seats");
        pay= 280.0*Double.parseDouble(SeatSelection.seats);
        price.setText("Rs. "+pay);
        paynow=(Button)findViewById(R.id.paynow);
        paynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Details.this,payment.class));
            }
        });
    }
}
