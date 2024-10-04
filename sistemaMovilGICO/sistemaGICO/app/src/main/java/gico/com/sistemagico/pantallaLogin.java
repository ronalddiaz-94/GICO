package gico.com.sistemagico;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import gico.com.sistemagico.bodega.asignarBodega;

public class pantallaLogin extends AppCompatActivity {

    EditText campoUsuario, campoPassword;
    Button btnLogin;
    ProgressDialog progreso;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_login);

        campoPassword = (EditText) this.<View>findViewById(R.id.etPassword);
        campoUsuario= (EditText) this.<View>findViewById(R.id.etNombreUsuario);
        btnLogin= (Button) this.<View>findViewById(R.id.btnIngresar);

        request = Volley.newRequestQueue(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(campoUsuario.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(),"Ingrese su nombre de usuario", Toast.LENGTH_SHORT).show();
                } else if (campoPassword.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(getApplicationContext(),"Ingrese su contraseña", Toast.LENGTH_SHORT).show();
                }else {
                    cargarServicioLogin();
                }
            }
        });

    }

    private void cargarServicioLogin() {

        String url="http://"+((generalGICO) getApplicationContext()).getDireccionIP()+":8080/GICO-AD/webresources/restAutentication/UserMovilAutentication";

        Map<String,String> parameters= new HashMap<>();
        String userNameUser = campoUsuario.getText().toString();
        String userPass= campoPassword.getText().toString();
        parameters.put("userNameUser", userNameUser);
        parameters.put("userPass", userPass);

        JSONObject parametros = new JSONObject(parameters);

        JsonObjectRequest jsonObjectRequest = null;

        jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, parametros, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String resultado = "";
                try {
                    resultado = response.getString("message");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (resultado.trim().equalsIgnoreCase("Exito")) {
                    Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(pantallaLogin.this, asignarBodega.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Credenciales invalidas", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Problemas con la conexion", Toast.LENGTH_SHORT).show();
                Log.d("Ingreso", "Error Respuesta en JSON: " + error.getMessage());
            }
        });
        request.add(jsonObjectRequest);
    }
}
