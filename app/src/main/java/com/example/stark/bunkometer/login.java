package com.example.stark.bunkometer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor edit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref=getSharedPreferences("as",MODE_APPEND);
        edit=pref.edit();
        edit.putBoolean("loginflag",true);
        edit.apply();
        //final TextView usernam=(TextView) findViewById(R.id.usernam);
        final TextView textView6=(TextView) findViewById(R.id.textView6);
        final EditText editText=(EditText) findViewById(R.id.editText);
        final Button btnlogin=(Button) findViewById(R.id.btnlogin);

        final Intent intent1=getIntent();
        final String n= intent1.getStringExtra("c");
        textView6.setText(n);
        final String m=intent1.getStringExtra("pd");



        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals(m)) {

                    Toast.makeText(login.this, "The password is correct", Toast.LENGTH_SHORT).show();
                    Intent intent5 = new Intent(login.this, user.class);
                    intent5.putExtra("usrnm", n);
                    intent5.putExtra("pwd",m);
                    startActivity(intent5);

                } else {

                    Toast.makeText(login.this, "The user name or password is wrong", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
