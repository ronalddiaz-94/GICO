package gico.com.sistemagico.ventas;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gico.com.sistemagico.MainActivity;
import gico.com.sistemagico.R;
import gico.com.sistemagico.generalGICO;
import gico.com.sistemagico.producto.adaptadores.CamionAdapter;
import gico.com.sistemagico.producto.clases.Bodega;
import gico.com.sistemagico.producto.clases.Producto;
import gico.com.sistemagico.producto.interfaces.CamionService;
import gico.com.sistemagico.utilidades;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class productoVentas extends AppCompatActivity  implements  SearchView.OnQueryTextListener{

    RecyclerView rvCamion;
    List<Producto> listaProductos, listaProvisionalProductos;
    CamionAdapter adapter;
    ImageView home, next, last, clear, seeList;
    ArrayList<Producto> listaPedido= new ArrayList<Producto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_ventas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarVentasProducto);
        toolbar.setTitle("Productos");
        setSupportActionBar(toolbar);


        home= (ImageView) findViewById(R.id.ivVentasHome);
        next= (ImageView) findViewById(R.id.ivNextStep);
        last= (ImageView) findViewById(R.id.ivLastStep);
        seeList= (ImageView) findViewById(R.id.ivSeeList);
        clear= (ImageView) findViewById(R.id.ivClearList);

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
                if (((generalGICO) getApplicationContext()).getoCliente()!=null){
                    if(((generalGICO) getApplicationContext()).getListaProductosVenta().size()>0){
                        Intent next= new Intent(getApplicationContext(),pagoVentas.class);
                        startActivity(next);
                    }
                    else{
                        AlertDialog.Builder alertOpciones= new AlertDialog.Builder(productoVentas.this);
                        alertOpciones.setTitle("Aviso");
                        alertOpciones.setMessage("No se ha pedido ningun producto");
                        alertOpciones.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        alertOpciones.show();
                    }
                } else{
                    Toast.makeText(getApplicationContext(), "Cliente no asignado", Toast.LENGTH_SHORT).show();
                }

            }
        });

        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent last= new Intent(getApplicationContext(),clienteVentas.class);
                startActivity(last);
            }
        });

        seeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next= new Intent(getApplicationContext(),listadoProductosPedido.class);
                startActivity(next);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertLimpiar= new AlertDialog.Builder(productoVentas.this);
                alertLimpiar.setTitle("Vaciar lista de pedido");
                alertLimpiar.setCancelable(false);
                alertLimpiar.setMessage("¿Seguro desea vaciar la lista de pedido?");
                alertLimpiar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((generalGICO) getApplicationContext()).clearProductList();
                        Toast.makeText(getApplicationContext(), "Se vacio la lista de pedido", Toast.LENGTH_SHORT).show();
                    }
                });
                alertLimpiar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "No se vacio la lista de pedido", Toast.LENGTH_SHORT).show();
                    }
                });
                alertLimpiar.show();

            }
        });

        rvCamion= (RecyclerView) findViewById(R.id.recyclerProductosVentas);
        rvCamion.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        listaProductos = new ArrayList<>();

        llenarListaCamion();

        adapter= new CamionAdapter(listaProductos);
        rvCamion.setAdapter(adapter);
    }

    private void llenarListaCamion() {

        Retrofit retrofit= new Retrofit.Builder().baseUrl("http://"+((generalGICO) getApplicationContext()).getDireccionIP()+":8080/GICO-AD/webresources/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CamionService camionService= retrofit.create(CamionService.class);
        Bodega b= new Bodega();
        String cellar= ((generalGICO) getApplicationContext()).getBodega();
        int cellarid= Integer.parseInt(cellar);
        b.setCellarId(cellarid);
        Call<List<Producto>> lista=camionService.getProductosBodega(b);
        lista.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if(response.isSuccessful()){
                    listaProductos= response.body();
                    adapter= new CamionAdapter(listaProductos);

                    adapter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            listaProvisionalProductos= adapter.getListaProductos();

                            final Producto producto= listaProvisionalProductos.get(rvCamion.getChildAdapterPosition(v));
                            final Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            final AlertDialog.Builder alertOpciones= new AlertDialog.Builder(productoVentas.this);
                            alertOpciones.setTitle("Seleccione la cantidad de producto");
                            alertOpciones.setCancelable(false);

                            final EditText cantidad= new EditText(productoVentas.this);
                            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
                            cantidad.setLayoutParams(layoutParams);
                            cantidad.setBackgroundColor(Color.parseColor("#9797A3"));
                            cantidad.setInputType(2); // 2 es tipo numerico
                            cantidad.setHint("Cantidad del producto");
                            cantidad.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                            alertOpciones.setView(cantidad);//Agregamos el edit text al alert dialog


                            alertOpciones.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    if (Double.parseDouble(cantidad.getText().toString()) <= producto.getProductCount()){
                                        listaPedido= ((generalGICO) getApplicationContext()).getListaProductosVenta();
                                        int bandera=1;
                                        for(int x=0;x<listaPedido.size(); x++){
                                            if (listaPedido.get(x).getProductId() == producto.getProductId()){
                                                bandera=0;
                                                if ((Double.parseDouble(cantidad.getText().toString())+listaPedido.get(x).getProductCount()) <= producto.getProductCount()){
                                                    listaPedido.get(x).setProductCount(Double.parseDouble(cantidad.getText().toString())+listaPedido.get(x).getProductCount());
                                                    Toast.makeText(getApplicationContext(),"Producto actualizado en el pedido", Toast.LENGTH_SHORT).show();
                                                } else{
                                                    Toast.makeText(getApplicationContext(),"El producto seleccionado ya se encuentra en el pedido y la cantidad solicitada excede la existencia en el camion", Toast.LENGTH_LONG).show();
                                                }
                                                x=listaPedido.size();
                                            }else {
                                                bandera=1;
                                            }
                                        }
                                        if (bandera==1){
                                            ((generalGICO) getApplicationContext()).addProductList(producto, Double.parseDouble(cantidad.getText().toString()));
                                            Toast.makeText(getApplicationContext(),"Producto agregado al pedido", Toast.LENGTH_SHORT).show();
                                        }
                                    }else {
                                        Toast.makeText(getApplicationContext(),"La cantidad pedida excede a la existencia en el camion", Toast.LENGTH_LONG).show();
                                    }
                                    finish();
                                    startActivity(getIntent());
                                }
                            });

                            alertOpciones.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });

                            alertOpciones.show();
                        }
                    });

                    rvCamion.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        SearchView searchView= (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        List<Producto> newList=new ArrayList<>();
        for (Producto producto: listaProductos){
            String name= producto.getProductName().toLowerCase();
            String descripcion= producto.getProductDescription().toLowerCase();
            String precio=producto.getProductPrice().toString().toLowerCase();
            String cantidad=producto.getProductCount().toString().toLowerCase();
            if (name.contains(newText) || descripcion.contains(newText) || precio.contains(newText) || cantidad.contains(newText)){
                newList.add(producto);
            }
        }
        adapter.setFilter(newList);
        return true;
    }
}
