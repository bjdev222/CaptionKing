package com.infinite.CaptionKing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    ImageView insta,wp,hashtag,wishesh,daily;
    private AdView adView;
    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //  Fixed Portrait orientation
        setContentView(R.layout.activity_main);

        insta=findViewById(R.id.insta);
        wp=findViewById(R.id.wp);
        hashtag=findViewById(R.id.hashtag);
        wishesh=findViewById(R.id.wish);
        daily=findViewById(R.id.daily);
        runTask();



        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this,instacap.class);
                startActivity(intent1);
            }
        });
        wp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(MainActivity.this,instacomment.class);
                startActivity(intent2);
            }
        });
        hashtag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(MainActivity.this,instahashtag.class);
                startActivity(intent3);
            }
        });
        wishesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(MainActivity.this,wishes.class);
                startActivity(intent4);
            }
        });
        daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5=new Intent(MainActivity.this,dailyQuotes.class);
                startActivity(intent5);
            }
        });

    }
// checking Internet Connection
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
          //  Toast.makeText(this, "Network available!", Toast.LENGTH_LONG).show();
           // Toast.makeText(getApplicationContext(), "We are fetching data...",Toast.LENGTH_SHORT).show();


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
                 //       Toast.makeText(getApplicationContext(),"Yes is clicked",Toast.LENGTH_LONG).show();
                        runTask();
                    }
                });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(true);

    }

    @Override
    public void onBackPressed() {
        alertDialog();

    }

    private void alertDialog() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Are you sure you want to exit? ");

        dialog.setPositiveButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        dialog.dismiss();

                    }
                });
        dialog.setNegativeButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        MainActivity.this.finish();
                        System.exit(0);
                    }
                });

        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
        alertDialog.setCanceledOnTouchOutside(false);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.home,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rate:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(
                        "https://play.google.com/store/apps/details?id=com.infinite.CaptionKing"));
                intent.setPackage("com.android.vending");
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Rating", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                ShareCompat.IntentBuilder.from(MainActivity.this)
                        .setType("text/plain")
                        .setChooserTitle("Choose App")
                        .setText("https://play.google.com/store/apps/details?id=" + MainActivity.this.getPackageName())
                        .startChooser();

        }

        return super.onOptionsItemSelected(item);
    }

}

