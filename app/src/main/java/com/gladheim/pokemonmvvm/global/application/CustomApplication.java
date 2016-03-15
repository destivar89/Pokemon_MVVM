package com.gladheim.pokemonmvvm.global.application;

import android.app.Application;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.gladheim.pokemonmvvm.global.volley.BitmapLruCache;

/**
 * Created by destivar on 14/03/16.
 */
public class CustomApplication extends Application{

    private ImageLoader imageLoader;

    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoader.ImageCache imageCache = new BitmapLruCache();
        imageLoader = new ImageLoader(Volley.newRequestQueue(getApplicationContext()), imageCache);
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }
}
