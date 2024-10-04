package gico.com.sistemagico.producto.interfaces;

import java.util.List;

import gico.com.sistemagico.cliente.clases.Cliente;
import gico.com.sistemagico.producto.clases.Producto;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductoService {

    @GET("product/listMovilProduct")
    Call<List<Producto>> getProductos();
}
