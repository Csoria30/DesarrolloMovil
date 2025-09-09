package com.ulp.ejemplomenu2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.ulp.ejemplomenu2.R;
import com.ulp.ejemplomenu2.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel mv;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mv = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String palabraBuscada = binding.etPalabraBuscada.getText().toString();

                // Coleccion de elementos - Envio de datos entre Fragments
                Bundle bundle = new Bundle();
                bundle.putString("palabra", palabraBuscada);

                int fragmentAInflar = R.id.nav_host_fragment_content_main;
                int frangmentDestino = R.id.resultadoFragment;
                Navigation.findNavController(getActivity(), fragmentAInflar).navigate(frangmentDestino, bundle);
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