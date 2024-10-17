package ru.mirea.bakiev.data.storage.sharedprefs;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import ru.mirea.bakiev.data.storage.UserStorage;
import ru.mirea.bakiev.data.storage.models.User;

public class SharedPrefsUserStorage implements UserStorage {
    private SharedPreferences sharedPreferences;
    private static String SHARED_PREFS_NAME = "user_data";
    private static String KEY_USER_ID = "user_id";
    private static String KEY_USER_NAME = "user_name";
    private static String KEY_USER_EMAIL = "user_email";
    private static String KEY_USER_PASS = "user_pass";
    private static String KEY_USER_CREATED_RECIPES = "user_created_recipes";
    private static String KEY_USER_FAVOURITE_RECIPES = "user_favourite_recipes";

    public SharedPrefsUserStorage(Context context) {
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
    }

    public User getUser() {
        int id = sharedPreferences.getInt(KEY_USER_ID, 0);
        String name = sharedPreferences.getString(KEY_USER_NAME, "");
        String email = sharedPreferences.getString(KEY_USER_EMAIL, "");
        String password = sharedPreferences.getString(KEY_USER_PASS, "");
        Set<String> createdRecipeSet = sharedPreferences.getStringSet(KEY_USER_CREATED_RECIPES, null);
        Set<String> favouriteRecipeSet = sharedPreferences.getStringSet(KEY_USER_FAVOURITE_RECIPES, null);

        List<String> temp = new ArrayList<>(createdRecipeSet);
        List<Integer> createdRecipesID = temp.stream().map(Integer::parseInt).collect(Collectors.toList());

        temp = new ArrayList<>(favouriteRecipeSet);
        List<Integer> favouriteRecipesID = temp.stream().map(Integer::parseInt).collect(Collectors.toList());

        return new User(id, name, email, password, createdRecipesID, favouriteRecipesID);
    }

    public void saveUser(User user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_USER_ID, user.getId());
        editor.putString(KEY_USER_NAME, user.getUsername());
        editor.putString(KEY_USER_EMAIL, user.getEmail());
        editor.putString(KEY_USER_PASS, user.getPass());

        List<String> temp = user.getCreatedRecipesID().stream().map(Object::toString).collect(Collectors.toList());
        Set<String> createdRecipeSet = new HashSet<>(temp);
        editor.putStringSet(KEY_USER_CREATED_RECIPES, createdRecipeSet);

        temp = user.getFavouriteRecipesID().stream().map(Object::toString).collect(Collectors.toList());
        Set<String> favouriteRecipeSet = new HashSet<>(temp);
        editor.putStringSet(KEY_USER_FAVOURITE_RECIPES, favouriteRecipeSet);

        editor.apply();
    }
}
