package database;

public class Movie {	
	private String title;
	private String director;
	private String genre;
	private String castlist;
	private String releasedate;
	private String metascore;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}

	public Movie(String title,String director, String genre,String castlist,String releasedate,String metascore)
	{
		this.setTitle(title);
		this.setDirector(director);
		this.setGenre(genre);
		this.setCastlist(castlist);
		this.setMetascore(metascore);
		this.setReleasedate(releasedate);
	}
	public String toString(){
		return  this.title;
	}
	public String getMetascore()
	{
		return metascore;
	}
	public void setMetascore(String metascore)
	{
		this.metascore = metascore;
	}
	public String getReleasedate()
	{
		return releasedate;
	}
	public void setReleasedate(String releasedate)
	{
		this.releasedate = releasedate;
	}
	public String getCastlist()
	{
		return castlist;
	}
	public void setCastlist(String castlist)
	{
		this.castlist = castlist;
	}
	public String getGenre()
	{
		return genre;
	}
	public void setGenre(String genre)
	{
		this.genre = genre;
	}
	
}

