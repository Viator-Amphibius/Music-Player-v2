package appV2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import componentsV2.*;

//TODO: Add songs to album at creation

public class MusicPlayer {

	public static Scanner in = new Scanner(System.in);
	public static ArrayList<Song> songs = new ArrayList<>();
	public static ArrayList<User> users = new ArrayList<>();
	public static ArrayList<Playlist> playlists = new ArrayList<>();
	public static ArrayList<Artist> artists = new ArrayList<>();
	public static ArrayList<Album> albums = new ArrayList<>();

	public static void main(String[] args) {
		DataPopulation.populateMusicPlayer();
		int option, exit=0;
		System.out.println("-------------------Arboreal Music Player-------------------");
		try {
			option = Interaction.menu();
		}
		catch (InputMismatchException e) {
			in.nextLine();
			option = 0;
			System.out.println("Invalid input. Please input numbers only for the menu options.");
		}	
		while(exit != 1)
		{
			try {
				switch(option)
				{
				case 0: //bypass the switch if the input was not valid
					break;
				
				case 1:
					Interaction.addUser_interactive();
					break;
					
				case 2:
					Interaction.deleteUserbyId_interactive();
					break;
					
				case 3:
					Interaction.deleteUserbyName_interactive();
					break;	
					
				case 4:
					Interaction.viewUserDetails_interactive();
					break;
					
				case 5:
					Interaction.addSong_interactive();
					break;
					
				case 6:
					Interaction.deleteSongbyId_interactive();
					break;
					
				case 7:
					Interaction.deleteSongbyName_interactive();
					break;
					
				case 8:
					Interaction.getSongAlbum_interactive();
					break;
					
				case 9:
					Interaction.addAlbum_interactive();
					break;
					
				case 10:
					Interaction.addArtist_interactive();
					break;
					
				case 11:
					Interaction.addPlaylist_interactive();
					break;
					
				case 12:
					Interaction.addSongToPlaylist_interactive();
					break;
					
				case 13:
					Interaction.getPlaylistDetails_interactive();
					break;
					
				case 14:
					Interaction.deletePlaylist_interactive();
					break;
					
				case 15:
					displaySongs();
					break;
					
				case 16:
					displayUsers();
					break;
		
				default:
					exit = 1;
					break;
				}
			}
			catch (InputMismatchException e) {
				in.nextLine();
				System.out.println("Invalid input!");
			}
			if(exit != 1)
			{
				try {
					option = Interaction.menu();
				}
				catch (InputMismatchException e) {
					in.nextLine();
					option = 0;
					System.out.println("Invalid input. Please input numbers only for the menu options.");
				}	
			}
		}
		in.close();
		System.out.println("Program Terminated");

	}
	
	/**
	 * Adds a new user to the system
	 * @param name
	 * @param albums list of albums
	 * @param playlists list of playlists
	 * @param followers list of followers
	 * @param Followings list of followings
	 * @return the newly created user object
	 */
	public static User addUser(String name, LocalDate DOB, String userName, ArrayList<Album> listOfAlbums,
			ArrayList<Playlist> listOfPlaylists, String email)
	{
		User tempUser = new User(name,DOB,userName,listOfAlbums,listOfPlaylists,email);
		users.add(tempUser);
		return tempUser;
	}
		
	/**
	 * Searches for a user using id
	 * @param id
	 * @return the user if found
	 */
	public static User getUser(int id)
	{
		for(User u: users)
		{
			if(u.getId() == id)
				return u;
		}
		return null;
	}
	
	/**
	 * Searches for a user using userName
	 * @param name
	 * @return the user if found
	 */
	public static User getUser(String name)
	{
		for(User u: users)
		{
			if(u.getUserName().equals(name))
				return u;
		}
		return null;
	}
	
	/**
	 * Deletes the user with the given id
	 * @param id
	 * @return the deleted user if found
	 */
	public static User deleteUser(int id)
	{
		User tempUser;
		for(int i=0; i<users.size(); i++)
		{
			if(users.get(i).getId() == id)
			{
				tempUser = users.get(i);
				deleteUserTraces(tempUser);
				users.remove(i);
				return tempUser;
			}
		}
		return null;
	}
	
	/**
	 * Deletes the user with the given userName
	 * @param name
	 * @return the deleted user if found
	 */
	public static User deleteUser(String name)
	{
		User tempUser;
		for(int i=0; i<users.size(); i++)
		{
			if(users.get(i).getUserName().equals(name))
			{
				tempUser = users.get(i);
				deleteUserTraces(tempUser);
				users.remove(i);
				return tempUser;
			}
		}
		return null;
	}
	
