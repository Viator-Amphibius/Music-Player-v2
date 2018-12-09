package appV2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;

import componentsV2.*;

/**
 * Contains interactive function concerning users.
 */
public class InteractionUser {
	public static void addUser_interactive() throws InputMismatchException
	{
		String name;
		LocalDate DOB;
		String userName;
		String email;
		ArrayList<Album> listOfAlbums = new ArrayList<>();
		ArrayList<Playlist> listOfPlaylists = new ArrayList<>();
		User tempUser;
		
		System.out.print("Enter the real name: ");
		name = MusicPlayer.in.nextLine();
				
		DOB = Interaction.getDate_interactive();
		
		System.out.print("Enter the userName: ");
		userName = MusicPlayer.in.nextLine();
		
		System.out.print("Enter the user's email: ");
		email = MusicPlayer.in.nextLine();
		
		System.out.println("Add albums to the user:");
		listOfAlbums = Interaction.getAlbums_interactive();
		
		System.out.println("Add playlists to the user:");
		listOfPlaylists = Interaction.getPlaylists_interactive();
				
		tempUser = MusicPlayer.addUser(name, DOB, userName, listOfAlbums, listOfPlaylists, email);
		
		System.out.println("The user was created successfully with ID: " + tempUser.getId());
		
	}
	
	public static void deleteUserbyId_interactive() throws InputMismatchException
	{
		int id;
		System.out.print("Enter the user's id: ");
		id = MusicPlayer.in.nextInt();
		MusicPlayer.in.nextLine();
		User tempUser = MusicPlayer.deleteUser(id);
		if(tempUser == null)
			System.out.println("No user was found with the given id.");
		else
			System.out.println("The user named \""+ tempUser.getUserName() + "\" whose id is " + tempUser.getId() + " was deleted.");
	}
	
	public static void deleteUserbyName_interactive()
	{
		String name;
		System.out.print("Enter the user's name: ");
		name = MusicPlayer.in.nextLine();
		User tempUser = MusicPlayer.deleteUser(name);
		if(tempUser == null)
			System.out.println("No user was found with the given name.");
		else
			System.out.println("The user named \""+ tempUser.getUserName() + "\" whose id is " + tempUser.getId() + " was deleted.");
	}
	
	public static void viewUserDetails_interactive() throws InputMismatchException
	{
		int id;
		System.out.print("Enter the user's id: ");
		id = MusicPlayer.in.nextInt();
		MusicPlayer.in.nextLine();
		boolean check = MusicPlayer.viewUserDetails(id);
		if(check == false)
			System.out.println("No user was found with the given id.");
	}
	
	/*
	public static ArrayList<User> getFollowers_interactive() throws InputMismatchException
	{
		int temp, exit = 0;
		ArrayList<User> listOfFollowers = new ArrayList<>();
		while (exit != 1)
		{
			User tempUser;
			System.out.print("\tEnter follower's id (or -1 to skip): ");
			temp = MusicPlayer.in.nextInt();
			MusicPlayer.in.nextLine();
			if(temp != -1)
			{
				tempUser = MusicPlayer.getUser(temp); 
				if(tempUser != null)
				{
					if(listOfFollowers.contains(tempUser))
						System.out.println("\tThe follower is already added.");
					else {
						listOfFollowers.add(tempUser);
						System.out.println("\tThe follower was added successfully.");
					}
				}
				else
				{
					System.out.println("\tNo user was found with the provided ID.");
				}	
			}
			else
				exit = 1;
		}
		return listOfFollowers;
	}
	
	public static ArrayList<User> getFollowings_interactive() throws InputMismatchException
	{
		int temp, exit = 0;
		ArrayList<User> listOfFollowings = new ArrayList<>();
		while (exit != 1)
		{
			User tempUser;
			System.out.print("\tEnter following's id (or -1 to skip): ");
			temp = MusicPlayer.in.nextInt();
			MusicPlayer.in.nextLine();
			if(temp != -1)
			{
				tempUser = MusicPlayer.getUser(temp); 
				if(tempUser != null)
				{
					if(listOfFollowings.contains(tempUser))
						System.out.println("\tThe following is already added.");
					else {
						listOfFollowings.add(tempUser);
						System.out.println("\tThe following was added successfully.");
					}
				}
				else
				{
					System.out.println("\tNo user was found with the provided ID.");
				}	
			}
			else
				exit = 1;
		}
		return listOfFollowings;
	}*/
}
