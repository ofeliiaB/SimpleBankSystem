package com.company;

import java.util.ArrayList;

public class Branch {

    //need to add customer and initial transaction amount
    // add transaction for customer

    private String branchName;
    private ArrayList<Customer> customers;


    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>();
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public boolean addNewCustomer(String customerName, double initialAmount){

        if(findCustomer(customerName)==null){
            this.customers.add(new Customer(customerName,initialAmount));
            return true;
        }

        return false;
    }



    private Customer findCustomer(String customerName){
        for(int i=0; i<this.customers.size();i++){
            if(this.customers.get(i).getName().equals(customerName)){
                return this.customers.get(i);
            }
        }
        return null;
    }

    public boolean addTransactionForCustomer(String customerName, double amount){
        Customer oldCustomer = findCustomer(customerName);
        if(oldCustomer !=null){
            oldCustomer.addTransaction(amount);
            return true;
        }

        return false;
    }


}
