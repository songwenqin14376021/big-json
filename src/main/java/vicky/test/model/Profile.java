package vicky.test.model;

import java.util.List;

public class Profile
{
    private String ContactNo;



    private Address Address;

    private List<Profile> children;



    public String getContactNo ()
    {
        return ContactNo;
    }

    public void setContactNo (String ContactNo)
    {
        this.ContactNo = ContactNo;
    }


    public Address getAddress ()
    {
        return Address;
    }

    public void setAddress (Address Address)
    {
        this.Address = Address;
    }

    public List<Profile> getChildren ()
    {
        return children;
    }

    public void setChildren (List<Profile> children)
    {
        this.children = children;
    }



    @Override
    public String toString()
    {
        return "ClassPojo [ContactNo = "+ContactNo+", Address = "+Address+", children = "+children+"]";
    }
}
