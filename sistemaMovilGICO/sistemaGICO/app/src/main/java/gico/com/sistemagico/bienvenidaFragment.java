package gico.com.sistemagico;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import gico.com.sistemagico.cliente.fragments.contenedorClienteFragment;
import gico.com.sistemagico.producto.fragments.contenedorProductFragment;
import gico.com.sistemagico.producto.fragments.productFragment;
import gico.com.sistemagico.ventas.fragments.pasosVentaFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link bienvenidaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link bienvenidaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class bienvenidaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ImageView ivCliente, ivVentas, ivProductos, ivInformacion;
    View vista;
    public bienvenidaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment bienvenidaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static bienvenidaFragment newInstance(String param1, String param2) {
        bienvenidaFragment fragment = new bienvenidaFragment();
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
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        vista =inflater.inflate(R.layout.fragment_bienvenida, container, false);
        ivCliente= (ImageView) vista.findViewById(R.id.ivAtajoCliente);
        ivProductos = (ImageView) vista.findViewById((R.id.ivAtajoProducto));
        ivVentas= (ImageView) vista.findViewById(R.id.ivAtajoVentas);
        ivInformacion= (ImageView) vista.findViewById((R.id.ivAtajoInformacion));

        ivCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment= new contenedorClienteFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();

            }
        });

        ivProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment= new contenedorProductFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();
            }
        });

        ivVentas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment= new pasosVentaFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();
            }
        });

        ivInformacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return vista;
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
