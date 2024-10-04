package gico.com.sistemagico.cliente.adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gico.com.sistemagico.R;
import gico.com.sistemagico.cliente.clases.Cliente;

public class ClientesAdapter extends RecyclerView.Adapter<ClientesAdapter.ClienteViewHolder>
    implements View.OnClickListener{
    //ESTE ADAPTADOR SE UTILIZA PARA EL PROCESO DE MOSTRAR LA INFORMACION EN EL RECYCLERVIEW DE CLIENTES
    List<Cliente> listaCLiente;
    String credito;
    Double precio;
    private View.OnClickListener listener;

    public ClientesAdapter(List<Cliente> listaCLiente) {
        this.listaCLiente = listaCLiente;
    }

    @NonNull
    @Override
    public ClienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_client, null, false);

        view.setOnClickListener(this);
        return new ClienteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClienteViewHolder holder, int position) {
        precio=listaCLiente.get(position).getClientCredit();
        credito= String.format("%.2f", precio).replace(" ", "0");
        holder.txtNombre.setText(listaCLiente.get(position).getClientName());
        holder.txtCredito.setText(credito);
        holder.txtCelular.setText(listaCLiente.get(position).getClientCell());
        holder.txtCedula.setText(listaCLiente.get(position).getClientCi());
        holder.txtMail.setText(listaCLiente.get(position).getClientMail());
    }

    @Override
    public int getItemCount() {
        return listaCLiente.size();
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

    public class ClienteViewHolder extends RecyclerView.ViewHolder{
        TextView txtNombre, txtCelular, txtCredito, txtMail, txtCedula ;

        public ClienteViewHolder(View itemView) {
            super(itemView);
            txtNombre= (TextView) itemView.findViewById(R.id.txtNombre);
            txtCelular= (TextView) itemView.findViewById(R.id.txtCelular);
            txtCredito = (TextView) itemView.findViewById(R.id.txtCredito);
            txtMail= (TextView) itemView.findViewById(R.id.txtMail);
            txtCedula= (TextView) itemView.findViewById(R.id.txtCedula);
        }
    }

    public void  setFilter(List<Cliente> newList){
        listaCLiente= new ArrayList<>();
        listaCLiente.addAll(newList);
        notifyDataSetChanged();
    }

    public List<Cliente> getListaCLiente() {
        return listaCLiente;
    }

    public void setListaCLiente(List<Cliente> listaCLiente) {
        this.listaCLiente = listaCLiente;
    }
}
