package appV2;

import java.util.InputMismatchException;

import componentsV2.Person;

public class InteractionPerson {
	public static void followPerson_interactive() throws InputMismatchException
	{
		int yourID, otherID;
		
		System.out.print("Enter the your id: ");
		yourID = MusicPlayer.in.nextInt();
		MusicPlayer.in.nextLine();
		Person you = MusicPlayer.getPerson(yourID);
		
		if(you==null)
		{
			System.out.println("No user or artist was found with the given ID!");
			return;
		}
		
		System.out.print("Enter the id of the person you want to follow: ");
		otherID = MusicPlayer.in.nextInt();
		MusicPlayer.in.nextLine();
		Person them = MusicPlayer.getPerson(otherID);
		
		if(them==null)
		{
			System.out.println("No user or artist was found with the given ID!");
			return;
		}
		
		if(MusicPlayer.followPerson(you, them))
			System.out.println("You are now following the user/artist named \""+ them.getName() + "\" whose id is " + them.getId());
		else
			System.out.println("You are ALREADY following the user/artist named \""+ them.getName() + "\" whose id is " + them.getId());
	}
	
	public static void listFollowers_Interactive() throws InputMismatchException
	{
		int ID;
		
		System.out.print("Enter the person's id: ");
		ID = MusicPlayer.in.nextInt();
		MusicPlayer.in.nextLine();
		Person person = MusicPlayer.getPerson(ID);
		
		if(person==null)
		{
			System.out.println("No user or artist was found with the given ID!");
			return;
		}
		else
		{
			System.out.println("The followers of this person:");
			MusicPlayer.listFollowers(person);
		}
	}
}
