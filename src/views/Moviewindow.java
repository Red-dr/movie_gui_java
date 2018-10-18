package views;

import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import database.Movie;
import database.MovieDatabase;
/**
 * 
 * This class represents a template example of a standard "View" 
 * component of the Model-View-Controller architecture.
 * 
 * It maintains a reference to the model (In this case an album database)
 * 
 * 
 * @author kjohnson
 * 
 * */
public class Moviewindow extends JPanel {

	//private instance variables of the model object(s)
	//and all components	

	private MovieDatabase database;

	private JButton addButton;
	private JButton removeButton;
	private JButton saveButton;
	private JList<Movie> movieList;
	private JTextField titleInput;
	private JLabel directorLabel;
	private JTextField directorInput;
	private JLabel genreLabel;
	private JTextField genreInput;
	private JLabel castLabel;
	private JTextField castInput;
	private JLabel metascoreLabel;
	private JTextField metascoreInput;
	private JLabel releaseDateLabel;
	private JTextField releaseDateInput;
	private JScrollPane movieScrollPane;
	
	
	public JLabel getCastLabel()
	{
		return castLabel;
	}
//---------------------------------------------------------------
	public JTextField getCast()
	{
		return castInput;
	}
//--------------------------------------------------------------------
	public JLabel getMetascoreLabel()
	{
		return metascoreLabel;
	}
//---------------------------------------------------------------------
	public JLabel getReleaseDateLabel()
	{
		return releaseDateLabel;
	}
//-------------------------------------------------------------------------
	public JTextField getMetascore()
	{
		return metascoreInput;
	}
//-----------------------------------------------------------------------------
	public JTextField getReleaseDate()
	{
		return releaseDateInput;
	}
//----------------------------------------------------------------------------
	public JLabel getGenreLable()
	{
		return genreLabel;
	}
	//-------------------------------------------------------------------
	
	
	//---------------------------------------------------------
	public JTextField getGenre()
	{
		return genreInput;
	}
	//--------------------------------------------------------------------
	
	

	//----------------------------------------------------------------------
	private JLabel titleLabel;
	public JLabel getTitleLabel() 
	{
		return titleLabel;
	}
	//----------------------------------------------------------------------
	public JLabel getDirectorLabel() 
	{
		return directorLabel;
	}
	//----------------------------------------------------------------------
	public JTextField getTitle()
	{
		return titleInput;
	}

	//----------------------------------------------------------------------
	public JTextField getDirector() 
	{
		return directorInput;
	}
	//----------------------------------------------------------------------
	public JScrollPane getAlbumScrollPane()
	{
		return this.movieScrollPane;
	}
	//----------------------------------------------------------------------
	public JList getMovieList()
	{
		return movieList;
	}
	//----------------------------------------------------------------------

	public JButton getRemoveButton()
	{
		return this.removeButton;
	}
	//----------------------------------------------------------------------

