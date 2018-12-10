package appV2;


import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;

import componentsV2.Album;
import componentsV2.Playlist;


/**
 * Class for interacting with the user. It accordingly calls the functions in the musicplayer class.
 * Since it was too big, I divided it into a couple of classes with separate concerns. Methods calls are self explanatory.
 */
public class Interaction {

	public static int menu() throws InputMismatchException{
		int option;
		System.out.println("\n****Main Menu****");
		System.out.println("1->add user");
		System.out.println("2->delete user by id");
		System.out.println("3->delete user by name");
		System.out.println("4->view user's details");
		System.out.println("5->add a song");
		System.out.println("6->delete song by id");
		System.out.println("7->delete song by name");
		System.out.println("8->view a song's albums");
		System.out.println("9->add an album");
		System.out.println("10->add a playlist from a user");
		System.out.println("11->add a song to a playlist");
		System.out.println("12->view playlist's details");
		System.out.println("13->delete a playlist from a user");
		System.out.println("14->view all songs");
		System.out.println("15->view all users");
		System.out.println("16->add an artist");
		System.out.println("17->delete an artist");
		System.out.println("18->view all artists");
		System.out.println("19->follow a person");
		System.out.println("20->list followers");
		System.out.println("21->subscribe user");
		System.out.println("22->list subscribed users");
		System.out.println("23->increase song limits for public subscriptions");
		System.out.println("else->exit");
		System.out.print("Your choice: ");
		option = MusicPlayer.in.nextInt();
		MusicPlayer.in.nextLine();
		return option;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void addUser_interactive() throws InputMismatchException
	{
		InteractionUser.addUser_interactive();
	}
	
	public static void deleteUserbyId_interactive() throws InputMismatchException
	{
		InteractionUser.deleteUserbyId_interactive();
	}
	
	public static void deleteUserbyName_interactive()
	{
		InteractionUser.deleteUserbyName_interactive();
	}
	
	public static void viewUserDetails_interactive() throws InputMismatchException
	{
		InteractionUser.viewUserDetails_interactive();
	}
	
	public static void subscribeUser_Interactive() throws InputMismatchException
	{
		InteractionUser.subscribeUser_Interactive();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void addSong_interactive() throws InputMismatchException
	{
		InteractionSong.addSong_interactive();
	}
	
	public static void deleteSongbyId_interactive() throws InputMismatchException
	{
		InteractionSong.deleteSongbyId_interactive();
	}
	
	public static void deleteSongbyName_interactive()
	{
		InteractionSong.deleteSongbyName_interactive();
	}
	
	public static void getSongAlbum_interactive() throws InputMismatchException
	{
		InteractionSong.getSongAlbum_interactive();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void addAlbum_interactive() throws InputMismatchException
	{
		InteractionAlbum.addAlbum_interactive();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void addArtist_interactive() throws InputMismatchException
	{
		InteractionArtist.addArtist_interactive();
	}
	
	public static void deleteArtist_interactive()
	{
		InteractionArtist.deleteArtist_interactive();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void addPlaylist_interactive() throws InputMismatchException
	{
		InteractionPlaylist.addPlaylist_interactive();
	}
	
	public static void addSongToPlaylist_interactive() throws InputMismatchException
	{
		InteractionPlaylist.addSongToPlaylist_interactive();
	}
	
	public static void getPlaylistDetails_interactive() throws InputMismatchException
	{
		InteractionPlaylist.getPlaylistDetails_interactive();
	}
	
	public static void deletePlaylist_interactive() throws InputMismatchException
	{
		InteractionPlaylist.deletePlaylist_interactive();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void followPerson_interactive() throws InputMismatchException
	{
		InteractionPerson.followPerson_interactive();
	}
	
	public static void listFollowers_Interactive() throws InputMismatchException
	{
		InteractionPerson.listFollowers_Interactive();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static LocalDate getDate_interactive() throws InputMismatchException
	{
		int d,m,y,exit=0;
		LocalDate date =  LocalDate.now(); //will be overwritten, just as a precaution
		do
		{
			System.out.print("\tEnter the day: ");
			d = MusicPlayer.in.nextInt();
			System.out.print("\tEnter the month: ");
			m = MusicPlayer.in.nextInt();
			System.out.print("\tEnter the year: ");
			y = MusicPlayer.in.nextInt();
			try {
				date = LocalDate.of(y, m, d);
				exit = 1;
			}
			catch (DateTimeException e) {
				System.out.println("Invalid date! Please try again: ");
			}
		}
		while(exit!=1);
		MusicPlayer.in.nextLine();
		return date;
	}
	
	public static ArrayList<Album> getAlbums_interactive() throws InputMismatchException
	{
		int temp, exit = 0;
		ArrayList<Album> listOfAlbums = new ArrayList<Album>();
		while (exit != 1)
		{
			Album tempAlbum;
			System.out.print("\tEnter album's id (or -1 to skip): ");
			temp = MusicPlayer.in.nextInt();
			MusicPlayer.in.nextLine();
			if(temp != -1)
			{
				tempAlbum = MusicPlayer.getAlbum(temp); 
				if(tempAlbum != null)
				{
					if(listOfAlbums.contains(tempAlbum))
						System.out.println("\tThe album is already selected.");
					else {
						listOfAlbums.add(tempAlbum);
						System.out.println("\tThe album was selected successfully.");
					}
				}
				else
				{
					System.out.println("\tNo album was found with the provided ID.");
				}	
			}
			else
				exit = 1;
		}
		return listOfAlbums;
	}
	
	public static ArrayList<Playlist> getPlaylists_interactive() throws InputMismatchException
	{
		int temp, exit = 0;
		ArrayList<Playlist> listOfPlaylists = new ArrayList<>();
		while (exit != 1)
		{
			Playlist tempPlaylist;
			System.out.print("\tEnter playlist's id (or -1 to skip): ");
			temp = MusicPlayer.in.nextInt();
			MusicPlayer.in.nextLine();
			if(temp != -1)
			{
				tempPlaylist = MusicPlayer.getPlaylist(temp); 
				if(tempPlaylist != null)
				{
					if(listOfPlaylists.contains(tempPlaylist))
						System.out.println("\tThe playlist is already added.");
					else
					{
						listOfPlaylists.add(tempPlaylist);
						System.out.println("\tThe playlist was added successfully.");
					}	
				}
				else
				{
					System.out.println("\tNo playlist was found with the provided ID.");
				}	
			}
			else
				exit = 1;
		}
		return listOfPlaylists;
	}
	
	public static ArrayList<String> getAwards_interactive() throws InputMismatchException
	{
		int exit = 0;
		ArrayList<String> awards = new ArrayList<>();
		while (exit != 1)
		{
			String tempAward;
			System.out.print("\tEnter the name of the award (or \"no\" to skip): ");
			tempAward = MusicPlayer.in.nextLine();
			if(!tempAward.equals("no"))
			{
				awards.add(tempAward);	
			}
			else
				exit = 1;
		}
		return awards;
	}
	
}
