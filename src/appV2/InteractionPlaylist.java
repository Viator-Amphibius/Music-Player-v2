package appV2;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;

import componentsV2.*;

/**
 * Contains interactive function concerning playlists.
 */
public class InteractionPlaylist {
	public static void addPlaylist_interactive() throws InputMismatchException
	{
		String name;
		LocalDate date;
		User tempUser = null;
		ArrayList<Song> songs;
		int userID, exit = 0;
		
		while(exit != 1)
		{
			System.out.print("Enter the user's id (or -1 to cancel the playlist addition): ");
			userID = MusicPlayer.in.nextInt();
			MusicPlayer.in.nextLine();
			if(userID == -1)
			{
				System.out.println("Process Aborted!");
				return;
			}
			tempUser = MusicPlayer.getUser(userID);
			if(tempUser != null)
				exit = 1;
			else
			{
				System.out.println("No user was found with given ID. The playlist must be added to an already existing user.");
			}
		}
		exit = 0;
		
		System.out.print("Enter the playlist's name: ");
		name = MusicPlayer.in.nextLine();
		
		date = LocalDate.now();
		
		System.out.println("Add songs to the playlist:");
		songs = getSongs_interactive();
		
		Playlist tempPlaylist = MusicPlayer.addPlaylist(name, tempUser, date, songs);
		
		System.out.println("The playlist was created successfully with ID: " + tempPlaylist.getId());
	}
	
	public static void addSongToPlaylist_interactive() throws InputMismatchException
	{
		int songID, playlistID;
		
		System.out.print("Enter the song's id: ");
		songID = MusicPlayer.in.nextInt();
		MusicPlayer.in.nextLine();
		
		System.out.print("Enter the playlist's id: ");
		playlistID = MusicPlayer.in.nextInt();
		MusicPlayer.in.nextLine();
		
		int check = MusicPlayer.addSongtoPlaylist(songID, playlistID);
		
		if(check > 0)
		{
			if(check == 1 || check == 3)
				System.out.println("No song was found with given ID.");
			if(check > 1)
				System.out.println("No playlist was found with given ID.");
		}
		else
		{
			if(check < 0)
				System.out.println("The song is already in the playlist.");
			else
				System.out.println("The song was successfully added to the playlist.");
		}
	}
	
	public static void getPlaylistDetails_interactive() throws InputMismatchException
	{
		int id;
		System.out.print("Enter the playlist's id: ");
		id = MusicPlayer.in.nextInt();
		MusicPlayer.in.nextLine();
		boolean check = MusicPlayer.getPlaylistDetails(id);
		if(check == false)
			System.out.println("No playlist was found with the given id.");
	}
	
	public static void deletePlaylist_interactive() throws InputMismatchException
	{
		int userID, playlistID;
		
		System.out.print("Enter the user's id: ");
		userID = MusicPlayer.in.nextInt();
		MusicPlayer.in.nextLine();
		
		System.out.print("Enter the playlist's id: ");
		playlistID = MusicPlayer.in.nextInt();
		MusicPlayer.in.nextLine();
		
		int check = MusicPlayer.deletePlaylist(userID, playlistID);
		
		if(check > 0)
		{
			if(check == 1 || check == 3)
				System.out.println("No user was found with given ID.");
			if(check > 1)
				System.out.println("No playlist was found with given ID.");
		}
		else
		{
			if(check == -1)
				System.out.println("The playlist was not previously added to the user in the first place.");
			else if(check == -2)
				System.out.println("The playlist was successfully deleted for all users, because this user was its owner.");
			else
				System.out.println("The playlist was successfully deleted for the user.");
		}
	}
	
	public static ArrayList<Song> getSongs_interactive() throws InputMismatchException
	{
		int temp, exit = 0;
		ArrayList<Song> listOfSongs = new ArrayList<Song>();
		while (exit != 1)
		{
			Song tempSong;
			System.out.print("\tEnter song's id (or -1 to skip): ");
			temp = MusicPlayer.in.nextInt();
			MusicPlayer.in.nextLine();
			if(temp != -1)
			{
				tempSong = MusicPlayer.getSong(temp); 
				if(tempSong != null)
				{
					if(listOfSongs.contains(tempSong))
						System.out.println("\tThe song is already added.");
					else {
						listOfSongs.add(tempSong);
						System.out.println("\tThe song was added successfully.");
					}
				}
				else
				{
					System.out.println("\tNo song was found with the provided ID.");
				}	
			}
			else
				exit = 1;
		}
		return listOfSongs;
	}
}
