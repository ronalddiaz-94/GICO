package gico.com.sistemagico.cliente.adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import gico.com.sistemagico.R;
import gico.com.sistemagico.cliente.clases.actividadesCliente;

public class HistorialClientAdapter extends RecyclerView.Adapter<HistorialClientAdapter.historialViewHolder> implements View.OnClickListener {
    //ESTE ADAPTADOR ES UTILIZADO PARA GENERAR LA LISTA DEL HISTORIAL DE PAGOS DEL CLIENTE EN SU RECYCLERVIEW

    List<actividadesCliente> listaHistorial;

    public HistorialClientAdapter( List<actividadesCliente> listaHistorial){
        this.listaHistorial=listaHistorial;
    }
    @NonNull
    @Override
    public historialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_historial, null, false);

        view.setOnClickListener(this);
        return new historialViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull historialViewHolder holder, int position) {
        holder.campoActividad.setText(listaHistorial.get(position).getActivityclientdescription());
        holder.campoFecha.setText(listaHistorial.get(position).getActivityclientdate());
        holder.campoCosto.setText(listaHistorial.get(position).getActivityclientcost().toString());
    }

    @Override
    public int getItemCount() {
        return listaHistorial.size();
    }

    @Override
    public void onClick(View v) {

    }


    public class historialViewHolder extends RecyclerView.ViewHolder{
        TextView campoFecha, campoCosto, campoActividad;
        public historialViewHolder(View itemView) {
            super(itemView);
            campoActividad= (TextView) itemView.findViewById(R.id.tvactividadcliente);
            campoFecha= (TextView) itemView.findViewById(R.id.tvfechaactividadcliente);
            campoCosto= (TextView) itemView.findViewById(R.id.tvvaloractividadcliente);
        }
    }
}
