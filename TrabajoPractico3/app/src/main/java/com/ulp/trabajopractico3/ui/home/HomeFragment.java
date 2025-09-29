package com.ulp.trabajopractico3.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ulp.trabajopractico3.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.cargarProducto(
                        binding.etCodigo.getText().toString(),
                        binding.etDescripcion.getText().toString(),
                        binding.etPrecio.getText().toString()
                );
            }
        });

        //Observer: Campos de error
        viewModel.getmError().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            }
        });

        //Observer: Campos Ok
        viewModel.getmCorrecto().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            }
        });


        //Observer: Formulario
        viewModel.getCampoCodigo().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String codigo) {
                binding.etCodigo.setText(codigo);
            }
        });

        viewModel.getCampoDescripcion().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String descripcion) {
                binding.etDescripcion.setText(descripcion);
            }
        });

        viewModel.getCampoPrecio().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String precio) {
                binding.etPrecio.setText(precio);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}