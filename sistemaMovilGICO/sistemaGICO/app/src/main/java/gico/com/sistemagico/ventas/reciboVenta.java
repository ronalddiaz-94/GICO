package gico.com.sistemagico.ventas;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import gico.com.sistemagico.R;
import gico.com.sistemagico.cliente.clases.Cliente;
import gico.com.sistemagico.generalGICO;
import gico.com.sistemagico.producto.clases.Producto;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.Set;
import java.util.UUID;

public class reciboVenta extends AppCompatActivity {
    ListView listView;
    ArrayList<Producto> pedido=new ArrayList<Producto>();
    ArrayList<String> productosArray=new ArrayList<String>();
    ImageView imprimir;
    TextView campoSubtotal, campoTotal, campoIVA;
    String descripcion, fix;
    int cantidad, conectividad=0, impresion=0;
    Double precio=0.00, precioSubtotal=0.00, precioTotal=0.00, precioIVA=0.00, valorSubtotalIVA=0.00;
    double cantP;
    Cliente cliente=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibo_venta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        campoIVA = (TextView) findViewById(R.id.tvIVAReciboVenta);
        campoSubtotal = (TextView) findViewById(R.id.tvSubtotalReciboVenta);
        campoTotal = (TextView) findViewById(R.id.tvTotalReciboVenta);
        imprimir = (ImageView) findViewById(R.id.ivImprimirReciboVenta);
        listView = (ListView) findViewById(R.id.lvReciboVenta);
        pedido = ((generalGICO) getApplicationContext()).getListaProductosVenta();
        cliente= ((generalGICO) getApplicationContext()).getoCliente();
        if (pedido.size()>0){
            for (int x=0; x<pedido.size(); x++){
                precio= pedido.get(x).getProductCount() * pedido.get(x).getProductPrice();
                precioSubtotal= precioSubtotal + precio;
                cantP = pedido.get(x).getProductCount();
                descripcion= pedido.get(x).getProductName().toString();
                if (pedido.get(x).getProductIva()>0){
                    valorSubtotalIVA= valorSubtotalIVA + (pedido.get(x).getProductPrice() * pedido.get(x).getProductCount());
                }
                if (descripcion.length()>15){
                    descripcion= descripcion.substring(0,descripcion.length() - 15);
                }
                if (descripcion.length()<15){
                    descripcion= String.format("%-15s", descripcion).replace(" ", "_");
                }
                String valor= String.format("%.2f", precio).replace(" ", "0");
                cantidad= (int) cantP;
                productosArray.add(""+descripcion+"                               "+cantidad+"             "+valor+"");
            }
        }else {
            productosArray.add("No existen productos en pedido");
        }

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,productosArray);

        listView.setAdapter(adapter);

        precioIVA=valorSubtotalIVA * (0.12);
        precioTotal= precioSubtotal+ precioIVA;
        fix= String.format("%.2f", precioIVA);
        campoIVA.setText(fix);
        ((generalGICO) getApplicationContext()).setValoriva(fix);
        fix= String.format("%.2f", precioSubtotal);
        campoSubtotal.setText(fix);
        ((generalGICO) getApplicationContext()).setValorsubtotal(fix);
        fix= String.format("%.2f", precioTotal);
        campoTotal.setText(fix);
        ((generalGICO) getApplicationContext()).setValortotal(fix);
        ((generalGICO) getApplicationContext()).setoClienteImpresion(((generalGICO) getApplicationContext()).getoCliente());
        ((generalGICO) getApplicationContext()).clearClient();
        ((generalGICO) getApplicationContext()).clearProductList();
        imprimir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent impresion= new Intent(getApplicationContext(), impresionVenta.class);
                    startActivity(impresion);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }





}
