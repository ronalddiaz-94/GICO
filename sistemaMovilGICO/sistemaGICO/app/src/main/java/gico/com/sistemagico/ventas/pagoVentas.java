package gico.com.sistemagico.ventas;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import gico.com.sistemagico.MainActivity;
import gico.com.sistemagico.R;
import gico.com.sistemagico.generalGICO;
import gico.com.sistemagico.producto.clases.Producto;
import gico.com.sistemagico.utilidades;

public class pagoVentas extends AppCompatActivity {

    TextView campoSaldo, campoTotal, campoNombreCliente;
    EditText campoAbono;
    Button btnPagar;
    ImageView last, home;
    Double cuenta1=0.00;
    ArrayList<Producto> listaProductos= new ArrayList<>();
    Double precio=0.00, precioSubtotal=0.00, precioTotal=0.00, precioIVA=0.00, valorSubtotalIVA=0.00;
    String fix;
    BigDecimal cuentaTotal,cuentaIva,cuentaSubtotal;
    ProgressDialog progreso;
    RequestQueue request;
    Integer pagar=1;
    double tiempoOcupado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago_ventas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        campoAbono= (EditText) findViewById(R.id.etAbonoTotalPedido);
        campoSaldo= (TextView) findViewById(R.id.tvSaldoTotalPedido);
        btnPagar= (Button) findViewById(R.id.btnEfectuarPago);
        campoTotal= (TextView) findViewById(R.id.tvValorTotalPedido);
        home= (ImageView) findViewById(R.id.ivPagoHome);
        last= (ImageView) findViewById(R.id.ivStepLast);
        campoNombreCliente= (TextView) findViewById(R.id.tvNombreClientePago);
        campoNombreCliente.setText(((generalGICO) getApplicationContext()).getoCliente().getClientName().toString());
        listaProductos=((generalGICO) getApplicationContext()).getListaProductosVenta();
        if (listaProductos.size()<1){
            Intent inicio= new Intent(getApplicationContext(),MainActivity.class);
            startActivity(inicio);
        }
        for (int x=0; x<listaProductos.size();x++){
            cuenta1= cuenta1 + (listaProductos.get(x).getProductCount() * listaProductos.get(x).getProductPrice());
        }

        if (listaProductos.size()>0){
            for (int x=0; x<listaProductos.size(); x++){
                precio= listaProductos.get(x).getProductCount() * listaProductos.get(x).getProductPrice();
                precioSubtotal= precioSubtotal + precio;
                if (listaProductos.get(x).getProductIva()>0){
                    valorSubtotalIVA= valorSubtotalIVA + (listaProductos.get(x).getProductPrice() * listaProductos.get(x).getProductCount());
                }
            }
        }
        precioIVA=valorSubtotalIVA * (0.12);
        precioTotal= precioSubtotal+ precioIVA;

        cuentaTotal= new BigDecimal(precioTotal.toString());
        cuentaTotal= cuentaTotal.setScale(2, BigDecimal.ROUND_DOWN);

        campoTotal.setText(cuentaTotal.toString());

        cuentaIva= new BigDecimal(precioIVA.toString());
        cuentaIva= cuentaIva.setScale(2, BigDecimal.ROUND_DOWN);

        cuentaSubtotal= new BigDecimal(precioSubtotal.toString());
        cuentaSubtotal= cuentaSubtotal.setScale(2, BigDecimal.ROUND_DOWN);

