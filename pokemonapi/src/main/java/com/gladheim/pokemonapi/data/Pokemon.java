package com.gladheim.pokemonapi.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by destivar on 04/03/16.
 */
public class Pokemon implements Serializable{

    private int id;
    private String name;
    private int height;
    private int weight;
    @SerializedName("location_area_encounters")
    private List<Location> locations;
    private List<AbilityItem> abilities;
    private List<TypeItem> types;

    public int getHeight() {
        return height * 10;
    }

    public int getWeight() {
        return weight / 10;
    }
}
