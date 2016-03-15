package com.gladheim.pokemonmvvm.detail.ui.viewmodel;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.android.volley.toolbox.ImageLoader;
import com.gladheim.pokemonapi.ApiManager;
import com.gladheim.pokemonapi.data.Pokemon;
import com.gladheim.pokemonapi.data.PokemonItem;
import com.gladheim.pokemonmvvm.BR;
import com.gladheim.pokemonmvvm.R;
import com.gladheim.pokemonmvvm.detail.ui.view.DetailView;
import com.gladheim.pokemonmvvm.global.application.CustomApplication;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by destivar on 04/03/16.
 */
public class DetailViewModel extends BaseObservable{

    private DetailView view;
    private Pokemon pokemon;
    private String name;
    private String id;
    private boolean isLoading;
    private Activity activity;

    public DetailViewModel(DetailView view, PokemonItem item) {
        this.view = view;
        activity = (Activity) view;
        name = item.getName();
        String[] splitedString = item.getUrl().split("/");
        id = splitedString[splitedString.length-1];
    }

    public void getPokemon() {
        ApiManager apiManager = new ApiManager();
        Call<Pokemon> call = apiManager.getPokemon(name);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Response<Pokemon> response, Retrofit retrofit) {
                isLoading = false;
                pokemon = response.body();
                notifyPropertyChanged(BR.contentVisibility);
                notifyPropertyChanged(BR.detailProgressVisibility);
                notifyPropertyChanged(BR.height);
                notifyPropertyChanged(BR.weight);
            }

            @Override
            public void onFailure(Throwable t) {
                view.showErrorFeedback();
                isLoading = false;
                notifyPropertyChanged(BR.contentVisibility);
                notifyPropertyChanged(BR.detailProgressVisibility);
            }
        });
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getHeight() {

        if(pokemon ==  null) return "";
        return activity.getString(R.string.string_height, pokemon.getHeight());

    }

    @Bindable
    public String getWeight() {

        if(pokemon ==  null) return "";
        return activity.getString(R.string.string_weight, pokemon.getWeight());

    }

    @Bindable
    public ImageLoader getImageLoader() {
        return ((CustomApplication)activity.getApplication()).getImageLoader();
    }

    @Bindable
    public String getPokemonId() {
        return id;
    }

    @Bindable
    public int getContentVisibility () {
        if (isLoading) return View.GONE;
        else return View.VISIBLE;
    }

    @Bindable
    public int getDetailProgressVisibility () {
        if (isLoading) return View.VISIBLE;
        else return View.GONE;
    }

}
