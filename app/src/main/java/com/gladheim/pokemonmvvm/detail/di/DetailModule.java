package com.gladheim.pokemonmvvm.detail.di;

import dagger.Module;
import dagger.Provides;

import com.gladheim.pokemonapi.data.PokemonItem;
import com.gladheim.pokemonmvvm.detail.ui.view.DetailView;
import com.gladheim.pokemonmvvm.detail.ui.viewmodel.DetailViewModel;

/**
 * Created by destivar on 04/03/16.
 */
@Module
public class DetailModule {

    private DetailViewModel viewModel;

    public DetailModule(DetailView view, PokemonItem pokemonItem) {
        viewModel = new DetailViewModel(view, pokemonItem);
    }

    @Provides
    DetailViewModel provideDetailViewModel() {
        return viewModel;
    }

}
