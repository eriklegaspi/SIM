package it.sim.main.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.xml.bind.ParseConversionEvent;

import it.sim.main.data.Call;
import it.sim.main.data.SIMCard;

public class FileManager {

	
	/**
	 * write into the file
	 * @param sim 
	 * @param file
	 */
	public static void write(SIMCard sim, File file) {
		String sender = String.valueOf(sim.getNumber());	//parse into a String the sim's number
		try {
			FileWriter fw = new FileWriter(file, true);
			HashMap<Integer, Call> register = sim.getRegister();	//get the hashMap of the sim
			for (Entry<Integer, Call> r : register.entrySet()) {
				Call call = r.getValue();	//get the call from the hashMap
				String reciever = String.valueOf(call.getReciever());	//convert to string the number of the reciever
				fw.write(r.getKey()+";"+sender+";"+reciever+";"+call.getEnd()+"\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * read the file 
	 * @param file
	 * @throws IOException
	 */
	public static void Read(File file) throws IOException {
		FileReader fr;
		try {
			fr = new FileReader(file);
			BufferedReader buffer = new BufferedReader(fr);
			String text = null;
			
			while((text = buffer.readLine()) != null) {
				String[] split = text.split(";");		//split the line
				System.out.println("ID Call:"+split[0]);
				System.out.println("Sender"+split[1]);
				System.out.println("Reciever:"+split[2]);
				System.out.println("Call's duration:"+split[3]);
			}
			
			buffer.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * get the last id of the call
	 * @param file
	 * @return the last id of the call
	 * @throws IOException
	 */
	public static int getLastId(File file) throws IOException {
		int id = 0;
		FileReader fr;
		String text = null;
		try {
			fr = new FileReader(file);
			BufferedReader buffer = new BufferedReader(fr);
			 while((text = buffer.readLine())!= null) {
				 String[] split = text.split(";");
				 id = Integer.parseInt(split[0]);
			 }
			 
			 fr.close();
			 buffer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
}

