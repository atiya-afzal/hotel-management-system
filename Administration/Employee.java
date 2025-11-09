package com.example.Lodgify.Administration;

import com.example.Lodgify.Generic.Individual;

import java.util.Scanner;

public class Employee extends Individual{
    int salary;
    

    Scanner input = new Scanner(System.in);


    // Authorizaion aut;
    Employee(String name , String cnic , String phoneNumber , String gmail , String dob,int salary,String userName,String passWord){
      super(name, cnic, phoneNumber, gmail, dob,userName, passWord);
      setSalary(salary);
    }

    Employee (String cnic , String phoneNumber , String gmail ,  String userName){
        super(cnic, phoneNumber, gmail);
        aut.setUserName(userName);
    }

    Employee(){};

    
    public int getSalary() {


        return salary;
    }
     void setSalary(int salary) {
        this.salary = salary;
    }

    public String giveCredentials() {
            return "CNIC: " + getCnic() + "\n" +
                    aut.toString();
    }




    public String getUserName() {
        return aut.getUserName();
    }

    public String getPassWord() {
        return aut.getPassWord();
    }

    
}
