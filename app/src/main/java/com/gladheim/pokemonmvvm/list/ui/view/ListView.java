package com.gladheim.pokemonmvvm.list.ui.view;

import android.view.View;

import com.gladheim.pokemonapi.data.PokemonItem;

/**
 * Created by destivar on 04/03/16.
 */
public interface ListView {
    void goToDetail(PokemonItem pokemon, View thumb);
}
