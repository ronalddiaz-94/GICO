package gico.com.sistemagico.cliente.interfaces;

import java.util.List;

import gico.com.sistemagico.cliente.clases.Cliente;
import gico.com.sistemagico.cliente.clases.actividadesCliente;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ActividadClienteService {
    @POST("activityClient/listActivityClient1")
    Call<List<actividadesCliente>> getActividades(@Body Cliente cliente);
}
