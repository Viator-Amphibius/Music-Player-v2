package appV2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;

import componentsV2.*;

/**
 * Contains interactive function concerning artists.
 */
public class InteractionArtist {
	public static void addArtist_interactive() throws InputMismatchException
	{
		String name, typeOfMusic;
		LocalDate DOB;
		ArrayList<String> awards;
		
		System.out.print("Enter the artist's name: ");
		name = MusicPlayer.in.nextLine();
		
		DOB = Interaction.getDate_interactive();
		
		System.out.print("Enter the artist's type of music: ");
		typeOfMusic = MusicPlayer.in.nextLine();
		
		System.out.println("Enter the artist's awards: ");
		awards = Interaction.getAwards_interactive();
		
		Artist tempArtist = MusicPlayer.addArtist(name, DOB, typeOfMusic, awards);
		
		System.out.println("The artist was created successfully with ID: " + tempArtist.getId());
	}
}
