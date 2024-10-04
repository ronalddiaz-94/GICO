package gico.com.sistemagico.cliente;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import gico.com.sistemagico.MainActivity;
import gico.com.sistemagico.R;
import gico.com.sistemagico.cliente.clases.Cliente;
import gico.com.sistemagico.generalGICO;

public class creditoCliente extends AppCompatActivity {

    EditText campoAbono;
    TextView campoNombre, campoCredito, campoCedula;
    Button btnAbonar, btnCancelarAbno;
    Intent intent;
    ProgressDialog progreso;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credito_cliente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        campoAbono= (EditText) findViewById(R.id.etAbonoCliente);
        campoCredito= (TextView) findViewById(R.id.etCreditoCliente);
        campoCedula= (TextView) findViewById(R.id.etCICliente);
        campoNombre= (TextView) findViewById(R.id.etNombreCliente);
        btnAbonar= (Button) findViewById(R.id.btnRealizarAbono);
        btnCancelarAbno= (Button)findViewById(R.id.btnCancelarAbono);

        Bundle clienteEnviado= getIntent().getExtras();
        Cliente client=null;

        if (clienteEnviado!=null){
            client= (Cliente) clienteEnviado.getSerializable("cliente");
            campoNombre.setText(client.getClientName().toString());
            campoCredito.setText(client.getClientCredit().toString());
            campoCedula.setText(client.getClientCi().toString());
        }

        btnCancelarAbno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent= new Intent(creditoCliente.this, MainActivity.class);
                startActivity(intent);
            }
        });

        request = Volley.newRequestQueue(this);
        final Cliente finalClient = client;

        btnAbonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double credito = Double.parseDouble(campoCredito.getText().toString());
                if (campoAbono.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(),"Ingrese el valor del abono", Toast.LENGTH_SHORT).show();
                }else if (Double.parseDouble(campoAbono.getText().toString()) > credito){
                    Toast.makeText(getApplicationContext(),"El abono no puede ser mayor al credito", Toast.LENGTH_SHORT).show();
                }else {
                    cargarServicioWeb(finalClient);
                }
            }
        });

    }

    private void cargarServicioWeb(final Cliente c) {
        final Cliente client = c;
        progreso = new ProgressDialog(this);
        progreso.setMessage("Cargando...");
        progreso.show();

        String url = "http://"+((generalGICO) getApplicationContext()).getDireccionIP()+":8080/GICO-AD/webresources/client/abonoClient";

        Map<String,String> params = new HashMap<>();
        String clientId = c.getClientId().toString();
        String clientCi = c.getClientCi().toString();
        String clientName = c.getClientName().toString();
        String clientPhone = c.getClientPhone().toString();
        String clientCell = c.getClientCell().toString();
        String clientMail = c.getClientMail().toString();
        String clientAddress = c.getClientAddress().toString();


        //Double credit= c.getClientCredit();

        BigDecimal credit1= new BigDecimal(c.getClientCredit().toString());
        credit1= credit1.setScale(2, BigDecimal.ROUND_CEILING);
        BigDecimal abono1= new BigDecimal(campoAbono.getText().toString());
        abono1= abono1.setScale(2, BigDecimal.ROUND_DOWN);
        final Double abono= Double.parseDouble(abono1.toString());
        Double credit= Double.parseDouble(credit1.toString());
        credit= credit-abono;

        String clientCredit = credit.toString();
        String clientPay= abono.toString();

        params.put("clientId", clientId);
        params.put("clientCi", clientCi);
        params.put("clientName", clientName);
        params.put("clientPhone", clientPhone);
        params.put("clientCell", clientCell);
        params.put("clientMail", clientMail);
        params.put("clientCredit", clientCredit);
        params.put("clientAddress", clientAddress);
        params.put("clientPay", clientPay);


        JSONObject parameters = new JSONObject(params);

        JsonObjectRequest jsonObjectRequest = null;

        final Double finalCredit = credit;
        jsonObjectRequest= new JsonObjectRequest(Request.Method.POST, url, parameters, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String resultado="";
                try {
                    resultado=response.getString("message");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (resultado.trim().equalsIgnoreCase("Exito")){
                    progreso.hide();
                    Toast.makeText(getApplicationContext(),"Se Realizo el abono", Toast.LENGTH_SHORT).show();
                    intent = new Intent(creditoCliente.this, reciboAbonoCliente.class);
                    Bundle bundle= new Bundle();
                    bundle.putSerializable("cliente", client);
                    bundle.putDouble("Saldo", finalCredit);
                    bundle.putDouble("Abono", abono);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else{
                    progreso.hide();
                    Toast.makeText(getApplicationContext(),"Problemas con la conexion", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progreso.hide();
                Log.d("Abono de Cliente", "Fallo: "+ error.getMessage());
            }
        });
        request.add(jsonObjectRequest);
    }
}
