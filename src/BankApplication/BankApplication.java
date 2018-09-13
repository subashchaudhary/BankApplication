package BankApplication;

import java.util.*;

// Main Class 
public class BankApplication{
	
// Main method
	public static void main(String[] args)
	{
		int n,i;
		int year;
		int rate = 12;
		double amount;
		Random r = new Random();
		BankApplication bank= new BankApplication(); 
		Scanner sc = new Scanner(System.in);
        Account account[] = new Account[10];
		System.out.println("");
		System.out.println("*************************************************");
		System.out.println("************ WELCOME TO OUR XYZ BANK ************");
		System.out.println("*************************************************");
		System.out.println("");
		
		for(;;)
		{   
			System.out.println("*************************************************");
			System.out.println(" \t\tMENU ");
			System.out.println("*************************************************");

			System.out.println("1. Create an Account\n");
			System.out.println("2. Login to Account\n");
			System.out.println("3. Exit\n");
			System.out.println("Enter your choice: \n");
			int ch = sc.nextInt();
			try {
			switch(ch){
        		 
        		case 1: System.out.println("Enter the number of account to be create:\n ");
        	        	n =sc.nextInt();
        	        	for(i=0; i<n; i++)
        	        	{
        	        		System.out.println("Create the " + (i+1) + " Account");
        	        		int accountNumber = Math.abs(r.nextInt());
        	        		System.out.println("Enter your name");
        	        		String name = sc.next();
        	        		System.out.println("Enter your Address:");
        	        		String Address = sc.next();
        	        		System.out.println("Enter your mobile number");
        	        		long mobileNumber = sc.nextLong();
        	        	
        	        		// bankManagement u1[] = new bankManagement();
        	        		account[i] = new Account(accountNumber,name,Address,mobileNumber,n);
        	        		account[i].display();
	                    
        	        	}
        	        	break; 
        	        	
        		case 2: System.out.println("*************************************************");
        			    System.out.println("Welcome to your Account login");
        				System.out.println("*************************************************");
                    	System.out.println("Enter your account number");
                    	int accountcode= sc.nextInt();
                    	int j=0;
                    	while(j < account[j].totalAcc) // loop to go in each account
                    	{
                    		if(accountcode == account[j].accountNumber) //check for account number is same
                    		{  
                    			for(;;)
                    			{   
                    				System.out.println("");
                    				System.out.println("*************************************************");
                    				System.out.println("Welcome to your Account");
                    				System.out.println("*************************************************");
                    				System.out.println("");
                    				System.out.println("1. Display Account");
                    				System.out.println("2. Deposit");
                    				System.out.println("3. Withdraw");
                    				System.out.println("4. Balance Enquiry");
                    				System.out.println("5. transfer Amount ");
                    				System.out.println("6. loan ");
                    				System.out.println("7. Exit ");
                    				System.out.println("Enter your choice:");
                    				int op = sc.nextInt();
                    				switch(op)
                    				{
                    				case 1: account[j].display();
                    				        break;
                    				case 2: System.out.println("Enter Amount");
                    						amount = sc.nextDouble();
                    						
                    						account[j].deposit(amount);
                    						account[j].getTransaction();
                    						break;
	             		    	       
                    				case 3: System.out.println("Enter Amount");
	             		    	        	amount = sc.nextDouble();
	             		    	        	if(amount > account[j].balance)
	             		    	        	{   
	             		    	        		System.out.println("Not Enough Balance");
	             		    	        	}
             		    	        		account[j].withdraw(amount);
             		    	        	    account[j].getTransaction();
 	             		    	        	
	             		    	        	break;
	             		    	        	
                    				case 4: account[j].enquiry();
 	             		                	break;
	             		        
                    				case 5: System.out.println("enter the amount");
                    			            amount= sc.nextDouble();
                    				        System.out.println("Enter the account number to transfer");
                    		                int accno = sc.nextInt();
                    		                int num = account[j].totalAcc;
                    		                account[j].withdraw(amount);
                    		      	        for(int k=0; k < num; k++)
                    		      	        {
                    		      		      if(accno==account[k].accountNumber)
                    		      		      {
                    		      			     account[k].deposit(amount);
                    		      			     account[k].display();
                    		      		      }
                    		      	        }
                    		      	        break;

                    				case 6: System.out.println("The bank rate is 3% perannum");
                    				        System.out.println("The bank rate is 8% for 5 years");
                    				        System.out.println("The bank rate is 12% for more than 5 years");
                    				        System.out.println("Enter the Amount: ");
                    						double principal = sc.nextDouble();
                    						System.out.println("Enter the time duration in year: ");
                    						year = sc.nextInt();
                    						account[j].loan(principal, year, rate);
                    						System.out.println("press 1 for yes and 0 for No");
                    						boolean a=sc.hasNext();
                    						if(a==true)
                    						{
                    							account[j].deposit(principal);
                    						}
                    						 	
                    					   break;
                    				
                    			// case to back
                    				
                    				case 7: System.out.println("THANK YOU FOR YOUR VISIT...!!!");
           				                   //System.exit(0);
                    				main(args);
                    				  
                    					    break;
                    					
                    				default: System.out.println("Invalid Choice");
                    				
                    				} //end of switch
                    			}     // end of for loop                			
                    		}     //end of if condition
                    		j++;   

                    	}
                    	 
                    	break;               
                
        		case 3: System.out.println("Thank you for using our services...!");
   		 	            System.exit(0);
   		 	            break;
   		 	            
         		default: System.out.println("Invalid Input"); 
           }
			}
			catch(NullPointerException e){
				System.out.println("Invalid Input");
			}
		}	
	}
}

 // Account class
