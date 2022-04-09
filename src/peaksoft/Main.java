package peaksoft;

import peaksoft.enums.SortType;
import peaksoft.exceptions.BadInputException;
import peaksoft.exceptions.MovieNotFoundException;
import peaksoft.models.Movie;
import peaksoft.services.MovieSearchService;
import peaksoft.services.MovieSortService;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	// write your code here

        MovieSearchService movieSearchService = new MovieSearchService();
        MovieSortService movieSortService = new MovieSortService();
        Scanner scanner = new Scanner(System.in);

//        System.out.print("How you want to sort movies asc & desc : ");
//        String sort = scanner.nextLine();
//        List<Movie> movies;
//
//        if (sort.equalsIgnoreCase("asc")) {
//            movies = movieSortService.sortMoviesByName(SortType.ASC);
//        } else if (sort.equalsIgnoreCase("desc")) {
//            movies = movieSortService.sortMoviesByName(SortType.DESC);
//        } else {
//            throw new BadInputException("you give wrong input type");
//        }
//
//        movies.forEach(System.out::println);

        try {
            System.out.print("find by director name : ");
            String directorsName = scanner.nextLine();
            movieSearchService.findByDirectorName(directorsName)
                    .forEach(System.out::println);
        } catch (MovieNotFoundException movieNotFoundException) {
            System.out.println("\u001B[36m " + movieNotFoundException.getMessage());
        }
    }
}
