package com.gladheim.pokemonmvvm.splash.ui;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.gladheim.pokemonapi.ApiManager;
import com.gladheim.pokemonapi.data.PokemonListResponse;
import com.gladheim.pokemonmvvm.BR;
import com.gladheim.pokemonmvvm.R;
import com.gladheim.pokemonmvvm.global.ui.view.BaseActivity;
import com.gladheim.pokemonmvvm.list.ui.view.ListActivity;

import java.io.Serializable;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by destivar on 15/03/16.
 */
public class SplashActivity extends BaseActivity {

    @Bind(R.id.splash_pika)
    ImageView splashPika;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);

        AnimationDrawable pikaAnimation = (AnimationDrawable) splashPika.getBackground();
        pikaAnimation.start();
        getPokemons();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    public void getPokemons() {
        ApiManager apiManager = new ApiManager();
        Call<PokemonListResponse> call = apiManager.getPokemons();
        call.enqueue(new Callback<PokemonListResponse>() {
            @Override
            public void onResponse(Response<PokemonListResponse> response, Retrofit retrofit) {
                Intent intent = new Intent(SplashActivity.this, ListActivity.class);
                intent.putExtra(getString(R.string.extra_pokemon_list), (Serializable) response.body().getList());
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(Throwable t) {
                Intent intent = new Intent(SplashActivity.this, ListActivity.class);
                intent.putExtra(getString(R.string.extra_error), t);
                startActivity(intent);
                finish();
            }
        });
    }
}
