package gico.com.sistemagico.producto.adaptadores;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SeccionesProductoAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> listaFragents=new ArrayList<>();
    private final List<String> listaTitulos=new ArrayList<>();
    public SeccionesProductoAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragmanents(Fragment fragment, String titulo){
        listaTitulos.add(titulo);
        listaFragents.add(fragment);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listaTitulos.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return listaFragents.get(position);
    }

    @Override
    public int getCount() {
        return listaFragents.size();
    }
}
