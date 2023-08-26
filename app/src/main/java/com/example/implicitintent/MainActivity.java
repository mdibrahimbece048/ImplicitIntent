package com.example.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShare,btnMessage,btnEmail,btnDial;

        btnEmail=findViewById(R.id.btnEmail);
        btnMessage=findViewById(R.id.btnMessage);
        btnDial=findViewById(R.id.btnDial);
        btnShare=findViewById(R.id.btnShare);
        // for dial
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDial=new Intent();
                iDial.setAction(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: +919351203347"));
                startActivity(iDial);

            }
        });
        //for message
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMessage=new Intent();
                iMessage.setAction(Intent.ACTION_SENDTO);
                iMessage.setData(Uri.parse("smsto:"+Uri.encode("+919351203347")));
                iMessage.putExtra("sms_body","Please solve this issue asap");
                startActivity(iMessage);

            }
        });

        //for email
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEmail=new Intent();
                iEmail.setAction(Intent.ACTION_SEND);
                iEmail.setType("message/rfc822");
                iEmail.putExtra(Intent.EXTRA_EMAIL,new String[]{"mdibrahimbece048@gmail.com","bat17092@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT,"Queries");
                iEmail.putExtra(Intent.EXTRA_TEXT,"Please solve this issue");
                startActivity(Intent.createChooser(iEmail,"Email via"));
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShare=new Intent();
                iShare.setAction(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT,"Go on ");
                startActivity(Intent.createChooser(iShare,"Share Via"));
            }
        });


    }
}
