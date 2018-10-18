package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.Scanner;
import java.io.*;

import database.Movie;
import database.MovieDatabase;
import views.Moviewindow;

/**
 * 
 * this class is the controler of the app this controls what the buttens and the
 * inputs do
 * 
 * @author callum drennan 14880673
 * 
 */
public class Moviecontroller extends JFrame
{

	private static final int Interger = 0;
	// the model... may be one or instances of objects.
	private static MovieDatabase movieDatabase;
	private Movie currentMovieSelection;
	// the "window" view of your app. contains all JComponents
	private Moviewindow moviewindow;
	// ----------------------------------------------------------------------

	/**
	 * this method looks thought the file and add the text to the feilds in the
	 * array
	 * 
	 * @author callum drennan 14880673s
	 * @throws IOException
	 */
	public void readFile() throws IOException
	{
		String title;
		String director;
		String genre;
		String cast;
		String metascore;
		String release;
		// this.movieDatabase = new MovieDatabase();

		try
		{
			Scanner file = new Scanner(new File("input/movielist.txt"));
			do
			{

				file.nextLine();// title
				title = file.nextLine();

				file.nextLine();// director
				director = file.nextLine();

				file.nextLine();// genre
				genre = file.nextLine();

				file.nextLine();// cast
				cast = file.nextLine();

				file.nextLine();// metascore
				metascore = file.nextLine();

				file.nextLine();// release
				release = file.nextLine();

				file.nextLine();

				Movie movie = new Movie(title, director, genre, cast, metascore, release);

				movieDatabase.add(movie);
				moviewindow.update();
			} while (file.hasNextLine());

			file.close();
		} catch (FileNotFoundException e)
		{

		} catch (NumberFormatException e)
		{
			System.err.println("Exception Error: " + e);
		}
	}

	public Moviecontroller(String title) throws IOException
	{
		super(title);
		this.currentMovieSelection = null;
		this.movieDatabase = new MovieDatabase();
		this.moviewindow = new Moviewindow(this.movieDatabase);
		this.readFile();
		moviewindow.getMovieList().setListData(movieDatabase.toList());
		// prepare the frame by adding the "view"
		getContentPane().add(this.moviewindow);

		// the dimensions of the window and it's close behaviour
		setSize(800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		/*
		 * Runtime.getRuntime().addShutdownHook(new Thread(new Runnable()) {
		 * 
		 * public void run(String[] args) throws IOException {
		 * 
		 * 
		 * 
		 * } });
		 */
		// set event handlers for all components
		// event handler for on button
		moviewindow.getAddButton().addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				eventHandlerAddButton();
			}
		});

		moviewindow.getRemoveButton().addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				eventHandlerRemoveButton();
			}
		});

		moviewindow.getSaveButton().addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					save();
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		moviewindow.getMovieList().addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				eventHandlerUpdateTitleMovieFields();
			}

		});

	}

	// ----------------------------------------------------------------------
	/**
	 * 
	 * Event handler methods go here. There are two things every event handler
	 * must do:
	 * 
	 * 1) modify the model based on the GUI event 2) update the view by calling
	 * view.update()
	 * 
	 */
	private void eventHandlerAddButton()
	{
		String title = moviewindow.getTitle().getText();
		String director = moviewindow.getDirector().getText();
		String genre = moviewindow.getGenre().getText();
		String cast = moviewindow.getCast().getText();
		String metascore = moviewindow.getMetascore().getText();
		String releasedate = moviewindow.getReleaseDate().getText();

		if (!(title.isEmpty() || director.isEmpty() || genre.isEmpty() || cast.isEmpty() || metascore.isEmpty()
				|| releasedate.isEmpty()))
		{
			Movie movie = new Movie(title, director, genre, cast, metascore, releasedate);
			this.movieDatabase.add(movie);
			this.clearMovieInput();
		}
		moviewindow.update();
	}

	// ----------------------------------------------------------------------
	private void clearMovieInput()
	{
		this.moviewindow.getTitle().setText("");
		this.moviewindow.getDirector().setText("");
		this.moviewindow.getGenre().setText("");
		this.moviewindow.getCast().setText("");
		this.moviewindow.getMetascore().setText("");
		this.moviewindow.getReleaseDate().setText("");
	}

	// ----------------------------------------------------------------------
	private void eventHandlerUpdateTitleMovieFields()
	{

		this.currentMovieSelection = (Movie) this.moviewindow.getMovieList().getSelectedValue();

		if (currentMovieSelection != null)
		{
			this.moviewindow.getTitle().setText(currentMovieSelection.getTitle());
			this.moviewindow.getDirector().setText(currentMovieSelection.getDirector());
			this.moviewindow.getGenre().setText(currentMovieSelection.getGenre());
			this.moviewindow.getCast().setText(currentMovieSelection.getCastlist());
			this.moviewindow.getMetascore().setText(currentMovieSelection.getMetascore());
			this.moviewindow.getReleaseDate().setText(currentMovieSelection.getReleasedate());
		} else
		{

			clearMovieInput();
		}
		moviewindow.update();
	}

	// ----------------------------------------------------------------------
	private void eventHandlerRemoveButton()
	{
		this.movieDatabase.remove(currentMovieSelection);
		this.currentMovieSelection = null;
		clearMovieInput();

		moviewindow.update();
	}

	/**
	 * this method itterates thought the array and saves the items to
	 * corrisponding elements and saves to a file
	 * 
	 * @author callum drennan 14880673
	 * 
	 */
	public void save() throws IOException
	{
		/*
		 * File myFile= new File("input/output.txt"); FileWriter writer = new
		 * FileWriter(myFile);
		 */
		// BufferedWriter bw = new BufferedWriter(writer);
		PrintWriter write = new PrintWriter("input/output.txt");
		String outputString = "";

		Movie[] hello = movieDatabase.toList();

		for (int i = 0; i < hello.length; ++i)
		{
			outputString += "@title\n";
			outputString += "" + hello[i].getTitle();
			outputString += "\n@director\n";
			outputString += "" + hello[i].getDirector();
			outputString += "\n@genre\n";
			outputString += "" + hello[i].getGenre();
			outputString += "\n@cast\n";
			outputString += "" + hello[i].getCastlist();
			outputString += "\n@release\n";
			outputString += "" + hello[i].getReleasedate();
			outputString += "\n@metascore\n";
			outputString += "" + hello[i].getMetascore() + "\n";

		}
		write.println(outputString);
		write.close();
	}

	// ----------------------------------------------------------------------
	/**
	 * 
	 * The main method makes an instance of the MovieController class and then
	 * sets it to visible
	 * 
	 * @throws IOException
	 * 
	 */
	public static void main(String[] args) throws IOException
	{

		JFrame app = new Moviecontroller("Movie Database window");
		app.setVisible(true);
	}
	// ----------------------------------------------------------------------

}
