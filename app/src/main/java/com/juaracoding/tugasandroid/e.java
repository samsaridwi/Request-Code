package com.juaracoding.tugasandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class e extends AppCompatActivity {
    String kode;

    public static int REQEST_CODE = 555;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e);

        kode = getIntent().getStringExtra("kode");
        Toast.makeText(e.this, kode, Toast.LENGTH_LONG).show();

        //pembalikan nilai normal
        if (kode.equals("1")) {
            kode = "0";
            Toast.makeText(e.this, kode, Toast.LENGTH_LONG).show();
            //perubahan nilai 1
        } else if (kode.equals("0")) {
            kode = "1";
            Toast.makeText(e.this, kode, Toast.LENGTH_LONG).show();
        }
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(e.this,a.class);
                startActivity(i);
            }
        });
        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("kode", kode);
                setResult(REQEST_CODE, i);

                finish();
            }
        });
    }
}
