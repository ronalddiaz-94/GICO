package gico.com.sistemagico.bodega;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import gico.com.sistemagico.MainActivity;
import gico.com.sistemagico.R;
import gico.com.sistemagico.bodega.adaptadores.BodegaAdapter;
import gico.com.sistemagico.bodega.clases.Bodega;
import gico.com.sistemagico.bodega.interfaces.BodegaService;
import gico.com.sistemagico.generalGICO;
import gico.com.sistemagico.utilidades;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class asignarBodega extends AppCompatActivity {

    RecyclerView rvBodegas;
    List<Bodega> listaBodegas;
    BodegaAdapter adapter;
    Button btnAceptar;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignar_bodega);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rvBodegas=(RecyclerView) findViewById(R.id.recyclerBodegaAsignar);
        listaBodegas= new ArrayList<>();
        rvBodegas.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        llenarListaBodegas();
        adapter=new BodegaAdapter(listaBodegas);
        rvBodegas.setAdapter(adapter);

    }

    private void llenarListaBodegas() {
        Retrofit retrofit= new Retrofit.Builder().baseUrl("http://"+((generalGICO) getApplicationContext()).getDireccionIP()+":8080/GICO-AD/webresources/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BodegaService bodegaService= retrofit.create(BodegaService.class);
        Call<List<Bodega>> lista= bodegaService.getBodegas();
        lista.enqueue(new Callback<List<Bodega>>() {
            @Override
            public void onResponse(Call<List<Bodega>> call, Response<List<Bodega>> response) {
                if (response.isSuccessful()){
                    listaBodegas= response.body();
                    adapter= new BodegaAdapter(listaBodegas);

                    adapter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Bodega bodega= listaBodegas.get(rvBodegas.getChildAdapterPosition(v));
                            intent = new Intent(getApplicationContext(), MainActivity.class);
                            ((generalGICO) getApplicationContext()).setBodega(bodega.getCellarId().toString());
                            utilidades.validaPantalla=true;
                            startActivity(intent);
                        }
                    });
                    rvBodegas.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Bodega>> call, Throwable t) {

            }
        });
    }

}
