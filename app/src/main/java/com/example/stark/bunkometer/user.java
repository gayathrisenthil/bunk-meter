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

public class user extends AppCompatActivity {
    boolean flag;
    SharedPreferences pref;
    SharedPreferences.Editor edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        pref=getSharedPreferences("as",MODE_APPEND);
        edit=pref.edit();
        edit.putBoolean("flag",true);
        edit.apply();
        final TextView textView4 = (TextView) findViewById(R.id.textView4);
        final TextView sub1 = (TextView) findViewById(R.id.textView4);


        final Button sbtn1 = (Button) findViewById(R.id.sbtn1);

        final EditText editText = (EditText) findViewById(R.id.editText);

        Button logoutbtn = (Button) findViewById(R.id.logoutbtn);
        final Intent intent2 = getIntent();
        String uname = intent2.getStringExtra("usrnm");
        textView4.setText(uname);


        View.OnClickListener Listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.putBoolean("flag",true);


                final Intent intent1 = new Intent(user.this, login.class);
                String pwrd = intent2.getStringExtra("pwd");
                intent1.putExtra("pd", pwrd);
                String b = intent2.getStringExtra("usrnm");
                intent1.putExtra("c", b);
                startActivity(intent1);
                finish();

            }
        };

        final SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();
        final String counterKey = "counter";


        int counter = prefs.getInt(counterKey, 0);

        editText.setText(String.valueOf(counter));

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String value = editText.getText().toString();

                int counter = Integer.parseInt(value);

                if (v.getId() == R.id.sbtn1) {

                    counter++;
                } else if (v.getId() == R.id.storeBtn) {

                    editor.putInt(counterKey, counter);

                    editor.apply();
                    Toast.makeText(user.this, "Saved!", Toast.LENGTH_SHORT).show();
                }

                editText.setText(String.valueOf(counter));
            }
        };

        logoutbtn.setOnClickListener(Listener1);
        sbtn1.setOnClickListener(listener);
    }
}










