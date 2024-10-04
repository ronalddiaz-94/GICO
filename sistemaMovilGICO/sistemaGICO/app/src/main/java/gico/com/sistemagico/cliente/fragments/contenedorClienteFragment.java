package gico.com.sistemagico.cliente.fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gico.com.sistemagico.R;
import gico.com.sistemagico.cliente.adaptadores.seccionesAdapter;
import gico.com.sistemagico.utilidades;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link contenedorClienteFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link contenedorClienteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class contenedorClienteFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    View vista;
    private AppBarLayout appBar;
    private TabLayout pestanas;
    private ViewPager viewPager;

    public contenedorClienteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment contenedorClienteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static contenedorClienteFragment newInstance(String param1, String param2) {
        contenedorClienteFragment fragment = new contenedorClienteFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_contenedor_cliente, container, false);

        if (utilidades.rotacion == 0) {
            View parent = (View) container.getParent();
            if (appBar == null) {
                appBar = (AppBarLayout) parent.findViewById(R.id.appBar);
                pestanas = new TabLayout(getActivity());
                pestanas.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#D33142"));
                pestanas.setBackgroundColor(Color.parseColor("#2c3e50"));
                pestanas.setSelectedTabIndicatorColor(Color.parseColor("#E4EE06"));
                pestanas.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));

                appBar.addView(pestanas);
                viewPager = (ViewPager) vista.findViewById(R.id.idViewPagerCliente);

                llenarViewPager(viewPager);
                viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                    }
                });
                pestanas.setupWithViewPager(viewPager);
                pestanas.getTabAt(0).setIcon(R.drawable.listacliente);
                pestanas.getTabAt(1).setIcon(R.drawable.agregarclientes);

            }
            pestanas.setTabGravity(TabLayout.GRAVITY_FILL);
        }else{
            utilidades.rotacion=1;
        }
        return vista;
    }

    private void llenarViewPager(ViewPager viewPager) {
        seccionesAdapter adaptador = new seccionesAdapter(getFragmentManager());
        adaptador.addFragmento(new ClientFragment(), "");
        adaptador.addFragmento(new RedFragment(), "");
        viewPager.setAdapter(adaptador);
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (utilidades.rotacion == 0) {
            appBar.removeView(pestanas);
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
