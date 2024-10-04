package gico.com.sistemagico.producto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import gico.com.sistemagico.MainActivity;
import gico.com.sistemagico.R;
import gico.com.sistemagico.producto.clases.Producto;

public class reciboDevolucionProducto extends AppCompatActivity {
    Integer cantidad;
    TextView campoNombre, campoCantidad, campoFecha, campoTotal;
    Button imprimir, finalizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibo_devolucion_producto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        campoFecha = (TextView) findViewById(R.id.tvFechaProductoReciboDevolucion);
        campoCantidad = (TextView) findViewById(R.id.tvCantidadProductoReciboDevolucion);
        campoTotal = (TextView) findViewById(R.id.tvTotalProductoReciboDevolucion);
        campoNombre = (TextView) findViewById(R.id.tvNombreProductoReciboDevolucion);
        imprimir = (Button) findViewById(R.id.btnImprimirProductoReciboDevolucion);
        finalizar = (Button) findViewById(R.id.btnFinalizarProductoReciboDevolucion);

        Bundle productoEnviado= getIntent().getExtras();
        Producto p= null;

        if (productoEnviado!=null) {
            p = (Producto) productoEnviado.getSerializable("producto");
            cantidad= productoEnviado.getInt("Cantidad");
        }

        campoNombre.setText(p.getProductName().toString());
        campoCantidad.setText(cantidad.toString());
        final Double valor= cantidad * p.getProductPrice();
        campoTotal.setText(valor.toString());


        Calendar fechaHoy= Calendar.getInstance();
        int dia= fechaHoy.get(Calendar.DAY_OF_MONTH);
        int mes= fechaHoy.get(Calendar.MONTH) + 1;
        int anio= fechaHoy.get(Calendar.YEAR);
        campoFecha.setText(" "+anio+"-"+mes+"-"+dia+"");

        final Producto finalP = p;
        imprimir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Se imprime" , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(reciboDevolucionProducto.this, impresionDevolucion.class);
                Bundle bundle= new Bundle();
                bundle.putString("Nombre", finalP.getProductName().toString());
                bundle.putDouble("Cantidad", cantidad);
                bundle.putDouble("Total", valor);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(reciboDevolucionProducto.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
