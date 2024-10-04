package gico.com.sistemagico.cliente.interfaces;

import java.util.List;

import gico.com.sistemagico.cliente.clases.Cliente;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ClienteService {
    //ESTE ADAPTADOR SE UTILIZA PARA EL PROCESO DE MOSTRAR LA INFORMACION EN EL RECYCLERVIEW DE CLIENTES
    @GET("client/listClient")
    Call<List<Cliente>> getClientes();
}
