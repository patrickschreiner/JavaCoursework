//Methods for creating an array that allows the user to find,
//add, or delete users if necessary.

package patrickschreiner.CS113.FinalProject;

import java.io.*;
import java.util.*;

public class Directory
{
   // setting up array of persons and scanners for textfile input
   final int maxDirectorySize = 1024;
   Person persons[] = new Person[maxDirectorySize];
   int directorySize = 0;
   Scanner directoryDataIn = null;
   Scanner input = new Scanner(System.in);
   File directoryFile = null;
    
   public Directory(String directoryFileName)
   {
      directoryFile = new File(directoryFileName);
      try
      {
         directoryDataIn = new Scanner(directoryFile);
      }
      catch (FileNotFoundException e)
      {
         System.out.printf("File %s not found, exiting!", directoryFileName);
         System.exit(0);
      }
   
      // filling the array as long as there is data to read
      // while seperating different types of Person based on position      
      while(directoryDataIn.hasNext())
      {
         String position = directoryDataIn.next();
         String ucid = directoryDataIn.next();
         String first = directoryDataIn.next();
         String last = directoryDataIn.next();
        
         if(position.equalsIgnoreCase("Senior") || position.equalsIgnoreCase("Junior") || 
         position.equalsIgnoreCase("Sophomore") || position.equalsIgnoreCase("Freshman"))
         {
            String major = directoryDataIn.next();
            String email = directoryDataIn.next();
            Student student = new Student(position, ucid, first, last, major, email);
            persons[directorySize++] = student;
         }
         
         else if(position.equalsIgnoreCase("Adjunct") || position.equalsIgnoreCase("Professor"))
         {
            String department = directoryDataIn.next();
            String email = directoryDataIn.next();
            String office = directoryDataIn.next();
            Instructor instructor = new Instructor(position, ucid, first, last, department, email, office);
            persons[directorySize++] = instructor;
         }
         
         else if(position.equalsIgnoreCase("Staff"))
         {
            String department = directoryDataIn.next();
            Employee employee = new Employee(position, ucid, first, last, department);
            persons[directorySize++] = employee;
         }
      }
   }
    
   // method for checking if a name is in the directory 
   public boolean find(String name)
   {
      for(int i = 0; i < directorySize; i++)
      {
         if (persons[i].getLast().equalsIgnoreCase(name))
         {
            System.out.println(persons[i].toString());
            return true;
         }
      }
      return false;
   }
   
   //method for adding a new Person object into the array based on
   //the position of the entry.  
   public void add()
   {
      String position, ucid, first, last, email, major, department, office;
      System.out.println("Enter ucid: ");
      ucid = input.nextLine();
      boolean toAdd = false;
        
      for(int i = 0; i < directorySize; i++)
      {
         //making sure the person is not in the directory already based on
         //their ucid, or if the array is full.
         if(!(ucid.equals(persons[i].getUcid()) || ucid.equals(null) &&
            directorySize < maxDirectorySize))
         {
            toAdd = true;
         }
         else
         {
            System.out.println("UCID already in the University Database");
            toAdd = false;
         }
      }
      
      //if the ucid is not already in the database, and boolean toAdd is true
      // then we ask the user for the fields depending on the position of the person  
      if(toAdd == true)
      {
         System.out.println("Position  = Professor, Adjunct, Staff, Senior, Junior, Sophomore, or Freshmen\n" +
            "MUST match case!");
            
         position = input.nextLine();
         System.out.println("Enter First Name: ");
         first = input.nextLine();
         System.out.println("Enter Last Name: ");
         last = input.nextLine();
            
         if (position.equals("Professor") || position.equals("Adjunct"))
         {
            System.out.println("Enter Department: ");
            department = input.nextLine();
            System.out.println("Enter Email Address: ");
            email = input.nextLine();
            System.out.println("Enter Office: ");
            office = input.nextLine();
            Instructor instructor = new Instructor(position, ucid, first, last, department, email, office);
            persons[directorySize++] = instructor;
            System.out.println(instructor.toString() + " Added Successfully");
         }
            
         else if (position.equals("Senior") || position.equals("Junior") || position.equals("Sophomore") || 
            position.equals("Freshman"))
         {            
            System.out.println("Enter Major: ");
            major = input.nextLine();
            System.out.println("Enter Email Address: ");
            email = input.nextLine();
            Student student = new Student(position, ucid, first, last, major, email);
            persons[directorySize++] = student;
            System.out.println(student.toString() + " Added Successfully");
         }
            
         else if (position.equals("Staff"))
         {
            System.out.println("Enter Department: ");
            department = input.nextLine();
            Employee employee = new Employee(position, ucid, first, last, department);
            persons[directorySize++] = employee;
            System.out.println(employee.toString() + " Added Successfully");
         }
      }
   }
    
   //method for deleting a Person from our array by using their ucid
   public boolean delete(String number)
   {
      for(int i = 0; i < directorySize; i++)
      {
         if(persons[i].getUcid().equals(number))
         {
            persons[i] = null;
            directorySize--;
            for (int x = i; x < directorySize; x++)
            {
               persons[i] = persons[x + 1];
            }
            
            System.out.println(number + " Deleted");
            return true;
         }
      }
      return false;
   }
    
   public void closeDirectory()
   {
      directoryDataIn.close();
      PrintStream directoryDataOut = null;
        
      try
      {
         directoryDataOut = new PrintStream(directoryFile);
      }
        
      catch (FileNotFoundException e)
      {
         System.out.printf("File %s not found, exiting!", directoryFile);
         System.exit(0);
      }
      //filling the file back with our updated array  
      for (int i = 0; i < directorySize; i++)
      {
         directoryDataOut.println(persons[i]);
      }
      //closing the directory  
      directoryDataOut.close();
   }
}
    
            
          
             