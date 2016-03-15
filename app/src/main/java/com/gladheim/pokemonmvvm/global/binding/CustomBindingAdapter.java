package com.gladheim.pokemonmvvm.global.binding;

import android.databinding.BindingAdapter;
import android.view.View;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.gladheim.pokemonmvvm.global.volley.BitmapLruCache;

/**
 * Created by destivar on 20/01/16.
 */
public class CustomBindingAdapter {

    public static final String ENDPOINT = "http://pokeapi.co/media/img/";
    public static final String EXTENSION = ".png";

    @BindingAdapter({"imageUrl", "imageLoader"})
    public static void loadImageWithLoader(NetworkImageView imageView, String pokemonId, ImageLoader imageLoader){
        imageView.setImageUrl(ENDPOINT + pokemonId + EXTENSION, imageLoader);

    }

    @BindingAdapter("bind:visibility")
    public static void visibility(View view, int visibility){
        view.setVisibility(visibility);
    }

}
