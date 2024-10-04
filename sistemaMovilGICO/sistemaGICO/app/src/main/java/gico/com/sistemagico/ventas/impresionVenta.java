package gico.com.sistemagico.ventas;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import gico.com.sistemagico.MainActivity;
import gico.com.sistemagico.R;
import gico.com.sistemagico.cliente.clases.Cliente;
import gico.com.sistemagico.generalGICO;
import gico.com.sistemagico.producto.clases.Producto;
import gico.com.sistemagico.utilidades;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;
import java.util.UUID;

public class impresionVenta extends AppCompatActivity {

    BluetoothAdapter bluetoothAdapter;
    BluetoothSocket bluetoothSocket;
    BluetoothDevice bluetoothDevice;
    OutputStream outputStream;
    InputStream inputStream;
    Thread thread;

    byte[] readBuffer;
    int readBufferPosition;
    volatile boolean stopWorker;

    Cliente clienteRecibo=null;

    ArrayList<Producto> pedido=new ArrayList<Producto>();
    ImageView conectar, desconectar, imprimir;
    TextView estado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impresion_venta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        conectar= (ImageView) findViewById(R.id.ivConectarVenta);
        desconectar= (ImageView) findViewById(R.id.ivDesconectarVenta);
        imprimir= (ImageView) findViewById(R.id.ivImprimirVenta);
        estado= (TextView) findViewById(R.id.ivestadoventa);
        bluetoothAdapter= BluetoothAdapter.getDefaultAdapter();
        bluetoothAdapter.enable();
        final AlertDialog.Builder alertLimpiar= new AlertDialog.Builder(impresionVenta.this);
        alertLimpiar.setTitle("IMPORTANTE");
        alertLimpiar.setCancelable(false);
        alertLimpiar.setMessage("No se olvide de tener encendida su impresora");
        alertLimpiar.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertLimpiar.show();
        conectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    buscarDispositivoBluetooth();
                    openBluetoothPrinter();
                } catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        });

        desconectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    desconectar();
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        imprimir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    imprimir();
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }


    public void buscarDispositivoBluetooth(){
        try {
            bluetoothAdapter= BluetoothAdapter.getDefaultAdapter();
            if (bluetoothAdapter==null){
                Toast.makeText(getApplicationContext(), "Revise el estado de su bluetoth y si la impresora esta encendida", Toast.LENGTH_SHORT).show();
            }
            if (bluetoothAdapter.isEnabled()){
                Intent enableBT=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBT,0);
            }
            Set<BluetoothDevice> pairedDevice =bluetoothAdapter.getBondedDevices();

            if (pairedDevice.size()>0){
                for (BluetoothDevice pairedDev:pairedDevice){
                    //Compara si la impresora esta en el rango del bluetooth
                    if (pairedDev.getName().equals("BlueTooth Printer")){
                        bluetoothDevice=pairedDev;
                        estado.setText("Conectada");
                        break;
                    }
                }

            }

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void openBluetoothPrinter() throws IOException{
        try {
            //Standar uuid from string
            UUID uuidString= UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
            bluetoothSocket=bluetoothDevice.createRfcommSocketToServiceRecord(uuidString);
            bluetoothSocket.connect();
            outputStream=bluetoothSocket.getOutputStream();
            inputStream=bluetoothSocket.getInputStream();
            empezarEscucharDatos();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void empezarEscucharDatos(){
        try {

            final Handler handler=new Handler();
            final byte delimiter=10;
            stopWorker=false;
            readBufferPosition=0;
            readBuffer=new byte[1024];

            thread= new Thread(new Runnable() {
                @Override
                public void run() {

                    while (!Thread.currentThread().isInterrupted() && !stopWorker){
                        try {
                            int byteAvailable =inputStream.available();
                            if (byteAvailable>0){
                                byte[] packetByte= new byte[byteAvailable];
                                inputStream.read(packetByte);

                                for (int i=0;i<byteAvailable; i++){
                                    byte b= packetByte[i];
                                    if (b==delimiter){
                                        byte[] encodedByte = new byte[readBufferPosition];
                                        System.arraycopy(
                                                readBuffer,0,
                                                encodedByte,0,
                                                encodedByte.length
                                        );
                                        final String data = new String(encodedByte, "US-ASCII");
                                        readBufferPosition=0;
                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                //letra.setText(data);
                                            }
                                        });
                                    } else{
                                        readBuffer[readBufferPosition++]=b;
                                    }
                                }
                            }
                        } catch (Exception ex){
                            stopWorker=true;
                        }
                    }
                }
            });

            thread.start();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void imprimir() throws IOException{
        clienteRecibo=((generalGICO) getApplicationContext()).getoClienteImpresion();
        pedido=((generalGICO) getApplicationContext()).getListaProductosVentaImpresion();
        String msg, descripcion, vunitario, vtotal, TOTAL, SUBTOTAL, IVA,cantid;
        int cantidad, contador=0;
        Double precio=0.00, preciounit=0.00;
        TOTAL= ((generalGICO) getApplicationContext()).getValortotal();
        SUBTOTAL= ((generalGICO) getApplicationContext()).getValorsubtotal();
        IVA= ((generalGICO) getApplicationContext()).getValoriva();
        Calendar fechaHoy= Calendar.getInstance();
        int dia= fechaHoy.get(Calendar.DAY_OF_MONTH);
        int mes= fechaHoy.get(Calendar.MONTH) + 1;
        int anio= fechaHoy.get(Calendar.YEAR);
        try {
            for (int x = 0; x < 2; x++) {
                contador++;
                msg = "      ''Comercial ORTIZ''       ";
                msg += "\n";
                outputStream.write(msg.getBytes());
                msg = "        MOCHA - ECUADOR         ";
                msg += "\n";
                outputStream.write(msg.getBytes());
                msg = "FECHA: "+anio+"-"+mes+"-"+dia+"";
                msg += "\n";
                outputStream.write(msg.getBytes());
                msg = "TELEFONO: 0987654321";
                msg += "\n";
                outputStream.write(msg.getBytes());
                msg = "RUC: 99999999999999";
                msg += "\n";
                outputStream.write(msg.getBytes());
                msg = "CLIENTE:"+clienteRecibo.getClientName().toString()+"";
                msg += "\n";
                outputStream.write(msg.getBytes());
                msg = "CI:"+clienteRecibo.getClientCi()+"";
                msg += "\n";
                outputStream.write(msg.getBytes());
                msg = "DIRECCION:"+clienteRecibo.getClientAddress()+"";
                msg += "\n";
                outputStream.write(msg.getBytes());
                msg = " ";
                msg += "\n";
                outputStream.write(msg.getBytes());

                msg = "C.  Descrip.      P.Uni    P.Tot";
                msg += "\n";
                outputStream.write(msg.getBytes());
                for (int i = 0; i < pedido.size(); i++) {
                    //controles para los datos del recibo
                    double cantidadD= pedido.get(i).getProductCount();
                    descripcion= pedido.get(i).getProductDescription().toString();
                    if (descripcion.length()>8){
                        descripcion= descripcion.substring(0,descripcion.length() - 8);
                    }
                    if (descripcion.length()<8){
                        descripcion= String.format("%-8s", descripcion).replace(" ", " ");
                    }
                    preciounit=pedido.get(i).getProductPrice();
                    vunitario= String.format("%.2f", preciounit).replace(" ", "0").replace(",",".");
                    precio=pedido.get(i).getProductCount() * pedido.get(i).getProductPrice();
                    vtotal= String.format("%.2f", precio).replace(" ", "0").replace(",",".");
                    cantidad= (int) cantidadD;
                    cantid= Integer.toString(cantidad);
                    //control de las posiciones de los precios
                    if (cantid.length()<4){
                        cantid= String.format("%-4s", cantid);
                    }
                    if (vunitario.length()==4){
                        vunitario="       "+vunitario+"";
                    }
                    if (vunitario.length()==5){
                        vunitario="      "+vunitario+"";
                    }
                    if (vunitario.length()==6){
                        vunitario="     "+vunitario+"";
                    }
                    if (vunitario.length()==7){
                        vunitario="    "+vunitario+"";
                    }
                    if (vtotal.length()==4){
                        vtotal="     "+vtotal+"";
                    }
                    if (vtotal.length()==5){
                        vtotal="    "+vtotal+"";
                    }
                    if (vtotal.length()==6){
                        vtotal="   "+vtotal+"";
                    }
                    if (vtotal.length()==7){
                        vtotal="  "+vtotal+"";
                    }
                    //impresion de la informacion
                    msg = ""+cantid+""+descripcion+""+vunitario+""+vtotal+"";
                    msg += "\n";
                    outputStream.write(msg.getBytes());
                }
                msg = "\n";
                outputStream.write(msg.getBytes());


                //impresion IVA SUBTOTAL y TOTAL
                switch (((generalGICO) getApplicationContext()).getValorsubtotal().length()){
                    case 4:
                        msg = "               Subtotal:    "+((generalGICO) getApplicationContext()).getValorsubtotal()+"";
                        break;
                    case 5:
                        msg = "               Subtotal:   "+((generalGICO) getApplicationContext()).getValorsubtotal()+"";
                        break;
                    case 6:
                        msg = "               Subtotal:  "+((generalGICO) getApplicationContext()).getValorsubtotal()+"";
                        break;
                    case 7:
                        msg = "               Subtotal: "+((generalGICO) getApplicationContext()).getValorsubtotal()+"";
                        break;
                    default:
                        msg = "               Subtotal:    "+((generalGICO) getApplicationContext()).getValorsubtotal()+"";
                        break;
                }
                msg += "\n";
                outputStream.write(msg.getBytes());

                switch (((generalGICO) getApplicationContext()).getValoriva().length()){
                    case 4:
                        msg = "               IVA (12):    "+((generalGICO) getApplicationContext()).getValoriva()+"";
                        break;
                    case 5:
                        msg = "               IVA (12):   "+((generalGICO) getApplicationContext()).getValoriva()+"";
                        break;
                    case 6:
                        msg = "               IVA (12):  "+((generalGICO) getApplicationContext()).getValoriva()+"";
                        break;
                    case 7:
                        msg = "               IVA (12): "+((generalGICO) getApplicationContext()).getValoriva()+"";
                        break;
                    default:
                        msg = "               IVA (12):    "+((generalGICO) getApplicationContext()).getValoriva()+"";
                        break;
                }
                msg += "\n";
                outputStream.write(msg.getBytes());


                switch (((generalGICO) getApplicationContext()).getValortotal().length()){
                    case 4:
                        msg = "                  Total:    "+((generalGICO) getApplicationContext()).getValortotal()+"";
                        break;
                    case 5:
                        msg = "                  Total:   "+((generalGICO) getApplicationContext()).getValortotal()+"";
                        break;
                    case 6:
                        msg = "                  Total:  "+((generalGICO) getApplicationContext()).getValortotal()+"";
                        break;
                    case 7:
                        msg = "                  Total: "+((generalGICO) getApplicationContext()).getValortotal()+"";
                        break;
                    default:
                        msg = "                  Total:    "+((generalGICO) getApplicationContext()).getValortotal()+"";
                        break;
                }
                msg += "\n\n";
                outputStream.write(msg.getBytes());

                msg = "El presente documento no tiene valor tributario, es un recibo con el cual queda la constancia de la venta que se realizo y por medio de este ud cuenta con un respaldo para exigir su factura por la cantidad de productos pedidos";
                msg += "\n";
                outputStream.write(msg.getBytes());

                msg = "";
                msg += "\n\n\n";
                outputStream.write(msg.getBytes());
            }

            if (contador==2){
                Thread.sleep(2000);
                desconectar();
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void desconectar() throws IOException{
        try {
            ((generalGICO) getApplicationContext()).clearProductListImpresion();
            ((generalGICO) getApplicationContext()).clearClientImpresion();
            stopWorker=true;
            outputStream.close();
            inputStream.close();
            bluetoothSocket.close();
            estado.setText("Desconectada");
            ((generalGICO) getApplicationContext()).clearProductListImpresion();
            ((generalGICO) getApplicationContext()).clearClientImpresion();
            Intent impresion= new Intent(getApplicationContext(), MainActivity.class);
            utilidades.validaPantalla=true;
            startActivity(impresion);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
