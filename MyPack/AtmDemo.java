// Java program to implement the ATM Management System
package MyPack;

import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;  

class Bank 
{
	Scanner sc = new Scanner(System.in);
	public String name ; // To save name of the user
	public String accnumber; // To save the account number
	public String type; //  To ask the type of Account i.e Savings or Current
	public String pin; // To set a password
	public static double tot = 0; // To enter amount
	public Date date; // To get the current date
	public String a,y;
	
	// Function to set the person's data
	void setvalue()
	{
		System.out.println("Enter name:");
		name = sc.nextLine();

		label1:
		while(true)
		{
			System.out.println("Enter Account Number:");
			accnumber = sc.next();
			
			if(accnumber.length()<=0|| accnumber.length()>=9)  
		   	{
				System.out.println("Account Number is invalid must be in the range(0,8)");	
				continue label1;
			}
			else
				break label1;
		}

		label2:
		while(true)
		{
			System.out.println("Enter Pin:");
		    pin = sc.next();

			if(pin.length()<=0|| pin.length()>=5)  
		   	{
				System.out.println("Pin is invalid must be in the range(0,4)");	
				continue label2;
			}
			else
				break label2;
		}
		System.out.println("Enter Account Type:");
		type = sc.next();
		
		label3:
		while(true)
		{
			System.out.println("Enter Balance:");
			tot = sc.nextDouble();

			if(tot<0)  
		   	{
				System.out.println("Balance is invalid must be greater than 0");	
				continue label3;
			}
			else
				break label3;
		}
		date = new Date();
	}

	// Function to display the required data
	void showdata()
	{
		System.out.println("Name:" +name);
		System.out.println("Account Number:"+accnumber);
		System.out.println("Account Type:" +type);
		System.out.println("Pin:" +pin);
		System.out.println("Balance:" +tot);
		System.out.println("Current date is " + date);
	}
}

class Deposit extends Bank
{
	Scanner sc = new Scanner(System.in);
	double amount = 0; // To enter a amount to be deposited
	
	// Function to deposit the amount in ATM
	void deposit()
	{
		System.out.println("Enter amount to be Deposited:");
		amount = sc.nextDouble();
	}

	// Function to show the balance amount
	void showbal()
	{
		Bank.tot = Bank.tot + amount;
		System.out.println("Total Balance is:" +Bank.tot);
	}
}

class Withdraw extends Bank 
{
	public int alter,a,option;
	public static double avai_balance;
	// Function to withdraw the amount in ATM
	
	void withdrawl() 
	{
		try
		{
			Scanner sc = new Scanner(System.in);
	    	
	    	System.out.println("Do you want\n (1) Fast cash or \n (2) Want to withdraw money: ");
        	alter = sc.nextInt();
    
        	if(alter == 1)
        	{
        		System.out.println("How much you want to withdraw: ");
	        	System.out.println("1. 100 ");
	        	System.out.println("2. 500 ");
	        	System.out.println("3. 1000 ");
	        	System.out.println("4. 1500 ");
	        	System.out.println("5. 2000 ");
	        	System.out.println("6. 5000 ");
	        	System.out.println("7. 10000 ");
	        	System.out.println("Enter your Choice: ");
	        	option = sc.nextInt();
   
	        	switch(option)
	        	{
	        		case 1:
	        		{
	        	    	avai_balance = Bank.tot - 100;
	        	    	System.out.println("Available Balance is: " +avai_balance);
	            		break;
	        		}
	        		case 2:
	        		{
	            		avai_balance = Bank.tot - 500;
	            		System.out.println("Available Balance is: " +avai_balance);
	            		break;
	        		}
	        		case 3:
	        		{
	            		avai_balance = Bank.tot - 1000;
	            		System.out.println("Available Balance is: " +avai_balance);
	            		break;
	        		}
	        		case 4:
	        		{
	            		avai_balance = Bank.tot - 1500;
	            		System.out.println("Available Balance is: " +avai_balance);
	            		break;

	        		}
	        		case 5:
	        		{
	            		avai_balance = Bank.tot - 2000;
	            		System.out.println("Available Balance is: " +avai_balance);
	            		break;
	        		}	
	        		case 6:
	        		{
	            		avai_balance = Bank.tot - 5000;
	            		System.out.println("Available Balance is: " +avai_balance);
	            		break;
	        		}
	        		case 7:
	        		{
	            		avai_balance = Bank.tot - 10000;
	            		System.out.println("Available Balance is: " +avai_balance);
	            		break;
	        		}
	        		default:
	        		{
	            		System.out.println("Invalid Output");
	            		break;
	        		}
	        	} //End of Switch case
        	}// End of if Statement

        	else if(alter == 2)
        	{
        		System.out.println("Enter amount to withdraw: ");
 				a = sc.nextInt();
	        	avai_balance = Bank.tot - a;
	        	System.out.println("Available Balance is: " +avai_balance);
        	}
        	else
        	{
        		System.out.println("Invalid Output ");
        	}
   		}catch (Exception e)
        {
            System.out.println("INVALID ENTRY");
        }

	}

}
class Recharge extends Bank
{
	Scanner sc = new Scanner(System.in);
	void recharge()
	{
		double pay;
	    long phone_no;
	    System.out.println("Enter phone no: ");
	    phone_no = sc.nextLong();
	    System.out.println("Enter how much you want to recharge:");
	    pay = sc.nextDouble();
	    Bank.tot = Withdraw.avai_balance - pay;
	    System.out.println("Total Balance is: " +Bank.tot);
	}
}

class Issues extends Bank
{
	void issue()
	{
		String email;
		System.out.println("Enter your Email: ");
		email = sc.nextLine();

		String issue;
		System.out.println("\nWhat is the Issue?");
		issue = sc.nextLine();
		System.out.println();
		System.out.println("Thank you your issue will be solved soon.");
	}
}

class AtmDemo
{
	public static void main(String args[])
	{
		Bank b1 = new Bank();
		Deposit d1 = new Deposit();
		Withdraw w1 = new Withdraw();
		Recharge r1 = new Recharge();
		Issues i1 = new Issues();

		Scanner sc = new Scanner(System.in);
		
		while(true) 
		{
			System.out.println("\n\n ------------ WELCOME TO TANAY'S ATM ---------");
			int choice;
			System.out.println("\t1. Enter name, Account number, Account type");
			System.out.println("\t2. Show Mini Statement ");
			System.out.println("\t3. Deposit Enquiry ");
			System.out.println("\t4. Balance Enquiry");
			System.out.println("\t5. Withdraw Money ");
			System.out.println("\t6. Recharge ");
			System.out.println("\t7. Issues ");
			System.out.println("\t8. Exit ");
			System.out.println("Enter  your choice:");
			choice = sc.nextInt();

			// Choices to select from
			switch (choice) 
			{
				case 1:
					b1.setvalue();
					System.out.println();
					break;
				case 2:
					b1.showdata();
					System.out.println();
					break;
				case 3:
					d1.deposit();
					System.out.println();
					break;
				case 4:
					d1.showbal();
					System.out.println();
					break;
				case 5:
					w1.withdrawl();
					System.out.println();
					break;
				case 6:
					r1.recharge();
					System.out.println();
					break;
				case 7:
					i1.issue();
					System.out.println();
					break;
				case 8:
					System.exit(1);
					break;
				default:
					System.out.println("\nInvalid Choice");
			}
		}
	}
}



