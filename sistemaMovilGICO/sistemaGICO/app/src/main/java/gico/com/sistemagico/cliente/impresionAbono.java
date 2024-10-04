package gico.com.sistemagico.cliente;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.io.IOException;
import java.util.Calendar;
import java.util.Set;
import java.util.UUID;

import gico.com.sistemagico.MainActivity;
import gico.com.sistemagico.R;
import gico.com.sistemagico.cliente.clases.Cliente;
import gico.com.sistemagico.generalGICO;
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
public class impresionAbono extends AppCompatActivity {

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
    ImageView conectar, desconectar, imprimir;
    TextView estado;
    Double saldo,abono;
    String nombre, cedula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impresion_abono);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        conectar= (ImageView) findViewById(R.id.ivConectarAbono);
        desconectar= (ImageView) findViewById(R.id.ivDesconectarAbono);
        imprimir= (ImageView) findViewById(R.id.ivImprimirAbono);
        estado= (TextView) findViewById(R.id.ivestadoabono);
        Bundle clienteEnviado= getIntent().getExtras();

        if (clienteEnviado!=null) {
            saldo= clienteEnviado.getDouble("Saldo");
            abono= clienteEnviado.getDouble("Abono");
            nombre= clienteEnviado.getString("Nombre");
            cedula= clienteEnviado.getString("Cedula");
        }


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

    public void openBluetoothPrinter() throws IOException {
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
        String msg;
        int  contador=0;
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
                msg = "Fecha: "+anio+"-"+mes+"-"+dia+"";
                msg += "\n";
                outputStream.write(msg.getBytes());
                msg = "Telefono: 0987654321";
                msg += "\n";
                outputStream.write(msg.getBytes());
                msg = "RUC: 9999999999";
                msg += "\n";
                outputStream.write(msg.getBytes());
                msg = "\n";
                msg += "  RECIBO POR ABONO DE CREDITO   ";
                msg += "\n";
                outputStream.write(msg.getBytes());
                msg = "";
                msg += "\n";
                outputStream.write(msg.getBytes());

                msg = "Cliente: "+nombre.toString()+"";
                msg += "\n";
                outputStream.write(msg.getBytes());
                msg = "Cedula: "+cedula.toString()+"";
                msg += "\n";

                String saldoC= String.format("%.2f", saldo).replace(" ", "0").replace(",",".");
                outputStream.write(msg.getBytes());
                msg = "Saldo: "+saldoC+"";
                msg += "\n";
                outputStream.write(msg.getBytes());
                String abonoC= String.format("%.2f", abono).replace(" ", "0").replace(",",".");
                msg = "Abono: "+abonoC+"";
                msg += "\n\n";
                outputStream.write(msg.getBytes());

                msg = "Este documento sirve como constancia del abono del credito perteneciente al cliente";
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