	public JButton getAddButton()
	{
		return this.addButton;
	}
	//----------------------------------------------------------------------
	public JButton getSaveButton()
	{
		return this.saveButton;
	}
	/**
	 *
	 * The constructor prepares a JPanel that
	 * can be added to any JFrame
	 * 
	 * */
	public Moviewindow(MovieDatabase db)
	{
		
		super();

		//set the model to display in this view.
		this.database = db; 

		//manually set the layout of components
		this.setLayout(null);

		//now create the components and set their attributes.
		this.movieList = new JList<Movie>();
		this.movieList.setFont(new Font("Arail", Font.PLAIN,20));
		//display the movie list in a scroll pane
		this.movieList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.movieScrollPane = new JScrollPane(this.movieList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		//place the scroll pane on the panel
		
		movieScrollPane.setLocation(10, 400);
		movieScrollPane.setSize(700,200);
		movieScrollPane.setFont(new Font("Arail", Font.PLAIN,20));
		add(movieScrollPane);

		//create the add button and add to panel
		this.addButton = new JButton("add");		
		addButton.setLocation(100,630);
		addButton.setSize(100, 30);
		addButton.setFont(new Font("Arial",Font.PLAIN,20));
		add(addButton);

		//create the remove button
		this.removeButton = new JButton("remove");		
		removeButton.setLocation(350,630);
		removeButton.setSize(100, 30);
		removeButton.setFont(new Font("Arial",Font.PLAIN,20));
		add(removeButton);
		
		//create the save button
		this.saveButton = new JButton("Save");
		saveButton.setLocation(650,630);
		saveButton.setSize(100,30);
		saveButton.setFont(new Font("Arial", Font.PLAIN,20));
		add(saveButton);

		//title label text
		this.titleLabel = new JLabel("Title");
		titleLabel.setLocation(100, 20);
		titleLabel.setSize(100, 30);
		titleLabel.setFont(new Font("Arial",Font.PLAIN,20));
		add(titleLabel);

		//input field for title
		this.titleInput = new JTextField();
		titleInput.setLocation(250, 20);
		titleInput.setSize(400, 30);
		titleInput.setFont(new Font("Arial",Font.PLAIN,20));
		add(titleInput);


		//director label text
		this.directorLabel = new JLabel("Director");
		directorLabel.setLocation(100,20+40);
		directorLabel.setSize(100, 30);
		directorLabel.setFont(new Font("Arial",Font.PLAIN,20));
		add(directorLabel);

		//input field for director
		this.directorInput = new JTextField();
		directorInput.setLocation(250, 20+40);
		directorInput.setSize(400, 30);
		directorInput.setFont(new Font("Arial",Font.PLAIN,20));
		add(directorInput);
		
		//genre label text
		this.genreLabel = new JLabel("Genre");
		genreLabel.setLocation(100,20+40+40);
		genreLabel.setSize(100, 30);
		genreLabel.setFont(new Font("Arial",Font.PLAIN,20));
		add(genreLabel);
		
		//input field for genre
		this.genreInput = new JTextField();
		genreInput.setLocation(250,20+40+40);
		genreInput.setSize(400,30);
		genreInput.setFont(new Font("Arial", Font.PLAIN,20));
		add(genreInput);
		
		//castlist label text
		this.castLabel = new JLabel("Cast List");
		castLabel.setLocation(100, 20+80+40);
		castLabel.setSize(200,30);
		castLabel.setFont(new Font("Arial", Font.PLAIN,20));
		add(castLabel);
		
		//input field for castlist
		this.castInput = new JTextField();
		castInput.setLocation(250,20+80+40);
		castInput.setSize(400, 30);
		castInput.setFont(new Font("Arial", Font.PLAIN,20));
		add(castInput);
		
		//metasore label text
		this.metascoreLabel = new JLabel("Metascore");
		metascoreLabel.setLocation(100,20+80+80);
		metascoreLabel.setSize(200,30);
		metascoreLabel.setFont(new Font("Arial", Font.PLAIN,20));
		add(metascoreLabel);
		
		//input field for metascore
		this.metascoreInput = new JTextField();
		metascoreInput.setLocation(250, 20+80+80);
		metascoreInput.setSize(200,30);
		metascoreInput.setFont(new Font("Arail", Font.PLAIN,20));
		add(metascoreInput);
		
		//releasedate lable text
		this.releaseDateLabel = new JLabel("Release Date");
		releaseDateLabel.setLocation(100, 20+80+80+40);
		releaseDateLabel.setSize(250,30);
		releaseDateLabel.setFont(new Font("Arail", Font.PLAIN,20));
		add(releaseDateLabel);
		
		
		//input Field For releasedate
		this.releaseDateInput = new JTextField();
		releaseDateInput.setLocation(250,20 +80+80+40);
		releaseDateInput.setSize(200,30);
		releaseDateInput.setFont(new Font("Arail", Font.PLAIN,20));
		add(releaseDateInput);
		
	
		//call the update method
		this.update();
	}
	//----------------------------------------------------------------------
	/**
	 * 
	 * The update method is used to update the information shown
	 * by each component in the view, based on the data stored in the model
	 * 
	 * */
	public void update()
	{
		//update the view's list of movies...
		this.getRemoveButton().setEnabled((this.database.getNumberOfMovies()>0));
		this.movieList.setListData(this.database.toList());
	}

}
