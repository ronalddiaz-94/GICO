package gico.com.sistemagico;

import android.app.Application;

import java.util.ArrayList;

import gico.com.sistemagico.cliente.clases.Cliente;
import gico.com.sistemagico.producto.clases.Producto;

public class generalGICO extends Application {
    private String bodega, valortotal, valorsubtotal, valoriva;
    private Cliente oCliente=null;
    private ArrayList<Producto> listaProductosVenta=new ArrayList<Producto>();
    private Cliente oClienteImpresion=null;
    private ArrayList<Producto> listaProductosVentaImpresion=new ArrayList<Producto>();
    private String direccionIP ="190.99.73.72";
    private long tiempoInicio, tiempoFin;

    public long getTiempoInicio() {
        return tiempoInicio;
    }

    public void setTiempoInicio(long tiempoInicio) {
        this.tiempoInicio = tiempoInicio;
    }

    public long getTiempoFin() {
        return tiempoFin;
    }

    public void setTiempoFin(long tiempoFin) {
        this.tiempoFin = tiempoFin;
    }

    public String getDireccionIP() {
        return direccionIP;
    }

    public void setDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }

    public String getValortotal() {
        return valortotal;
    }

    public void setValortotal(String valortotal) {
        this.valortotal = valortotal;
    }

    public String getValorsubtotal() {
        return valorsubtotal;
    }

    public void setValorsubtotal(String valorsubtotal) {
        this.valorsubtotal = valorsubtotal;
    }

    public String getValoriva() {
        return valoriva;
    }

    public void setValoriva(String valoriva) {
        this.valoriva = valoriva;
    }

    public String getBodega() {
        return bodega;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }

    public Cliente getoCliente() {
        return oCliente;
    }

    public void setoCliente(Cliente oCliente) {
        this.oCliente = oCliente;
    }

    public ArrayList<Producto> getListaProductosVenta() {
        return listaProductosVenta;
    }

    public void setListaProductosVenta(ArrayList<Producto> listaProductosVenta) {
        this.listaProductosVenta = listaProductosVenta;
    }

    public Cliente getoClienteImpresion() {
        return oClienteImpresion;
    }

    public void setoClienteImpresion(Cliente oClienteImpresion) {
        this.oClienteImpresion = oClienteImpresion;
    }

    public ArrayList<Producto> getListaProductosVentaImpresion() {
        return listaProductosVentaImpresion;
    }

    public void setListaProductosVentaImpresion(ArrayList<Producto> listaProductosVentaImpresion) {
        this.listaProductosVentaImpresion = listaProductosVentaImpresion;
    }

    public void addProductList(Producto product, Double d){
        product.setProductCount(d);
        listaProductosVenta.add(product);
        listaProductosVentaImpresion.add(product);
    }

    public void clearProductList(){
        listaProductosVenta.clear();
    }

    public void clearClient(){
        oCliente= null;
    }

    public void clearProductListImpresion(){
        listaProductosVentaImpresion.clear();
    }

    public void clearClientImpresion(){
        oClienteImpresion= null;
    }
}
