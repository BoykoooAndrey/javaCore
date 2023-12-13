package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private String firstName;
    private String secondName;
    private String post;
    private  String phoneNum;
    private  int salary;
    private int age;

    public String getInfo(){
        return String.format("%s %s\nPost: %s\nNumber: %s\nSalary: %s\nAge:%s",
                firstName,secondName,post,phoneNum,salary,age);
    }

    public static void upSal(Employee[] state, int agePromotion, int amountIncrease)
    {
        for (Employee e : state)
        {
            if (e.getAge() > agePromotion)
            {
                e.setSalary(e.getSalary() + amountIncrease) ;
            }
        }
    }




}
