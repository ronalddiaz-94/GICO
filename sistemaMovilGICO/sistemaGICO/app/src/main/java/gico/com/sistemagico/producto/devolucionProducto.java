package gico.com.sistemagico.producto;

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

import java.util.HashMap;
import java.util.Map;

import gico.com.sistemagico.MainActivity;
import gico.com.sistemagico.R;
import gico.com.sistemagico.generalGICO;
import gico.com.sistemagico.producto.clases.Producto;

public class devolucionProducto extends AppCompatActivity {

    EditText campoCantidad;
    TextView campoNombre, campoPrecio, campoDescripcion;
    Button btnDevolver, btnCancelarDevolucion;
    Intent intent;
    ProgressDialog progreso;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devolucion_producto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        campoCantidad= (EditText) findViewById(R.id.etCantidadProductoDevolucion);
        campoPrecio= (TextView) findViewById(R.id.etPrecioProductoDevolucion);
        campoDescripcion= (TextView) findViewById(R.id.etDescripcionProductoDevolucion);
        campoNombre= (TextView) findViewById(R.id.etNombreProductoDevolucion);
        btnDevolver= (Button) findViewById(R.id.btnRealizarDevolucion);
        btnCancelarDevolucion= (Button)findViewById(R.id.btnCancelarDevolucion);

        Bundle productoEnviado= getIntent().getExtras();
        Producto product=null;

        if (productoEnviado!=null){
            product= (Producto) productoEnviado.getSerializable("producto");
            campoNombre.setText(product.getProductName().toString());
            campoPrecio.setText(product.getProductPrice().toString());
            campoDescripcion.setText(product.getProductDescription().toString());
        }

        btnCancelarDevolucion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent= new Intent(devolucionProducto.this, MainActivity.class);
                startActivity(intent);
            }
        });

        request = Volley.newRequestQueue(this);
        final Producto finalProduct = product;

        btnDevolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (campoCantidad.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(),"Ingrese la cantidad a devolver", Toast.LENGTH_SHORT).show();
                }else {
                    cargarServicioWeb(finalProduct);
                }
            }
        });
    }

    private void cargarServicioWeb(final Producto producto) {
//        Toast.makeText(getApplicationContext()," "+producto.getProductId(), Toast.LENGTH_SHORT).show();
        progreso = new ProgressDialog(this);
        progreso.setMessage("Cargando...");
        progreso.show();

        String url = "http://"+((generalGICO) getApplicationContext()).getDireccionIP()+":8080/GICO-AD/webresources/badInventory/addInventory";

        Map<String,String> params=new HashMap<>();
        String nombreP= producto.getProductName().toString();
        String idP= producto.getProductId().toString();
        String cantidadP= campoCantidad.getText().toString();

        params.put("returnedProductId", "1");
        params.put("productName", nombreP);
        params.put("productId", idP);
        params.put("productCount", cantidadP);

        JSONObject parameters = new JSONObject(params);

        JsonObjectRequest jsonObjectRequest;

        jsonObjectRequest= new JsonObjectRequest(Request.Method.POST, url, parameters, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String resultado="";
                try {
                    resultado= response.getString("message");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (resultado.trim().equalsIgnoreCase("Exito")){
                    progreso.hide();
                    Toast.makeText(getApplicationContext(),"Se Realizo la devolución", Toast.LENGTH_SHORT).show();
                    intent = new Intent(devolucionProducto.this, reciboDevolucionProducto.class);
                    Bundle bundle= new Bundle();
                    bundle.putSerializable("producto", producto);
                    bundle.putInt("Cantidad", Integer.parseInt(campoCantidad.getText().toString()));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else{
                    progreso.hide();
                    Toast.makeText(getApplicationContext(),"Problemas de conexion intentelo más tarde", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progreso.hide();
                Log.d("Devolución de producto", "Fallo: "+ error.getMessage());
            }
        });
        request.add(jsonObjectRequest);
    }

}