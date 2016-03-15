package com.gladheim.pokemonmvvm.list.ui.viewmodel;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.volley.toolbox.ImageLoader;
import com.gladheim.pokemonapi.data.PokemonItem;
import com.gladheim.pokemonmvvm.global.application.CustomApplication;

/**
 * Created by destivar on 04/03/16.
 */
public class PokemonViewModel extends BaseObservable{

    private PokemonItem model;
    private Activity activity;

    public PokemonViewModel(Activity activity, PokemonItem model) {
        this.model = model;
        this.activity = activity;
    }

    @Bindable
    public String getName() {
        return model.getName();
    }

    @Bindable
    public String getPokemonId(){
        String[] splitedString = model.getUrl().split("/");
        return splitedString[splitedString.length-1];
    }

    @Bindable
    public ImageLoader getImageLoader() {
        return ((CustomApplication)activity.getApplication()).getImageLoader();
    }

}
