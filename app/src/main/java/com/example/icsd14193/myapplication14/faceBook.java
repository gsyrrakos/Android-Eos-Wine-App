package com.example.icsd14193.myapplication14;


import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class faceBook extends Fragment implements View.OnClickListener {
    LoginButton login;
    float rating1;
    TextView textView;
    CallbackManager call;

    int i=0;
    EditText textathemis;
    EditText textnectar;
    EditText textfyllas;
    EditText textgrund;
    EditText textvin;
    EditText texteklisia;
    EditText textgoldsam;
    EditText textpsiles;
    EditText textsamena;
    EditText textageri;
    EditText textdryousa;
    EditText textnesod;
   //BUTTONS
    private Button nectarsod;
private Button anthemis;
    private Button nectarbut;
    private Button grudbut;
    private Button fullasbut;
    private Button vinbut;
    private Button eklisiabut;
    private Button gsamenabut;
    private Button psilesbut;
    private Button samenabut;
    private Button ageribut;
    private Button dryousabut;
    public static String onoma="";
    public static long fb_id;
    public static String lastname="";
private ArrayList<LinearLayout> list=new ArrayList<LinearLayout>();
int x;
    private LinearLayout nectarsodlay;
    private LinearLayout anthemislay;
    private LinearLayout nectarlay;
    private LinearLayout grandcrulay;
    private LinearLayout fyllaslay;
    private LinearLayout vindouxlay;
    private LinearLayout eklisialay;
    private LinearLayout goldensamlay;
    private LinearLayout psileslay;
    private LinearLayout samenalay;
    private LinearLayout agerilay;
    private LinearLayout dryousalay;
private RatingBar ratingbar;
    private RatingBar ratingbar2;
    private RatingBar ratingbar3;
    private RatingBar ratingbar4;
    private RatingBar ratingbar5;
    private RatingBar ratingbar6;
    private RatingBar ratingbar7;
    private RatingBar ratingbar8;
    private RatingBar ratingbar9;
    private RatingBar ratingbar10;
    private RatingBar ratingbar11;
    private RatingBar ratingbar12;


private ArrayList<RatingBar> rate=new ArrayList<>();
    public faceBook() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v6=inflater.inflate(R.layout.fragment_face_book,container,false);
 //gemisma rate arraylist


       rate.add(ratingbar);
        rate.add(ratingbar2);
        rate.add(ratingbar3);
rate.add(ratingbar4);
rate.add(ratingbar5);
rate.add(ratingbar6);
rate.add(ratingbar7);
rate.add(ratingbar8);
rate.add(ratingbar9);
rate.add(ratingbar10);
rate.add(ratingbar11);
rate.add(ratingbar12);
        //rating oristikoiphsh

        ratingbar=(RatingBar)v6.findViewById(R.id.ratingBar) ;
        ratingbar2=(RatingBar)v6.findViewById(R.id.ratingBar2) ;
        ratingbar3=(RatingBar)v6.findViewById(R.id.ratingBar3) ;
        ratingbar4=(RatingBar)v6.findViewById(R.id.ratingBar4) ;
        ratingbar5=(RatingBar)v6.findViewById(R.id.ratingBar5) ;
        ratingbar6=(RatingBar)v6.findViewById(R.id.ratingBar6) ;
        ratingbar7=(RatingBar)v6.findViewById(R.id.ratingBar7) ;
        ratingbar8=(RatingBar)v6.findViewById(R.id.ratingBar8) ;
        ratingbar9=(RatingBar)v6.findViewById(R.id.ratingBar9) ;
        ratingbar10=(RatingBar)v6.findViewById(R.id.ratingBar10) ;
        ratingbar11=(RatingBar)v6.findViewById(R.id.ratingBar11) ;
        ratingbar12=(RatingBar)v6.findViewById(R.id.ratingBar12) ;

//oristikopoihsh edittexts
         textathemis=(EditText)v6.findViewById(R.id.anthemistxt);
        textnectar=(EditText)v6.findViewById(R.id.nectartxt);
         textfyllas=(EditText)v6.findViewById(R.id.fyllastxt);
         textgrund=(EditText)v6.findViewById(R.id.grandcrutxt);
         textvin=(EditText)v6.findViewById(R.id.vindouxtxt);
         texteklisia=(EditText)v6.findViewById(R.id.eklisiatxt);
         textgoldsam=(EditText)v6.findViewById(R.id.goldensamtxt);
         textpsiles=(EditText)v6.findViewById(R.id.psilestxt);
         textsamena=(EditText)v6.findViewById(R.id.samenatxt);
         textageri=(EditText)v6.findViewById(R.id.ageritxt);
         textdryousa=(EditText)v6.findViewById(R.id.dryousatxt);







//layouts oristikopoihsh
        nectarsodlay = (LinearLayout) v6.findViewById(R.id.nectarsodlay);
        anthemislay = (LinearLayout) v6.findViewById(R.id.anthemis1);
        nectarlay = (LinearLayout) v6.findViewById(R.id.nectarlay);
        grandcrulay = (LinearLayout) v6.findViewById(R.id.grandcrulay);
        fyllaslay = (LinearLayout) v6.findViewById(R.id.fyllaslay);
        vindouxlay = (LinearLayout) v6.findViewById(R.id.vindouxlay);
        eklisialay = (LinearLayout) v6.findViewById(R.id.eklisialay);
        goldensamlay=(LinearLayout)v6.findViewById(R.id.goldensamlay);
        psileslay=(LinearLayout)v6.findViewById(R.id.psileslay);
        samenalay=(LinearLayout)v6.findViewById(R.id.samenalay);
        agerilay=(LinearLayout)v6.findViewById(R.id.agerilay);
        dryousalay=(LinearLayout)v6.findViewById(R.id.dryousalay);
        //koumpia oristikopoihsh
textnesod=(EditText)v6.findViewById(R.id.nectarsodtxt);
       nectarsod=(Button)v6.findViewById(R.id.nectarsod);
        nectarsod.setEnabled(false);

        nectarbut=(Button)v6.findViewById(R.id.nectar);
        nectarbut.setEnabled(false);






        nectarbut.setOnClickListener(this);






        grudbut=(Button)v6.findViewById(R.id.grandcru);
        grudbut.setEnabled(false);
        grudbut.setOnClickListener(this);
        fullasbut=(Button)v6.findViewById(R.id.fyllas);
        fullasbut.setEnabled(false);
        fullasbut.setOnClickListener(this);
        eklisiabut=(Button)v6.findViewById(R.id.eklisia);
        eklisiabut.setEnabled(false);
        eklisiabut.setOnClickListener(this);
        vinbut=(Button)v6.findViewById(R.id.vindoux);
        vinbut.setEnabled(false);
        vinbut.setOnClickListener(this);

        anthemis=(Button)v6.findViewById(R.id.anthemis) ;
        anthemis.setEnabled(false);
        anthemis.setOnClickListener(this);

        nectarsod.setOnClickListener(this);

        gsamenabut=(Button)v6.findViewById(R.id.goldensambut) ;
        gsamenabut.setOnClickListener(this);
        gsamenabut.setEnabled(false);

         psilesbut=(Button)v6.findViewById(R.id.psilesbut);
        psilesbut.setOnClickListener(this);
        psilesbut.setEnabled(false);

         samenabut=(Button)v6.findViewById(R.id.samenabut);
        samenabut.setOnClickListener(this);
        samenabut.setEnabled(false);

         ageribut=(Button)v6.findViewById(R.id.ageribut);
        ageribut.setOnClickListener(this);
        ageribut.setEnabled(false);

         dryousabut=(Button)v6.findViewById(R.id.dryousabut);
        dryousabut.setOnClickListener(this);
        dryousabut.setEnabled(false);
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        AppEventsLogger.activateApp(getActivity());
        printKeyHash();
        list.add(nectarsodlay);
        list.add(anthemislay);
        list.add(nectarlay);
        list.add(grandcrulay);
        list.add(fyllaslay);
        list.add(vindouxlay);
        list.add(eklisialay);
list.add(goldensamlay);
        list.add(psileslay);
list.add(samenalay);
        list.add(dryousalay);
        list.add(agerilay);


        nectarsod.setText("Login via facebook");
        nectarbut.setText("Login via facebook");
        grudbut.setText("Login via facebook");
        fullasbut.setText("Login via facebook");
        vinbut.setText("Login via facebook");
        eklisiabut.setText("Login via facebook");
        anthemis.setText("Login via facebook");
        gsamenabut.setText("Login via facebook");
        psilesbut.setText("Login via facebook");
        ageribut.setText("Login via facebook");
        samenabut.setText("Login via facebook");
        dryousabut.setText("Login via facebook");



         Comments task = new Comments(list);

        task.execute();

        login=(LoginButton)v6.findViewById(R.id.fb_login_bn);
        textView=(TextView)v6.findViewById(R.id.textView);
        textView.setText("Πρεπει να συνδεθεις για να σχολιασεις");
        call=CallbackManager.Factory.create();
        login.registerCallback(call, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {


nectarsod.setEnabled(true);
anthemis.setEnabled(true);
nectarbut.setEnabled(true);
 vinbut.setEnabled(true);
  fullasbut.setEnabled(true);
   grudbut.setEnabled(true);
   eklisiabut.setEnabled(true);
   gsamenabut.setEnabled(true);
                psilesbut.setEnabled(true);
                samenabut.setEnabled(true);
                ageribut.setEnabled(true);
                dryousabut.setEnabled(true);





fb_id=Long.parseLong(loginResult.getAccessToken().getUserId());






                nectarsod.setText("Σχολιασε");
                nectarbut.setText("Σχολιασε");
                grudbut.setText("Σχολιασε");
                fullasbut.setText("Σχολιασε");
                vinbut.setText("Σχολιασε");
                eklisiabut.setText("Σχολιασε");
                anthemis.setText("Σχολιασε");
                gsamenabut.setText("Σχολιασε");
                psilesbut.setText("Σχολιασε");
                ageribut.setText("Σχολιασε");
                samenabut.setText("Σχολιασε");
                dryousabut.setText("Σχολιασε");










                setFacebookData(loginResult);

                textView.setText("Συνδεθηκες με επιτυχια");




            }

            @Override
            public void onCancel() {
                Log.v("LoginActivity", "cancel");            }

            @Override
            public void onError(FacebookException error) {
                System.out.println("edw");

                Log.v("LoginActivity", error.getCause().toString());
            }
        });


        return v6;
    }
    public float addListenerOnRatingBar(RatingBar r) {





        r.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
System.out.println(rating);
                rating1=rating;


            }
        });
  return rating1;  }

    private void printKeyHash() {
        try {
            PackageInfo info = getActivity().getPackageManager().getPackageInfo(
                    getActivity().getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.i("KeyHash:",
                        Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("jk", "Exception(NameNotFoundException) : " + e);
        } catch (NoSuchAlgorithmException e) {
            Log.e("mkm", "Exception(NoSuchAlgorithmException) : " + e);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        call.onActivityResult(requestCode,resultCode,data);
    }

    public void setFacebookData(final LoginResult loginResult)
    {
        GraphRequest request = GraphRequest.newMeRequest(
                loginResult.getAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        // Application code
                        try {
                            Log.i("Response",response.toString());


                          String  firstName = response.getJSONObject().getString("first_name");
                            String lastName = response.getJSONObject().getString("last_name");


                            Profile profile = Profile.getCurrentProfile();

onoma=firstName;
                            onoma=response.getJSONObject().getString("first_name");
                            lastname=response.getJSONObject().getString("last_name");




                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,email,first_name,last_name,gender");
        request.setParameters(parameters);
        request.executeAsync();



    }

  public  ArrayList<Data> data = new ArrayList<Data>();
    public  ArrayList<Data> data2 = new ArrayList<Data>();
    public  ArrayList<Data> data3 = new ArrayList<Data>();
    public  ArrayList<Data> data4= new ArrayList<Data>();
    public  ArrayList<Data> data5= new ArrayList<Data>();
    public  ArrayList<Data> data6= new ArrayList<Data>();
    public  ArrayList<Data> data7= new ArrayList<Data>();
    public  ArrayList<Data> data8= new ArrayList<Data>();
    public  ArrayList<Data> data9= new ArrayList<Data>();
    public  ArrayList<Data> data10= new ArrayList<Data>();
    public  ArrayList<Data> data11= new ArrayList<Data>();
    public  ArrayList<Data> data12= new ArrayList<Data>();

    @Override
    public void onClick(View v) {


        if(v.getId() == R.id.nectarsod) {
addListenerOnRatingBar(ratingbar);
            if(textnesod.getText().toString().matches("")) {
                Toast.makeText(v.getContext(), "Δωσε τιμες", Toast.LENGTH_SHORT).show();

            }else {
            Connect_users task1 = new Connect_users(1, textnesod.getText().toString(), rating1);
            task1.execute();}



                // in pixels (left, top, right, bottom)


        }

if(v.getId()==R.id.anthemis){
   System.out.println( ratingbar2.getRating());
    if(textathemis.getText().toString().matches("")) {
        Toast.makeText(v.getContext(), "Δωσε τιμες", Toast.LENGTH_SHORT).show();

    }else {Connect_users task1=new Connect_users(2,textathemis.getText().toString(),ratingbar2.getRating());
    task1.execute();}





}
        if(v.getId()==R.id.nectar) {
            addListenerOnRatingBar(ratingbar3);
            if(textnectar.getText().toString().matches("")) {
                Toast.makeText(v.getContext(), "Δωσε τιμες", Toast.LENGTH_SHORT).show();

            }else  {Connect_users task1 = new Connect_users(3, textnectar.getText().toString(),ratingbar3.getRating());
            task1.execute();}

        }
        if(v.getId()==R.id.grandcru) {
            addListenerOnRatingBar(ratingbar4);
            if(textgrund.getText().toString().matches("")) {
                Toast.makeText(v.getContext(), "Δωσε τιμες", Toast.LENGTH_SHORT).show();

            }else { Connect_users task1 = new Connect_users(4, textgrund.getText().toString(),ratingbar4.getRating());
            task1.execute();}

        } if(v.getId()==R.id.fyllas) {
            addListenerOnRatingBar(ratingbar5);
            if(textfyllas.getText().toString().matches("")) {
                Toast.makeText(v.getContext(), "Δωσε τιμες", Toast.LENGTH_SHORT).show();

            }else  { Connect_users task1 = new Connect_users(5, textfyllas.getText().toString(),ratingbar5.getRating());
            task1.execute();}

        } if(v.getId()==R.id.vindoux) {
            addListenerOnRatingBar(ratingbar6);
            if(textvin.getText().toString().matches("")) {
                Toast.makeText(v.getContext(), "Δωσε τιμες", Toast.LENGTH_SHORT).show();

            }else { Connect_users task1 = new Connect_users(6, textvin.getText().toString(),ratingbar6.getRating());
            task1.execute();}

        } if(v.getId()==R.id.eklisia) {
            addListenerOnRatingBar(ratingbar7);
            if(texteklisia.getText().toString().matches("")) {
                Toast.makeText(v.getContext(), "Δωσε τιμες", Toast.LENGTH_SHORT).show();

            }else   { Connect_users task1 = new Connect_users(7, texteklisia.getText().toString(),ratingbar7.getRating());
            task1.execute();}

        } if(v.getId()==R.id.goldensambut) {
            addListenerOnRatingBar(ratingbar8);
            if(textgoldsam.getText().toString().matches("")) {
                Toast.makeText(v.getContext(), "Δωσε τιμες", Toast.LENGTH_SHORT).show();

            }else  { Connect_users task1 = new Connect_users(8, textgoldsam.getText().toString(),ratingbar8.getRating());
            task1.execute();}

        } if(v.getId()==R.id.psilesbut) {
            addListenerOnRatingBar(ratingbar9);
            if(textpsiles.getText().toString().matches("")) {
                Toast.makeText(v.getContext(), "Δωσε τιμες", Toast.LENGTH_SHORT).show();

            }else {  Connect_users task1 = new Connect_users(9, textpsiles.getText().toString(),ratingbar9.getRating());
            task1.execute();}

        } if(v.getId()==R.id.samenabut) {
            addListenerOnRatingBar(ratingbar10);
            if(textsamena.getText().toString().matches("")) {
                Toast.makeText(v.getContext(), "Δωσε τιμες", Toast.LENGTH_SHORT).show();

            }else   { Connect_users task1 = new Connect_users(10, textsamena.getText().toString(),ratingbar10.getRating());
            task1.execute();}

        } if(v.getId()==R.id.ageribut) {
            addListenerOnRatingBar(ratingbar11);
            if(textageri.getText().toString().matches("")) {
                Toast.makeText(v.getContext(), "Δωσε τιμες", Toast.LENGTH_SHORT).show();

            }else   { Connect_users task1 = new Connect_users(11, textageri.getText().toString(),ratingbar11.getRating());
            task1.execute();}

        } if(v.getId()==R.id.dryousabut) {
            addListenerOnRatingBar(ratingbar12);
            if(textdryousa.getText().toString().matches("")) {
                Toast.makeText(v.getContext(), "Δωσε τιμες", Toast.LENGTH_SHORT).show();

            }else  { Connect_users task1 = new Connect_users(12, textdryousa.getText().toString(),ratingbar12.getRating());
            task1.execute();}

        }

    }
    public class Data {
        private String Name = null;
        private String lastn = null;
        private String comment=null;
        private Float rat;

        public Data(String lName, String laste,String com,Float rt) {
            this.Name = lName;
            this.lastn = laste;
            this.comment=com;
this.rat=rt;
        }
    }


    private class Comments extends AsyncTask<String, Void, String> {

        protected LinearLayout l1;
protected ArrayList<LinearLayout> list1;
        Comments(LinearLayout l){

    this.l1=l;


}Comments(ArrayList<LinearLayout>l4){this.list1=l4;}
public void gemisma(int x,ArrayList<Data> d){


        String string1=Integer.toString(x);
    String string = "select distinct firstname,lastname,comment,rating from users,sxolia where product_id="+string1+" and user_id=fb_id";;



        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/eosdb", "root", "");
            // System.out.println("Database connection success");

            String onoma2;
            String comm;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(string);
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {


                onoma2 = rs.getString(1);

                comm = rs.getString(3);

                d.add(new Data(rs.getString(1), rs.getString(2), rs.getString(3),rs.getFloat(4)));




            }
            st.close();


        } catch (Exception e) {
            e.printStackTrace();

        }





}
        @Override
        protected String doInBackground(String... urls) {
            String response="" ;
            la:
            for(int g=0;g<list1.size();g++) {

if(list1.get(g)==nectarsodlay){
   gemisma(1,data);
 continue la;
}else if(list1.get(g)==anthemislay){
               gemisma(2,data2);
    continue la;

            }else if(list1.get(g)==nectarlay){
    gemisma(3,data3);
    continue la;}
else if(list1.get(g)==grandcrulay){gemisma(4,data4);
    continue la;}

else if(list1.get(g)==fyllaslay){
    gemisma(5,data5);
    continue la;}
else if(list1.get(g)==vindouxlay){gemisma(6,data6);
    continue la;}
else if(list1.get(g)==eklisialay){gemisma(7,data7);
    continue la;}
else if(list1.get(g)==goldensamlay){gemisma(8,data8);
    continue la;}
else if(list1.get(g)==psileslay){gemisma(9,data9);
    continue la;}
else if(list1.get(g)==samenalay){gemisma(10,data10);
    continue la;}
else if(list1.get(g)==agerilay){gemisma(11,data11);
    continue la;}
else if(list1.get(g)==dryousalay){gemisma(12,data12);
    continue la;}
            }









            return response;


        }

        public void gemisma_com(int y,ArrayList<Data>d1){

            for (int q = 0; q < d1.size(); q++) {
                RatingBar rating_bar = new RatingBar(getActivity(), null, android.R.attr.ratingBarStyleSmall);

                rating_bar.setEnabled(false);

                rating_bar.setStepSize(0);
                rating_bar.setRating(d1.get(q).rat);

                rating_bar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                rating_bar.setNumStars(5);

            GridLayout l2 = new GridLayout(getActivity());
            GridLayout.Spec titleTxtSpecColumn = GridLayout.spec(2, GridLayout.BASELINE);
            GridLayout.Spec titleRowSpec = GridLayout.spec(1);

            TextView textView15 = new TextView(getActivity());
            textView15.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            textView15.setId(i);
            textView15.setText(d1.get(q).Name + " " +d1.get(q).lastn+" \n "+ d1.get(q).comment);

            textView15.setBackgroundColor(Color.CYAN); // hex color 0xAARRGGBB
            textView15.setPadding(20, 20, 20, 20);// in pixels (left, top, right, bottom)
            l2.addView(textView15);
                l2.addView(rating_bar);
            list1.get(y).addView(l2);


        }}

        @Override

        protected void onPostExecute(String result2) {
ba:
            for(int y=0;y<list1.size();y++) {

    if(list1.get(y)==nectarsodlay){
    gemisma_com(y,data);
    continue ba;}
    else if(list1.get(y)==anthemislay){
        gemisma_com(y,data2);
    continue ba;}
              else  if(list1.get(y)==nectarlay){
                    gemisma_com(y,data3);
                    continue ba;}
              else  if(list1.get(y)==grandcrulay){
                    gemisma_com(y,data4);
                    continue ba;}
             else   if(list1.get(y)==fyllaslay){
                    gemisma_com(y,data5);
                    continue ba;}
             else   if(list1.get(y)==vindouxlay){
                    gemisma_com(y,data6);
                    continue ba;}
             else   if(list1.get(y)==eklisialay){
                    gemisma_com(y,data7);
                    continue ba;}

else if(list1.get(y)==goldensamlay){
        gemisma_com(y,data8);
        continue ba;

    }else if(list1.get(y)==psileslay){
        gemisma_com(y,data9);
        continue ba;

    }
    else if(list1.get(y)==samenalay){
        gemisma_com(y,data10);
        continue ba;

    }else if(list1.get(y)==agerilay){
        gemisma_com(y,data11);
        continue ba;

    }else if(list1.get(y)==dryousalay){
        gemisma_com(y,data12);
        continue ba;

    }











}





data.removeAll(data);
            data2.removeAll(data2);
            data3.removeAll(data3);
            data4.removeAll(data4);
            data5.removeAll(data5);
            data6.removeAll(data6);
            data7.removeAll(data7);
            data8.removeAll(data8);
            data9.removeAll(data9);
            data10.removeAll(data10);
            data11.removeAll(data11);
            data12.removeAll(data12);

    }
    }

    private class Connect_users extends AsyncTask<String, Void, String> {
private  String com;
        private int proin;
        private float rate1;
Connect_users(int proion,String sxolio,float rate12){

    this.com=sxolio;
    this.proin=proion;
    this.rate1=rate12;
}



        @Override
        protected String doInBackground(String... urls) {
            String done = "0";

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con = DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/eosdb", "root", "");
                // System.out.println("Database connection success");

               

                String query = " insert into users (fb_id, firstname, lastname)"
                        + " values (?, ?, ?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setLong (1, faceBook.fb_id);
                preparedStmt.setString (2, faceBook.onoma);
                preparedStmt.setString   (3, faceBook.lastname);

                // execute the preparedstatement
                preparedStmt.execute();
                preparedStmt.close();
                String query1 = " insert into sxolia (user_id, product_id, comment,rating)"
                        + " values (?, ?, ?, ?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt1 = con.prepareStatement(query1);
                preparedStmt1.setLong (1, faceBook.fb_id);
                preparedStmt1.setInt (2, proin);
                preparedStmt1.setString   (3, com);
                preparedStmt1.setFloat   (4, rate1);

                // execute the preparedstatement
                preparedStmt1.execute();
                preparedStmt1.close();
                done = "1";

                con.close();

            }
            catch(Exception e) {
                e.printStackTrace();

            }
            return done;


        }


        @Override
        protected void onPostExecute(String result) {
           for(int i=0;i<list.size();i++){
               list.get(i).removeAllViews();
           }
            data.removeAll(data);
            data2.removeAll(data2);
            data3.removeAll(data3);
            data4.removeAll(data4);
            data5.removeAll(data5);
            data6.removeAll(data6);
            data7.removeAll(data7);
            data8.removeAll(data8);
            data9.removeAll(data9);
data10.removeAll(data10);
            data11.removeAll(data11);
            data12.removeAll(data12);
            Comments task = new Comments(list);

            task.execute();

        }
    }






}
