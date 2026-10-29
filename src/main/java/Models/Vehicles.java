package Models;

public abstract class Vehicles
{
    private String registrationNumber;
    private String brand;
    private String color;
    private double dailyRentalRate;
    private boolean isAvailabl;
    


    public Vehicles(String registrationNumber, String brand, String color, double dailyRentalRate, boolean isAvailabl) 
    {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.color = color;
        setDailyRentalRate(dailyRentalRate);
        this.isAvailabl = isAvailabl;
        
    }

    public String getRegistrationNumber() 
    {
        return registrationNumber;
    }

    public String getBrand() 
    {
        return brand;
    }

    public String getColor() 
    {
        return color;
    }

    public double getDailyRentalRate()
    {
        return dailyRentalRate;
    }

    public boolean getIsAvailabl() 
    {
        return isAvailabl;
    }

    public void setRegistrationNumber(String registrationNumber) 
    {
        this.registrationNumber = registrationNumber;
    }

    public void setBrand(String brand) 
    {
        this.brand = brand;
    }

    public void setColor(String color) 
    {
        this.color = color;
    }

    public void setDailyRentalRate(double dailyRentalRate) 
    {
        if(dailyRentalRate>0)
        this.dailyRentalRate = dailyRentalRate;
        else
            this.dailyRentalRate = dailyRentalRate*-1;
            
    }

    public void setIsAvailabl(boolean isAvailabl) 
    {
        this.isAvailabl = isAvailabl;
    }
    public abstract double calculateRentalCost(int days);

    @Override
    public String toString()
    {
        return "Vehicles "+'{' + "registrationNumber=" + registrationNumber + ", brand=" + brand + ", color=" + color + ", dailyRentalRate=" + dailyRentalRate + ", isAvailabl=" + isAvailabl ;
    }
    
}
