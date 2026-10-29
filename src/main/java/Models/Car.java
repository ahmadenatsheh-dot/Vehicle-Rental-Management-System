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
        if(numberofseats>=2&&numberofseats<=7)
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
         double extrafee = (getNumberofseats()>5)?0.1:0.0;
         return days*getDailyRentalRate()+(extrafee*getDailyRentalRate()*days);
     }
     
    @Override
    public String toString() 
    {
        return super.toString()+", numberOfSeats=" + numberOfSeats + " (Seats)" + '}'; 
    }

   
    
}