        request = Volley.newRequestQueue(getApplicationContext());

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

        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent last= new Intent(getApplicationContext(),productoVentas.class);
                startActivity(last);
            }
        });

        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pagar==1){
                    if ((listaProductos.size()<1) || ((((generalGICO) getApplicationContext()).getoCliente())==null)){
                        utilidades.validaPantalla=true;
                        Intent inicio= new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(inicio);
                    } else{
                        String clientenombre= campoNombreCliente.getText().toString();
                        if (clientenombre.equalsIgnoreCase("Consumidor Final")){
                            String abono= campoAbono.getText().toString();
                            if (abono.trim().equalsIgnoreCase("")){
                                abono="0.00";
                            }
                            String total= campoTotal.getText().toString();
                            if (abono.equalsIgnoreCase(total)){
                                guardarFactura(1);
                            }else{
                                Toast.makeText(getApplicationContext(),"RECUERDE QUE PARA CONSUMIDOR FINAL, EL ABONO DEBE SER IGUAL AL VALOR TOTAL DEL PEDIDO", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            guardarFactura(2);
                        }
                    }
                } else{
                    Toast.makeText(getApplicationContext(),"El valor del abono es mayor al total", Toast.LENGTH_SHORT).show();
                }

            }
        });

        campoAbono.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()!=0){
                    BigDecimal abono1= new BigDecimal(campoAbono.getText().toString());
                    abono1= abono1.setScale(2, BigDecimal.ROUND_DOWN);
                    Double abono=Double.parseDouble(abono1.toString());
                    BigDecimal total1= new BigDecimal(campoTotal.getText().toString());
                    total1= total1.setScale(2, BigDecimal.ROUND_CEILING);
                    Double total= Double.parseDouble(total1.toString());
                    if (total>=abono){
                        Double saldo = total-abono;
                        BigDecimal saldo1= new BigDecimal(saldo.toString());
                        saldo1= saldo1.setScale(2, BigDecimal.ROUND_DOWN);
                        campoSaldo.setText(saldo1.toString());
                        pagar=1;
                    } else{
                        Toast.makeText(getApplicationContext(),"El abono es mayor al total del pedido", Toast.LENGTH_LONG).show();
                        pagar=0;
                    }
                } else{
                    campoSaldo.setText(campoTotal.getText().toString());
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void guardarFactura(Integer cliente){
        progreso = new ProgressDialog(pagoVentas.this);
        progreso.setMessage("Cargando...");
        progreso.show();

        String url = "http://"+((generalGICO) getApplicationContext()).getDireccionIP()+":8080/GICO-AD/webresources/Factura/addFactura";

        Map<String, String> params = new HashMap<>();
        String facturaId = "0";
        String facturaTotal = cuentaTotal.toString();
        String facturaIva = cuentaIva.toString();
        String facturaAbono = campoAbono.getText().toString();
        String facturaSubTotal = cuentaSubtotal.toString();
        Calendar fechaHoy= Calendar.getInstance();
        int dia= fechaHoy.get(Calendar.DAY_OF_MONTH);
        int mes= fechaHoy.get(Calendar.MONTH) + 1;
        int anio= fechaHoy.get(Calendar.YEAR);
        String facturaDate = " "+anio+"-"+mes+"-"+dia+"" ;
        String clientId = ((generalGICO) getApplicationContext()).getoCliente().getClientId().toString();
        String facturaState = "1";

        if (facturaAbono.trim().equalsIgnoreCase("")){
            facturaAbono="0.00";
        }
        BigDecimal abono= new BigDecimal(facturaAbono);
        abono= abono.setScale(2, BigDecimal.ROUND_DOWN);

        params.put("facturaMType", cliente.toString());
        params.put("facturaId", facturaId);
        params.put("facturaTotal", facturaTotal);
        params.put("clientId", clientId);
        params.put("facturaIva", facturaIva);
        params.put("facturaSubTotal", facturaSubTotal);
        params.put("facturaDate", facturaDate);
        params.put("facturaState", facturaState);
        params.put("facturaAbono", abono.toString());

        JSONObject parameters = new JSONObject(params);

        JsonObjectRequest jsonObjectRequest = null;

        jsonObjectRequest= new JsonObjectRequest(Request.Method.POST, url, parameters, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String resultado = "";
                try {
                    resultado = response.getString("message");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if ((resultado.trim().equalsIgnoreCase("Sin Respuesta")) || (resultado.trim().equalsIgnoreCase("Error"))) {
                    progreso.hide();
                    Toast.makeText(getApplicationContext(), "Fallo en el registro de la venta", Toast.LENGTH_SHORT).show();
                } else {
                    guardarProductos(resultado);
                    progreso.hide();

//                    Toast.makeText(getApplicationContext(), "Registro exitoso: "+tiempoOcupado, Toast.LENGTH_SHORT).show();
                    Intent recibo= new Intent(getApplicationContext(),reciboVenta.class);
                    startActivity(recibo);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progreso.hide();
                Log.d("Factura", "Error Respuesta en JSON: " + error.getMessage());
            }
        });
        request.add(jsonObjectRequest);
    }

    ArrayList<Producto> pedido=new ArrayList<Producto>();

    public void guardarProductos(String resultado){
        String url = "http://"+((generalGICO) getApplicationContext()).getDireccionIP()+":8080/GICO-AD/webresources/Factura/addFacturaProduct";
        pedido = ((generalGICO) getApplicationContext()).getListaProductosVenta();
        ((generalGICO) getApplicationContext()).setTiempoFin(System.currentTimeMillis());
        long tiempo=((generalGICO) getApplicationContext()).getTiempoFin()-((generalGICO) getApplicationContext()).getTiempoInicio();
        tiempoOcupado= (double)(tiempo);
        tiempoOcupado=tiempoOcupado/1000;
        String tiempoFinal= Double.toString(tiempoOcupado);
        Toast.makeText(getApplicationContext(), "Registro:"+tiempoOcupado, Toast.LENGTH_SHORT).show();
        Map<String, String> params = new HashMap<>();
        if (pedido.size()>0){
            for (int x=0; x<pedido.size(); x++){

                if (x==0){
                    params.put("productMType", "2");
                    params.put("productId", pedido.get(x).getProductId().toString());
                    params.put("productTotalValue", resultado);
                    params.put("productPrice", pedido.get(x).getProductPrice().toString());
                    params.put("productIva", pedido.get(x).getProductIva().toString());
                    params.put("productCount", pedido.get(x).getProductCount().toString());
                    params.put("productUtility", pedido.get(x).getProductUtility().toString());
                    params.put("productAveragePrice", "12");
                    params.put("productValue", ((generalGICO) getApplicationContext()).getBodega());
                    params.put("productcountprocess", tiempoFinal);
                }else {
                    params.put("productMType", "1");
                    params.put("productId", pedido.get(x).getProductId().toString());
                    params.put("productTotalValue", resultado);
                    params.put("productPrice", pedido.get(x).getProductPrice().toString());
                    params.put("productIva", pedido.get(x).getProductIva().toString());
                    params.put("productCount", pedido.get(x).getProductCount().toString());
                    params.put("productUtility", pedido.get(x).getProductUtility().toString());
                    params.put("productAveragePrice", "12");
                    params.put("productValue", ((generalGICO) getApplicationContext()).getBodega());
                    params.put("productcountprocess", tiempoFinal);
                }
                JSONObject parameters = new JSONObject(params);

                JsonObjectRequest jsonObjectRequest = null;

                jsonObjectRequest= new JsonObjectRequest(Request.Method.POST, url, parameters, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Factura", "Producto Guardado ");
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progreso.hide();
                        Log.d("Factura", "Error Respuesta en JSON: " + error.getMessage());
                    }
                });
                request.add(jsonObjectRequest);

            }
        }
    }
}
