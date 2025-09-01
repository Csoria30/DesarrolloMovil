package com.ulp.trabajopractico2.View;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.ulp.trabajopractico2.R;
import com.ulp.trabajopractico2.ViewModel.DetallesActivityViewModel;
import com.ulp.trabajopractico2.databinding.ActivityDetallesBinding;

public class DetallesActivity extends AppCompatActivity {
    private ActivityDetallesBinding binding;
    private DetallesActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetallesBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(DetallesActivityViewModel.class);

        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvAutorLibro), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Observadores
        viewModel.getMuLibro().observe(this, libro ->{
            int imagenId = getResources().getIdentifier(libro.getPortadaUrl(), "drawable", getPackageName());

            binding.tvTitulo.setText(getString(R.string.titulo_label, libro.getTitulo()));
            binding.tvAutor.setText(getString(R.string.autor_label, libro.getAutor()));
            binding.tvGenero.setText(getString(R.string.genero_label, libro.getGenero()));
            binding.tvAnio.setText(getString(R.string.anio_label, libro.getAnio()));
            binding.tvDescripcion.setText(libro.getDescripcion());
            binding.imgPortada.setImageResource(imagenId);
        });

        viewModel.cargarDatos(getIntent());

        //Boton para volver
        binding.btnVolver.setOnClickListener( boton -> {
            //onBackPressed();
            finish();
        });
    }
}