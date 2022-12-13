package com.example.projetlibrairie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdherentActivity extends AppCompatActivity {
    Button adherentliste;
    Button ajouteradherent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adherent);
        adherentliste=(Button) findViewById(R.id.adhliste);
        adherentliste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(AdherentActivity.this, listeadherent.class);
                startActivity(intent);

            }
        });

        ajouteradherent=(Button) findViewById(R.id.adhajout);
        ajouteradherent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(AdherentActivity.this, ajouteradherent.class);
                startActivity(intent);

            }
        });
    }
}