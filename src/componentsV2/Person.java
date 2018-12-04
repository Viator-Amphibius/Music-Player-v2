package componentsV2;

import java.time.LocalDate;
import java.util.ArrayList;

import interfaces.IFollow;

public abstract class Person implements IFollow<Person>{

	private static int nextID = 0;
	private int id;
	private String name;
	private LocalDate DOB;
	private ArrayList<Person> listOfFollowers;
	private ArrayList<Person> listOfFollowings;
	public Person(String name, LocalDate DOB)
	{
		this.id = nextID++;
		this.name = name;
		this.DOB = DOB;
		listOfFollowers = new ArrayList<>();
		listOfFollowings = new ArrayList<>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDOB() {
		return DOB;
	}
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
	public ArrayList<Person> getListOfFollowers() {
		return listOfFollowers;
	}
	public void setListOfFollowers(ArrayList<Person> listOfFollowers) {
		this.listOfFollowers = listOfFollowers;
	}
	public ArrayList<Person> getListOfFollowings() {
		return listOfFollowings;
	}
	public void setListOfFollowings(ArrayList<Person> listOfFollowings) {
		this.listOfFollowings = listOfFollowings;
	}
	/**
	 * The next two methods are from the implemented interface.
	 * Ideally, if one of them is called, the other one should also be called for the other object to
	 * ensure the integrity of the relations.
	 * In my opinion, since both methods are public, it would have been better if we only have one 
	 * public method that makes sure that both operations are done. 
 	 */
	public void follow(Person toBeFollowed)
	{
		this.listOfFollowings.add(toBeFollowed);
	}
	public void followedBy(Person toBeFollowed)
	{
		this.listOfFollowers.add(toBeFollowed);
	}
	public void printBrief()
	{
		System.out.println("ID: " + this.id + ", name: " + this.name);
	}
	public void printPersonDetailed()
	{
		System.out.println("id: " + this.id);
		System.out.println("name: " + this.name);
		System.out.println("List of followers: ");
		for(Person p: this.listOfFollowers)
		{
			System.out.print("\t");
			p.printBrief();
		}
		System.out.println("List of followings: ");
		for(Person p: this.listOfFollowings)
		{
			System.out.print("\t");
			p.printBrief();
		}
	}
	public abstract void printDetailed();
}
