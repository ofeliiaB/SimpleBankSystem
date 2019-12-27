package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Bank {

    //add a new branch
    //add customer and initial transaction amount
    //add additional transactons for customer
    //query customers for Branch

    private ArrayList<Branch> branches;
    private String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName){

        if(findBranch(branchName)==null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double transactionAmount){

        Branch branch = findBranch(branchName);
        if(branch != null){

            return branch.addNewCustomer(customerName, transactionAmount);
        }
        return false;
    }

    private Branch findBranch(String branchName) {
        for(int i=0;i<this.branches.size();i++){
            Branch oldBranch = this.branches.get(i);
            if(oldBranch.getBranchName().equals(branchName)){
                return oldBranch;
            }
        }
        return null;
    }


    public boolean addTransactionForCustomer(String branchName, String customerName, double transactionAmount){

        Branch branch = findBranch(branchName);
        if(branch!=null){
            return branch.addTransactionForCustomer(customerName, transactionAmount);
        }
        return false;
    }

    public boolean queryCustomersForBranch(String branchName, boolean showTransactions){


        Branch branch = findBranch(branchName);
        if(branch!=null){

            System.out.println("Customer for branch "+branch.getBranchName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for(int i=0;i<branchCustomers.size();i++){
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: "+branchCustomer.getName()+" "+ i);
                if(showTransactions){
                    System.out.println("Transactions");
                    ArrayList<Double> transactions= branchCustomer.getTransactions();
                    for(int j=0; j<transactions.size();j++){
                        System.out.println(" "+(j+1)+ " Amount "+transactions.get(j) );
                    }
                }
            }
        }

        return false;
    }
}
