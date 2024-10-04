package gico.com.sistemagico.ventas;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gico.com.sistemagico.MainActivity;
import gico.com.sistemagico.R;
import gico.com.sistemagico.cliente.adaptadores.ClientesAdapter;
import gico.com.sistemagico.cliente.clases.Cliente;
import gico.com.sistemagico.cliente.interfaces.ClienteService;
import gico.com.sistemagico.generalGICO;
import gico.com.sistemagico.utilidades;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class clienteVentas extends AppCompatActivity  implements SearchView.OnQueryTextListener{

    RecyclerView recyclerClientes;
    List<Cliente> listaClientes, listaProvisional;
    ClientesAdapter adapter;
    ImageView home, next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_ventas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarVentasCliente);
        toolbar.setTitle("Clientes");
        setSupportActionBar(toolbar);
        ((generalGICO) getApplicationContext()).setTiempoInicio(System.currentTimeMillis());
        long tiempoInicio= System.currentTimeMillis();
        home= (ImageView) findViewById(R.id.ivVentasHome);
        next= (ImageView) findViewById(R.id.ivNextStep);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home= new Intent(getApplicationContext(),MainActivity.class);
                utilidades.validaPantalla=true;
                ((generalGICO) getApplicationContext()).clearProductList();
                ((generalGICO) getApplicationContext()).clearClient();
                startActivity(home);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((generalGICO) getApplicationContext()).getoCliente()==null){
                    final AlertDialog.Builder alertOpciones= new AlertDialog.Builder(clienteVentas.this);
                    alertOpciones.setTitle("Aviso");
                    alertOpciones.setMessage("No se ha escogido ningun cliente por lo que se asignara como consumidor final");
                    alertOpciones.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Cliente consFinal= new Cliente();
                            consFinal.setClientCell("9999999999");
                            consFinal.setClientCi("9999999999");
                            consFinal.setClientName("Consumidor Final");
                            consFinal.setClientId(1);
                            ((generalGICO) getApplicationContext()).setoCliente(consFinal);
                            Intent next= new Intent(getApplicationContext(),productoVentas.class);
                            startActivity(next);
                        }
                    });
                    alertOpciones.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alertOpciones.show();
                }else{
                    Intent next= new Intent(getApplicationContext(),productoVentas.class);
                    startActivity(next);
                }

            }
        });
        listaClientes= new ArrayList<>();
        recyclerClientes = (RecyclerView) findViewById(R.id.recyclerClienteVentas);
        recyclerClientes.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        llenarlista();

        adapter = new ClientesAdapter(listaClientes);

        recyclerClientes.setAdapter(adapter);

    }

    private void llenarlista() {
        Retrofit retrofit= new Retrofit.Builder().baseUrl("http://"+((generalGICO) getApplicationContext()).getDireccionIP()+":8080/GICO-AD/webresources/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ClienteService clienteservice= retrofit.create(ClienteService.class);
        final Call<List<Cliente>> lista = clienteservice.getClientes();
        lista.enqueue(new Callback<List<Cliente>>() {
            @Override
            public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
                if (response.isSuccessful()){
                    listaClientes = response.body();
                    adapter = new ClientesAdapter(listaClientes);

                    adapter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            listaProvisional=adapter.getListaCLiente();

                            final Cliente client= listaProvisional.get(recyclerClientes.getChildAdapterPosition(v));
                            final Intent intent = new Intent(getApplicationContext(),MainActivity.class);

                            final CharSequence[] opciones= {"Seleccionar cliente", "Cancelar"};
                            final AlertDialog.Builder alertOpciones= new AlertDialog.Builder(clienteVentas.this);
                            alertOpciones.setTitle("Seleccione una opción");
                            alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (opciones[which].equals("Seleccionar cliente")){
                                        ((generalGICO) getApplicationContext()).setoCliente(client);
                                        Toast.makeText(getApplicationContext(),"Cliente Asignado", Toast.LENGTH_SHORT).show();
                                    } else{
                                        dialog.dismiss();
                                    }
                                }
                            });
                            alertOpciones.show();
                        }
                    });
                    recyclerClientes.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Cliente>> call, Throwable t) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        SearchView searchView= (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText= newText.toLowerCase();
        List<Cliente> newList = new ArrayList<>();
        for (Cliente cliente : listaClientes){
            String name= cliente.getClientName().toLowerCase();
            String cedula= cliente.getClientCi().toLowerCase();
            String celular= cliente.getClientCell().toLowerCase();
            if (name.contains(newText) || cedula.contains(newText) || celular.contains(newText)){
                newList.add(cliente);
            }
        }
        adapter.setFilter(newList);
        return true;
    }
}
