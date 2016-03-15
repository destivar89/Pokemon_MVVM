package com.gladheim.pokemonapi;

import com.gladheim.pokemonapi.data.PokemonItem;
import com.gladheim.pokemonapi.data.PokemonListResponse;

import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class ApiManager implements Pokemon{

    public static final String ENDPOINT_POKEMON = "http://pokeapi.co";
    public static final int POKEMON_ORIGINAL_NUMBER = 150;
    private PokemonService pokemonService;

    public ApiManager(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT_POKEMON)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        pokemonService = retrofit.create(PokemonService.class);

    }

    @Override
    public Call<PokemonListResponse> getPokemons() {
        return pokemonService.getPokemons(POKEMON_ORIGINAL_NUMBER);
    }

    @Override
    public Call<com.gladheim.pokemonapi.data.Pokemon> getPokemon(String name) {
        return pokemonService.getPokemon(name);
    }
}
