package com.infinite.CaptionKing;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class instahashtag extends AppCompatActivity {

    ImageView ht1,ht2,ht3,ht4,ht5,ht7,ht8,ht9,ht10,ht11,ht12;
    private AdView adView;



    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);     //  Fixed Portrait orientation
        setContentView(R.layout.activity_instahashtag);
        ht1=findViewById(R.id.ht1);
        ht2=findViewById(R.id.ht2);
        ht3=findViewById(R.id.ht3);
        ht4=findViewById(R.id.ht4);
        ht5=findViewById(R.id.ht5);
        ht7=findViewById(R.id.ht7);
        ht8=findViewById(R.id.ht8);
        ht9=findViewById(R.id.ht9);
        ht10=findViewById(R.id.ht10);
        ht11=findViewById(R.id.ht11);

        runTask();


        ht1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instahashtag.this,insta_one.class);
                intent.putExtra("key","htrelation");
                startActivity(intent);
            }
        });
        ht2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instahashtag.this,insta_one.class);
                intent.putExtra("key","httravel");
                startActivity(intent);
            }
        });
        ht3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instahashtag.this,insta_one.class);
                intent.putExtra("key","htselfie");
                startActivity(intent);
            }
        });
        ht4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instahashtag.this,insta_one.class);
                intent.putExtra("key","htshopping");
                startActivity(intent);

            }
        });
        ht5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instahashtag.this,insta_one.class);
                intent.putExtra("key","htphotography");
                startActivity(intent);
            }
        });

        ht7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instahashtag.this,insta_one.class);
                intent.putExtra("key","htwedding");
                startActivity(intent);
            }
        });
        ht8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instahashtag.this,insta_one.class);
                intent.putExtra("key","htfriend");
                startActivity(intent);

            }
        });
        ht9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instahashtag.this,insta_one.class);
                intent.putExtra("key","htfashion");
                startActivity(intent);
            }
        });
        ht10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instahashtag.this,insta_one.class);
                intent.putExtra("key","htfood");
                startActivity(intent);

            }
        });
        ht11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instahashtag.this,insta_one.class);
                intent.putExtra("key","httrend");
                startActivity(intent);

            }
        });


    }
    private boolean checkInternet() {

        boolean y = true;
        ConnectivityManager connectivityManager=(ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if(networkInfo==null || !networkInfo.isConnected() || !networkInfo.isAvailable()){
            y=false;
        }

        return y;
    }
    public void runTask () {
        if(checkInternet())
        {
           // Toast.makeText(this, "Network available!", Toast.LENGTH_LONG).show();



        } else {
            Internetdialog();

        }
    }

    private void Internetdialog() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Please check your connection!!");
        dialog.setTitle("No internet !!");
        dialog.setPositiveButton("Retry",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                    //    Toast.makeText(getApplicationContext(),"Yes is clicked",Toast.LENGTH_LONG).show();
                        runTask();
                    }
                });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(true);

    }

}
