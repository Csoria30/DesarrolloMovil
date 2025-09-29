package com.ulp.trabajopractico3.ui.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ulp.trabajopractico3.R;
import com.ulp.trabajopractico3.model.ProductoModel;

import java.util.List;

public class ListaProductosAdapter extends RecyclerView.Adapter<ListaProductosAdapter.ViewHolderProducto> {
    private List<ProductoModel> listaProductos;
    private Context context;
    private LayoutInflater layoutInflater;

    //Constructos
    public ListaProductosAdapter(List<ProductoModel> listaProductos, Context context, LayoutInflater layoutInflater){
        this.listaProductos = listaProductos;
        this.context = context;
        this.layoutInflater = layoutInflater;
    }

    @NonNull
    @Override
    public ViewHolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item, parent, false);
        return new ViewHolderProducto(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProducto holder, int position) {
        ProductoModel productoActual = listaProductos.get(position);
        holder.codigo.setText("Codigo: " + productoActual.getCodigo());
        holder.descripcion.setText("Descripción: " + productoActual.getDescripcion());
        holder.precio.setText("Precio: " + productoActual.getPrecio());
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    //Clase interna - Holder parametro
    public class ViewHolderProducto extends RecyclerView.ViewHolder{
        TextView codigo, descripcion, precio;

        public ViewHolderProducto(@NonNull View itemView) {
            super(itemView);
            codigo = itemView.findViewById(R.id.tvCodigoItem);
            descripcion = itemView.findViewById(R.id.tvDescripcionItem);
            precio = itemView.findViewById(R.id.tvPrecioItem);

        }
    }
}
