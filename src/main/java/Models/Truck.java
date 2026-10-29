/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;


/**
 *
 * @author Ahmad
 */
public class Truck extends Vehicles 
{
    private int capacity;

    

    public Truck( String registrationNumber, String brand, String color, double dailyRentalRate, boolean isAvailabl,int capacity) {
        super(registrationNumber, brand, color, dailyRentalRate, isAvailabl);
        setcapacity(capacity);
    }

    public int getcapacity() 
    {
        return capacity;
    }

    public void setcapacity(int capacity)
    {
        if(capacity>0&&capacity<150)
        this.capacity = capacity;
        else
            this.capacity=30;
    }
    @Override
        public  double calculateRentalCost(int days)
        {
          double extrafee = (capacity>=50) ? (0.25*getDailyRentalRate()):0.0;
            return days*getDailyRentalRate()+(extrafee*days);
        }

    @Override
    public String toString()
    {
        return super.toString() + ", capacity=" + capacity + " (ton)" + '}';
    }
        

}
