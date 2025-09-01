package com.ulp.trabajopractico2.View;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
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

        // MODIFICAR EL TAMAÑO DEL ICONO
        // Obtenemos el drawable
        Drawable lupa = ContextCompat.getDrawable(this, R.drawable.lupa);

        // Ajustamos tamaño del drawable (en píxeles)
        int anchoIcono = 20;
        int altoIcono = 20;
        int ancho = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, anchoIcono, getResources().getDisplayMetrics());
        int alto  = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, altoIcono, getResources().getDisplayMetrics());
        lupa.setBounds(0, 0, ancho, alto);

        // Asignamos el drawable al inicio del EditText
        binding.etLibroBuscado.setCompoundDrawables(lupa, null, null, null);

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