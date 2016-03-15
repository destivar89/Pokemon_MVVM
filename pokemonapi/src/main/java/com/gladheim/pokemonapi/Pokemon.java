package com.gladheim.pokemonapi;

import com.gladheim.pokemonapi.data.PokemonItem;
import com.gladheim.pokemonapi.data.PokemonListResponse;

import java.util.List;

import retrofit.Call;

/**
 * Created by destivar on 04/03/16.
 */
public interface Pokemon {

    Call<PokemonListResponse> getPokemons();

    Call<com.gladheim.pokemonapi.data.Pokemon> getPokemon(String name);

}
