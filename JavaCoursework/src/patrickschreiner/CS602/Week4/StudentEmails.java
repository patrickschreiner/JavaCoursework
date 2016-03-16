//StudentEmails class takes data from a text file, parses the
//contents using a StringTokenizer, and formats the data into
//usable email addresses in a new txt file.

package patrickschreiner.CS602.Week4;

import java.io.*; 
import java.util.*;
public class StudentEmails 
{
	public static void main(String[] args)
	{
		try
		{
			BufferedReader in = new BufferedReader(new FileReader("students.txt"));
			PrintWriter out = new PrintWriter (new BufferedWriter(new FileWriter("studentemail.txt")));
			//setting up reader/writer for file
			String line = null;
			String delim = ":";
			
			while((line = in.readLine()) != null)
			{
				StringTokenizer st = new StringTokenizer(line, delim);
				
				String last = null;
				String first = null;
				String ssnumber = null;
				int tokennumber = 0;
				//set up variables for tokens
				while(st.hasMoreTokens())
				{
					++tokennumber;
					if (tokennumber == 1)
					{
						last = st.nextToken();
					}
					else if (tokennumber == 2)
					{
						first = st.nextToken();
					}
					else if (tokennumber == 3)
					{
						ssnumber = st.nextToken();
					}
					//separate our tokens in the right variables, respectively
				
				}
				String emaildomain = "@se.depaul.edu";
				String ssnumberparse = ssnumber.substring(ssnumber.length()-4,ssnumber.length());
				String emailaddress = "" + first.toLowerCase().charAt(0) + last.toLowerCase().charAt(0) + ssnumberparse + emaildomain;
				out.println(emailaddress);
				//prep our tokens to be formatted for export to new text file studentemail.txt
			}
			in.close();
			out.flush();
			out.close();
			//close out I/O
		}
		catch (IOException e)
		{
		}
		
		
		
	}
		
}


