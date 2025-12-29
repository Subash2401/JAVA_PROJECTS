package com.employee;

import java.util.ArrayList;
import java.util.Scanner;

class Employee 
{
    int id;
    String name;
    String department;

    Employee(int id, String name, String department) 
    {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    void showDetails() 
    {
        System.out.println("ID: " + id + " | Name: " + name + " | Department: " + department);
    }
}

public class EmployeeRecordSystem 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        ArrayList<Employee> employeeList = new ArrayList<>();
        
        int x = 0;
        
        while (x != 5) 
        {
            System.out.println("\nEmployee Record System");
            System.out.println("1. Add Employee");
            System.out.println("2. Show Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            x = input.nextInt();
            input.nextLine();

            switch(x) 
            {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = input.nextInt();
                    input.nextLine();
                    boolean exists = false;
                    for (Employee emp : employeeList) 
                    {
                        if (emp.id == id) 
                        {
                            exists = true;
                            break;
                        }
                    }
                    if (exists) {
                        System.out.println("Employee ID already exists! Try a different ID.");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = input.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = input.nextLine();
                    employeeList.add(new Employee(id, name, dept));
                    System.out.println("Employee added!");
                    break;

                case 2:
                    System.out.println("\nList of Employees:");
                    if (employeeList.isEmpty()) 
                    {
                        System.out.println("No employees found.");
                    } 
                    else 
                    {
                        for (Employee emp : employeeList) 
                        {
                            emp.showDetails();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = input.nextInt();
                    input.nextLine();
                    boolean updated = false;
                    for (Employee emp : employeeList) 
                    {
                        if (emp.id == updateId) 
                        {
                            System.out.print("Enter new Name: ");
                            emp.name = input.nextLine();
                            System.out.print("Enter new Department: ");
                            emp.department = input.nextLine();
                            System.out.println("Employee updated!");
                            updated = true;
                            break;
                        }
                    }
                    
                    if (!updated) 
                    {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = input.nextInt();
                    input.nextLine();
                    boolean removed = false;
                    for (int i = 0; i < employeeList.size(); i++) 
                    {
                        if (employeeList.get(i).id == deleteId) 
                        {
                            employeeList.remove(i);
                            removed = true;
                            System.out.println("Employee deleted!");
                            break;
                        }
                    }
                    
                    if (!removed) {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 5:
                    System.out.println("Thank You:)");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }

        input.close();
    }
}
