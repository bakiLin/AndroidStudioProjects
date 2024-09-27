package ru.mirea.bakiev.movieproject.domain;

import ru.mirea.bakiev.movieproject.domain.models.Movie;
import ru.mirea.bakiev.movieproject.domain.repository.MovieRepository;

public class GetFavoriteFilmUseCase {
    private MovieRepository movieRepository;

    public GetFavoriteFilmUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie execute(){
        return movieRepository.getMovie();
    }
}
