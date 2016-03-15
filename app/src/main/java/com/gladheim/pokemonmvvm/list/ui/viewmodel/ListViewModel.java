package com.gladheim.pokemonmvvm.list.ui.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.gladheim.pokemonapi.ApiManager;
import com.gladheim.pokemonapi.data.PokemonItem;
import com.gladheim.pokemonapi.data.PokemonListResponse;
import com.gladheim.pokemonmvvm.BR;
import com.gladheim.pokemonmvvm.list.ui.adapter.PokemonAdapter;
import com.gladheim.pokemonmvvm.list.ui.view.ListView;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by destivar on 04/03/16.
 */
public class ListViewModel extends BaseObservable implements PokemonAdapter.OnItemClickListener {

    private ListView view;
    private PokemonAdapter adapter;
    private boolean isLoading = true;

    public ListViewModel(ListView view, PokemonAdapter adapter) {
        this.view = view;
        this.adapter = adapter;
        this.adapter.setOnItemClickListener(this);
    }

    public void setPokemons(List<PokemonItem> pokemons) {
        adapter.setPokemonItems(pokemons);
        adapter.notifyDataSetChanged();
        isLoading = false;
        notifyPropertyChanged(BR.recyclerVisibility);
        notifyPropertyChanged(BR.progressVisibility);
    }

    @Bindable
    public int getRecyclerVisibility () {
        if (isLoading) return View.GONE;
        else return View.VISIBLE;
    }

    @Bindable
    public int getProgressVisibility () {
        if (isLoading) return View.VISIBLE;
        else return View.GONE;
    }


    @Override
    public void onItemClick(View v, int position) {
        view.goToDetail(adapter.getPokemon(position), v);
    }
}
