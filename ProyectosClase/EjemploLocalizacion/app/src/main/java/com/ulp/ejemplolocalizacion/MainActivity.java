package com.ulp.ejemplolocalizacion;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        solicitarPermisos();
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        viewModel.getMLocation().observe(this, new Observer<Location>() {
            @Override
            public void onChanged(Location location) {


                if (location != null) {
                    Toast.makeText(MainActivity.this, "Lat: " + location.getLatitude() + " Long: " + location.getLongitude(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Ubicación no disponible", Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewModel.obtenerUbicacion();

    }

    public void solicitarPermisos(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M
                && (checkSelfPermission(ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)  ||
                (checkSelfPermission(ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED)){
            requestPermissions(new String[]{ACCESS_FINE_LOCATION,ACCESS_COARSE_LOCATION},1000);
        }
    }


}