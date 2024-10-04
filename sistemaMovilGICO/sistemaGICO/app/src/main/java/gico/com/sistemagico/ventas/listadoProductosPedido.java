package gico.com.sistemagico.ventas;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import gico.com.sistemagico.R;
import gico.com.sistemagico.generalGICO;
import gico.com.sistemagico.producto.clases.Producto;

public class listadoProductosPedido extends AppCompatActivity {

    ListView listView;
    ArrayList<Producto> pedido=new ArrayList<Producto>();
    ArrayList<String> productosArray=new ArrayList<String>();
    ImageView atras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_productos_pedido);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        atras = (ImageView) findViewById(R.id.ivRegresarPedidoProducto);
        listView = (ListView) findViewById(R.id.lvPedidoProductos);
        pedido = ((generalGICO) getApplicationContext()).getListaProductosVentaImpresion();
        if (pedido.size()>0){
            for (int x=0; x<pedido.size(); x++){
                productosArray.add("* "+pedido.get(x).getProductCount().toString()+" x "+pedido.get(x).getProductName().toString()+"");
            }
        }else {
            productosArray.add("No existen productos en pedido");
        }

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,productosArray);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final CharSequence[] opciones={"Quitar del pedido","Cancelar"};
                final AlertDialog.Builder alertOpciones= new AlertDialog.Builder(listadoProductosPedido.this);
                alertOpciones.setTitle("Seleccione una opción");
                final int pos=position;
                alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (opciones[which].equals("Quitar del pedido")){
                            pedido.remove(pos);
                            ((generalGICO) getApplicationContext()).setListaProductosVenta(pedido);
                            ((generalGICO) getApplicationContext()).setListaProductosVentaImpresion(pedido);
                            finish();
                            startActivity(getIntent());
                        } else {
                            dialog.dismiss();
                        }
                    }
                });
                alertOpciones.show();

            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next= new Intent(getApplicationContext(),productoVentas.class);
                startActivity(next);
            }
        });


    }

}
