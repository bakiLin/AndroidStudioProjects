package ru.mirea.bakiev.movieproject.domain;

import ru.mirea.bakiev.movieproject.domain.repository.MovieRepository;
import ru.mirea.bakiev.movieproject.domain.models.Movie;

public class SaveFilmToFavoriteUseCase {
    private MovieRepository movieRepository;

    public SaveFilmToFavoriteUseCase (MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public boolean execute(Movie movie){
        return movieRepository.saveMovie(movie);
    }
}
