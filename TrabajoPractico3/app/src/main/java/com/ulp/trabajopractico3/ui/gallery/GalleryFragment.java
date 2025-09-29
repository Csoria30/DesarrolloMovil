package com.ulp.trabajopractico3.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.ulp.trabajopractico3.databinding.FragmentGalleryBinding;
import com.ulp.trabajopractico3.model.ProductoModel;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private GalleryViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(GalleryViewModel.class);
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Observador
        viewModel.getListaProductos().observe(getViewLifecycleOwner(), new Observer<List<ProductoModel>>() {
            @Override
            public void onChanged(List<ProductoModel> productos) {
                ListaProductosAdapter listaProductosAdapter = new ListaProductosAdapter(
                        (ArrayList<ProductoModel>) productos,
                        getContext(),
                        getLayoutInflater()
                );
                GridLayoutManager glm = new GridLayoutManager(
                        getContext(),
                        1,
                        GridLayoutManager.VERTICAL,
                        false
                );
                binding.rvLista.setLayoutManager(glm);
                binding.rvLista.setAdapter(listaProductosAdapter);
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