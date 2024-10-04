package gico.com.sistemagico.cliente;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gico.com.sistemagico.MainActivity;
import gico.com.sistemagico.R;
import gico.com.sistemagico.cliente.adaptadores.HistorialClientAdapter;
import gico.com.sistemagico.cliente.clases.Cliente;
import gico.com.sistemagico.cliente.clases.actividadesCliente;
import gico.com.sistemagico.cliente.interfaces.ActividadClienteService;
import gico.com.sistemagico.generalGICO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class historialCliente extends AppCompatActivity {

    RecyclerView rvHistorial;
    List<actividadesCliente> listaActividades;
    HistorialClientAdapter adapter;
    Button btnAceptar;
    TextView campoNombre, campoCedula;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_cliente);
        rvHistorial= (RecyclerView) findViewById(R.id.recyclerHistorialClient);
        campoCedula= (TextView) findViewById(R.id.tvCedulaClienteHistorial);
        campoNombre= (TextView) findViewById(R.id.tvNombreClienteHistorial);
        btnAceptar= (Button) findViewById(R.id.btnAceptarHistoriall);
        listaActividades = new ArrayList<>();

        rvHistorial.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        
        llenarLista();

        adapter= new HistorialClientAdapter(listaActividades);

        rvHistorial.setAdapter(adapter);


        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent= new Intent(historialCliente.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void llenarLista() {
        Retrofit retrofit= new Retrofit.Builder().baseUrl("http://"+((generalGICO) getApplicationContext()).getDireccionIP()+":8080/GICO-AD/webresources/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ActividadClienteService actividadClienteService= retrofit.create(ActividadClienteService.class);

        Bundle clienteEnviado= getIntent().getExtras();
        Cliente c= null;
        if (clienteEnviado!=null) {
            c = (Cliente) clienteEnviado.getSerializable("cliente");
        }
        campoNombre.setText(c.getClientName().toString());
        campoCedula.setText(c.getClientCi().toString());

        Call<List<actividadesCliente>> lista= actividadClienteService.getActividades(c);
        lista.enqueue(new Callback<List<actividadesCliente>>() {
            @Override
            public void onResponse(Call<List<actividadesCliente>> call, Response<List<actividadesCliente>> response) {
                if (response.isSuccessful()){
                    listaActividades= response.body();
                    adapter= new HistorialClientAdapter(listaActividades);
                    rvHistorial.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<actividadesCliente>> call, Throwable t) {

            }
        });
    }

}
