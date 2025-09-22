package com.ulp.sensores;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ulp.sensores.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityViewModel mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        super.onCreate(savedInstanceState);

        setContentView(binding.getRoot());

        mv.getmDAtos().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvMostrar.setText(s);
            }
        });

        //mv.accederASensores();
        mv.activarLecturas();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mv.desactivarLecturas();
    }
}