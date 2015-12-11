package com.example.stark.bunkometer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
     boolean flag,loginflag;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        pref= getSharedPreferences("as",MODE_APPEND);
        flag=pref.getBoolean("flag",false);
        loginflag=pref.getBoolean("loginflag",false);
        if (flag){
            Intent intent=new Intent(MainActivity.this,user.class);
            startActivity(intent);
        }
        if (loginflag){
            Intent intent=new Intent(MainActivity.this,login.class);
            startActivity(intent);
        }
        setContentView(R.layout.activity_main);
        Button btn1=(Button) findViewById(R.id.btn1);
        View.OnClickListener Listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, regpage.class);
                startActivity(intent);
                finish();
            }
        };
        btn1.setOnClickListener(Listener);



    }

}
