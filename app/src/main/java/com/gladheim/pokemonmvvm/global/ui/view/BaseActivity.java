package com.gladheim.pokemonmvvm.global.ui.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by destivar on 04/03/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

    }

    protected abstract int getLayoutId();

}
