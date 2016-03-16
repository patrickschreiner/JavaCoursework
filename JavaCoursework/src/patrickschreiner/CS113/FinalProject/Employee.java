//Employee class is a sub-class of Person, applying the necessary parameters

package patrickschreiner.CS113.FinalProject;

public class Employee extends Person
{
    protected String Department;
    
    //setting up our Employee constructor with the call to our Parent(Person) class
    public Employee(String position, String ucid, String first, String last, String department)
    {
        super(position, ucid, first, last);
        Department = department;
    }
        
    public String toString()
    {
        return super.toString() + " " + Department;
    }
}