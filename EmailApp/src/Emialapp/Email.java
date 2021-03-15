package Emialapp;
import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String department;
	private int mailboxSize = 500;
	private int defaultPassword = 8;
	private String alternateEmail;
	private String companySuffix = "asdcompany.com";
	
	//constructor receive first and last name
	public Email(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println(this.firstName + " " + this.lastName);
		
		//call method asking for department
		this.department = setDepartment();
		
		//call method for random password
		this.password = ranPassword(defaultPassword);
		
		//combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
	}
	//ask for department
	private String setDepartment()
	{
		System.out.print("\nEnter Department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		//add do while loop to take care of invalid entries
		if(depChoice==1)
			return "Sales";
		else if(depChoice==2)
			return "Development";
		else if(depChoice==3)
			return "Accounting";
		else
			return "";
			
	}
	
	//generate a random password
	private String ranPassword(int length)
	{
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
		char[] password = new char[length];
		for(int i=0; i<length;i++)
		{
			int rand = (int)(Math.random()*passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//set mailbox capacity
	public void setMailboxCapacity(int capacity)
	{
		this.mailboxSize = capacity;
	}
	
	//set alt email
	public void setAltEmail(String altEmail)
	{
		this.alternateEmail = altEmail;
	}
	
	//change password
	public void changePassword(String password)
	{
		this.password = password;
	}
	
	public int getMailboxCapacity()
	{
		return mailboxSize;
	}
	
	public String getAltEmail()
	{
		return alternateEmail;
	}
	public String getPassword()
	{
		return password;
	}
	
	public String print()
	{
		return "\nDisplay Name: " + firstName + " " + lastName + " \nCompany Email: " + email + " \nMailbox Capacity: " + mailboxSize;
	}

}
