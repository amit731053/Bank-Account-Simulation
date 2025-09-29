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

        acc.withdrawal(100);
        acc.deposit(10000);
        acc.showHistory();
        acc.withdrawal(50000);
        acc.deposit(-150);
        acc.showHistory();
    }

}
