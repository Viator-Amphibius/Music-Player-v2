package componentsV2;

import java.time.LocalDate;
import java.util.ArrayList;

public class User extends Person{
	private String userName;
	private ArrayList<Album> listOfAlbums;
	private ArrayList<Playlist> listOfPlaylists;
	private Subscription subscription;
	
	public User(String name, LocalDate DOB, String userName, ArrayList<Album> listOfAlbums,
			ArrayList<Playlist> listOfPlaylists, String email) {
		super(name, DOB);
		this.userName = userName;
		this.listOfAlbums = listOfAlbums;
		this.listOfPlaylists = listOfPlaylists;
		this.subscription = new PublicSubscription(email);
	}
	
	public User(String name, LocalDate DOB, String userName, ArrayList<Album> listOfAlbums,
			ArrayList<Playlist> listOfPlaylists, Subscription subscription) {
		super(name, DOB);
		this.userName = userName;
		this.listOfAlbums = listOfAlbums;
		this.listOfPlaylists = listOfPlaylists;
		this.subscription = subscription;
	}
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ArrayList<Album> getListOfAlbums() {
		return listOfAlbums;
	}

	public void setListOfAlbums(ArrayList<Album> listOfAlbums) {
		this.listOfAlbums = listOfAlbums;
	}

	public ArrayList<Playlist> getListOfPlaylists() {
		return listOfPlaylists;
	}

	public void setListOfPlaylists(ArrayList<Playlist> listOfPlaylists) {
		this.listOfPlaylists = listOfPlaylists;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	/**
	 * Adds the given playlist to the user.
	 * @param p
	 */
	public void addPlaylist(Playlist p)
	{
		if(!this.listOfPlaylists.contains(p))
			this.listOfPlaylists.add(p);
	}
	
	/**
	 * Removes the given playlist from the user.
	 * @param p
	 */
	public void removePlaylist(Playlist p)
	{
		this.listOfPlaylists.remove(p);
	}
	
	public void printDetailed()
	{
		super.printPersonDetailed();
		System.out.println("List of albums: ");
		for(Album a: this.listOfAlbums)
		{
			System.out.print("\t");
			a.printBrief();
		}
		System.out.println("List of playlists: ");
		for(Playlist p: this.listOfPlaylists)
		{
			System.out.print("\t");
			p.printBrief();
		}
	}
}
