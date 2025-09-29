package Internship;
import java.util.*;
public class Account {
    private  String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    Account(String accoutnHolder, double initialBalance)
    {
        this.accountHolder = accoutnHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        this.transactionHistory.add("Account Created With Balance : "+initialBalance);
    }
     void deposit(double amount)
    {
        if(amount>0)
        {
            balance+= amount;
            transactionHistory.add("Deposited : "+amount +", New Balance : "+balance);
        }
        else {
            transactionHistory.add("Failed Deposit Attempt : "+balance);
        }
    }
    public void withdrawal(double amount)
    {
        if(amount>0 && amount <= balance)
        {
            balance-=amount;
            transactionHistory.add("Withdrawal : "+amount+", New Balance : "+balance);
        }
        else {
            transactionHistory.add("Failed Withdrawal Attempt : "+balance);
        }
    }
    void showHistory()
    {
        System.out.println("Transaction History For "+accountHolder+" : ");
        for(String record : transactionHistory)
        {
            System.out.println(record);

        }
    }
    double getBalance()
    {
        return balance;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Account Holder Name : ");
        String name = sc.nextLine();
        System.out.println("Initial Balance : ");
        double balance = sc.nextDouble();
        Account acc = new Account(name,balance);

        int choice;
        do {
            System.out.println("\n--- Account Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Show Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    acc.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double wd = sc.nextDouble();
                    acc.withdrawal(wd);
                    break;
                case 3:
                    System.out.println("Current Balance: " + acc.getBalance());
                    break;
                case 4:
                    acc.showHistory();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }

}
