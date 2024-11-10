package ru.mirea.bakiev.recipe_app.presentation.viewModels;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class RegActivityViewModelFactory implements ViewModelProvider.Factory {
    private Context context;

    public RegActivityViewModelFactory(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new AuthActivityViewModel(context);
    }
}
