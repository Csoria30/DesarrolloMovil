package com.ulp.trabajopractico3.ui.detalle;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ulp.trabajopractico3.R;
import com.ulp.trabajopractico3.databinding.FragmentDetalleBinding;
import com.ulp.trabajopractico3.databinding.FragmentEliminarBinding;
import com.ulp.trabajopractico3.ui.eliminar.EliminarViewModel;

public class DetalleFragment extends Fragment {
    private FragmentDetalleBinding binding;
    private DetalleViewModel viewModel;
    private String codigoParaEliminar;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(DetalleViewModel.class);
        binding = FragmentDetalleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Click Botons list
        binding.btnConfirmarEliminar.setOnClickListener(v -> {
            viewModel.eliminarProducto(codigoParaEliminar);
        });

        binding.btnCancelar.setOnClickListener(v -> {
            viewModel.cancelarEliminacion();
        });

        //Observers
        viewModel.getCodigoProducto().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String codigoTexto) {
                binding.tvCodigo.setText(codigoTexto);
            }
        });

        viewModel.getDescripcionProducto().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String descripcionTexto) {
                binding.tvDescripcion.setText(descripcionTexto);
            }
        });

        viewModel.getPrecioProducto().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String precioTexto) {
                binding.tvPrecio.setText(precioTexto);

            }
        });


        viewModel.getMsgeError().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String error) {
                Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
            }
        });

        viewModel.getNavegarAtras().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean navegar) {
                if(navegar != null && navegar) {
                    Navigation.findNavController(getView()).popBackStack();
                }
            }
        });

        Bundle data = getArguments();
        if(data != null) {
            String codigo = data.getString("codigo");
            String descripcion = data.getString("descripcion");
            double precio = data.getDouble("precio");
            String precioString = String.valueOf(precio);

            codigoParaEliminar = codigo;
            viewModel.cargarDatosProducto(codigo, descripcion, precioString);
        }


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}