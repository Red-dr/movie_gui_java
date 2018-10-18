package database;

import java.util.ArrayList;

import database.Movie;;

/**
 * this class is the setting up of the array list
 * @author callum drennan 14880673
 * 
 * */
public class MovieDatabase {
	private ArrayList<Movie> movie;
	//----------------------------------------------------------------------
	public Movie[] toList()
	{
		Movie[] movielist = new Movie[this.movie.size()];
		for(int i=0;i<movielist.length;i++)
		{			
			movielist[i] = this.movie.get(i);
		}

		return movielist;
	}
	//----------------------------------------------------------------------
	public void remove(Movie selectedMovie)
	{
		this.movie.remove(selectedMovie);	
	}
	//----------------------------------------------------------------------
	public void add(Movie a)
	{
		this.movie.add(a);
	}
	//----------------------------------------------------------------------
	public int getNumberOfMovies()
	{
		return this.movie.size();
	}
	//----------------------------------------------------------------------
	public MovieDatabase()
	{
		this.movie = new ArrayList<Movie>();

	}
	//----------------------------------------------------------------------
	public Movie get(int index) {
		if(index >= 0&&index<this.movie.size())
		{
			return this.movie.get(index);
		}
		return null;
	}

}
