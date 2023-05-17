package com.example.tugaskuis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();

        /* Deklarasi dan Menginisialisasi variable nama dengan Label Nama dari Layout MainActivity */
        TextView nama = findViewById(R.id.tv_namaMain);
        TextView email = findViewById(R.id.email);
        TextView nim = findViewById(R.id.nim);



        /* Men-set Label Nama dengan data User sedang login dari Preferences */
        nama.setText(Preferences.getRegisteredUser(getBaseContext()));
        email.setText(Preferences.getRegisteredEmail(getBaseContext()));
        nim.setText(Preferences.getRegisteredNim(getBaseContext()));

        /* Men-set Status dan User yang sedang login menjadi default atau kosong di
         * Data Preferences. Kemudian menuju ke LoginActivity*/
        findViewById(R.id.btn_kembali).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Menghapus Status login dan kembali ke Login Activity
                Preferences.clearLoggedInUser(getBaseContext());
                startActivity(new Intent(getBaseContext(),MainActivity.class));
                finish();
            }
        }
        );

    }
}