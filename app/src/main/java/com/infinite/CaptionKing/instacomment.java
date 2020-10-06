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

public class instacomment extends AppCompatActivity {

    ImageView com1,com2,com3,com4,com5,com6,com7,com8;
    private AdView adView;


    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);     //  Fixed Portrait orientation
        setContentView(R.layout.activity_instacomment);
        com1=findViewById(R.id.com1);
        com2=findViewById(R.id.com2);
        com3=findViewById(R.id.com3);
        com4=findViewById(R.id.com4);
        com5=findViewById(R.id.com5);
        com6=findViewById(R.id.com6);
        com7=findViewById(R.id.com7);
        com8=findViewById(R.id.com8);

        runTask();


        com1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacomment.this,insta_one.class);
                intent.putExtra("key","comboy");
                startActivity(intent);
            }
        });
        com2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacomment.this,insta_one.class);
                intent.putExtra("key","comgirl");
                startActivity(intent);
            }
        });
        com3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacomment.this,insta_one.class);
                intent.putExtra("key","comfriend");
                startActivity(intent);
            }
        });
        com4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacomment.this,insta_one.class);
                intent.putExtra("key","combestie");
                startActivity(intent);
            }
        });
        com5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacomment.this,insta_one.class);
                intent.putExtra("key","comfamily");
                startActivity(intent);
            }
        });
        com6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacomment.this,insta_one.class);
                intent.putExtra("key","comsister");
                startActivity(intent);
            }
        });
        com7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacomment.this,insta_one.class);
                intent.putExtra("key","comcouple");
                startActivity(intent);
            }
        });
        com8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacomment.this,insta_one.class);
                intent.putExtra("key","combrother");
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
                      //  Toast.makeText(getApplicationContext(),"Yes is clicked",Toast.LENGTH_LONG).show();
                        runTask();
                    }
                });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(true);

    }

}
