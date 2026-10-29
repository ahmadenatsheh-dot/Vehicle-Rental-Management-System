package Models;

public class Customer 
{
    private int customerId;
    private String customerName;
    private String phoneNumber;

    public Customer(int customerId, String customerName, String phoneNumber) 
    {
        setCustomerId(customerId);
        
        this.customerName = customerName;
        setPhoneNumber(phoneNumber);
    }

    public int getCustomerId()
    {
        return customerId;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    public void setCustomerId(int customerId)
    {
        if(customerId>0)
        this.customerId = customerId;
        else
             System.out.println("Error: ID number must consist of Positive digits");
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }
   
   public static boolean isValidPhoneNumber(String Number)
   {
     if(Number==null||Number.isEmpty()||Number.length()!=10)
     {
        return false;
     }
    for(int i=0;i<10;i++)
    {
        char ch =Number.charAt(i);
        if(ch < '0' || ch >'9')
        {
            return false;
        }
    }
    return true;
 }
    public void setPhoneNumber(String phoneNumber)
    {
        
        if(isValidPhoneNumber(phoneNumber))
        this.phoneNumber = phoneNumber;
        else
            System.out.println("Error: Phone number must consist of exactly 10 digits");
    }
    @Override
    public String toString() 
    {
        return "Customer{" + "customerId=" + customerId + ", customerName=" + customerName + ", phoneNumber=" + phoneNumber + '}';
    }
}
