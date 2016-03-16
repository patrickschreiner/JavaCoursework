//Implementation of the Directory, adding user functionality for using the find,
//add, and delete functions.

package patrickschreiner.CS113.FinalProject;

import java.io.*;
import java.util.*;

public class DirectoryServer
{
    public static void main(String[] args)
    {
        //Getting our input file UniversityDirectoryA, and prompting
        //the user to enter input
        String directoryDataFile = "UniversityDirectoryA.txt";
        Directory d = new Directory(directoryDataFile);
        Scanner stdin = new Scanner(System.in);
        System.out.println("Directory Server is Ready!");
        System.out.println("Command : find LastName | delete UCID | add");
        System.out.println("To end, enter ^Z");
        System.out.print("Enter Command: ");
        
        //continue to prompt as long as the user wants, with control + Z stopping input
        while (stdin.hasNext())
        {
            String command = stdin.next();

            if(command.equalsIgnoreCase("find"))
            {
                String name = stdin.next();
                //if user input and last name of a Person in the array are the same
                //then the information about that person will print, find successful
                if(d.find(name))
                {
                    System.out.print("");
                }
                else
                {
                    System.out.println(name + " is NOT in the directory");
                }
            }
            else if(command.equalsIgnoreCase("add"))
            {
                //if the user writes "add" then it will go to the function add()
                //and prompt the user how to add a new entry to the directory
                d.add();
            }            
            else if(command.equalsIgnoreCase("delete"))
            {
                String ucid = stdin.next();
                //if user input and ucid of a Person in the array are the same
                //then the entire element in the array will be deleted
                if(d.delete(ucid))
                {
                    System.out.print("");
                }
                else
                {
                    System.out.println(ucid + " NOT in the directory");
                }
            }
            else
            {
                System.out.println("Bad Command! Please Try Again");
            }
             System.out.print("Enter Command: ");
        }
        System.out.print("Goodbye!");
        //making sure to write back to the directory and closing it after done
        //with user input
        d.closeDirectory();
        System.exit(0);
        
    }
}
                        
                  