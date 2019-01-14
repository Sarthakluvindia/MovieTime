package com.movietime.sarthak.movietime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SeatSelection extends AppCompatActivity {
ImageButton b1,b2,b3,b4;
static String seats;
Button book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_selection);
        Intent in=getIntent();
        seats=in.getStringExtra("n_seats");
        b1=(ImageButton)findViewById(R.id.b1);
        b2=(ImageButton)findViewById(R.id.b2);
        b3=(ImageButton)findViewById(R.id.b3);
        b4=(ImageButton)findViewById(R.id.b4);
        book=(Button)findViewById(R.id.book);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(seats.equals("1")) {
                    b1.setImageResource(R.drawable.selected_seat);
                    book.setText("Book 1 Ticket");
                }
                else if(seats.equals("2")){
                    b1.setImageResource(R.drawable.selected_seat);
                    b2.setImageResource(R.drawable.selected_seat);
                    book.setText("Book 2 Tickets");
                }
                else if(seats.equals("3")){
                    b1.setImageResource(R.drawable.selected_seat);
                    b2.setImageResource(R.drawable.selected_seat);
                    b3.setImageResource(R.drawable.selected_seat);
                    book.setText("Book 3 Tickets");
                }
                else if(seats.equals("4")){
                    b1.setImageResource(R.drawable.selected_seat);
                    b2.setImageResource(R.drawable.selected_seat);
                    b3.setImageResource(R.drawable.selected_seat);
                    b4.setImageResource(R.drawable.selected_seat);
                    book.setText("Book 4 Tickets");
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(seats.equals("1")) {
                    b2.setImageResource(R.drawable.selected_seat);
                    book.setText("Book 1 Ticket");
                }
                else if(seats.equals("2")){
                    b2.setImageResource(R.drawable.selected_seat);
                    b3.setImageResource(R.drawable.selected_seat);
                    book.setText("Book 2 Tickets");
                }
                else if(seats.equals("3")){
                    b2.setImageResource(R.drawable.selected_seat);
                    b3.setImageResource(R.drawable.selected_seat);
                    b4.setImageResource(R.drawable.selected_seat);
                    book.setText("Book 3 Tickets");
                }
            }

        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(seats.equals("1")) {
                    b3.setImageResource(R.drawable.selected_seat);
                    book.setText("Book 1 Ticket");
                }
                else if(seats.equals("2")){
                    b3.setImageResource(R.drawable.selected_seat);
                    b4.setImageResource(R.drawable.selected_seat);
                    book.setText("Book 2 Tickets");
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b4.setImageResource(R.drawable.selected_seat);
                book.setText("Book 1 Ticket");
            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SeatSelection.this,Details.class));
            }
        });
    }
}
