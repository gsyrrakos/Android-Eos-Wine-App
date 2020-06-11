package com.example.icsd14193.myapplication14;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.facebook.CallbackManager;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    CallbackManager call;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (hasConnection(MainActivity.this)){
            //call methods
            //getJsonData();
        }
        else{
            showNetDisabledAlertToUser(MainActivity.this);
        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }
    public boolean hasConnection(Context context){
        ConnectivityManager cm=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo   NetworkInfowifiNetwork=cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (NetworkInfowifiNetwork != null && NetworkInfowifiNetwork.isConnected()){
            return true;
        }
        NetworkInfo mobileNetwork=cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (mobileNetwork != null && mobileNetwork.isConnected()){
            return true;
        }
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected()){
            return true;
        }
        return false;
    }
    public static void showNetDisabledAlertToUser(final Context context){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context, AlertDialog.THEME_TRADITIONAL);
        alertDialogBuilder.setMessage("Would you like to enable it?")
                .setTitle("No Internet Connection")
                .setPositiveButton(" Enable Internet ", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Intent dialogIntent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                        dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(dialogIntent);
                    }
                });

        alertDialogBuilder.setNegativeButton(" Cancel ", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                dialog.cancel();
            }
        });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for (android.support.v4.app.Fragment fragment : getSupportFragmentManager().getFragments()) {
            //System.out.println("@#@");
            fragment.onActivityResult(requestCode, resultCode, data);
        }

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.


        int id = item.getItemId();

        if (id == R.id.proin) {
            setTitle("Προιοντα");
            proionta pro = new proionta();

            FragmentTransaction tranc = getSupportFragmentManager().beginTransaction();

            tranc.replace(R.id.frame, pro, "dwse1");

            tranc.commit();

        } else if (id == R.id.ampelones) {
            setTitle("Αμπελωνες");
            ampelones amp = new ampelones();
            FragmentTransaction tranc = getSupportFragmentManager().beginTransaction();
            tranc.replace(R.id.frame, amp, "dwse");
            tranc.commit();

        } else if (id == R.id.diktyo) {
            setTitle("Δικτυο");
            BlankFragment amp1 = new BlankFragment();
            FragmentTransaction tranc = getSupportFragmentManager().beginTransaction();
            tranc.replace(R.id.frame, amp1, "dwse");
            tranc.commit();
        } else if (id == R.id.poikilia) {
            setTitle("Ποικιλια");
            poikilia poi = new poikilia();
            FragmentTransaction tranc = getSupportFragmentManager().beginTransaction();
            tranc.replace(R.id.frame, poi, "dwse");
            tranc.commit();
        } else if (id == R.id.oinopieio) {
            setTitle("Οινοπειιο");
            oinopeiio oin = new oinopeiio();
            FragmentTransaction tranc = getSupportFragmentManager().beginTransaction();
            tranc.replace(R.id.frame, oin, "dwse");
            tranc.commit();
        } else if (id == R.id.home) {
            setTitle("Αξιολογηση");
            faceBook ne = new faceBook();
            FragmentTransaction tranc = getSupportFragmentManager().beginTransaction();
            tranc.replace(R.id.frame, ne, "dwse");

            tranc.commit();
        } else if (id == R.id.brabeyseis) {
            setTitle("Βραβευσεις");
            vavreyseis vav = new vavreyseis();
            FragmentTransaction tranc = getSupportFragmentManager().beginTransaction();
            tranc.replace(R.id.frame, vav, "dwse");
            tranc.commit();
        } else if (id == R.id.mousio) {
            setTitle("Μουσειο");
            mouseio mou = new mouseio();
            FragmentTransaction tranc = getSupportFragmentManager().beginTransaction();
            tranc.replace(R.id.frame, mou, "dwse");
            tranc.commit();
        } else if (id == R.id.suneterismos) {
            setTitle("Συνεταιρισμος");
            Synaiterismos syn = new Synaiterismos();
            FragmentTransaction tranc = getSupportFragmentManager().beginTransaction();
            tranc.replace(R.id.frame, syn, "dwse");
            tranc.commit();
        } else if (id == R.id.nea) {

            setTitle("Νεα");
            nea syn = new nea();
            FragmentTransaction tranc = getSupportFragmentManager().beginTransaction();
            tranc.replace(R.id.frame, syn, "nea");
            tranc.commit();


        } else if (id == R.id.epoik) {
            setTitle("Επικοινωνια");
            epikoinwnia epin = new epikoinwnia();
            FragmentTransaction tranc = getSupportFragmentManager().beginTransaction();
            tranc.replace(R.id.frame, epin, "epoik");
            tranc.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
