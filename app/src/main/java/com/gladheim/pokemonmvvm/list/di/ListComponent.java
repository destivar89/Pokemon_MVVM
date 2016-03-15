package com.gladheim.pokemonmvvm.list.di;

import dagger.Component;
import com.gladheim.pokemonmvvm.global.di.PerActivity;
import com.gladheim.pokemonmvvm.list.ui.view.ListActivity;

/**
 * Created by destivar on 04/03/16.
 */
@PerActivity
@Component(modules = ListModule.class)
public interface ListComponent {
    void inject(ListActivity activity);
}
