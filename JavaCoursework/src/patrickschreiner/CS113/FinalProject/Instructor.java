package patrickschreiner.CS113.FinalProject;

public class Instructor extends Employee
{
    protected String Email;
    protected String Office;
    
    //setting up our Instructor constructor with the call to Parent(Employee) class
    //which is already calls the constructor of Person
    public Instructor(String position, String ucid, String first, String last, String department,
    String email, String office)
    {
        super(position, ucid, first, last, department);
        Email = email;
        Office = office;
    }
    
    public String toString()
    {
        return super.toString() + " " + Email + " " + Office;
    }
    
}
    