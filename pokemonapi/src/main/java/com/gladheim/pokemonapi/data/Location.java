package com.gladheim.pokemonapi.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by destivar on 04/03/16.
 */
public class Location implements Serializable {

    @SerializedName("location_area")
    private LocationArea locationArea;

}
