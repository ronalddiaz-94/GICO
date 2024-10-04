package gico.com.sistemagico;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import gico.com.sistemagico.cliente.fragments.ClientFragment;
import gico.com.sistemagico.cliente.fragments.RedFragment;
import gico.com.sistemagico.cliente.fragments.contenedorClienteFragment;
import gico.com.sistemagico.producto.fragments.CamionFragment;
import gico.com.sistemagico.producto.fragments.contenedorProductFragment;
import gico.com.sistemagico.producto.fragments.productFragment;
import gico.com.sistemagico.ventas.fragments.pasosVentaFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, RedFragment.OnFragmentInteractionListener,
        ClientFragment.OnFragmentInteractionListener, contenedorClienteFragment.OnFragmentInteractionListener,
        bienvenidaFragment.OnFragmentInteractionListener,productFragment.OnFragmentInteractionListener,
        contenedorProductFragment.OnFragmentInteractionListener, CamionFragment.OnFragmentInteractionListener,
        pasosVentaFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        ((generalGICO) this.getApplication()).setBodega("2");


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (utilidades.validaPantalla==true){
            Fragment fragment= new bienvenidaFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();
            utilidades.validaPantalla=false;
        }



        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment miFragment=null;
        boolean fragmentSeleccionado=false;
        if (id == R.id.nav_cliente) {
            miFragment= new contenedorClienteFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_producto) {
            miFragment= new contenedorProductFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_ventas) {
            miFragment= new pasosVentaFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_cerrarSesion) {
            utilidades.validaPantalla=true;
            Intent intent = new Intent(MainActivity.this, pantallaLogin.class);
            startActivity(intent);

        }


        if(fragmentSeleccionado==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, miFragment).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
