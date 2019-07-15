package it.sim.main;
import it.sim.main.data.*;
import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		long number = 3896888929L;
		long reciever = 9999999999L;
		float money = 5;
		File file = new File(System.getProperty("user.home") + File.separatorChar + "Desktop", "Telefonate"); //creating the file
		
		//create the file if it doesn't exist
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//take the last call's id
		int lastID = 0;
		try {
			lastID = FileManager.getLastId(file)+1;	
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		SIMCard sim = new SIMCard(number, money, lastID );	//create the SIM
		sim.addCall(reciever);	//calling
		
		
		
		//write the call's information in the file
		FileManager.Write(sim, file);
		//read the file
		try {
			FileManager.Read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
