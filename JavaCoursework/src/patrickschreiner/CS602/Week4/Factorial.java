package patrickschreiner.CS602.Week4;

public class Factorial 
{
	public static void main (String[] args) 
	{
		long n = Integer.parseInt(args[0]); //obtain argument from command line
		if (n < 0)
		{
			System.err.println("Error: Factorial number must be greater than 0");
			System.exit(0); //handle error for numbers less than 0
		}
		
		else
		{
			long fact = 1;
			for (long i = 1; i <= n; i++) //for loop handles factorial
			{
				fact = fact * i;
			}
			System.out.println(args[0]);
			System.out.println(fact); //print result of factorial
		}
	}
}