package com.example.projetlibrairie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class supprimeradherent extends AppCompatActivity {
    MaterialButton retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimeradherent);
        retour=(MaterialButton) findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(supprimeradherent.this, AdherentActivity.class);
                startActivity(intent);

            }
        });
        RetrofitService retrofitService = new RetrofitService();
        AdherentApi adherentApi = retrofitService.getRetrofit().create(AdherentApi.class);
        MaterialButton delete=(MaterialButton) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextInputEditText id = (TextInputEditText) findViewById(R.id.idadh);

                int idval=0;
                idval=Integer.parseInt(String.valueOf(id.getText()));
                        if (idval!=0)
                adherentApi.Adherent(idval).enqueue(new Callback<Adherent>() {

                    @Override
                    public void onResponse(Call<Adherent> call, Response<Adherent> response) {
                        Adherent adh= response.body();
                        adherentApi.deleteadh(adh).enqueue(new Callback<Adherent>(){

                                                             @Override
                                                             public void onResponse(Call<Adherent> call, Response<Adherent> response) {
                                                                 Toast.makeText(supprimeradherent.this,"success",Toast.LENGTH_SHORT).show();
                                                                 Intent intent =new Intent(supprimeradherent.this, AdherentActivity.class);startActivity(intent);

                                                             }
                                                             @Override
                                                             public void onFailure(Call<Adherent> call, Throwable t) {
                                                                 Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE,t.getMessage(),t);
                                                                 Toast.makeText(supprimeradherent.this,t.getMessage(),Toast.LENGTH_SHORT).show();

                                                             }
                                                         }
                        );
                    }

                    @Override
                    public void onFailure(Call<Adherent> call, Throwable t) {
                        Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, t.getMessage(), t);
                        Toast.makeText(supprimeradherent.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });



    }   }



