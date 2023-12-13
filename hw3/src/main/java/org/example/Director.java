package org.example;

public class Director extends Employee{
    public Director(String firstName, String secondName, String post, String phoneNum, int salary, int age) {
        super(firstName, secondName, post, phoneNum, salary, age);
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }

    public static void upSal(Employee[] state, int agePromotion, int amountIncrease)
    {
        for (Employee e : state)
        {
            if (e.getAge() > agePromotion && e.getClass() != Director.class)
            {
                e.setSalary(e.getSalary() + amountIncrease) ;
            }
        }
    }

}
