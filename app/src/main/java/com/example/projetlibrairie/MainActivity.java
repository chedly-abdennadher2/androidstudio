package com.example.projetlibrairie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;


import java.util.logging.Level;
import java.util.logging.Logger;

import model.Adherent;
import retrofit.AdherentApi;
import retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity extends AppCompatActivity {
    TextInputEditText nom;
    TextInputEditText prenom;
    MaterialButton save;
    Button adherentliste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adherentliste=(Button) findViewById(R.id.adhliste);
        adherentliste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, listeadherent.class);
                startActivity(intent);

            }
        });
     nom=(TextInputEditText) findViewById(R.id.nom);
     prenom=(TextInputEditText)  findViewById(R.id.prenom);
     save=(MaterialButton) findViewById(R.id.save);
        RetrofitService retrofitService =new RetrofitService();
     AdherentApi adherentApi=   retrofitService.getRetrofit().create(AdherentApi.class);

     save.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            String name=String.valueOf(nom.getText());
            String lastname=String.valueOf(prenom.getText());
             Adherent adh=new Adherent();
             adh.setNom(name);
             adh.setPrenom(lastname);
             adherentApi.save(adh).enqueue(new Callback<Adherent>(){

                 @Override
                 public void onResponse(Call<Adherent> call, Response<Adherent> response) {
                     Toast.makeText(MainActivity.this,"success",Toast.LENGTH_SHORT).show();

                 }
                 @Override
                 public void onFailure(Call<Adherent> call, Throwable t) {
                     Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE,t.getMessage(),t);
                     Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();

                 }
             }
             );

         }

     });
    }
}