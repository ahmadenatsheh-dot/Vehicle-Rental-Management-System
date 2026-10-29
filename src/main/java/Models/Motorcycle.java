/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;


/**
 *
 * @author Ahmad
 */
public class Motorcycle extends Vehicles 
{
private int engineCapacity;

    public Motorcycle( String registrationNumber, String brand, String color, double dailyRentalRate, boolean isAvailabl,int engineCapacity) 
    {
        super(registrationNumber, brand, color, dailyRentalRate, isAvailabl);
        setEngineCapacity(engineCapacity);
    }

    

    public int getEngineCapacity() 
    {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) 
    {
        if(engineCapacity>100&&engineCapacity<=1200)
        this.engineCapacity = engineCapacity;
        else
        {
            System.out.println("Please enter a value higher than 100 and less than 1200");
            this.engineCapacity =200;
        }
    }

    

    @Override
    public double calculateRentalCost(int days)
    {
       double extrafee = (engineCapacity>=600) ? (0.25*getDailyRentalRate()):0.0;
            
        return days*getDailyRentalRate()+(extrafee*days);
    }

    @Override
    public String toString()
    {
        return super.toString()+ ", engineCapacity=" + engineCapacity + "cc" + '}';
    }
    
}
