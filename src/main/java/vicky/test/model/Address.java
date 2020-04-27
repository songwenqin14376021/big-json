package vicky.test.model;

public class Address
{
    private String Zip;

    private String State;

    private String City;

    public String getZip ()
    {
        return Zip;
    }

    public void setZip (String Zip)
    {
        this.Zip = Zip;
    }

    public String getState ()
    {
        return State;
    }

    public void setState (String State)
    {
        this.State = State;
    }

    public String getCity ()
    {
        return City;
    }

    public void setCity (String City)
    {
        this.City = City;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Zip = "+Zip+", State = "+State+", City = "+City+"]";
    }
}