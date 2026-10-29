package Services;

import Models.*;
import java.util.ArrayList;
interface VehicleMangementOperation
{
    void displayAllVehicles();
    void displayIsAvailablForRental();
    void addNewVehicle(Vehicles other);
    Vehicles searchForVehicle(String vehicleNamber );
}

public class VehicleMangement implements VehicleMangementOperation
{
    ArrayList<Vehicles> ls = new ArrayList<Vehicles>();
    @Override
   public void displayAllVehicles()
   {
       if (ls.isEmpty()) 
       {
            System.out.println("No vehicles registered in the system");
            return;
       }
       for(var c : ls)
       {
           System.out.println(c.toString());
       }
   }
   @Override
   public void displayIsAvailablForRental()
   {
       boolean found = false;
      
       for(var v : ls )
       {
           if(v.getIsAvailabl())
           {
               found = true;
            System.out.println(v.toString());
           }
       }
       if(!found)
           System.out.println("No vehicles are currently available for rental");
       
   }   
   @Override
   public void addNewVehicle(Vehicles other)
   {
       if(other==null)return;
       for(var v : ls)
       {
           if(v.getRegistrationNumber().equalsIgnoreCase(other.getRegistrationNumber()))
           {
            System.out.println("Error: A vehicle with this registration number already exists");
            return;
           }
       }
       ls.add(other);
        System.out.println("Vehicle added successfully");
   }
   @Override
   public Vehicles searchForVehicle(String vehicleNamber )
   {
       for(var c : ls)
       {
           if(vehicleNamber.equalsIgnoreCase(c.getRegistrationNumber()) )
           {
            
            System.out.println(c.toString());
            return c;
           }      
       }
       
       
         System.out.println("Vehicle with registration number was not found");   
        return null;
   }
   
}
        
   


   

