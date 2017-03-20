package data;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Rental implements Serializable {

	private static final long serialVersionUID = -4185538624344792753L;
	private Map<String, Motorcycle> motorcycles;
	private Map<String, RentalUser> users;

	public int getMotorcycleNumber() {
		return motorcycles.size();
	}

	public Map<String, Motorcycle> getMotorcycles() {
		return motorcycles;
	}

	public Map<String, RentalUser> getUsers() {
		return users;
	}

	public Rental() {
		motorcycles = new HashMap<>();
		users = new HashMap<>();
	}

	public void addHard(Hard hard) {
		addMotorcycle(hard);
	}

	public void addDual(Dual dual) {
		addMotorcycle(dual);
	}

	public void addAdventure(Adventure adventure) {
		addMotorcycle(adventure);
	}

	public void addUser(RentalUser user) {
		users.put(user.getPesel(), user);
	}

	public void removeMotorcycle(Motorcycle moto) {
		if (motorcycles.containsValue(moto)) {// sprawdza czy mapa zawiera taki
												// obiekt:
			motorcycles.remove(moto.getProducer());
		}
	}

	public void addMotorcycle(Motorcycle moto) {
		motorcycles.put(moto.getProducer(), moto);// poliforyzm
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Motorcycle m : motorcycles.values()) {
			builder.append(m);
			builder.append("\n");
		}
		return builder.toString();
	}

	public static class AlphabeticalComparator implements Comparator<Motorcycle> {
		@Override
		public int compare(Motorcycle o1, Motorcycle o2) {
			if (o1 == null && o2 == null) {
				return 0;
			}
			if (o1 == null) {
				return 1;
							

			}
			if (o2 == null) {
				return -1;
			}
			return o1.getProducer().compareTo(o2.getProducer());
		}
	}

	public static class DateComparator implements Comparator<Motorcycle> {
		@Override
		public int compare(Motorcycle o1, Motorcycle o2) {
			if (o1 == null && o2 == null) {
				return 0;
			}
			if (o1 == null) {
				return 1;
			}
			if (o2 == null) {
				return -1;
			}
			Integer i1 = o1.getYear();// outboxing
			Integer i2 = o2.getYear();
			return -i1.compareTo(i2);
		}
	}
}
