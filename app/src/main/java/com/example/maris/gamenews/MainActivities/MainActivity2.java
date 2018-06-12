package com.example.maris.gamenews.MainActivities;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.maris.gamenews.Class.Adapter.RecyclerAdapter;
import com.example.maris.gamenews.Class.Cardview;

import com.example.maris.gamenews.Class.News;
import com.example.maris.gamenews.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,

        Cardview.OnFragmentInteractionListener{

            List<News> newsList;
            RecyclerView rv;
            RecyclerView.Adapter adapter;


            @Override
            protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);


            newsList = new ArrayList<>();

            rv = findViewById(R.id.recycler);

            //agregando quemados

                newsList.add(new News(null,"NOTICIAS LOL",null));
                newsList.add(new News(null,"NOTICIAS DOTA",null));
                newsList.add(new News(null,"NOTICIAS CSGO",null));
                newsList.add(new News(null,"NOTICIAS LOL",null));
                newsList.add(new News(null,"NOTICIAS DOTA",null));
                newsList.add(new News(null,"NOTICIAS CSGO",null));

            //llamando al recycler

                GridLayoutManager gridLayoutManager = new GridLayoutManager(this,6);
                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {

                        switch (position % 3){

                            case 0:
                                return 6;
                            case 1:
                            case 2:
                                return 3;

                        }

                        throw new IllegalStateException("Error");

                    }
                });

                rv.setLayoutManager(gridLayoutManager);
                adapter = new RecyclerAdapter(this,newsList);
                rv.setAdapter(adapter);

    }

        @Override
        public void onBackPressed () {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
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
        public boolean onNavigationItemSelected (MenuItem item){
        // Handle navigation view item clicks here.

            android.support.v4.app.Fragment miFragment = null;
            boolean fragmentSeleccionado=false;


            int id = item.getItemId();
            fragmentSeleccionado=true;

            if (id == R.id.nav_news) {
                miFragment = new Cardview();
                fragmentSeleccionado=true;

            } else if (id == R.id.nav_lol) {

            } else if (id == R.id.nav_csgo) {

            } else if (id == R.id.nav_dota) {

            }

            if (fragmentSeleccionado){

                getSupportFragmentManager().beginTransaction().replace(R.id.contenido,miFragment).commit();

            }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
        }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
