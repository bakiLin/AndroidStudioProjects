package ru.mirea.bakiev.data.storage.sharedprefs;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ru.mirea.bakiev.data.storage.UserStorage;
import ru.mirea.bakiev.domain.models.User;

public class SharedPrefsUserStorage implements UserStorage {
    private final SharedPreferences sharedPreferences;
    private static String SHARED_PREFS_NAME = "user_data";
    private static String KEY_USER_NAME = "user_name";
    private static String KEY_USER_EMAIL = "user_email";
    private static String KEY_USER_PASS = "user_pass";
    private static String KEY_USER_CREATED_RECIPE = "user_created_recipes";
    private static String KEY_USER_FAVOURITE_RECIPE = "user_favourite_recipes";

    public SharedPrefsUserStorage(Context context) {
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
    }

    public User getUser() {
        String name = sharedPreferences.getString(KEY_USER_NAME, "");
        String email = sharedPreferences.getString(KEY_USER_EMAIL, "");
        String password = sharedPreferences.getString(KEY_USER_PASS, "");
        Set<String> createdRecipeSet = sharedPreferences.getStringSet(KEY_USER_CREATED_RECIPE, null);
        Set<String> favouriteRecipeSet = sharedPreferences.getStringSet(KEY_USER_FAVOURITE_RECIPE, null);

        List<String> createdRecipeList = new ArrayList<>(createdRecipeSet);
        List<String> favouriteRecipeList = new ArrayList<>(favouriteRecipeSet);

        return new User(name, email, password, createdRecipeList, favouriteRecipeList);
    }

    public void saveUser(User user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_USER_NAME, user.getName());
        editor.putString(KEY_USER_EMAIL, user.getEmail());
        editor.putString(KEY_USER_PASS, user.getPass());

        Set<String> createdRecipeSet = new HashSet<>(user.getCreatedRecipes());
        editor.putStringSet(KEY_USER_CREATED_RECIPE, createdRecipeSet);

        Set<String> favouriteRecipeSet = new HashSet<>(user.getFavouriteRecipes());
        editor.putStringSet(KEY_USER_FAVOURITE_RECIPE, favouriteRecipeSet);

        editor.apply();
    }
}
