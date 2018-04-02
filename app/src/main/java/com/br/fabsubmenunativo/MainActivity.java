package com.br.fabsubmenunativo;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;

import com.br.fabsubmenunativo.model.FabSubmenu;
import com.br.fabsubmenunativo.model.InicioFragment;

import java.util.ArrayList;

import static android.widget.RelativeLayout.CENTER_IN_PARENT;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab, fabsub1, fabsub2, fabsub3;
    ArrayList<FloatingActionButton> submenuFab = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        InicioFragment ini = new InicioFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.mContent, ini)
                .commit();
        /*---------- Preparando os botões FAB | Ini  ----------*/
        fab = (FloatingActionButton) findViewById(R.id.fabCustom);
        fabsub1 = (FloatingActionButton) findViewById(R.id.fabsub1);
        fabsub2 = (FloatingActionButton) findViewById(R.id.fabsub2);
        fabsub3 = (FloatingActionButton) findViewById(R.id.fabsub3);
        submenuFab.add(fabsub1);
        submenuFab.add(fabsub2);
        submenuFab.add(fabsub3);
        /*---------- Preparando os botões FAB | Fim  ----------*/

        /*********** FAB com Mensagem | Ini  **********/
        FabSubmenu fsm = new FabSubmenu(fab, submenuFab, MainActivity.this);
        fsm.fabMainTouch();
        fsm.fabSubmenuTouchMessage(fabsub1,"Minha Localização");
        /*********** FAB com Mensagem | Fim  **********/

        /*********** FAB com Activity | Ini  **********/
        Intent i = new Intent(MainActivity.this, FaleConoscoActivity.class);
        fsm.fabSubmenuTouchOpenActivity(fabsub2, i);
        /*********** FAB com Activity | Fim  **********/

        /*********** FAB com Fragment | Ini  **********/
        NotificacoesFragment notif = new NotificacoesFragment();
        FragmentManager managerNotif = getSupportFragmentManager();
        fsm.fabSubmenuTouchOpenFragment(fabsub3, R.id.mContent, notif, managerNotif, "fragment_inicio");
        /*********** FAB com Fragment | Fim  **********/

        /* Setando a cor verde para o primeiro FAB Button */
        fsm.setFabBackgroundColor(fabsub1,"#1b7d83");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
