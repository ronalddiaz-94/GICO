package gico.com.sistemagico.cliente.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gico.com.sistemagico.R;
import gico.com.sistemagico.cliente.actualizarCliente;
import gico.com.sistemagico.generalGICO;
import gico.com.sistemagico.utilidades;
import gico.com.sistemagico.cliente.creditoCliente;
import gico.com.sistemagico.cliente.historialCliente;
import gico.com.sistemagico.cliente.interfaces.ClienteService;
import gico.com.sistemagico.cliente.adaptadores.ClientesAdapter;
import gico.com.sistemagico.cliente.clases.Cliente;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ClientFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ClientFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClientFragment extends Fragment implements SearchView.OnQueryTextListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    RecyclerView recyclerClientes;
    List<Cliente> listaClientes, listaProvisional;
    ClientesAdapter adapter;
    public ClientFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClientFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClientFragment newInstance(String param1, String param2) {
        ClientFragment fragment = new ClientFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista =inflater.inflate(R.layout.fragment_client, container, false);

        listaClientes= new ArrayList<>();
        recyclerClientes = vista.findViewById(R.id.recyclerClients);
        recyclerClientes.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarlista();

        adapter = new ClientesAdapter(listaClientes);

        recyclerClientes.setAdapter(adapter);
        return vista;
    }

    private void llenarlista() {
        Retrofit retrofit= new Retrofit.Builder().baseUrl("http://"+((generalGICO) getActivity().getApplicationContext()).getDireccionIP()+":8080/GICO-AD/webresources/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ClienteService clienteservice= retrofit.create(ClienteService.class);
        final Call<List<Cliente>> lista = clienteservice.getClientes();
        lista.enqueue(new Callback<List<Cliente>>() {
            @Override
            public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
                if (response.isSuccessful()){
                    listaClientes = response.body();
                    adapter = new ClientesAdapter(listaClientes);

                    adapter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            listaProvisional=adapter.getListaCLiente();
//                            Toast.makeText(getContext(),
//                                    "Aqui va el alert Dialog de: "+listaProvisional.get(recyclerClientes.getChildAdapterPosition(v)).getClientId(), Toast.LENGTH_LONG).show();

                            final Cliente client= listaProvisional.get(recyclerClientes.getChildAdapterPosition(v));
                            final Intent intentAct = new Intent(getActivity().getApplicationContext(),actualizarCliente.class);
                            final Intent intentAbon = new Intent(getActivity().getApplicationContext(),creditoCliente.class);
                            final Intent intentHist = new Intent(getActivity().getApplicationContext(),historialCliente.class);
                            final Bundle bundle= new Bundle();
                            bundle.putSerializable("cliente",client);

                            intentAct.putExtras(bundle);
                            intentAbon.putExtras(bundle);
                            intentHist.putExtras(bundle);

                            final CharSequence[] opciones={"Actualizar Datos","Abonar Crédito","Historial de pagos","Cancelar"};
                            final AlertDialog.Builder alertOpciones= new AlertDialog.Builder(getContext());
                            alertOpciones.setTitle("Seleccione una opción");
                            alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (opciones[which].equals("Actualizar Datos")){
                                        utilidades.validaPantalla=true;
                                        startActivity(intentAct);
                                    } else if (opciones[which].equals("Abonar Crédito")){
                                        Double credit=client.getClientCredit();
                                        if (credit>0){
                                            utilidades.validaPantalla=true;
                                            startActivity(intentAbon);
                                        }else{
                                            Toast.makeText(getContext(),"El cliente seleccionado no debe nada", Toast.LENGTH_SHORT).show();
                                        }

                                    }else if (opciones[which].equals("Historial de pagos")){
                                        utilidades.validaPantalla=true;
                                        startActivity(intentHist);
                                        //Toast.makeText(getContext(),"Presentar Historial", Toast.LENGTH_SHORT).show();
                                    }else{
                                        dialog.dismiss();
                                    }
                                }
                            });
                            alertOpciones.show();
                        }
                    });

                    recyclerClientes.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Cliente>> call, Throwable t) {

            }
        });

    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //getActivity().getMenuInflater().inflate(R.menu.main, menu);
        MenuItem menuItem= menu.findItem(R.id.action_search);
        SearchView searchView= (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        super.onCreateOptionsMenu(menu, inflater);
    }





    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    //ESTE METODO AYUDA PARA EL BUSCAR EN EL RECYCLERVEW DE CLIENTES
    @Override
    public boolean onQueryTextChange(String newText) {
        newText= newText.toLowerCase();
        List<Cliente> newList = new ArrayList<>();
        for (Cliente cliente : listaClientes){
            String name= cliente.getClientName().toLowerCase();
            String cedula= cliente.getClientCi().toLowerCase();
            String celular= cliente.getClientCell().toLowerCase();
            if (name.contains(newText) || cedula.contains(newText) || celular.contains(newText)){
                newList.add(cliente);
            }
        }
        adapter.setFilter(newList);
        return true;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
