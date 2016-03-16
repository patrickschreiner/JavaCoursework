package patrickschreiner.CS602.Week4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Average 
{
	public static void main(String[] args)
	{
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(args[0]));
			//obtain txt file to be read via command line argument
			String line = null;
			int inputs = 0;
			double inputsum = 0;
			//set up counters
			while((line = in.readLine()) != null)
			{
				try
			    {
					int getvalue = Integer.valueOf(line).intValue();
					inputsum += getvalue;
					//obtain value of Integer strings and store
					inputs++;
					//update counter for number of inputs
			    }
			    catch (NumberFormatException e)
			    {
			    	continue;
			    }
				//use NumberFormatException to not include non-integer values
				
				
			}
			in.close();
			//close BufferedReader
			System.out.println("Number of inputs = " + inputs);
			System.out.println("Average of inputs = " + inputsum / inputs);
			//print results
		}
		catch (IOException e)
		{
			System.out.println("Error on input: " + e.getMessage());
		}
		
		
	}

}
