package com.ulp.appmapa1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.SupportMapFragment;

public class MainActivity extends FragmentActivity {
    private MainActivityViewModel mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        setContentView(R.layout.activity_main);

        mv.getmMapa().observe(this, mapaActual -> {
            SupportMapFragment supportMapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.mapa);
            supportMapFragment.getMapAsync(mapaActual);
        });

        mv.cargarMapa();
    }
}