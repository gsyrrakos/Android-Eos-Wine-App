package com.example.icsd14193.myapplication14;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class epikoinwnia extends Fragment {
private EditText text1;
    private EditText txt2;
private Button send;
    public epikoinwnia() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.fragment_epikoinwnia, container, false);

text1=(EditText)v.findViewById(R.id.editText3);
        txt2=(EditText)v.findViewById(R.id.editText2);


        send=(Button)v.findViewById(R.id.button1);
        send.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                ;
                String subject=text1.getText().toString();
                String message=txt2.getText().toString();


                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("text/plain");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "info@samoswine.gr"});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }

        });
        return v;
    }










}
