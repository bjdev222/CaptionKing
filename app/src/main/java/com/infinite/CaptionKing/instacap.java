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
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;


public class instacap extends AppCompatActivity {


    ImageView insta1,insta2,insta3,insta4,insta5,insta6,insta7,insta8,insta9,insta10,insta11,insta12,insta13,insta14,insta17,insta18,insta19,insta20,insta21,insta22,insta23,insta24;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);     //  Fixed Portrait orientation
        setContentView(R.layout.activity_instacap);


        insta1=findViewById(R.id.insta1);
        insta2=findViewById(R.id.insta2);
        insta3=findViewById(R.id.insta3);
        insta4=findViewById(R.id.insta4);
        insta5=findViewById(R.id.insta5);
        insta6=findViewById(R.id.insta6);
        insta7=findViewById(R.id.insta7);
        insta8=findViewById(R.id.insta8);
        insta9=findViewById(R.id.insta9);
        insta10=findViewById(R.id.insta10);
        insta11=findViewById(R.id.insta11);
        insta12=findViewById(R.id.insta12);
        insta13=findViewById(R.id.insta13);
        insta14=findViewById(R.id.insta14);

        insta17=findViewById(R.id.insta17);
        insta18=findViewById(R.id.insta18);
        insta19=findViewById(R.id.insta19);
        insta20=findViewById(R.id.insta20);
        insta21=findViewById(R.id.insta21);
        insta22=findViewById(R.id.insta22);
        insta23=findViewById(R.id.insta23);
        insta24=findViewById(R.id.insta24);
        runTask();
        insta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacap.this,insta_one.class);
                intent.putExtra("key","capattitude");
                startActivity(intent);
            }
        });
        insta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacap.this,insta_one.class);
                intent.putExtra("key","caplove");
                startActivity(intent);
            }
        });
        insta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacap.this,insta_one.class);
                intent.putExtra("key","capjealousy");
                startActivity(intent);
            }
        });
        insta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(instacap.this,insta_one.class);
                intent4.putExtra("key","caphappy");
                startActivity(intent4);
            }
        });
        insta5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacap.this,insta_one.class);
                intent.putExtra("key","capclever");
                startActivity(intent);
            }
        });
        insta6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacap.this,insta_one.class);
                intent.putExtra("key","capcool");
                startActivity(intent);
            }
        });
        insta7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacap.this,insta_one.class);
                intent.putExtra("key","capfoodie");
                startActivity(intent);
            }
        });
        insta8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacap.this,insta_one.class);
                intent.putExtra("key","capfunny");
                startActivity(intent);
            }
        });
        insta9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacap.this,insta_one.class);
                intent.putExtra("key","capparty");
                startActivity(intent);
            }
        });
        insta10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacap.this,insta_one.class);
                intent.putExtra("key","capsavage");
                startActivity(intent);
            }
        });
        insta11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacap.this,insta_one.class);
                intent.putExtra("key","capromantic");
                startActivity(intent);
            }
        });
        insta12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacap.this,insta_one.class);
                intent.putExtra("key","caplife");
                startActivity(intent);
            }
        });
        insta13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacap.this,insta_one.class);
                intent.putExtra("key","capsad");
                startActivity(intent);
            }
        });
        insta14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacap.this,insta_one.class);
                intent.putExtra("key","capheartbreak");
                startActivity(intent);
            }
        });

        insta17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacap.this,insta_one.class);
                intent.putExtra("key","capsuccess");
                startActivity(intent);
            }
        });
        insta18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacap.this,insta_one.class);
                intent.putExtra("key","capphotography");
                startActivity(intent);
            }
        });
        insta19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacap.this,insta_one.class);
                intent.putExtra("key","captravel");
                startActivity(intent);
            }
        });
        insta20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacap.this,insta_one.class);
                intent.putExtra("key","capnature");
                startActivity(intent);
            }
        });
        insta21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacap.this,insta_one.class);
                intent.putExtra("key","capshopping");
                startActivity(intent);
            }
        });
        insta22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacap.this,insta_one.class);
                intent.putExtra("key","capcooking");
                startActivity(intent);
            }
        });
        insta23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacap.this,insta_one.class);
                intent.putExtra("key","captrending");
                startActivity(intent);
            }
        });
        insta24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(instacap.this,insta_one.class);
                intent.putExtra("key","capmusic");
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
