package com.ulp.trabajopractico3.ui.eliminar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import com.ulp.trabajopractico3.R;
import com.ulp.trabajopractico3.databinding.FragmentEliminarBinding;
import com.ulp.trabajopractico3.model.ProductoModel;

public class EliminarFragment extends Fragment {
    private FragmentEliminarBinding binding;
    private EliminarViewModel viewModel;

    public static EliminarFragment newInstance() {
        return new EliminarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(EliminarViewModel.class);
        binding = FragmentEliminarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Observer: Botop
        binding.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.buscarProducto(binding.etCodigoEliminar.getText().toString());
            }
        });

        //Observer: Msge Error
        viewModel.getMsgeError().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String error) {
                Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
            }
        });

        //Observer: Ok
        viewModel.getProductoEncontrado().observe(getViewLifecycleOwner(), new Observer<ProductoModel>() {
            @Override
            public void onChanged(ProductoModel producto) {

                Bundle bundle = new Bundle();
                bundle.putString("codigo", producto.getCodigo());
                bundle.putString("descripcion", producto.getDescripcion());
                bundle.putDouble("precio", producto.getPrecio());

            }
        });

        //Observer: Limpiar Campos del formulario
        viewModel.getCampoCodigo().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String codigo) {
                binding.etCodigoEliminar.setText(codigo);
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