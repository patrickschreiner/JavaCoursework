//Student class is a sub-class of Person, applying the necessary parameters

package patrickschreiner.CS113.FinalProject;

public class Student extends Person
{
    protected String Major;
    protected String Email;
    
    //setting up our Student constructor with the call to Parent(Person) class
    public Student(String position, String ucid, String first, String last, String major, String email)
    {
        super(position, ucid, first, last);
        Major = major; 
        Email = email;
    }
    
    public String toString()
    {
        return super.toString() + " " + Major + " " + Email;
    }
}