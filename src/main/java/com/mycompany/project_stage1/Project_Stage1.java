package com.mycompany.project_stage1;

import Models.*;
import static Models.Customer.isValidPhoneNumber;
import Services.*;
import java.util.Scanner;

public class Project_Stage1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        VehicleMangement vehicleService = new VehicleMangement();
        CustomerMangement customerService = new CustomerMangement();
        
        int choice; 

        do 
        {
            System.out.println("""
                               
                     ---- VEHICLE RENTAL SYSTEM ---- 
                      1. Add New Vehicle
                      2. Display All Vehicles
                      3. Display Available Vehicles
                      4. Search Vehicle by Registration Number
                      5. Register New Customer
                      6. Display All Customers
                      7. Search Customer by ID
                      8. Rent a Vehicle
                      9. Exit
                      Enter your choice:
                               
                     """);

            choice = Integer.parseInt(scan.nextLine());
            switch (choice) 
            {
                case 1:
                    System.out.println("Select Vehicle Type (1: Car, 2: Motorcycle, 3: Truck): ");
                    int type = Integer.parseInt(scan.nextLine());
                    System.out.print("Registration Number: ");
                    String reg = scan.nextLine();
                    System.out.print("Brand: ");
                    String brand = scan.nextLine();
                    System.out.print("Color: ");
                    String color = scan.nextLine();
                    System.out.print("Daily Rate: ");
                    double rate = Double.parseDouble(scan.nextLine());

                    if (type == 1) 
                        {
                        System.out.print("Enter Number of Seats: ");
                        int seats = Integer.parseInt(scan.nextLine());
                        vehicleService.addNewVehicle(new Car(reg, brand, color, rate, true, seats));
                    } 
                    else if (type == 2) 
                    {
                        System.out.print("Enter Engine Capacity (CC): ");
                        int cc = Integer.parseInt(scan.nextLine());
                        vehicleService.addNewVehicle(new Motorcycle(reg, brand, color, rate, true, cc));
                    } 
                    else if (type == 3) 
                    {
                        System.out.print("Enter Capacity (Tons): ");
                        int capacity = Integer.parseInt(scan.nextLine());
                        vehicleService.addNewVehicle(new Truck(reg, brand, color, rate, true, capacity));
                    }
                    break;

                case 2:
                    vehicleService.displayAllVehicles();
                    break;

                case 3:
                    vehicleService.displayIsAvailablForRental();
                    break;

                case 4:
                    System.out.print("Enter Registration Number: ");
                    String searchReg = scan.nextLine();
                    vehicleService.searchForVehicle(searchReg);
                    break;

                case 5:
                   
                    System.out.print("Enter Customer ID: ");
                    int id = Integer.parseInt(scan.nextLine());
                    
                    System.out.print("Enter Customer Name: ");
                    String name = scan.nextLine();
                    
                    String phone;
                    while(true)
                    {
                    System.out.print("Enter Phone Number (10 digits): ");
                     phone = scan.nextLine();
                      if(!isValidPhoneNumber(phone))
                      {
                       System.out.println("Error: Phone number must consist of exactly 10 digits");
                      }
                      else
                          break;
                    }
                    customerService.addNewCustomer(new Customer(id, name, phone));
                    break;

                case 6:
                    customerService.displayAllCustomer();
                    break;

                case 7:
                    System.out.print("Enter Customer ID: ");
                    int searchId = Integer.parseInt(scan.nextLine());
                    customerService.searchById(searchId);
                    break;

                case 8:
                    System.out.print("Enter Customer ID: ");
                    int custId = Integer.parseInt(scan.nextLine());
                    Customer c = customerService.searchById(custId);
                    if (c == null)
                    {
                        System.out.println("This ID is not in our records");
                        break;
                    }

                    System.out.print("Enter Vehicle Registration Number: ");
                    String vReg = scan.nextLine();
                    Vehicles v = vehicleService.searchForVehicle(vReg);
                    if (v == null)
                    {
                        System.out.println("the Vehicle does not exist");
                        break;
                    }

                    if (!v.getIsAvailabl()) {
                        System.out.println("Vehicle is currently not available");
                        break;
                    }

                    System.out.print("Enter Rental Duration (Days): ");
                    int days = Integer.parseInt(scan.nextLine());
                    if (days <= 0) {
                        System.out.println("Rental duration must be positive");
                        break;
                    }

                    double totalCost = v.calculateRentalCost(days);
                    v.setIsAvailabl(false);
                    System.out.println("Rental Successful");
                    System.out.println("Total Cost: " + totalCost+'$');
                    break;

                case 9:
                    System.out.println("Exiting System Goodbye");
                    break;

                default:
                    System.out.println("Invalid choice Please try again.");
            }
        } while (choice != 9);
    }
}
