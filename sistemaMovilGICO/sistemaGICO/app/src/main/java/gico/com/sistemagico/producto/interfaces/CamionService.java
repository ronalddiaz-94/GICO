package gico.com.sistemagico.producto.interfaces;

import java.util.List;

import gico.com.sistemagico.producto.clases.Bodega;
import gico.com.sistemagico.producto.clases.Producto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CamionService {
    @POST("product/listProductCellar")
    Call<List<Producto>> getProductosBodega(@Body Bodega bodega);
}
