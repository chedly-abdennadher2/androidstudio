package com.example.projetlibrairie;

import android.os.AsyncTask;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

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

public class threadadherent extends AsyncTask<RecyclerView,Integer,RecyclerView> {

    @Override
    protected RecyclerView doInBackground(RecyclerView... recyclerViews) {
        RecyclerView recyclerView=recyclerViews[0];
        RetrofitService retrofitService =new RetrofitService();
        AdherentApi adherentApi=   retrofitService.getRetrofit().create(AdherentApi.class);
        adherentApi.adherents().enqueue(new Callback<List<Adherent>>(){

            @Override
            public void onResponse(Call<List<Adherent>> call, Response<List<Adherent>> response) {
                AdherentAdapter adherentAdapter = new AdherentAdapter(response.body());
                recyclerView.setAdapter(adherentAdapter);

            }

            @Override
            public void onFailure(Call<List<Adherent>> call, Throwable t) {
                Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE,t.getMessage(),t);
//                Toast.makeText(listeadherent.this,t.getMessage(),Toast.LENGTH_SHORT).show();

            }});
        return recyclerView;
    }
    }

