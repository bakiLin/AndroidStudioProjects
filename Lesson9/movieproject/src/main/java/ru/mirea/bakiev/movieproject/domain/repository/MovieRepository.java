package ru.mirea.bakiev.movieproject.domain.repository;

import ru.mirea.bakiev.movieproject.domain.models.Movie;

public interface MovieRepository {
    public boolean saveMovie(Movie movie);
    public Movie getMovie();
}