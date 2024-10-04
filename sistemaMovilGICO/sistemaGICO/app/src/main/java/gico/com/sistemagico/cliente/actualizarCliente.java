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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import gico.com.sistemagico.MainActivity;
import gico.com.sistemagico.R;
import gico.com.sistemagico.cliente.clases.Cliente;
import gico.com.sistemagico.generalGICO;

public class actualizarCliente extends AppCompatActivity {

    EditText campoNombre, campoCedula, campoDireccion, campoCelular, campoMail;
    Button btnGuardarActualizacion, btnCancelarActualizacion;
    Intent intent;
    ProgressDialog progreso;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_cliente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        campoNombre= (EditText)findViewById(R.id.etNombreActualizar);
        campoCedula= (EditText) findViewById(R.id.etCedulaActualizar);
        campoDireccion= (EditText) findViewById(R.id.etDireccionActualizar);
        campoMail= (EditText) findViewById(R.id.etCorreoActualizar);
        campoCelular= (EditText) findViewById(R.id.etCelularActualizar);
        btnCancelarActualizacion= (Button) findViewById(R.id.btnCancelarActualizar);
        btnGuardarActualizacion= (Button) findViewById(R.id.btnRealizarActualizar);

        Bundle clienteEnviado= getIntent().getExtras();
        Cliente client= null;

        if (clienteEnviado!=null){
            client=(Cliente) clienteEnviado.getSerializable("cliente");
            if (client.getClientName().toString().equalsIgnoreCase("")){
                campoNombre.setText("");
            }else {
                campoNombre.setText(client.getClientName().toString());
            }
            if (client.getClientCell().toString().equalsIgnoreCase("")){
                campoCelular.setText("");
            }else {
                campoCelular.setText(client.getClientCell().toString());
            }
            if (client.getClientMail().toString().equalsIgnoreCase("")){
                campoMail.setText("");
            }else {
                campoMail.setText(client.getClientMail().toString());
            }
            if (client.getClientAddress().toString().equalsIgnoreCase("")){
                campoDireccion.setText("");
            }else {
                campoDireccion.setText(client.getClientAddress().toString());
            }
            if (client.getClientCi().toString().equalsIgnoreCase("")){
                campoCedula.setText("");
            }else {
                campoCedula.setText(client.getClientCi().toString());
            }
        }

        btnCancelarActualizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent= new Intent(actualizarCliente.this, MainActivity.class);
                startActivity(intent);
            }
        });

        request = Volley.newRequestQueue(this);

        final Cliente finalClient = client;
        btnGuardarActualizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarServicioWeb(finalClient);
            }
        });



    }

    private void cargarServicioWeb(Cliente c) {

        progreso = new ProgressDialog(this);
        progreso.setMessage("Cargando.....");
        progreso.show();

        String url = "http://"+((generalGICO) getApplicationContext()).getDireccionIP()+":8080/GICO-AD/webresources/client/managementMovilClient";

        Map<String, String> params= new HashMap<>();
        String clientMType = "2";
        String clientId = c.getClientId().toString();
        String clientCi = campoCedula.getText().toString();
        String clientName = campoNombre.getText().toString();
        String clientPhone = c.getClientPhone().toString();
        String clientCell = campoCelular.getText().toString();
        String clientMail = campoMail.getText().toString();
        String clientCredit = c.getClientCredit().toString();
        String clientAddress = campoDireccion.getText().toString();

        params.put("clientMType", clientMType);
        params.put("clientId", clientId);
        params.put("clientCi", clientCi);
        params.put("clientName", clientName);
        params.put("clientPhone", clientPhone);
        params.put("clientCell", clientCell);
        params.put("clientMail", clientMail);
        params.put("clientCredit", clientCredit);
        params.put("clientAddress", clientAddress);

        JSONObject parameters = new JSONObject(params);

        JsonObjectRequest jsonObjectRequest = null;

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
                    Toast.makeText(getApplicationContext(),"Se Actualizo los datos del cliente", Toast.LENGTH_SHORT).show();
                    intent = new Intent(actualizarCliente.this, MainActivity.class);
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
                Log.d("Actualizar Cliente", "Fallo: "+ error.getMessage());
            }
        });
        request.add(jsonObjectRequest);

    }


}
