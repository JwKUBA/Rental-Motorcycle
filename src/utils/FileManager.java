package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import data.Rental;

public class FileManager {
	public static final String FILE_NAME = "Rental.o";

	public void writeRentalToFile(Rental ren) {
		try(
				FileOutputStream fos = new FileOutputStream(FILE_NAME);
				ObjectOutputStream oos = new ObjectOutputStream(fos);// opakowane klasa ObjectOutputStream... ma wiecje mozliwosi zapisu
				){
			oos.writeObject(ren);
		} catch (FileNotFoundException e) {
			System.err.println("Nie znaeziono pliku" + FILE_NAME);
		} catch (IOException e) {
			System.err.println("B³¹d podczas zapisu danych do pliku " + FILE_NAME);
		}
	}
	
	public Rental readRentalFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		Rental rental = null;
		try(
				FileInputStream fis = new FileInputStream(FILE_NAME);
				ObjectInputStream ois = new ObjectInputStream(fis);
				){
			
			rental = (Rental)ois.readObject();
			
		} catch (FileNotFoundException e) {
			System.err.println("Nie odnaleziono pliku" + FILE_NAME);
			throw e;
		} catch (IOException e) {
			System.err.println("B³¹d podczas zapisu danych do pliku " + FILE_NAME);
			throw e;
		} catch (ClassNotFoundException e) {
			System.err.println("Nieprawidlowy format pliku");
			throw e;
		}
		
		return rental;
		
	}

}
