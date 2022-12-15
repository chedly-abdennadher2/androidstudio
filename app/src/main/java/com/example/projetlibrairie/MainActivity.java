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
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                    Intent intent=new Intent(MainActivity.this,AdherentActivity.class);
                    startActivity(intent);
                    break;
                }
                case R.id.Livre: {
                    Intent intent=new Intent(MainActivity.this,LivreActivity.class);
                    startActivity(intent);
                    break;
            }
                case R.id.Exemplaire:{
                    Intent intent=new Intent(MainActivity.this,ExemplaireActivity.class);
                    startActivity(intent);
                    break;
                }
                case R.id.Emprunt: {
                    Intent intent=new Intent(MainActivity.this,EmpruntActivity.class);
                    startActivity(intent);
                }
                case R.id.exit:{
                    System.exit(0);
                    break;
                }
            }

            return super.onOptionsItemSelected(item);
        }

}