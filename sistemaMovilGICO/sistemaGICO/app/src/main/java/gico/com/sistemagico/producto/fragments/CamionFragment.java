package gico.com.sistemagico.producto.fragments;

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

import java.util.ArrayList;
import java.util.List;

import gico.com.sistemagico.R;
import gico.com.sistemagico.generalGICO;
import gico.com.sistemagico.producto.adaptadores.CamionAdapter;
import gico.com.sistemagico.producto.clases.Bodega;
import gico.com.sistemagico.producto.clases.Producto;
import gico.com.sistemagico.producto.interfaces.CamionService;
import gico.com.sistemagico.producto.regresoBodegaPrincipal;
import gico.com.sistemagico.utilidades;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CamionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CamionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CamionFragment extends Fragment implements SearchView.OnQueryTextListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    RecyclerView rvCamion;
    List<Producto> listaProductos, listaProvisionalProductos;
    CamionAdapter adapter;
    View v;

    public CamionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CamionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CamionFragment newInstance(String param1, String param2) {
        CamionFragment fragment = new CamionFragment();
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
        v= inflater.inflate(R.layout.fragment_camion, container, false);
        rvCamion= (RecyclerView) v.findViewById(R.id.recyclerCamion);
        rvCamion.setLayoutManager(new LinearLayoutManager(getContext()));
        listaProductos = new ArrayList<>();

        llenarListaCamion();

        adapter= new CamionAdapter(listaProductos);
        rvCamion.setAdapter(adapter);

        return v;
    }

    private void llenarListaCamion() {
        Retrofit retrofit= new Retrofit.Builder().baseUrl("http://"+((generalGICO) getActivity().getApplicationContext()).getDireccionIP()+":8080/GICO-AD/webresources/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CamionService camionService= retrofit.create(CamionService.class);
        Bodega b= new Bodega();
        String cellar= ((generalGICO) getActivity().getApplicationContext()).getBodega();
        int cellarid= Integer.parseInt(cellar);
        b.setCellarId(cellarid);
        Call<List<Producto>> lista=camionService.getProductosBodega(b);
        lista.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if(response.isSuccessful()){
                    listaProductos= response.body();
                    adapter= new CamionAdapter(listaProductos);

                    adapter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            listaProvisionalProductos= adapter.getListaProductos();

                            Producto producto= listaProvisionalProductos.get(rvCamion.getChildAdapterPosition(v));
                            final Intent intentBodegaPrincipal = new Intent(getActivity().getApplicationContext(), regresoBodegaPrincipal.class);
                            final Bundle bundle= new Bundle();
                            bundle.putSerializable("productoRegreso",producto);
                            intentBodegaPrincipal.putExtras(bundle);

                            final CharSequence[] opciones={"Mover a bodega principal","Cancelar"};
                            final AlertDialog.Builder alertOpciones= new AlertDialog.Builder(getContext());
                            alertOpciones.setTitle("Seleccione una opción");
                            alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (opciones[which].equals("Mover a bodega principal")){
                                        utilidades.validaPantalla=true;
                                        startActivity(intentBodegaPrincipal);
                                    }else {
                                        dialog.dismiss();
                                    }
                                }
                            });
                            alertOpciones.show();
                        }
                    });

                    rvCamion.setAdapter(adapter);
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
            String cantidad=producto.getProductCount().toString().toLowerCase();
            if (name.contains(newText) || descripcion.contains(newText) || precio.contains(newText) || cantidad.contains(newText)){
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
