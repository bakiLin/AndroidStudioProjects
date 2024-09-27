package ru.mirea.bakiev.movieproject.data;

import android.content.Context;
import android.content.SharedPreferences;

import ru.mirea.bakiev.movieproject.domain.models.Movie;
import ru.mirea.bakiev.movieproject.domain.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {
    private Context context;

    public MovieRepositoryImpl(Context context) {
        this.context = context;
    }

    @Override
    public boolean saveMovie(Movie movie) {
        SharedPreferences sharedPref = context.getSharedPreferences("movies", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("top_movie", movie.getName());
        editor.apply();

        return true;
    }

    @Override
    public Movie getMovie() {
        SharedPreferences sharedPref = context.getSharedPreferences("movies", Context.MODE_PRIVATE);
        String filmName = sharedPref.getString("top_movie", "green_book");

        return new Movie(1, filmName);
    }
}
