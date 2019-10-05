package com.ahasan.arraylist.test;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.function.Predicate;
 
public class ArrayListExample
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
        ArrayList<Employee> employees = new ArrayList<>();
         
        employees.add(new Employee(1l, "Alex", LocalDate.of(2018, Month.APRIL, 21)));
        employees.add(new Employee(4l, "Brian", LocalDate.of(2018, Month.APRIL, 22)));
        employees.add(new Employee(3l, "Piyush", LocalDate.of(2018, Month.APRIL, 25)));
        employees.add(new Employee(5l, "Charles", LocalDate.of(2018, Month.APRIL, 23)));
        employees.add(new Employee(2l, "Pawan", LocalDate.of(2018, Month.APRIL, 24)));
         
        Predicate<Employee> condition = employee -> employee.getName().startsWith("P");
         
        employees.removeIf(condition);
         
        employees.forEach(a->System.out.println(a.getId()+" : "+a.getName()+" : "+a.getOf()));
    }
}