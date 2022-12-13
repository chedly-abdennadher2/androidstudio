package com.example.projetlibrairie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import adapter.AdherentAdapter;
import model.Adherent;
import retrofit.AdherentApi;
import retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class listeadherent extends AppCompatActivity {
    RecyclerView recyclerView;
    MaterialButton retour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listeadherent);
        //recyclerView
        recyclerView =(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
         loadadherents();
         retour=(MaterialButton) findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(listeadherent.this, listeadherent.class);
                startActivity(intent);

            }
        });

    }
    private void loadadherents ()
    {   RetrofitService retrofitService =new RetrofitService();
        AdherentApi adherentApi=   retrofitService.getRetrofit().create(AdherentApi.class);
        adherentApi.adherents().enqueue(new Callback<List<Adherent>>(){

            @Override
            public void onResponse(Call<List<Adherent>> call, Response<List<Adherent>> response) {
                populateListView(response.body());
            }

            @Override
            public void onFailure(Call<List<Adherent>> call, Throwable t) {
                Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE,t.getMessage(),t);
                Toast.makeText(listeadherent.this,t.getMessage(),Toast.LENGTH_SHORT).show();

            }});

    }
    private void populateListView(List<Adherent> adherents) {
        AdherentAdapter adherentAdapter = new AdherentAdapter(adherents);
        recyclerView.setAdapter(adherentAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadadherents();
    }
}