	/**
	 * Removes all references to the given user. Used before deletion.
	 * @param u the concerned user
	 */
	public static void deleteUserTraces(User u)
	{
		deletePlaylistsOwnedByUser(u.getId());
		RemovePersonFollowers(u);
		RemovePersonFollowings(u);
	}
	
	/**
	 * prints the details of the user with the given id.
	 * @param id
	 * @return a check to inform the calling function if the user was found or not.
	 */
	public static boolean viewUserDetails(int id)
	{
		User tempUser = getUser(id);
		if(tempUser == null)
			return false;
		else
		{
			tempUser.printDetailed();
			return true;
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Finds a user using the given id.
	 * @param id
	 * @return the playlist if found.
	 */
	public static Playlist getPlaylist(int id)
	{
		for(Playlist p: playlists)
		{
			if(p.getId() == id)
				return p;
		}
		return null;
	}
	
	/**
	 * Deletes all playlists owned by the user with the given id.
	 * @param userId
	 */
	public static void deletePlaylistsOwnedByUser(int userId)
	{
		for(User u: users)
		{
			ArrayList<Playlist> p = u.getListOfPlaylists();
			for(int i=0; i<p.size(); i++)
			{
				if(p.get(i).getOwner().getId() == userId)
					p.remove(i);
			}
		}
		for(int i=0; i<playlists.size(); i++)
		{
			if(playlists.get(i).getOwner().getId() == userId)
				playlists.remove(i);
		}
	}
	
	/**
	 * Deletes the playlist with the given id for all users.
	 * @param playlistID
	 */
	public static void deletePlaylistForAllUser(int playlistID)
	{
		for(User u: users)
		{
			ArrayList<Playlist> p = u.getListOfPlaylists();
			for(int i=0; i<p.size(); i++)
			{
				if(p.get(i).getId() == playlistID)
					p.remove(i);
			}
		}
		for(int i=0; i<playlists.size(); i++)
		{
			if(playlists.get(i).getId() == playlistID)
				playlists.remove(i);
		}
	}
	
	/**
	 * Adds a new playlist to the system for a user
	 * @param userID
	 * @param playlistName
	 * @param playlistDate
	 * @param playlistSongs
	 * @return the new playlist if the user was found.
	 */
	public static Playlist addPlaylistbyUser(int userID, String playlistName, LocalDate playlistDate, ArrayList<Song> playlistSongs)
	{
		User tempUser = getUser(userID);
		if(tempUser == null)
			return null;
		else
			return addPlaylist(playlistName, tempUser, playlistDate, playlistSongs);
	}
	
	/**
	 * Adds a new playlist to the system.
	 * @param name
	 * @param owner
	 * @param date
	 * @param songs
	 * @return the created playlist.
	 */
	public static Playlist addPlaylist(String name, User owner, LocalDate date, ArrayList<Song> songs)
	{
		Playlist tempPlaylist = new Playlist(name, owner, date, songs);
		tempPlaylist.getOwner().addPlaylist(tempPlaylist);
		playlists.add(tempPlaylist);
		return tempPlaylist;
	}
	
	/**
	 * Adds to a user an already existing playlist
	 * @param p
	 * @param u
	 */
	public static void addExistingPlaylistToUser(Playlist p, User u)
	{
		u.addPlaylist(p);
	}
	
	/**
	 * Adds a song to a playlist.
	 * @param songID
	 * @param playlistID
	 * @return an int for error checking in the caller function.
	 */
	public static int addSongtoPlaylist(int songID, int playlistID)
	{
		int error = 0, size;
		Song tempSong = getSong(songID);
		Playlist tempPlaylist = getPlaylist(playlistID);
		if(tempSong == null)
			error++;
		if(tempPlaylist == null)
			error += 2;
		if(error == 0)
		{
			size = tempPlaylist.getSongs().size();
			tempPlaylist.addSong(tempSong);
			if(size == tempPlaylist.getSongs().size())
				error = -1; //just a warning that the song was already in the playlist
		}
		return error;
	}
	
	/**
	 * Prints the details of the playlist with the given id.
	 * @param id
	 * @return a boolean for check.
	 */
	public static boolean getPlaylistDetails(int id)
	{
		Playlist tempPlaylist = getPlaylist(id);
		if(tempPlaylist == null)
			return false;
		else
		{
			tempPlaylist.printDetailed();
			return true;
		}
	}
	
	/**
	 * Deletes a playlist for a user 
	 * @param userID
	 * @param playlistID
	 * @return an int for error checking with the caller function.
	 */
	public static int deletePlaylist(int userID, int playlistID)
	{
		int error = 0;
		User tempUser = getUser(userID);
		Playlist tempPlaylist = getPlaylist(playlistID);
		if(tempUser == null)
			error++;
		if(tempPlaylist == null)
			error += 2;
		if(error == 0)
		{
			if(!tempUser.getListOfPlaylists().contains(tempPlaylist))
			{
				error = -1;
			}
			else
			{
				if(tempPlaylist.getOwner().getId() == userID)
				{
					deletePlaylistForAllUser(playlistID);
					error = -2;
				}
				else
					tempUser.removePlaylist(tempPlaylist);
			}
		}
		return error;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Adds a new song to the system.
	 * @param name
	 * @param genre
	 * @param date
	 * @param album
	 * @param artist
	 * @return the newly created song object.
	 */
	public static Song addSong(String name, String genre, LocalDate date, ArrayList<Album> albums, Artist artist)
	{
		Song tempSong = new Song(name, genre, date, albums, artist);
		for(Album album : albums)
			album.addSong(tempSong);
		songs.add(tempSong);
		return tempSong;
	}
	
	/**
	 * Returns a song with the given id.
	 * @param id
	 * @return the sing if found.
	 */
	public static Song getSong(int id)
	{
		for(Song s: songs)
		{
			if(s.getId() == id)
				return s;
		}
		return null;
	}
	
	/**
	 * Deletes the song with the given id.
	 * @param id
	 * @return the deleted song if found. 
	 */
	public static Song deleteSong(int id)
	{
		Song tempSong;
		for(int i=0; i<songs.size(); i++)
		{
			if(songs.get(i).getId() == id)
			{
				tempSong = songs.get(i);
				for(Album album : tempSong.getAlbums())
					album.removeSong(tempSong);
				songs.remove(i);
				return tempSong;
			}
		}
		return null;
	}
	
	/**
	 * Deletes the song with the given name.
	 * @param name
	 * @return the deleted song if found.
	 */
	public static Song deleteSong(String name)
	{
		Song tempSong;
		for(int i=0; i<songs.size(); i++)
		{
			if(songs.get(i).getName().equals(name))
			{
				tempSong = songs.get(i);
				for(Album album : tempSong.getAlbums())
					album.removeSong(tempSong);
				songs.remove(i);
				return tempSong;
			}
		}
		return null;
	}
	
	/**
	 * Returns the albums of the song with the given id.
	 * @param songID
	 * @return the albums if found.
	 */
	public static ArrayList<Album> getSongAlbums(int songID)
	{
		Song tempSong = getSong(songID);
		if(tempSong==null)
			return null;
		else
			return tempSong.getAlbums();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Gets an album with the given id.
	 * @param id
	 * @return the album if found.
	 */
	public static Album getAlbum(int id)
	{
		for(Album a: albums)
		{
			if(a.getId() == id)
				return a;
		}
		return null;
	}
	
	/**
	 * Adds a new album to the system
	 * @param name
	 * @param genre
	 * @param date
	 * @param artist
	 * @return the newly created album object.
	 */
	public static Album addAlbum(String name, String genre, LocalDate date, Artist artist)
	{
		Album tempAlbum = new Album(name, genre, date, artist);
		tempAlbum.getArtist().addAlbum(tempAlbum);
		albums.add(tempAlbum);
		return tempAlbum;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Gets an artist with the given id.
	 * @param id
	 * @return the artist if found.
	 */
	public static Artist getArtist(int id)
	{
		for(Artist a: artists)
		{
			if(a.getId() == id)
				return a;
		}
		return null;
	}
	
	/**
	 * Adds an artist to the system
	 * @param name
	 * @param country
	 * @param typeOfMusic
	 * @return the newly created artist object.
	 */
	public static Artist addArtist(String name, LocalDate DOB, String typeOfMusic, ArrayList<String> awards)
	{
		Artist tempArtist = new Artist(name, DOB, typeOfMusic, awards);
		artists.add(tempArtist);
		return tempArtist;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	/**
	 * Forces all the given person's followers to unfollow it.
	 * @param person
	 */
	public static void RemovePersonFollowers(Person person)
	{
		if(person != null) {
			for(Person follower: person.getListOfFollowers())
				follower.unfollow(person);
		}
	}
	
	/**
	 * Removes the given person from the list of followers of all the persons that it followed.
	 * @param person
	 */
	public static void RemovePersonFollowings(Person person)
	{
		if(person != null) {
			for(Person following: person.getListOfFollowings())
				following.removeFollower(person);
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Displays all users.
	 */
	public static void displayUsers()
	{
		System.out.println("All the users in the system: \n");
		for(User u:users)
		{
			u.printDetailed();
			System.out.println("***********");
		}	
	}
	
	/**
	 * Displays all songs.
	 */
	public static void displaySongs()
	{
		System.out.println("All the songs in the system: \n");
		for(Song s:songs)
		{
			s.printDetailed();
			System.out.println("***********");
		}	
	}
}
