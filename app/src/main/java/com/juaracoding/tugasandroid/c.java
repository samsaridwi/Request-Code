package com.juaracoding.tugasandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class c extends AppCompatActivity {
    public static int REQUEST_CODE = 1;
    Button btn;
    String kode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        kode = getIntent().getStringExtra("kode");
        Toast.makeText(c.this, kode, Toast.LENGTH_LONG).show();
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(c.this,d.class);
                i.putExtra("kode", kode);
                startActivityForResult(i, REQUEST_CODE);
                //startActivityForResult(new Intent(c.this,e.class),REQUEST_CODE);
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
        if(requestCode == c.REQUEST_CODE && resultCode == d.REQUEST_CODE){
            String kode = data.getStringExtra("kode");
            this.kode = kode;
        }
    }

}
