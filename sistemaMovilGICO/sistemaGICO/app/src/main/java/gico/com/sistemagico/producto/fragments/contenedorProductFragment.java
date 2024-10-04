package gico.com.sistemagico.producto.fragments;

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
import gico.com.sistemagico.producto.adaptadores.SeccionesProductoAdapter;
import gico.com.sistemagico.utilidades;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link contenedorProductFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link contenedorProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class contenedorProductFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER



    private OnFragmentInteractionListener mListener;
    View vista;
    private AppBarLayout appBarLayout;
    private TabLayout pestanas;
    private ViewPager viewPager;
    public contenedorProductFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment contenedorProductFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static contenedorProductFragment newInstance(String param1, String param2) {
        contenedorProductFragment fragment = new contenedorProductFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista= inflater.inflate(R.layout.fragment_contenedor_product, container, false);

        if (utilidades.rotacion==0){
            View parent= (View) container.getParent();
            if (appBarLayout==null){
                appBarLayout=(AppBarLayout) parent.findViewById(R.id.appBar);
                pestanas= new TabLayout(getActivity());
                pestanas.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#D33142"));
                pestanas.setBackgroundColor(Color.parseColor("#2c3e50"));
                pestanas.setSelectedTabIndicatorColor(Color.parseColor("#E4EE06"));
                pestanas.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));

                appBarLayout.addView(pestanas);
                viewPager= (ViewPager) vista.findViewById(R.id.idViewPagerProducto);
                llenarViewPager(viewPager);

                viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                    }
                });
                pestanas.setupWithViewPager(viewPager);
                pestanas.getTabAt(0).setIcon(R.drawable.enempresa);
                pestanas.getTabAt(1).setIcon(R.drawable.encamion);
            }
            pestanas.setTabGravity(TabLayout.GRAVITY_FILL);
        }else {
            utilidades.rotacion=1;
        }
        return vista;
    }

    private void llenarViewPager(ViewPager viewPager) {
        SeccionesProductoAdapter seccionesProductoAdapter= new SeccionesProductoAdapter(getFragmentManager());
        seccionesProductoAdapter.addFragmanents(new productFragment(), "");
        seccionesProductoAdapter.addFragmanents(new CamionFragment(), "");
        viewPager.setAdapter(seccionesProductoAdapter);
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
        if (utilidades.rotacion==0){
            appBarLayout.removeView(pestanas);
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
