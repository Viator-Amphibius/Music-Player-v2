package appV2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;

import componentsV2.*;

/**
 * Contains interactive function concerning songs.
 */
public class InteractionSong {
	public static void addSong_interactive() throws InputMismatchException
	{
		int albumID, exit = 0;
		String name, genre;
		LocalDate date;
		Song tempSong;
		Album tempAlbum = null;
		ArrayList<Album> otherAlbums;
		Artist tempArtist = null;
		
		System.out.print("Enter the song's name: ");
		name = MusicPlayer.in.nextLine();
		
		System.out.print("Enter the song's genre: ");
		genre = MusicPlayer.in.nextLine();
		
		while(exit != 1)
		{
			System.out.print("Enter the song's main(first) album id (or -1 to cancel the song addition): ");
			albumID = MusicPlayer.in.nextInt();
			MusicPlayer.in.nextLine();
			if(albumID == -1)
			{
				System.out.println("Process Aborted!");
				return;
			}
			tempAlbum = MusicPlayer.getAlbum(albumID);
			if(tempAlbum != null)
				exit = 1;
			else
			{
				System.out.println("No album was found with given ID. The song must be added to an already existing album.");
			}
		}
		exit = 0;
		
		date = tempAlbum.getReleaseDate();
		
		tempArtist = tempAlbum.getArtist();
		
		System.out.print("Enter other albums that the song belongs to: ");
		otherAlbums = Interaction.getAlbums_interactive();
		
		ArrayList<Album> albums = new ArrayList<>();
		albums.add(tempAlbum);
		albums.addAll(otherAlbums);
		
		tempSong = MusicPlayer.addSong(name, genre, date, albums, tempArtist); //will handle adding the song to its albums song lists
		
		System.out.println("The song was created successfully with ID: " + tempSong.getId());
	}
	
	public static void deleteSongbyId_interactive() throws InputMismatchException
	{
		int id;
		System.out.print("Enter the song's id: ");
		id = MusicPlayer.in.nextInt();
		MusicPlayer.in.nextLine();
		Song tempSong = MusicPlayer.deleteSong(id);
		if(tempSong == null)
			System.out.println("No song was found with the given id.");
		else
			System.out.println("The song named \""+ tempSong.getName() + "\" whose id is " + tempSong.getId() + " was deleted.");
	}
	
	public static void deleteSongbyName_interactive()
	{
		String name;
		System.out.print("Enter the song's name: ");
		name = MusicPlayer.in.nextLine();
		Song tempSong = MusicPlayer.deleteSong(name);
		if(tempSong == null)
			System.out.println("No song was found with the given name.");
		else
			System.out.println("The song named \""+ tempSong.getName() + "\" whose id is " + tempSong.getId() + " was deleted.");
	}
	
	public static void getSongAlbum_interactive() throws InputMismatchException
	{
		int songID;
		System.out.print("Enter the song's id: ");
		songID = MusicPlayer.in.nextInt();
		MusicPlayer.in.nextLine();
		ArrayList<Album> albums = MusicPlayer.getSongAlbums(songID);
		if(albums == null)
			System.out.println("No song was found with the given id.");
		else {
			System.out.println("The albums that the song belongs to: ");
			for(Album album:albums)
			{
				album.printDetailed();
				System.out.println("***********");
			}
		}
	}
}
