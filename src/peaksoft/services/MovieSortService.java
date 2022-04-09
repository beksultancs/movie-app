package peaksoft.services;

import peaksoft.enums.SortType;
import peaksoft.models.Movie;
import peaksoft.repositories.MovieRepository;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;

/**
 * @author Beksultan
 */
public class MovieSortService {
    private final MovieRepository movieRepository;

    public MovieSortService() throws FileNotFoundException {
        this.movieRepository = new MovieRepository();
    }

    public List<Movie> sortMoviesByName(SortType sortType) {
        if (sortType.equals(SortType.ASC)) {
            return movieRepository.getMovieList().stream()
                    .sorted(Comparator.comparing(Movie::getName))
                    .toList();
        } else {
            return movieRepository.getMovieList().stream()
                    .sorted(Comparator.comparing(Movie::getName).reversed())
                    .toList();
        }
    }
}
