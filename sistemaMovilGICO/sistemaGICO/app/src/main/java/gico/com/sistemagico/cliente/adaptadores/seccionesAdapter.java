package gico.com.sistemagico.cliente.adaptadores;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class seccionesAdapter extends FragmentStatePagerAdapter {
    //ESTE ADAPTADOR SE UTILIZA PARA EL VIEWPAGER DE CLIENTES
    private final List<Fragment> listaFragmentos = new ArrayList<>();
    private final List<String> listaTitulos = new ArrayList<>();

    public seccionesAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragmento(Fragment fragment, String titulo){
        listaTitulos.add(titulo);
        listaFragmentos.add(fragment);
    }



    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listaTitulos.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return listaFragmentos.get(position);
    }

    @Override
    public int getCount() {
        return listaFragmentos.size();
    }



}
