package com.juaracoding.tugasandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class d extends AppCompatActivity {

    public static int REQUEST_CODE = 444;
    String kode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);

        Button btn = (Button) findViewById(R.id.btn);
        kode = getIntent().getStringExtra("kode");
        Toast.makeText(d.this, kode, Toast.LENGTH_LONG).show();
        //jika nilai 1
        if (kode.equals("1")) {
            Intent i = new Intent(d.this,e.class);
            i.putExtra("kode", kode);
            startActivity(i);
        }
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(d.this,e.class);
                i.putExtra("kode", kode);
                startActivityForResult(i, REQUEST_CODE);

            }
        });
        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == d.REQUEST_CODE && resultCode == e.REQEST_CODE) {
            String kode = data.getStringExtra("kode");
            Toast.makeText(d.this, kode, Toast.LENGTH_LONG).show();
            this.kode = kode;

            if (kode.equals("1")) {
                Intent i = new Intent();
                i.putExtra("kode", kode);
                setResult(REQUEST_CODE, i);
                finish();
            }
        }
    }
}
