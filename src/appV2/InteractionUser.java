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
	
	public static void subscribeUser_Interactive() throws InputMismatchException
	{
		int id;
		System.out.print("Enter the user's id: ");
		id = MusicPlayer.in.nextInt();
		MusicPlayer.in.nextLine();
		User tempUser = MusicPlayer.getUser(id);
		if(tempUser == null)
		{
			System.out.println("No user was found with the given id.");
			return;
		}
		
		int type;
		System.out.println("Choose the subscription type");
		System.out.println("1->Public, 2->Student, 3->Premium, else->abort process");
		System.out.print("Your choice: ");
		type = MusicPlayer.in.nextInt();
		MusicPlayer.in.nextLine();
		if(type!=1 && type!=2 && type!=3)
		{
			System.out.println("Process Aborted");
			return;
		}
		
		System.out.print("Enter your email: ");
		String email = MusicPlayer.in.nextLine();
		String schoolName, schoolAddress, workOrganization, workAddress;
		int schoolID, studentID;
		long card;
		switch (type)
		{
			case 1:
				MusicPlayer.subscribeUser(tempUser, new PublicSubscription(email));
				System.out.println(tempUser.getUserName() + " now has a public subscription" +
					" that will expire on: " + tempUser.getSubscription().getExpiryDate());
				break;
			case 2:
				System.out.print("Enter your school's name: ");
				schoolName = MusicPlayer.in.nextLine();
				System.out.print("Enter your school's address: ");
				schoolAddress = MusicPlayer.in.nextLine();
				System.out.print("Enter your school's id: ");
				schoolID = MusicPlayer.in.nextInt();
				MusicPlayer.in.nextLine();
				System.out.print("Enter your student's id: ");
				studentID = MusicPlayer.in.nextInt();
				MusicPlayer.in.nextLine();
				MusicPlayer.subscribeUser(tempUser, new StudentSubscription(email, schoolName, schoolID, schoolAddress, studentID));
				System.out.println(tempUser.getUserName() + " now has a student subscription" +
					" that will expire on: " + tempUser.getSubscription().getExpiryDate());
				break;
			default:
				System.out.print("Enter your work organization's name: ");
				workOrganization = MusicPlayer.in.nextLine();
				System.out.print("Enter your work organization's address: ");
				workAddress = MusicPlayer.in.nextLine();
				System.out.print("Enter your credit card's number: ");
				card = MusicPlayer.in.nextLong();
				MusicPlayer.in.nextLine();
				MusicPlayer.subscribeUser(tempUser, new PremiumSubscription(email,card,workOrganization,workAddress));
				System.out.println(tempUser.getUserName() + " now has a premium subscription" +
						" that will expire on: " + tempUser.getSubscription().getExpiryDate());
				break;
		}
	}
}
