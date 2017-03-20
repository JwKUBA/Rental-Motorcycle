package utils;

import data.Dual;
import data.Hard;
import data.RentalUser;
import data.Adventure;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {

	private Scanner sc;

	public DataReader() {
		sc = new Scanner(System.in);
	}

	public int getInt() throws NumberFormatException {
		int number = 0;
		try {
			number = sc.nextInt();
		} catch (InputMismatchException e) {
			throw new NumberFormatException("Liczba wprowadzona w niepoprawnej formie");
		} finally {
			sc.nextLine();
		}
		return number;
	}

	public void close() {
		sc.close();
	}

	public Hard readAndCreateHard() throws InputMismatchException {
		System.out.println("Podaj producenta :");
		String producer = sc.nextLine();
		System.out.println("Podaj model :");
		String model = sc.nextLine();
		System.out.println("Podaj pojemnoœæ :");
		int engineCapicity = 0;
		int year = 0;
		try {
			engineCapicity = sc.nextInt();
			sc.nextLine();
			System.out.println("Podaj rok produkcji :");
			year = sc.nextInt();
			sc.nextLine();

		} catch (InputMismatchException e) {
			sc.nextLine();
			throw e;

		}
		System.out.println("Podaj typ silnika :");
		String engineType = sc.nextLine();
		System.out.println("Podaj przebieg w mh:");
		int milageMh = 0;
		int weight = 0;
		try {
			milageMh = sc.nextInt();
			sc.nextLine();
			System.out.println("Podaj wage :");
			weight = sc.nextInt();
			sc.nextLine();
		} catch (InputMismatchException e) {
			sc.nextLine();
			throw e;

		}

		return new Hard(producer, model, engineCapicity, year, engineType, milageMh, weight);

	}

	public Dual readAndCreateDual() throws InputMismatchException {
		System.out.println("Podaj producenta :");
		String producer = sc.nextLine();
		System.out.println("Podaj model :");
		String model = sc.nextLine();
		System.out.println("Podaj pojemnoœc :");
		int engineCapicity = 0;
		int year = 0;
		int milage = 0;
		try {
			engineCapicity = sc.nextInt();
			sc.nextLine();
			System.out.println("Podaj rok produkcji :");
			year = sc.nextInt();
			sc.nextLine();
			System.out.println("Podaj przebieg w km:");
			milage = sc.nextInt();
			sc.nextLine();
		} catch (InputMismatchException e) {
			sc.nextLine();
			throw e;
		}
		System.out.println("Podaj rodzaj opon :");
		String tires = sc.nextLine();

		return new Dual(producer, model, engineCapicity, year, milage, tires);

	}

	public Adventure readAndCreateAdventure() throws InputMismatchException {
		System.out.println("Podaj producenta :");
		String producer = sc.nextLine();
		System.out.println("Podaj model :");
		String model = sc.nextLine();
		System.out.println("Podaj pojemnoœc :");
		int engineCapicity = 0;
		int year = 0;
		int milage = 0;
		try {
			engineCapicity = sc.nextInt();
			sc.nextLine();
			System.out.println("Podaj rok produkcji :");
			year = sc.nextInt();
			sc.nextLine();
			System.out.println("Podaj przebieg w km:");
			milage = sc.nextInt();
			sc.nextLine();
		} catch (InputMismatchException e) {
			sc.nextLine();
			throw e;
		}
		System.out.println("Podaj rodzaj opon: ");
		String tires = sc.nextLine();
		System.out.println("Podaj dodatkowe wyposa¿enie:");
		String equipment = sc.nextLine();

		return new Adventure(producer, model, engineCapicity, year, milage, tires, equipment);
	}

	public RentalUser readAndCreateRentalUser() {
	        System.out.println("Imiê: ");
	        String firstName = sc.nextLine();
	        System.out.println("Nazwisko: ");
	        String lastName = sc.nextLine();
	        System.out.println("PESEL: ");
	        String pesel = sc.nextLine();
	  
	        return new RentalUser(firstName, lastName, pesel);
	    }
}
