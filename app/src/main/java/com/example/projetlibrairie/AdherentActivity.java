package com.example.projetlibrairie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.adherent: {
                break;
            }
            case R.id.Livre: {
                break;
            }
            case R.id.Exemplaire:{

                break;
            }
            case R.id.Emprunt: {
                break;
                }
            case R.id.retour: {
                Intent intent=new Intent(AdherentActivity.this,MainActivity.class);
                startActivity(intent);

                break;

            }
        }

        return super.onOptionsItemSelected(item);
    }
}