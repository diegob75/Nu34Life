package com.app.fas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.app.fas.retrofit.JsonPlaceHolder;
import com.app.fas.retrofit.Recipe;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity  implements ListaRecipeAdapter.OnNoteListener{
    private static final String TAG ="CANCION";
    private ArrayList<Recipe> dataset = new ArrayList<>();
    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private ListaRecipeAdapter listacancionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =(RecyclerView) findViewById(R.id.recycler);
        listacancionAdapter = new ListaRecipeAdapter(this);
        recyclerView.setAdapter(listacancionAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://nu34life-api-boot.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerDatos();
    }

    private void obtenerDatos(){
        JsonPlaceHolder jsonPlaceHolderApi=retrofit.create(JsonPlaceHolder.class);
        Call<List<Recipe>> call=jsonPlaceHolderApi.getCancion();
        call.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                if(response.isSuccessful()) {

                    List<Recipe> canciones = response.body();
                    ArrayList<Recipe> listaCancion = (ArrayList) canciones;
                    dataset=(ArrayList) canciones;
                    listacancionAdapter.adicionarListaCancion(listaCancion,MainActivity.this::oneNoteClick);
                }else{
                    Log.e(TAG,"onResponse:" + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                Log.e(TAG,"onFailure:" + t.getMessage());
            }
        });
    }

    @Override
    public void oneNoteClick(int position){

        Toast.makeText(getApplicationContext(),"Cargando ...",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(),RecipeDetail.class);
        intent.putExtra("posicion",dataset.get(position).getId());
        startActivity(intent);
    }
}
