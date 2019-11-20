package com.app.app_nu34life;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AccountActivity extends AppCompatActivity {
    private BottomNavigationView mainNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        mainNav = (BottomNavigationView) findViewById(R.id.navbar_item);
        Menu menu = mainNav.getMenu();
        MenuItem menuItem= menu.getItem(2);
        menuItem.setChecked(true);

        mainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home_navbar:
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.author_navbar:
                        Intent intent2 = new Intent(getApplicationContext(), FoodListActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.account_navbar:
                        break;

                }
                return false;
            }
        });

        onBackPressed();

    }

    @Override
    public void onBackPressed(){

    }

}
