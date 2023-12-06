package com.driver;

public class BankAccount {

    private String name;

    public double getBalance() {
        return balance;
    }

    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
             this.name = name;
             this.balance = balance;
             this.minBalance = minBalance;
    }

    public BankAccount() {

    }

    public double getMinBalance(){
        return minBalance;
    }
    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

        if(sum==0 && digits==1) return "0";

        if((sum>9*digits) || (sum==0 && digits>1)) throw new Exception("Account Number can not be generated");

        return generator(sum,digits);
    }

    public String generator(int sum, int digits){

        int[] res = new int[digits];
        sum = sum-1;
        for(int i = digits-1;i>=0;i--)
        {
            if(sum>9){
                res[i] = 9;
                sum  = sum - 9;
            }
            else{
                res[i] = sum;
                sum  = 0;
            }
        }
        res[0]++;
        StringBuilder sb = new StringBuilder();
        for(int i:res){
            sb.append(i);
        }

        return sb.toString();

    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(amount>balance)
            throw new Exception("Insufficient Balance");
        else
            this.balance-= amount;
    }

}