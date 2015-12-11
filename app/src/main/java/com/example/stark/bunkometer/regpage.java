package com.example.stark.bunkometer;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class regpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regpage);

        Intent intent1=getIntent();

        final EditText username=(EditText) findViewById(R.id.username);
        final EditText password=(EditText) findViewById(R.id.password);

        final Button btn2=(Button) findViewById(R.id.btn2);

        View.OnClickListener Listener2=new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String txt1=username.getText().toString();
                String txt2=password.getText().toString();
                Intent intent1=new Intent(regpage.this, user.class);
                intent1.putExtra("usrnm", txt1);
                intent1.putExtra("pwd", txt2);
                startActivity(intent1);
                finish();


//                if(txt1=="" || txt2=="" )
//                {
//                    btn2.setEnabled(false);
//                }

            }
        };
        btn2.setOnClickListener(Listener2);


    }
}
