package appV2;

import java.time.LocalDate;
import java.util.InputMismatchException;

import componentsV2.*;

/**
 * Contains interactive function concerning albums.
 */
public class InteractionAlbum {

	public static void addAlbum_interactive() throws InputMismatchException
	{
		String name, genre;
		LocalDate date;
		Artist tempArtist = null;
		int artistID, exit = 0;
		Album tempAlbum;
		
		System.out.print("Enter the albums's name: ");
		name = MusicPlayer.in.nextLine();
		
		System.out.print("Enter the albums's genre: ");
		genre = MusicPlayer.in.nextLine();
		
		System.out.println("Enter the album's release date: ");
		date = Interaction.getDate_interactive();
		
		while(exit != 1)
		{
			System.out.print("Enter the album's artist's id (or -1 to cancel the album addition): ");
			artistID = MusicPlayer.in.nextInt();
			MusicPlayer.in.nextLine();
			if(artistID == -1)
			{
				System.out.println("Process Aborted!");
				return;
			}
			tempArtist = MusicPlayer.getArtist(artistID);
			if(tempArtist != null)
				exit = 1;
			else
			{
				System.out.println("No artist was found with given ID. The album must be added to an already existing artist.");
			}
		}
		exit = 0;
		
		tempAlbum = MusicPlayer.addAlbum(name, genre, date, tempArtist);
		
		System.out.println("The album was created successfully with ID: " + tempAlbum.getId());
	}
}
