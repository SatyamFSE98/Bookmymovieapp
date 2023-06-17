package com.bookmymoviesapp.service;

import java.util.List;

import com.bookmymoviesapp.exceptions.DuplicateMovieIdExceptions;
import com.bookmymoviesapp.exceptions.DuplicateMovieNameException;
import com.bookmymoviesapp.model.Movie;

public interface MovieService {

	public List<Movie> getAllMovies();

	public Movie addMovie(Movie movie) throws DuplicateMovieIdExceptions, DuplicateMovieNameException;

	public boolean deleteMovie(String movieName, String theatreName);

	public boolean updateMovie(Movie movie);

	public Movie getMovieById(int mid);
	
	public List<Movie> getMovieByName(String name);
	
	//public List<Movie> searchByMovieName(String str) throws MovieNotAvailableException;

}