class Account{
	Scanner sc = new Scanner(System.in);
	int accountNumber;
	String accountName;
	String Address;
	long mobileNum;
	double balance = 0.00;
	double lastTransaction = 0.00;
    int totalAcc;
    
   
    
    //constructor
	Account(int id, String name, String address, long phone, int n)
	{
		accountNumber = id;
	    accountName = name;
	    Address = address;
	    mobileNum = phone;
	    totalAcc = n;
	}
    //deposit method
    void deposit(double amount) {
    	if(amount != 0)
    	{
    		balance = balance + amount;
    		lastTransaction = amount;
    	}
    }
    //withdraw method
    void withdraw(double amount)
    {  
    	if(amount != 0)
    	{
    		balance = balance - amount;
    		lastTransaction = -amount;
    	}							
    }
    //last transaction
    void getTransaction()
    {
    	if(lastTransaction > 0) //if positive then display amount deposited
    	{   
    		System.out.println("*************************************");
    		System.out.println("Deposited Amount : " + lastTransaction);
    		System.out.println("*************************************");
    	}
    	if(lastTransaction < 0) // if negative then display amount withdrawl
    	{
    		System.out.println("*************************************");
    		System.out.println("Withdraw Amount : " + Math.abs(lastTransaction));
    		System.out.println("*************************************");
    	}
    }
    //Balance inquiry
    public void enquiry()
    {
    	System.out.println("*************************************");
		System.out.println("Total Amount : " + balance);
		System.out.println("*************************************");
    }
    //display Account details	
    public void display()
    {
    	System.out.println("");
		System.out.println("*************************************************");
		System.out.println("Account Details");
		System.out.println("*************************************************");
		System.out.println("");
    	 System.out.println("Your Account No. is = " + accountNumber);
    	 System.out.println("Account Name: = " + accountName);
    	 System.out.println("Address: = " + Address);
    	 System.out.println("Mobile Number: = " + mobileNum);
    	 System.out.println("Total Balance = " + balance);
    	 
    }
    //loan method
    public void loan(double principal, int year, int rate)
    {
    	if( year <= 1)
		{
			rate=3;
			double interest=(principal*rate*year)/100;
			System.out.println("Amount " + principal);
			System.out.println("interest " + interest);
			
		}
		else if(year<=5)
		{
			rate=8;
			double interest=(principal*rate*year)/100;
			System.out.println("Amount " + principal);
			System.out.println("interest " + interest);
			
			
		}
		else
		{
			double interest=(principal*rate*year)/100;
			System.out.println("Amount " + principal);
			System.out.println("interest " + interest);
			
		}
    }
    
//    public void transfer()
//    {
//    
//    }
}

//class transfer{
//	public void Transfer()
//    {
//    	//System.out.println("enter your Account number");
//    	Scanner sc=new Scanner(System.in);
//    	//accountNumber=sc.nextInt();
//    	//for(
//    	System.out.println("enter amount");
//    	int amt=sc.nextInt();
//    	balance=balance-amt;
//    	//end of for
//    	System.out.println("enter the account to transfer");
//    	accountNumber=sc.nextInt();
//    	
//    	for(int k = 0; k < totalAcc; k++)
//    	{
//    	   balance=balance+amt;
//    	}
//    }
//}