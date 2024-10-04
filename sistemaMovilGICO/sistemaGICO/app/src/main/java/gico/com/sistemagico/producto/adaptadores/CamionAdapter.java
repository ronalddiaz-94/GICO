package gico.com.sistemagico.producto.adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import gico.com.sistemagico.R;
import gico.com.sistemagico.producto.clases.Producto;

public class CamionAdapter extends RecyclerView.Adapter<CamionAdapter.CamionViewHolder> implements View.OnClickListener {

    List<Producto> listaProductos;
    String precio;
    Double valor;
    private View.OnClickListener listener;

    public CamionAdapter(List<Producto> listaProductos){
        this.listaProductos=listaProductos;
    }

    @NonNull
    @Override
    public CamionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_camion, null,false);
        view.setOnClickListener(this);
        return new CamionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CamionViewHolder holder, int position) {
        valor=listaProductos.get(position).getProductPrice();
        precio= String.format("%.2f", valor).replace(" ", "0");
        holder.txtNombreProducto.setText(listaProductos.get(position).getProductName().toString());
        holder.txtDescripcionProducto.setText(listaProductos.get(position).getProductDescription().toString());
        holder.txtCantidadProducto.setText(listaProductos.get(position).getProductCount().toString());
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

    public class CamionViewHolder extends RecyclerView.ViewHolder{
        TextView txtNombreProducto, txtDescripcionProducto, txtPrecioProducto, txtCantidadProducto;
        public CamionViewHolder(View itemView) {
            super(itemView);
            txtNombreProducto= (TextView) itemView.findViewById(R.id.txtNombreProductoCamion);
            txtDescripcionProducto= (TextView) itemView.findViewById(R.id.txtDescripcionProductoCamion);
            txtCantidadProducto= (TextView) itemView.findViewById(R.id.txtCantidadProductoCamion);
            txtPrecioProducto= (TextView) itemView.findViewById(R.id.txtPrecioProductoCamion);
        }
    }


    public void  setFilter(List<Producto> newList){
        listaProductos= new ArrayList<>();
        listaProductos.addAll(newList);
        notifyDataSetChanged();
    }

    public List<Producto> getListaProductos(){
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
