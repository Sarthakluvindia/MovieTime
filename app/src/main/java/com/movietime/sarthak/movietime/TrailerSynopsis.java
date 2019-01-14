package com.movietime.sarthak.movietime;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;

public class TrailerSynopsis extends AppCompatActivity {
private VideoView trailer;
private TextView name;
LinearLayout llts;
String[] mumbaicinema;
String noofseats=null;
Button btn1=null,btn2=null,btn3=null,btn4=null,btn5=null,btn6=null,btn7=null,btn8=null,btn9=null,btn10=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer_synopsis);
        Intent in=getIntent();
        String movie=in.getStringExtra("movie");
        String city=in.getStringExtra("city");
        trailer=(VideoView)findViewById(R.id.trailer);
        name=(TextView)findViewById(R.id.movie_name);
        llts=(LinearLayout)findViewById(R.id.llts);
        if(movie.equals("Black Panther")) {
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.blackk_panther);
            trailer.setVideoURI(uri);
            trailer.start();
        }
        if(movie.equals("Captain America: Winter Sodlier")) {
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.capt_america);
            trailer.setVideoURI(uri);
            trailer.start();
        }
        trailer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        mumbaicinema=getResources().getStringArray(R.array.mumbaicinema);
        int size=mumbaicinema.length;
        String cinema;
        for(int i=0;i<size;i++){
            TextView tv=new TextView(TrailerSynopsis.this);
            Button button=new Button(TrailerSynopsis.this);
            cinema=mumbaicinema[i];
            tv.setText(cinema);
            button.setText("11:15 am");
            button.setTextColor(Color.rgb(247, 175, 66));
            button.setBackgroundColor(Color.rgb(255,255,255));
            button.setLayoutParams(new LinearLayout.LayoutParams(250, 120));
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder build=new AlertDialog.Builder(TrailerSynopsis.this);
                    View mview=getLayoutInflater().inflate(R.layout.activity_choosing_seats,null);
                    btn1=(Button)mview.findViewById(R.id.s1);
                    btn2=(Button)mview.findViewById(R.id.s2);
                    btn3=(Button)mview.findViewById(R.id.s3);
                    btn4=(Button)mview.findViewById(R.id.s4);
                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            noofseats="1";
                            btn1.setBackgroundColor(Color.parseColor("#F7AF42"));
                            btn2.setBackgroundColor(Color.rgb(255,255,255));
                            btn3.setBackgroundColor(Color.rgb(255,255,255));
                            btn4.setBackgroundColor(Color.rgb(255,255,255));
                        }
                    });

                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            noofseats="2";
                            btn2.setBackgroundColor(Color.parseColor("#F7AF42"));
                            btn1.setBackgroundColor(Color.rgb(255,255,255));
                            btn3.setBackgroundColor(Color.rgb(255,255,255));
                            btn4.setBackgroundColor(Color.rgb(255,255,255));

                        }
                    });

                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            noofseats="3";
                            btn3.setBackgroundColor(Color.parseColor("#F7AF42"));
                            btn1.setBackgroundColor(Color.rgb(255,255,255));
                            btn2.setBackgroundColor(Color.rgb(255,255,255));
                            btn4.setBackgroundColor(Color.rgb(255,255,255));
                        }
                    });

                    btn4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            noofseats="4";
                            btn4.setBackgroundColor(Color.parseColor("#F7AF42"));
                            btn1.setBackgroundColor(Color.rgb(255,255,255));
                            btn2.setBackgroundColor(Color.rgb(255,255,255));
                            btn3.setBackgroundColor(Color.rgb(255,255,255));
                        }
                    });
                    btn5=(Button)mview.findViewById(R.id.s5);
                    btn6=(Button)mview.findViewById(R.id.s6);
                    btn7=(Button)mview.findViewById(R.id.s7);
                    btn8=(Button)mview.findViewById(R.id.s8);
                    btn9=(Button)mview.findViewById(R.id.s9);
                    btn10=(Button)mview.findViewById(R.id.s10);
                    Button next=(Button)mview.findViewById(R.id.next);
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent in=new Intent(TrailerSynopsis.this,SeatSelection.class);
                            in.putExtra("n_seats",noofseats);
                            startActivity(in);
                        }
                    });
                    build.setView(mview);
                    AlertDialog alertDialog=build.create();
                    alertDialog.show();
                }
            });
            tv.setTextSize(18);
            tv.setTextColor(Color.rgb(0,0,0));
            llts.addView(tv);
            llts.addView(button);
        }


    }
}
