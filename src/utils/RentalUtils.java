package utils;

import data.Hard;
import data.Dual;
import data.Motorcycle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import data.Adventure;
import data.Rental;
import data.RentalUser;

public class RentalUtils {

	public static void printHard(Rental ren) {
		List<Motorcycle> motorcycle = new ArrayList<>();
		motorcycle.addAll(ren.getMotorcycles().values());
		Collections.sort (motorcycle , new Rental.AlphabeticalComparator());
		int countHard = 0; 
		for (Motorcycle m : motorcycle) {
			if (m instanceof Hard) {
				System.out.println(m);
				countHard++;
			}
		}
		if (countHard == 0) {
			System.out.println("Brak motocykli hard enduro w wypo¿yczalni.");
		}
	}

	public static void printDual(Rental ren) {
		List<Motorcycle> motorcycle = new ArrayList<>();
		motorcycle.addAll(ren.getMotorcycles().values());
		Collections.sort (motorcycle , new Rental.AlphabeticalComparator());
		int countDual = 0; 
		for (Motorcycle m : motorcycle) {
			if (m instanceof Dual) {
				System.out.println(m);
				countDual++;
			}
		}

		if (countDual == 0) {
			System.out.println("Brak motocykli Dual sport w wypo¿yczalni.");
		}
	}

	public static void printAdventure(Rental ren) {
		List<Motorcycle> motorcycle = new ArrayList<>();
		motorcycle.addAll(ren.getMotorcycles().values());
		Collections.sort (motorcycle , new Rental.AlphabeticalComparator());
		int countAdventure = 0; 
		for (Motorcycle m : motorcycle) {
			if (m instanceof Adventure) {
				System.out.println(m);
				countAdventure++;
			}
		}

		if (countAdventure == 0) {
			System.out.println("Brak motocykli Adventure w wypo¿yczalni.");
		}
	}

	public static void printUsers(Rental ren) {
		List<RentalUser> users = new ArrayList<>();
		users.addAll(ren.getUsers().values());
		Collections.sort(users, new Comparator<RentalUser>() {

			@Override
			public int compare(RentalUser o1, RentalUser o2) { //klasa anonimowa
				// TODO Auto-generated method stub
				return o1.getLastName().compareTo(o2.getLastName());
			}
			
			
		});
		
		for (RentalUser u : users) {
			System.out.println(u);
		}

	}
}
