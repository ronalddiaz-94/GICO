package gico.com.sistemagico.bodega.adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import gico.com.sistemagico.R;
import gico.com.sistemagico.bodega.clases.Bodega;

public class BodegaAdapter extends RecyclerView.Adapter<BodegaAdapter.BodegaViewHolder> implements View.OnClickListener {
    List<Bodega> listaBodegas;
    private View.OnClickListener listener;

    public BodegaAdapter (List<Bodega> listaBodegas){
        this.listaBodegas=listaBodegas;
    }

    @NonNull
    @Override
    public BodegaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bodega, null,false);
        view.setOnClickListener(this);
        return new BodegaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BodegaViewHolder holder, int position) {
        holder.campoNombreBodega.setText(listaBodegas.get(position).getCellarName().toString());
    }

    @Override
    public int getItemCount() {
        return listaBodegas.size();
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

    public class BodegaViewHolder extends RecyclerView.ViewHolder{
        TextView campoNombreBodega;
        public BodegaViewHolder(View itemView) {
            super(itemView);
            campoNombreBodega= (TextView) itemView.findViewById(R.id.txtNombreBodegaSeleccion);
        }
    }

    public List<Bodega> getListaBodegas() {
        return listaBodegas;
    }

    public void setListaBodegas(List<Bodega> listaBodegas) {
        this.listaBodegas = listaBodegas;
    }
}
