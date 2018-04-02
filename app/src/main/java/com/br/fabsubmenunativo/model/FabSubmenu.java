package com.br.fabsubmenunativo.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;

import com.br.fabsubmenunativo.R;

import java.util.ArrayList;

public class FabSubmenu {
    private FloatingActionButton fab;
    private ArrayList<FloatingActionButton> submenuFab ;
    private OvershootInterpolator interpolator;
    private Boolean fabActionEnable;
    private FragmentManager manager;
    private Context ctx;

    public FabSubmenu(FloatingActionButton fab, ArrayList<FloatingActionButton> submenuFab, Context ctx) {
        this.fab = fab;
        this.submenuFab = submenuFab;
        this.interpolator =  new OvershootInterpolator();
        this.fabActionEnable = false;
        this.ctx = ctx;
    }


    public void fabMainTouch(){
        getFab().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ft = getSubmenuFab().size();
                if(!getFabActionEnable()){
                    for(int f=0;f<ft;f++){ getSubmenuFab().get(f).show(); }
                    setFabActionEnable(true);
                    ViewCompat.animate(getFab()).
                            rotation(135f).
                            withLayer().
                            setDuration(1000).
                            setInterpolator(getInterpolator()).
                            start();
                } else {
                    for(int f=0;f<ft;f++){ getSubmenuFab().get(f).hide(); }
                    setFabActionEnable(false);
                    ViewCompat.animate(getFab()).
                            rotation(0f).
                            withLayer().
                            setDuration(1000).
                            setInterpolator(getInterpolator()).
                            start();
                }

            }
        });
    }
    public void hideSubmenu(){
        int ft = getSubmenuFab().size();
        for(int f=0;f<ft;f++){ getSubmenuFab().get(f).hide(); }
        setFabActionEnable(false);
        ViewCompat.animate(getFab()).
                rotation(0f).
                withLayer().
                setDuration(1000).
                setInterpolator(getInterpolator()).
                start();
    }

    public void fabSubmenuTouchMessage(FloatingActionButton fabSub, String message){
        final String msg = message;
        fabSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSubmenu();
                Toast.makeText(getCtx(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void fabSubmenuTouchOpenActivity(FloatingActionButton fabSub , Intent intent){
        final Intent i = intent;
        fabSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCtx().startActivity(i);
                hideSubmenu();
            }
        });
    }

    public void fabSubmenuTouchOpenFragment(FloatingActionButton fabSub,int contentFragament, Fragment myFragment, FragmentManager manager, String fragmentoRetorno){
        final Fragment fragment = myFragment;
        final int contentReplaceFragament = contentFragament;
        final   FragmentManager managerHere = manager;
        final String retorno = fragmentoRetorno;

        fabSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managerHere.beginTransaction()
                        .replace(contentReplaceFragament, fragment)
                        .addToBackStack(retorno)
                        .commit();
                hideSubmenu();
            }
        });
    }
    public void setFabBackgroundColor(FloatingActionButton fab, String hexadecimalColor){
        fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(hexadecimalColor)));
    }


    public FloatingActionButton getFab() {
        return fab;
    }

    public void setFab(FloatingActionButton fab) {
        this.fab = fab;
    }

    public ArrayList<FloatingActionButton> getSubmenuFab() {
        return submenuFab;
    }

    public void setSubmenuFab(ArrayList<FloatingActionButton> submenuFab) {
        this.submenuFab = submenuFab;
    }

    public OvershootInterpolator getInterpolator() {
        return interpolator;
    }

    public void setInterpolator() {
        this.interpolator =  new OvershootInterpolator();
    }

    public Boolean getFabActionEnable() {
        return fabActionEnable;
    }

    public void setFabActionEnable(Boolean fabActionEnable) {
        this.fabActionEnable = fabActionEnable;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }
}
