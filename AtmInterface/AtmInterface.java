

import java.util.Scanner;

import javax.swing.text.AsyncBoxView.ChildLocator;

public class AtmInterface {
    String userid;
    String password;
    String history="";
    int balance=0;
    String username;
    int transactions=0;

    public void Register()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("\nEnter user Name:");
        this.username=sc.nextLine();

        System.out.print("Enter user id:");
        this.userid=sc.nextLine();

        System.out.print("Enter password:");
        this.password=sc.nextLine();
        System.out.println("\n\nRegistration successfully completed.\n");
    }

    public int Login()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("\n*****Login******\n");
                    
        System.out.print("Enter UserID:");
        String loginid=sc.nextLine();
        System.out.print("Enter Password:");
        String password=sc.nextLine();

        if(this.userid.equals(loginid) && this.password.equals(password))
        {
            return(1);
        }
        return(0);
    }

    public void withdraw()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("\nEnter amount to withdraw:");
        int withdraw=sc.nextInt();

        if(withdraw <= this.balance)
        {
            transactions++;
            this.balance=this.balance-withdraw;
            System.out.print("Withdraw successful\n");
            String str=withdraw + " RS. Withdrawed\n";
            this.history=this.history.concat(str);
        }
        else{
            System.out.println("Insufficient balance.\n");
        }
    }

    public void deposit()
    {
        transactions++;
        Scanner sc=new Scanner(System.in);
        System.out.print("\nEnter amount to deposit:");
        int deposit=sc.nextInt();
        this.balance=this.balance+deposit;
        System.out.println("Deposited Successfully\n");
        String str=deposit+" Rs. Deposited\n";
        this.history=this.history.concat(str);
    }

    public void transfer()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("\nEnter amount to transfer:");
        int transfer=sc.nextInt();
        if(transfer<= this.balance)
        {
            transactions++;
            this.balance=this.balance-transfer;
            System.out.println("Transfer successful\n");
            String str=transfer + " RS. transfered\n";
            this.history=this.history.concat(str);
        }
        else{
            System.out.println("Insufficient balance.\n");
        }
    }

    public void Checkbalance()
    {
        System.out.println("\nAvailable balance is: "+this.balance);
    }

    public void transactionhistory()
    {
        if(this.transactions!=0)
        {
            System.out.println("Transaction History");
            System.out.println("\n"+this.history);
        }
        else{
            System.out.println("No transaction history found.");
        }
    }

    

    public static void main(String[] args) {
        AtmInterface ob=new AtmInterface();
        System.out.println("******************WelCome**********************\n");
        System.out.println("1.Register");
        System.out.println("2.Exit\n");
        System.out.print("Select your choice:");
        Scanner sc=new Scanner(System.in);
        int register=sc.nextInt();
        switch(register)
        {
           
            case 1:{
                ob.Register();
                
                while(true)
                {
                    System.out.println("\n1.Login");
                    System.out.println("2.Exit\n");
                    System.out.print("Select your choice:");
                    int loginchoice=sc.nextInt();
                    switch(loginchoice)
                    {
                        
                        case 1:
                        {
                            int temp=ob.Login();
                            if(temp==1)
                            {
                                System.out.println("\nLogin Successful.\n");
                                while(true)
                                {
                                    int flag=0;
                                    System.out.println("\n1.Transaction History");
                                    System.out.println("2.Withdraw");
                                    System.out.println("3.Deposit");
                                    System.out.println("4.Transfer");
                                    System.out.println("5.Check Balance");
                                    System.out.println("6.Exit\n");
                                    System.out.print("Enter Your Choice:");
                                    
                                    int Choice=sc.nextInt();
                                    
                                    switch(Choice)
                                    {
                                        
                                        case 1:ob.transactionhistory(); break;
                                        case 2:ob.withdraw(); break;
                                        case 3:ob.deposit(); break;
                                        case 4:ob.transfer(); break;
                                        case 5:ob.Checkbalance();break;
                                        case 6: flag=1;break;
                                        
                                    }
                                    if(flag==1){break;}
                                } 
                            }
                            else{
                                System.out.println("\nInvalid details.\n");
                                break;
                            }break;
                        }
                    case 2:System.exit(0);
                    } 
                }
            }
            case 2:System.exit(0);
        }
    }
}
