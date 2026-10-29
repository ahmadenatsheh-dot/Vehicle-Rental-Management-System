package Models;

public class Car extends Vehicles 
{
    private int numberOfSeats;
    public Car(String registrationNumber, String brand, String color, double dailyRentalRate, boolean isAvailabl,int numberOfSeats) 
    {
        super(registrationNumber, brand, color, dailyRentalRate, isAvailabl);
        setNumberofseats(numberOfSeats);
    }

   

    public int getNumberofseats()
    {
        return numberOfSeats;
    }

    public void setNumberofseats(int numberofseats) 
    {
        if(numberofseats>=2)
        this.numberOfSeats = numberofseats;
        else
        {
            this.numberOfSeats = 5;
            System.out.println("Enter two or more seats");
        }
    }
    @Override
     public  double calculateRentalCost(int days)
     {
         return days*getDailyRentalRate();
     }
     
    @Override
    public String toString() 
    {
        return super.toString()+", numberOfSeats=" + numberOfSeats + " (Seats)" + '}'; 
    }

   
    
}
