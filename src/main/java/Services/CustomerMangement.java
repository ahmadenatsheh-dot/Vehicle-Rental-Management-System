/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Models.*;
import java.util.ArrayList;
interface CustomerMangementOperation
{
    void addNewCustomer(Customer other);
    void displayAllCustomer();
    Customer searchById(int id); 
}
public class CustomerMangement implements CustomerMangementOperation {
ArrayList<Customer> lc= new ArrayList<Customer>();

@Override
    public void addNewCustomer(Customer other)
    {
        if(other==null)return;
        for(var c : lc)
        {
            
            if(c.getCustomerId()== other.getCustomerId())
            {
                System.out.println("Error: A Customer with this registration number ID already exists");
            return;
            }
        }
        lc.add(other);
        System.out.println("Customer added successfully");
    }

    @Override
    public void displayAllCustomer() 
    {
        if(lc.isEmpty())
        {
             System.out.println("No Customer registered in the system");
             return;
        }
        for(var c: lc)
        {
            System.out.println(c.toString());
        }
    }

    @Override
    public Customer searchById(int id) 
    {
        for(var c : lc)
        {
            if(c.getCustomerId()== id)
            {
                System.out.println(c.toString());
                return c;
            }
        }
        System.out.println("Customer with ID " +id + " was not found");
        return null;
    }

    
    
    
}
