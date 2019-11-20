package com.app.app_nu34life;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.app_nu34life.retrofit.JsonPlaceHolder;
import com.app.app_nu34life.retrofit.Recipe;
import com.bumptech.glide.Glide;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeDetail extends AppCompatActivity  implements ListaRecipeAdapter.OnNoteListener {
    private static final String TAG ="CANCION";
    boolean val=false;
    private ImageView fotoImagen;
    private TextView txtNombre;
    private TextView textfood2;
    private Button retrocederbutton;
    private Retrofit retrofit;
    private Recipe recipe2;
    private RecyclerView recyclerView;

    private ListaFoodAdapter listaFoodAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        fotoImagen=(ImageView)findViewById(R.id.imagefood);
        txtNombre=(TextView)findViewById(R.id.textfood);
        recyclerView =(RecyclerView) findViewById(R.id.recycler);
        listaFoodAdapter = new ListaFoodAdapter(this);
        recyclerView.setAdapter(listaFoodAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        Bundle datos= getIntent().getExtras();

        int position= datos.getInt("posicion");

        retrofit = new Retrofit.Builder()

                .baseUrl("https://nu34life-api-boot.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        obtenerDatos( String.valueOf(position));
    }

    private void obtenerDatos(String position){
        JsonPlaceHolder jsonPlaceHolderApi=retrofit.create(JsonPlaceHolder.class);
        Call<Recipe> call=jsonPlaceHolderApi.getCancionbyId("recipes/"+position);
        call.enqueue(new Callback<Recipe>() {
            @Override
            public void onResponse(Call<Recipe> call, Response<Recipe> response) {
                if(response.isSuccessful()) {

                    Recipe canciones = response.body();
                    recipe2=canciones;

                    String url=recipe2.getImagen();
                    String named=recipe2.getName();
                    listaFoodAdapter.adicionarListaCancion(recipe2.getIngredients(),RecipeDetail.this::oneNoteClick);
                    Glide.with(RecipeDetail.this)
                            .load(url)
                            .into(fotoImagen);
                    txtNombre.setText(named);
                }else{
                    Log.e(TAG,"onResponse:" + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Recipe> call, Throwable t) {
                Log.e(TAG,"onFailure:" + t.getMessage());
            }
        });




    }
    @Override
    public void oneNoteClick(int position){
    }
}
