package com.movietime.sarthak.movietime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

public class SelectPage extends AppCompatActivity {
    DatePicker simpleDatePicker;
    Button submit;
    Spinner spinner;
    Spinner spinner1;
    static String day,month,year,movie,city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_page);
        // initiate the date picker and a button



        // perform click event on submit button
        simpleDatePicker = (DatePicker) findViewById(R.id.Selectdate);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // get the values for day of month , month and year from a date picker
                day = String.valueOf(simpleDatePicker.getDayOfMonth());
                month = String.valueOf(simpleDatePicker.getMonth() + 1);
                year = String.valueOf(simpleDatePicker.getYear());
                // display the values by using a toast
                movie=spinner.getSelectedItem().toString();
                city=spinner1.getSelectedItem().toString();
                Intent in = new Intent(SelectPage.this, TrailerSynopsis.class);
                in.putExtra("movie",movie);
                in.putExtra("city",city);
                startActivity(in);
            }
        });
         spinner= (Spinner) findViewById(R.id.Selectmovie);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Select_Movie, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

      spinner1 = (Spinner) findViewById(R.id.Selectcity);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.Select_City, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner1.setAdapter(adapter1);

    }

    public class SpinnerActivity extends MainActivity1 implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }
    public class SpinnerActivity1 extends MainActivity1 implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }

    }
}
