package patrickschreiner.CS356.Router;

import java.io.*;
import java.net.*;

public class Rout0{
	@SuppressWarnings("resource")
	public static void main(String[] args){
		Socket SourceSocket = null;
		int[] RoutTable = {0, 1, 3, 7};
		int LocalRout = 0;
		int RecvRout;
		boolean UpdatedTable = true;
		try{
			while(UpdatedTable == true){
			//Establish Flag; Stop Condition
				UpdatedTable = false;
				SourceSocket = ConnectRout1();
				//Socket connection to Rout1
				
				//Stream to send initial routing table
				OutputStream Output = SourceSocket.getOutputStream();
				OutputStreamWriter StreamTextOut = new OutputStreamWriter(Output);
				BufferedWriter BufferedTextOut = new BufferedWriter(StreamTextOut);
				//Print initial table
				System.out.println("Initial Routing Table R0");
				System.out.println("Distance to Router 0: Local");
				System.out.println("Distance to Router 1: " + RoutTable[1]);
				System.out.println("Distance to Router 2: " + RoutTable[2]);
				System.out.println("Distance to Router 3: " + RoutTable[3] + "\n");
				//Prepare routing table to be sent to connected router and send via BufferedWriter
				int distance0to0 = RoutTable[0];
				int distance0to1 = RoutTable[1];
				int distance0to2 = RoutTable[2];
				int distance0to3 = RoutTable[3];
				BufferedTextOut.write(String.valueOf(LocalRout) + "\n");
				BufferedTextOut.write(String.valueOf(distance0to0) + "\n");
				BufferedTextOut.write(String.valueOf(distance0to1) + "\n");
				BufferedTextOut.write(String.valueOf(distance0to2) + "\n");
				BufferedTextOut.write(String.valueOf(distance0to3) + "\n");
				BufferedTextOut.flush();
				
					
				//Prepare connected router's routing table to be received
				InputStream Input = SourceSocket.getInputStream();
				InputStreamReader StreamTextIn = new InputStreamReader(Input);
				BufferedReader BufferedTextIn = new BufferedReader(StreamTextIn);
				//Set up array to contain routing information from connected router
				RecvRout = Integer.parseInt(BufferedTextIn.readLine());
				int[] IncomingTable = new int[4];
				for(int i = 0; i < 4; i++){
					String ReceivedInfo = BufferedTextIn.readLine();
					IncomingTable[i] = Integer.parseInt(ReceivedInfo);
				}
				//Print routing table received from connected router
				System.out.println("Received Routing Table: R" + RecvRout);
				System.out.println("Distance to Router 0: " + IncomingTable[0]);
				System.out.println("Distance to Router 1: " + IncomingTable[1]);
				System.out.println("Distance to Router 2: " + IncomingTable[2]);
				System.out.println("Distance to Router 3: " + IncomingTable[3] + "\n");
					
				//Update Rout0's routing table via Bellman-Ford shortest path algorithm
				if(RecvRout == 1){
					if(((distance0to1 + IncomingTable[2]) < distance0to2) && (IncomingTable[2] != 16)){
						RoutTable[2] = distance0to1 + IncomingTable[2];
						UpdatedTable = true;	
					}	
					
					if(((distance0to1 + IncomingTable[3]) < distance0to3) && (IncomingTable[3] != 16)){
						RoutTable[3] = distance0to1 + IncomingTable[3];
						UpdatedTable = true;	
					}
				}
					
				//Print out newly updated routing table for Rout0
				System.out.println("Updated Routing Table R0");
				System.out.println("Distance to Router 0: Local");
				System.out.println("Distance to Router 1: " + RoutTable[1]);
				System.out.println("Distance to Router 2: " + RoutTable[2]);
				System.out.println("Distance to Router 3: " + RoutTable[3]);
				System.out.println(" ");
				
				SourceSocket = ConnectRout2();
				//Socket connection to Rout2
				
				//Stream to send initial routing table
				Output = SourceSocket.getOutputStream();
				StreamTextOut = new OutputStreamWriter(Output);
				BufferedTextOut = new BufferedWriter(StreamTextOut);
				//Print initial table
				System.out.println("Initial Routing Table R0");
				System.out.println("Distance to Router 0: Local");
				System.out.println("Distance to Router 1: " + RoutTable[1]);
				System.out.println("Distance to Router 2: " + RoutTable[2]);
				System.out.println("Distance to Router 3: " + RoutTable[3] + "\n");
				//Prepare routing table to be sent to connected router and send via BufferedWriter
				distance0to0 = RoutTable[0];
				distance0to1 = RoutTable[1];
				distance0to2 = RoutTable[2];
				distance0to3 = RoutTable[3];
				BufferedTextOut.write(String.valueOf(LocalRout) + "\n");
				BufferedTextOut.write(String.valueOf(distance0to0) + "\n");
				BufferedTextOut.write(String.valueOf(distance0to1) + "\n");
				BufferedTextOut.write(String.valueOf(distance0to2) + "\n");
				BufferedTextOut.write(String.valueOf(distance0to3) + "\n");
				BufferedTextOut.flush();
				
					
				//Prepare connected router's routing table to be received
				Input = SourceSocket.getInputStream();
				StreamTextIn = new InputStreamReader(Input);
				BufferedTextIn = new BufferedReader(StreamTextIn);
				//Set up array to contain routing information from connected router
				RecvRout = Integer.parseInt(BufferedTextIn.readLine());
				for(int i = 0; i < 4; i++){
					String ReceivedInfo = BufferedTextIn.readLine();
					IncomingTable[i] = Integer.parseInt(ReceivedInfo);
				}
				//Print routing table received from connected router
				System.out.println("Received Routing Table: R" + RecvRout);
				System.out.println("Distance to Router 0: " + IncomingTable[0]);
				System.out.println("Distance to Router 1: " + IncomingTable[1]);
				System.out.println("Distance to Router 2: " + IncomingTable[2]);
				System.out.println("Distance to Router 3: " + IncomingTable[3] + "\n");
					
				//Update Rout0's routing table via Bellman-Ford shortest path algorithm
				if(RecvRout == 2){
					if(((distance0to2 + IncomingTable[1]) < distance0to1) && (IncomingTable[1] != 16)){
						RoutTable[1] = distance0to2 + IncomingTable[1];
						UpdatedTable = true;	
					}	
					
					if(((distance0to2 + IncomingTable[3]) < distance0to3) && (IncomingTable[3] != 16)){
						RoutTable[3] = distance0to2 + IncomingTable[3];
						UpdatedTable = true;	
					}
				}
					
				//Print out newly updated routing table for Rout0
				System.out.println("Updated Routing Table R0");
				System.out.println("Distance to Router 0: Local");
				System.out.println("Distance to Router 1: " + RoutTable[1]);
				System.out.println("Distance to Router 2: " + RoutTable[2]);
				System.out.println("Distance to Router 3: " + RoutTable[3]);
				System.out.println(" ");
				
				SourceSocket = ConnectRout3();
				//Socket connection to Rout3
				
				//Stream to send initial routing table
				Output = SourceSocket.getOutputStream();
				StreamTextOut = new OutputStreamWriter(Output);
				BufferedTextOut = new BufferedWriter(StreamTextOut);
				//Print initial table
				System.out.println("Initial Routing Table R0");
				System.out.println("Distance to Router 0: Local");
				System.out.println("Distance to Router 1: " + RoutTable[1]);
				System.out.println("Distance to Router 2: " + RoutTable[2]);
				System.out.println("Distance to Router 3: " + RoutTable[3] + "\n");
				//Prepare routing table to be sent to connected router and send via BufferedWriter
				distance0to0 = RoutTable[0];
				distance0to1 = RoutTable[1];
				distance0to2 = RoutTable[2];
				distance0to3 = RoutTable[3];
				BufferedTextOut.write(String.valueOf(LocalRout) + "\n");
				BufferedTextOut.write(String.valueOf(distance0to0) + "\n");
				BufferedTextOut.write(String.valueOf(distance0to1) + "\n");
				BufferedTextOut.write(String.valueOf(distance0to2) + "\n");
				BufferedTextOut.write(String.valueOf(distance0to3) + "\n");
				BufferedTextOut.flush();
				
					
				//Prepare connected router's routing table to be received
				Input = SourceSocket.getInputStream();
				StreamTextIn = new InputStreamReader(Input);
				BufferedTextIn = new BufferedReader(StreamTextIn);
				//Set up array to contain routing information from connected router
				RecvRout = Integer.parseInt(BufferedTextIn.readLine());
				for(int i = 0; i < 4; i++){
					String ReceivedInfo = BufferedTextIn.readLine();
					IncomingTable[i] = Integer.parseInt(ReceivedInfo);
				}
				//Print routing table received from connected router
				System.out.println("Received Routing Table: R" + RecvRout);
				System.out.println("Distance to Router 0: " + IncomingTable[0]);
				System.out.println("Distance to Router 1: " + IncomingTable[1]);
				System.out.println("Distance to Router 2: " + IncomingTable[2]);
				System.out.println("Distance to Router 3: " + IncomingTable[3] + "\n");
					
				//Update Rout0's routing table via Bellman-Ford shortest path algorithm
				if(RecvRout == 3){
					if(((distance0to3 + IncomingTable[1]) < distance0to1) && (IncomingTable[1] != 16)){
						RoutTable[1] = distance0to3 + IncomingTable[1];
						UpdatedTable = true;	
					}	
					
					if(((distance0to3 + IncomingTable[2]) < distance0to2) && (IncomingTable[2] != 16)){
						RoutTable[2] = distance0to3 + IncomingTable[2];
						UpdatedTable = true;	
					}
				}
					
				//Print out newly updated routing table for Rout0
				System.out.println("Updated Routing Table R0");
				System.out.println("Distance to Router 0: Local");
				System.out.println("Distance to Router 1: " + RoutTable[1]);
				System.out.println("Distance to Router 2: " + RoutTable[2]);
				System.out.println("Distance to Router 3: " + RoutTable[3]);
				System.out.println(" ");
				System.out.println("Final Table for Router 0, YAY!");
			}
		}
		catch(IOException e){
		//Catch exception
			System.out.println(e);
		}
		finally{
		//Finally statement ensures socket is closed after exchange of tables regardless of errors
			try{
				SourceSocket.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
	
	@SuppressWarnings({ "finally", "resource" })
	public static Socket ConnectRout1(){
	//Static method to connect Rout0 to Rout1
		Socket ConnectedSocket = null;
		try{
        //Set up host and port number for socket connection			
			ConnectedSocket = new Socket("afsaccess2.njit.edu", 12345);
		}
		catch(IOException e){
			System.out.println(e);
		}
		finally{
			return ConnectedSocket;
		}
	}
	
	@SuppressWarnings({ "finally", "resource" })
	public static Socket ConnectRout2(){
	//Static method to connect Rout0 to Rout2
		Socket ConnectedSocket = null;
		try{
        //Set up host and port number for socket connection			
			ConnectedSocket = new Socket("afsaccess3.njit.edu", 12346);
		}
		catch(IOException e){
			System.out.println(e);
		}
		finally{
			return ConnectedSocket;
		}
	}
	
	@SuppressWarnings({ "finally", "resource" })
	public static Socket ConnectRout3(){
	//Static method to connect Rout0 to Rout3
		Socket ConnectedSocket = null;
		try{
        //Set up host and port number for socket connection			
			ConnectedSocket = new Socket("afsaccess4.njit.edu", 12347);
		}
		catch(IOException e){
			System.out.println(e);
		}
		finally{
			return ConnectedSocket;
		}
	}
	
	
}
