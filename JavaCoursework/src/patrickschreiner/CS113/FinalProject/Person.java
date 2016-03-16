//Person class is the superclass for the directory, applying the necessary parameters

package patrickschreiner.CS113.FinalProject;

public class Person
{
    protected String Position;
    protected String Ucid;
    protected String First;
    protected String Last;
    
    //setting up our Person constructor
    public Person(String position, String ucid, String first, String last)
    { 
        Position = position; 
        Ucid = ucid; 
        First = first; 
        Last = last;
    }
    
    public String toString()
    {
        return String.format("%s %s %s %s", Position, Ucid, First, Last);
    }
    
    String getLast()
    {
        return Last;
    }
    
    String getUcid()
    {
        return Ucid;
    }
}
        
       