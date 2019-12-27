package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Bank bank = new Bank("Bank of America");
        bank.addBranch("First Branch");
        bank.addBranch("Second Branch");
        bank.addCustomer("First Branch","Anna", 700.02);
        bank.addCustomer("First Branch", "Jack", 90000.120);
        bank.addCustomer("Second Branch", "Marina", 80.07);

        bank.addTransactionForCustomer("First Branch", "Anna", 75.05);

        bank.queryCustomersForBranch("First Branch",false);


        bank.queryCustomersForBranch("First Branch",true);

        bank.queryCustomersForBranch("Non Existing branch",true);
    }
}
