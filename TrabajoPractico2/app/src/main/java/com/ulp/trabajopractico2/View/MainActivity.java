package com.ulp.trabajopractico2.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.ulp.trabajopractico2.R;
import com.ulp.trabajopractico2.ViewModel.MainActivityViewModel;
import com.ulp.trabajopractico2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvAutorLibro), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Observadores
        viewModel.getmLibro().observe(this, libro ->{
            Intent intent = new Intent(this, DetallesActivity.class);
            intent.putExtra("libro", libro);
            startActivity(intent);;
        });

        viewModel.getMensaje().observe(this, mensaje ->{
            binding.tvError.setText(mensaje);
        });

        //Listener Boton
        binding.btnBuscar.setOnClickListener( b -> {
            viewModel.buscarLibro(binding.etLibroBuscado.getText().toString());
        });


    }
}