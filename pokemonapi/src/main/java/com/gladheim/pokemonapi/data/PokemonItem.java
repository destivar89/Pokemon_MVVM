package com.gladheim.pokemonapi.data;

import java.io.Serializable;

/**
 * Created by destivar on 04/03/16.
 */
public class PokemonItem implements Serializable{

    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
