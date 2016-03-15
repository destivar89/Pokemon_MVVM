package com.gladheim.pokemonmvvm.detail.di;

import dagger.Component;
import com.gladheim.pokemonmvvm.detail.ui.view.DetailActivity;
import com.gladheim.pokemonmvvm.global.di.PerActivity;

/**
 * Created by destivar on 04/03/16.
 */
@PerActivity
@Component(modules = DetailModule.class)
public interface DetailComponent {
    void inject(DetailActivity activity);
}
