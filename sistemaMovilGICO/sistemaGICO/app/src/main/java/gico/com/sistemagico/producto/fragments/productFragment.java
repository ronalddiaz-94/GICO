package gico.com.sistemagico.producto.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import gico.com.sistemagico.R;
import gico.com.sistemagico.generalGICO;
import gico.com.sistemagico.producto.adaptadores.ProductosAdapter;
import gico.com.sistemagico.producto.clases.Producto;
import gico.com.sistemagico.producto.devolucionProducto;
import gico.com.sistemagico.producto.interfaces.ProductoService;
import gico.com.sistemagico.utilidades;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link productFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link productFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class productFragment extends Fragment implements SearchView.OnQueryTextListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    RecyclerView recyclerProducts;
    List<Producto> listaProductos, listaProvisionalProductos;
    ProductosAdapter adapter;



    public productFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment productFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static productFragment newInstance(String param1, String param2) {
        productFragment fragment = new productFragment();
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
        View vista=inflater.inflate(R.layout.fragment_product, container, false);
        listaProductos = new ArrayList<>();

        recyclerProducts= (RecyclerView) vista.findViewById(R.id.recyclerProductos);
        recyclerProducts.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarListaProductos();

        adapter = new ProductosAdapter(listaProductos);
        recyclerProducts.setAdapter(adapter);

        return vista;
    }

    private void llenarListaProductos() {
        Retrofit retrofit= new Retrofit.Builder().baseUrl("http://"+((generalGICO) getActivity().getApplicationContext()).getDireccionIP()+":8080/GICO-AD/webresources/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductoService productoService= retrofit.create(ProductoService.class);
        final Call<List<Producto>> lista=productoService.getProductos();
        lista.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if (response.isSuccessful()){
                    listaProductos=response.body();
                    adapter= new ProductosAdapter(listaProductos);

                    adapter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            listaProvisionalProductos= adapter.getListaProductos();

                            final Producto product= listaProvisionalProductos.get(recyclerProducts.getChildAdapterPosition(v));
                            final Intent intentDev = new Intent(getActivity().getApplicationContext(),devolucionProducto.class);
                            final Bundle bundle= new Bundle();
                            bundle.putSerializable("producto",product);

                            intentDev.putExtras(bundle);

                            final CharSequence[] opciones={"Devolución","Cancelar"};
                            final AlertDialog.Builder alertOpciones= new AlertDialog.Builder(getContext());
                            alertOpciones.setTitle("Selecciona una opción");
                            alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (opciones[which].equals("Devolución")){
                                        utilidades.validaPantalla=true;
                                        startActivity(intentDev);
                                    }else {
                                        dialog.dismiss();
                                    }
                                }
                            });
                            alertOpciones.show();
                        }
                    });

                    recyclerProducts.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {

            }
        });

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuItem menuItem= menu.findItem(R.id.action_search);
        SearchView searchView= (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        super.onCreateOptionsMenu(menu, inflater);
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

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        List<Producto> newList=new ArrayList<>();
        for (Producto producto: listaProductos){
            String name= producto.getProductName().toLowerCase();
            String descripcion= producto.getProductDescription().toLowerCase();
            String precio=producto.getProductPrice().toString().toLowerCase();
            if (name.contains(newText) || descripcion.contains(newText) || precio.contains(newText)){
                newList.add(producto);
            }
        }
        adapter.setFilter(newList);
        return true;
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
