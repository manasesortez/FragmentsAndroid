package com.amtodev.exserciseactionbar;

import static android.content.ClipData.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Fragment fragmentAbout, fragmentContact, fragmentConfig;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentAbout = new aboutUs();
        fragmentContact = new addContact();
        fragmentConfig = new Configuration();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_group_24);
        toolbar.setTitle("Administrar Clientes");
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(getApplicationContext(),"your icon was clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        switch(item.getItemId()){

            case R.id.item1:
                FragmentTransaction transaccion = getSupportFragmentManager().beginTransaction();
                transaccion.replace(R.id.contenedorFragment,fragmentContact, null).commit();
                Toast.makeText(getApplicationContext(),"Add Contact",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                FragmentTransaction transaccion2 = getSupportFragmentManager().beginTransaction();
                transaccion2.replace(R.id.contenedorFragment,fragmentConfig, null).commit();
                Toast.makeText(getApplicationContext(),"Configurar",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                FragmentTransaction transaccion3 = getSupportFragmentManager().beginTransaction();
                transaccion3.replace(R.id.contenedorFragment, fragmentAbout, null).commit();
                Toast.makeText(getApplicationContext(),"About US",Toast.LENGTH_SHORT).show();
                return true;

        }
        return super.onOptionsItemSelected(item);

    }
}