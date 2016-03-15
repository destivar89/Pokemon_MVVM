package com.gladheim.pokemonmvvm.list.di;

import dagger.Module;
import dagger.Provides;

import com.gladheim.pokemonmvvm.list.ui.adapter.PokemonAdapter;
import com.gladheim.pokemonmvvm.list.ui.view.ListView;
import com.gladheim.pokemonmvvm.list.ui.viewmodel.ListViewModel;

/**
 * Created by destivar on 04/03/16.
 */
@Module
public class ListModule {

    ListViewModel viewModel;

    public ListModule(ListView view, PokemonAdapter adapter) {
        viewModel = new ListViewModel(view, adapter);
    }

    @Provides
    ListViewModel provideListViewModel(){
        return viewModel;
    }

}
