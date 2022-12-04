package com.example.projetlibrairie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listeadherent);
        //recyclerView
        recyclerView =(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
         loadadherents();
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