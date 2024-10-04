package gico.com.sistemagico.cliente;

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
import gico.com.sistemagico.cliente.clases.Cliente;

public class reciboAbonoCliente extends AppCompatActivity {
    Double saldo, abono;
    TextView campoNombre, campoCedula, campoSaldo,campoAbono, campoFecha;
    Button imprimir, finalizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibo_abono_cliente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        campoFecha = (TextView) findViewById(R.id.tvFechaClienteReciboAbono);
        campoSaldo = (TextView) findViewById(R.id.tvSaldoClienteReciboAbono);
        campoAbono = (TextView) findViewById(R.id.tvAbonoClienteReciboAbono);
        campoCedula = (TextView) findViewById(R.id.tvCedulaClienteReciboAbono);
        campoNombre = (TextView) findViewById(R.id.tvNombreClienteReciboAbono);
        imprimir = (Button) findViewById(R.id.btnImprimirClienteReciboAbono);
        finalizar = (Button) findViewById(R.id.btnFinalizarClienteReciboAbono);

        Bundle clienteEnviado= getIntent().getExtras();
        Cliente c= null;

        if (clienteEnviado!=null) {
            c = (Cliente) clienteEnviado.getSerializable("cliente");
            saldo= clienteEnviado.getDouble("Saldo");
            abono= clienteEnviado.getDouble("Abono");
        }

        campoNombre.setText(c.getClientName().toString());
        campoCedula.setText(c.getClientCi().toString());
        campoAbono.setText(abono.toString());
        campoSaldo.setText(saldo.toString());

        Calendar fechaHoy= Calendar.getInstance();
        int dia= fechaHoy.get(Calendar.DAY_OF_MONTH);
        int mes= fechaHoy.get(Calendar.MONTH) + 1;
        int anio= fechaHoy.get(Calendar.YEAR);
        campoFecha.setText(" "+anio+"-"+mes+"-"+dia+"");

        final Cliente finalC = c;
        imprimir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Se imprime" , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(reciboAbonoCliente.this, impresionAbono.class);
                Bundle bundle= new Bundle();
                bundle.putString("Nombre", finalC.getClientName().toString());
                bundle.putDouble("Saldo", saldo);
                bundle.putDouble("Abono", abono);
                bundle.putString("Cedula", finalC.getClientCi().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(reciboAbonoCliente.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
