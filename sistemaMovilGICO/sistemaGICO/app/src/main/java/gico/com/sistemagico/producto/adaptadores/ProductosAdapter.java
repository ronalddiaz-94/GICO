package gico.com.sistemagico.producto.adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gico.com.sistemagico.R;
import gico.com.sistemagico.producto.clases.Producto;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ProductoViewHolder> implements View.OnClickListener {

    List<Producto> listaProductos;
    String precio;
    Double valor;
    private View.OnClickListener listener;

    public ProductosAdapter(List<Producto> listaProductos) {
        this.listaProductos=listaProductos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,null,false);
        view.setOnClickListener(this);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        valor=listaProductos.get(position).getProductPrice();
        precio= String.format("%.2f", valor).replace(" ", "0");
        holder.txtNomreProducto.setText(listaProductos.get(position).getProductName().toString());
        holder.txtDescripcionProducto.setText(listaProductos.get(position).getProductDescription().toString());
        holder.txtPrecioProducto.setText(precio);
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }
    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder{
        TextView txtNomreProducto, txtDescripcionProducto, txtPrecioProducto;
        public ProductoViewHolder(View itemView) {
            super(itemView);
            txtNomreProducto= (TextView) itemView.findViewById(R.id.txtNombreProducto);
            txtDescripcionProducto= (TextView) itemView.findViewById(R.id.txtDescripcionProducto);
            txtPrecioProducto= (TextView) itemView.findViewById(R.id.txtPrecioProducto);
        }
    }

    public void setFilter(List<Producto> newList){
        listaProductos=new ArrayList<>();
        listaProductos.addAll(newList);
        notifyDataSetChanged();
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
