package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Ivan","Ivanov", "Worker", "89224563544", 40000, 25);
        Employee e2= new Employee("Petr","Sidorov", "Worker", "89224563555", 40000, 30);
        Employee e3= new Employee("Maxim","Petrov", "Worker", "89224563566", 40000, 45);
        Employee e4= new Employee("Leonid","Ivanov", "Worker", "89224563577", 40000, 48);
        Employee e5= new Employee("Maxim","Kolos", "Worker", "89224563588", 40000, 55);
        Director d1 = new Director("Maxim","Ivanov", "Dir", "89224888888", 100000, 49);
        Employee[] state = {e1, e2, e3, e4, e5, d1};
        for (Employee e : state)
        {
            System.out.println(e.getInfo());
        }

//        for (Employee e : state)
//        {
//            upSal(e, 45, 10000);
//
//        }
        //Employee.upSal(state, 45, 10000);
        Director.upSal(state, 45, 10000);
        for (Employee e : state)
        {
            System.out.println(e.getInfo());
        }
        averageSalAge(state);

    }

    private static void upSal(Employee e, int agePromotion, int amountIncrease)
    {
        if (e.getAge() > agePromotion)
        {
            e.setSalary(e.getSalary() + amountIncrease) ;
        }
    }

    private static void averageSalAge(Employee[] state)
    {
        int ageSum = 0;
        int salSum = 0;
        for (Employee e : state)
        {
            ageSum += e.getAge();
            salSum += e.getSalary();

        }
        try {
            double averageAge = (double) ageSum /state.length;
            double averageSal = (double) salSum /state.length;
            System.out.println(String.format("Average age -> %s\nAverage salary -> %s", averageAge, averageSal));
        }
        catch (ArithmeticException e)
        {
            e.printStackTrace();
        }

    }

}