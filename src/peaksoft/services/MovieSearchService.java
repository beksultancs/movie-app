package peaksoft.services;

import peaksoft.exceptions.MovieNotFoundException;
import peaksoft.models.Movie;
import peaksoft.repositories.MovieRepository;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author Beksultan
 */
public class MovieSearchService {

    private final MovieRepository movieRepository;

    public MovieSearchService() throws FileNotFoundException {
        movieRepository = new MovieRepository();
    }

    public Movie findMovieByName(String movieName) {
        return movieRepository.getMovieList().stream()
                .filter(m -> m.getName().equalsIgnoreCase(movieName))
                .findFirst().orElseThrow(() -> new MovieNotFoundException(
                        "movie with name = " + movieName + " not found"
                ));
    }

    public List<Movie> findByDirectorName(String directorsName) {
        return movieRepository.getMovieList().stream()
                .filter(movie -> movie.getDirector().getFullName().equalsIgnoreCase(directorsName))
                .toList();
    }
}
