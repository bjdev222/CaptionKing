package com.infinite.CaptionKing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;



import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import com.facebook.ads.*;


public class insta_one extends AppCompatActivity {

    ListView listView;
    DatabaseReference databaseReference;
    List<String> title_list;
   public ArrayAdapter<String> adapter;
    MyStory myStory;
    AnimatorSet set;


    private ClipboardManager myClipboard;
    private ClipData myClip;
    private InterstitialAd interstitialAd;
    EditText search;
    Button cancel;
    TextView datainfo;

    private AdView mAdView;






    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);     //  Fixed Portrait orientation
        setContentView(R.layout.activity_insta_one);
        AudienceNetworkAds.initialize(this);

        listView=findViewById(R.id.listView);
        search=findViewById(R.id.search);
        cancel=findViewById(R.id.cancel);
        datainfo=findViewById(R.id.datainfo);
        runTask();
        //banner
        AdView adView = new AdView(this, "2379798102265672_2391251711120311", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();

        //INterstitial facebook
        //facebook audience
        AudienceNetworkAds.initialize(this);
        //interstitial
        interstitialAd = new InterstitialAd(this, "2379798102265672_2393234037588745");
        interstitialAd.setAdListener(new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {

            }

            @Override
            public void onError(Ad ad, AdError adError) {
                //finish();

            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Show the ad
                interstitialAd.show();
                //finish();
            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        });



        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        interstitialAd.loadAd();





        final String y=getIntent().getStringExtra("key");
        assert y != null;
        databaseReference= FirebaseDatabase.getInstance().getReference(y);
        myStory=new MyStory();
        title_list=new ArrayList<>();
        adapter=new ArrayAdapter<>(this,R.layout.bg,R.id.item_txt,title_list);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search.setText("");
                cancel.setVisibility(View.GONE);

            }
        });
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (insta_one.this).adapter.getFilter().filter(s);
                if(adapter.isEmpty())
                {
                    datainfo.setText("Sorry!No data found!!!");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                cancel.setVisibility(View.VISIBLE);
                if(search.equals(""))
                {
                    cancel.setVisibility(View.GONE);
                }


            }
        });


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    myStory=ds.getValue(MyStory.class);
                    if (myStory != null) {
                        title_list.add(myStory.getTitle());
                    }
                }







                listView.setAdapter(adapter);
                //Toast.makeText(getApplicationContext(), "DATA FETCHED...",Toast.LENGTH_LONG).show();

                Animation animation = null;
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.wave);
                animation.setDuration(200);
                listView.startAnimation(animation);
                animation = null;
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                        String p = title_list.get(position);
                        myClip = ClipData.newPlainText("textView",p);
                        myClipboard.setPrimaryClip(myClip);
                        Toast.makeText(getApplicationContext(), "Text Copied",Toast.LENGTH_SHORT).show();

                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,p);
                        startActivity(Intent.createChooser(sharingIntent, "Share text via"));


                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
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
            //Toast.makeText(this, "Network available!", Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), "We are fetching data...",Toast.LENGTH_SHORT).show();


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
            alertDialog.setCancelable(false);

        }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.men,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.info:
                Toast.makeText(getApplicationContext(), "info shows", Toast.LENGTH_SHORT).show();
                alertDialog();
                break;
            case R.id.share:
                ShareCompat.IntentBuilder.from(insta_one.this)
                        .setType("text/plain")
                        .setChooserTitle("Choose App")
                        .setText("https://play.google.com/store/apps/details?id=" + insta_one.this.getPackageName())
                        .startChooser();
                break;
            case R.id.back:
               // Toast.makeText(getApplicationContext(), "back", Toast.LENGTH_SHORT).show();
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void alertDialog() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Tap on text to copy and share");
        dialog.setTitle("Info");
        dialog.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                       // Toast.makeText(getApplicationContext(),"Yes is clicked",Toast.LENGTH_LONG).show();
                    }
                });

        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
        alertDialog.setCanceledOnTouchOutside(false);


    }

  //  public void onBackPressed() {


   // }
    @Override
    protected void onDestroy() {
        if (interstitialAd != null) {
            interstitialAd.destroy();

        }
        super.onDestroy();
      //  finish();
    }




}
