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

	public static void Write(SIMCard sim, File file) {
		
		String sender = String.valueOf(sim.getNumber());
		try {
			FileWriter fw = new FileWriter(file, true);
			HashMap<Integer, Call> register = sim.getRegister();
			for (Entry<Integer, Call> r : register.entrySet()) {
				Call call = r.getValue();
				String reciever = String.valueOf(call.getReciever());
				fw.write(r.getKey()+";"+sender+";"+reciever+";"+call.getEnd()+"\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void Read(File file) throws IOException {
		FileReader fr;
		try {
			fr = new FileReader(file);
			BufferedReader buffer = new BufferedReader(fr);
			String text = null;
			
			while((text = buffer.readLine()) != null) {
				String[] split = text.split(";");
				System.out.println("ID Call:"+split[0]);
				System.out.println("Sender"+split[1]);
				System.out.println("Reciever:"+split[2]);
				System.out.println("Call's duration:"+split[3]);
			}
			
			buffer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
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

