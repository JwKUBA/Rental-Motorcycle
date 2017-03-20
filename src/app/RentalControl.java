package app;

import utils.DataReader;
import utils.FileManager;
import utils.RentalUtils;
import data.Hard;
import data.Rental;
import data.RentalUser;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import data.Adventure;
import data.Dual;

public class RentalControl {

	private DataReader dataReader;
	private FileManager filemanager;
	private Rental rental;

	public RentalControl() {
		dataReader = new DataReader();
		filemanager = new FileManager();
		try {
			rental = filemanager.readRentalFromFile();
			System.out.println( "Wczytano dane wypo¿yczalni z pliku");
		} catch (ClassNotFoundException | IOException e) {
			rental = new Rental();
			System.out.println("Utworzono now¹ baze wypo¿yczalni");
		}
	}

	public void controlLoop() {
		Option option = null;
		while (option != Option.EXIT) {
			try {
				printOptions();
				option = Option.createFromInt(dataReader.getInt());
				switch (option) {
				case ADD_HARD:
					addHardEnduro();
					break;
				case ADD_DUAL:
					addDualEnduro();
					break;
				case ADD_ADVENTURE:
					addAdventureEnduro();
					break;
				case PRINT_HARD:
					printHardEnduro();
					break;
				case PRINT_DUAL:
					printDualEnduro();
					break;
				case PRINT_ADVENTURE:
					printAdventureEnduro();
					break;
				case ADD_USER:
                    addUser();
                    break;
                case PRINT_USERS:
                    printUsers();
                    break;	
				case EXIT:
					exit();
				default:
					break;
				
				}

			} catch (InputMismatchException e) {
				System.out.println("Wprowadzono niepoprawne dane. Wprowadz liczbe.");
			} catch (NumberFormatException | NoSuchElementException e) {
				System.out.println("Nie ma takiej opcji, wybierz ponownie: ");
			}
		}
		dataReader.close();
	}

	private void printOptions() {
		System.out.println("Wybierz opcje");
		for (Option o : Option.values()) {
			System.out.println(o);
		}

	}

	private void addHardEnduro() {
		Hard hard = dataReader.readAndCreateHard();
		rental.addHard(hard);
	}

	private void addDualEnduro() {
		Dual dual = dataReader.readAndCreateDual();
		rental.addDual(dual);
	}

	private void addAdventureEnduro() {
		Adventure adventure = dataReader.readAndCreateAdventure();
		rental.addAdventure(adventure);

	}

	private void printHardEnduro() {
		RentalUtils.printHard(rental);
	}

	private void printDualEnduro() {
		RentalUtils.printDual(rental);
	}

	private void printAdventureEnduro() {
		RentalUtils.printAdventure(rental);
	}
	
	 private void addUser() {
	        RentalUser user = dataReader.readAndCreateRentalUser();
	        rental.addUser(user);
	    }
	     
	    private void printUsers() {
	        RentalUtils.printUsers(rental);
	    }

	private void exit() {
		filemanager.writeRentalToFile(rental);
	}

	private enum Option {
		
		ADD_HARD(1, "Dodanie do bazy motocykla Hard Enduro:"),
		ADD_DUAL(2, "Dodanie do bazy motocykla Dual Sport:"),
		ADD_ADVENTURE(3, "Dodanie do bazy motocykla Adventure:"), 
		PRINT_HARD (4, "Wyœwietlenie dostêpnych motocykli Hard Enduro:"),
		PRINT_DUAL(5, " Wyœwietlenie dostêpnych motocykli Dual Sport:"), 
		PRINT_ADVENTURE(6, " Wyœwietlenie dostêpnych motocykli Adventure:"),
	    ADD_USER(7, "Dodanie nowego u¿ytkownika"),
	    PRINT_USERS(8, "Wyœwietlenie listy u¿ytkowników"),
		EXIT(9, "Wyjœcie");
		
		
		private int value; //wartosc
		private String description; // opis

		private Option(int value, String description) {
			this.value = value;
			this.description = description;
		}
		
		 @Override
		    public String toString() {
		        return value + " - " + description;
		    }
		 
		 public static Option createFromInt(int option) throws NoSuchElementException { 
			 Option result = null; 
			 try {
				 result = Option.values()[option-1];
			 } catch(ArrayIndexOutOfBoundsException e) {
				 throw new NoSuchElementException("Brak elementu o wskazanym ID");
			 }
			 
			 return result;
		 }
		

	}
}
