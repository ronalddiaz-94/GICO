package gico.com.sistemagico.bodega.interfaces;

import java.util.List;

import gico.com.sistemagico.bodega.clases.Bodega;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BodegaService {
    //ESTE ADAPTADOR SE UTILIZA PARA EL PROCESO DE MOSTRAR LA INFORMACION EN EL RECYCLERVIEW DE CLIENTES
    @GET("cellar/listMovilCellar")
    Call<List<Bodega>> getBodegas();
}
