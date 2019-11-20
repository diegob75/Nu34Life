package com.app.app_nu34life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.app.app_nu34life.retrofit.Food;
import com.app.app_nu34life.retrofit.JsonPlaceHolder;
import com.app.app_nu34life.retrofit.NutrFact;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddFoodActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private EditText txt_Name;
    private TextView txt_Carbs;
    private TextView txt_Protein;
    private TextView txt_Fat;
    private TextView txt_Image;
    private JsonPlaceHolder jsonPlaceHolder;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        txt_Name=(EditText) findViewById(R.id.editname);
        txt_Carbs=(EditText) findViewById(R.id.editCarb);
        txt_Protein=(EditText) findViewById(R.id.editprotein);
        txt_Fat=(EditText) findViewById(R.id.editfat);
        txt_Image=(EditText) findViewById(R.id.editImage);
        button=(Button)findViewById(R.id.btn_Add);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://nu34life-api-boot.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolder=retrofit.create(JsonPlaceHolder.class);


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Food food= new Food();
                NutrFact nutrFact= new NutrFact();
                food.setName(txt_Name.getText().toString());
                food.setImage(txt_Image.getText().toString());
                food.setCreatedBy(0);

                nutrFact.setCarbohydrates(Integer.parseInt(txt_Carbs.getText().toString()));
                nutrFact.setProtein(Integer.parseInt(txt_Protein.getText().toString()));
                nutrFact.setTotalFat(Integer.parseInt(txt_Fat.getText().toString()));
                nutrFact.setEnergeticValue(0);
                nutrFact.setSalt(0);
                nutrFact.setSaturatedFats(0);
                nutrFact.setSugars(0);

                food.setNutrFact(nutrFact);


                Call<Food> call=jsonPlaceHolder.createFood(food);
            }
        });
    }

}
