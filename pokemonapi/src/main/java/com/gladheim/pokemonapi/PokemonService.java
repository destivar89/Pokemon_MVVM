package com.gladheim.pokemonapi;


import com.gladheim.pokemonapi.data.Pokemon;
import com.gladheim.pokemonapi.data.PokemonItem;
import com.gladheim.pokemonapi.data.PokemonListResponse;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by destivar on 04/03/16.
 */
public interface PokemonService {

    @GET("api/v2/pokemon")
    Call<PokemonListResponse> getPokemons(@Query("limit") int limit);

    @GET("api/v2/pokemon/{name}")
    Call<Pokemon> getPokemon(@Path("name") String name);

}
