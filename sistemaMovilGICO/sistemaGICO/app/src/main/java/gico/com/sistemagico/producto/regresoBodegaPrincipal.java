package gico.com.sistemagico.producto;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

import java.util.HashMap;
import java.util.Map;

import gico.com.sistemagico.MainActivity;
import gico.com.sistemagico.R;
import gico.com.sistemagico.generalGICO;
import gico.com.sistemagico.producto.clases.Producto;

public class regresoBodegaPrincipal extends AppCompatActivity {

    TextView campoNombre, campoCantidad, campoPrecio, campoDescripcion;
    Button btnRegresarBodega, btnCancelarRegreso;
    Intent intent;
    ProgressDialog progreso;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regreso_bodega_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        campoCantidad= (TextView) findViewById(R.id.etCantidadProductoRegresoBodega);
        campoDescripcion= (TextView) findViewById(R.id.etDescripcionProductoRegresoBodega);
        campoNombre= (TextView) findViewById(R.id.etNombreProductoRegresoBodega);
        campoPrecio= (TextView) findViewById(R.id.etPrecioProductoRegresoBodega);
        btnCancelarRegreso= (Button) findViewById(R.id.btnCancelarRegresoBodegaPrincipal);
        btnRegresarBodega= (Button) findViewById(R.id.btnRealizarRegresoBodegaPrincipal);

        Bundle productoEnviado= getIntent().getExtras();
        Producto producto=null;

        if (productoEnviado != null){
            producto= (Producto) productoEnviado.getSerializable("productoRegreso");
            campoPrecio.setText(producto.getProductPrice().toString());
            campoNombre.setText(producto.getProductName().toString());
            campoDescripcion.setText(producto.getProductDescription().toString());
            campoCantidad.setText(producto.getProductCount().toString());
        }

        btnCancelarRegreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent= new Intent(regresoBodegaPrincipal.this, MainActivity.class);
                startActivity(intent);
            }
        });

        request= Volley.newRequestQueue(this);


        final Producto finalProducto = producto;
        btnRegresarBodega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarServicioRegreso(finalProducto);
            }
        });


    }

    private void cargarServicioRegreso(Producto productoDevolver) {
        progreso = new ProgressDialog(this);
        progreso.setMessage("Cargando...");
        progreso.show();

        String url = "http://"+((generalGICO) getApplicationContext()).getDireccionIP()+":8080/GICO-AD/webresources/product/returnPrincipalProduct";

        Map<String, String> params=new HashMap<>();
        String prodId=productoDevolver.getProductId().toString();
        String prodCant= productoDevolver.getProductCount().toString();
        String prodM= ((generalGICO) this.getApplication()).getBodega();

        params.put("productId", prodId );
        params.put("productCount", prodCant);
        params.put("productMType", prodM);

        JSONObject parameters= new JSONObject(params);

        JsonObjectRequest jsonObjectRequest;

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
                    Toast.makeText(getApplicationContext(),"Se regreso el producto a la bodega principal", Toast.LENGTH_SHORT).show();
                    intent = new Intent(regresoBodegaPrincipal.this, MainActivity.class);
                    startActivity(intent);
                } else{
                    progreso.hide();
                    Toast.makeText(getApplicationContext(),"Problemas de conexion intentelo más tarde", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progreso.hide();
                Log.d("Regreso de producto", "Fallo: "+ error.getMessage());
            }
        });
        request.add(jsonObjectRequest);
    }

}
