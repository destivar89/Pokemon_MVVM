package com.gladheim.pokemonapi.data;

import java.util.List;

/**
 * Created by destivar on 07/03/16.
 */
public class PokemonListResponse {

    private int count;
    private String next;
    private String previous;
    private List<PokemonItem> results;

    public List<PokemonItem> getList() {
        return results;
    }
}
