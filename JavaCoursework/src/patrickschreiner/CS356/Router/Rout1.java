package patrickschreiner.CS356.Router;

import java.io.*;
import java.net.*;

public class Rout1{
	public static void main(String[] args){
		Socket RouterSocket = null;
		ServerSocket ServSocket = null;
		int[] RoutTable = {1, 0, 1, 16};
		int[] SourceTable;
		int LocalRout = 1;
		int RecvRout;
		try{
			//Create connection with Source Router
			ServSocket = new ServerSocket(12345);
			ServSocket.setSoTimeout(50000);
			
			while(true){
				//Await connection from router
				RouterSocket = ServSocket.accept();
				//Prepare connected router's router table to be received
				InputStream Input = RouterSocket.getInputStream();
				InputStreamReader StreamTextIn = new InputStreamReader(Input);
				BufferedReader BufferedTextIn = new BufferedReader(StreamTextIn);
				//Populate array with routing table from source router
				RecvRout = Integer.parseInt(BufferedTextIn.readLine());
				SourceTable = new int[4];
				for(int i = 0; i < 4; i++){
					String ReceivedInfo = BufferedTextIn.readLine();
					SourceTable[i] = Integer.parseInt(ReceivedInfo);
				}
				//Determine which router we are receiving from
				for(int i = 0; i < 4; i++){
					if(SourceTable[i] == 0){
						RecvRout = i;
					}
				}			
				
				//Stream to send Rout1 routing table to Rout0
				OutputStream Output = RouterSocket.getOutputStream();
				OutputStreamWriter StreamTextOut = new OutputStreamWriter(Output);
				BufferedWriter BufferedTextOut = new BufferedWriter(StreamTextOut);
				//Prepare routing table to be sent to Rout0 via BufferedWriter
				int distance1to0 = RoutTable[0];
				int distance1to1 = RoutTable[1];
				int distance1to2 = RoutTable[2];
				int distance1to3 = RoutTable[3];
				BufferedTextOut.write(String.valueOf(LocalRout) + "\n");
				BufferedTextOut.write(String.valueOf(distance1to0) + "\n");
				BufferedTextOut.write(String.valueOf(distance1to1) + "\n");
				BufferedTextOut.write(String.valueOf(distance1to2) + "\n");
				BufferedTextOut.write(String.valueOf(distance1to3) + "\n");
				BufferedTextOut.flush();
			}
		}
		catch (IOException e) {
			System.out.println(e);
		}
		finally{
		//Finally statement ensures sockets are closed after tables sent, regardless of errors
			try{
				RouterSocket.close();
				ServSocket.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
} 
