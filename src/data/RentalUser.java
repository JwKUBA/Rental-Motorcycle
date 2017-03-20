package data;

import java.util.ArrayList;
import java.util.List;

public class RentalUser extends User {

	private static final long serialVersionUID = -7306818580374755443L;

	private List<Motorcycle> motorcycleHistory;
	private List<Motorcycle> borrowedMotorcycle;

	public List<Motorcycle> getMotorcycleHistory() {
		return motorcycleHistory;
	}

	

	public List<Motorcycle> getBorrowedMotorcycle() {
		return borrowedMotorcycle;
	}


	public RentalUser(String firstName, String lastName, String pesel) {
		super(firstName, lastName, pesel);
		motorcycleHistory = new ArrayList<>();
		borrowedMotorcycle = new ArrayList<>();
	}

	private void addMotorcycleToHistory(Motorcycle mot) {
		motorcycleHistory.add(mot);
	}

	public void borrowMotorcycle(Motorcycle mot) {
		borrowedMotorcycle.add(mot);

	}

	public boolean returnMotorcycle(Motorcycle mot) { 
		boolean result = false;
		if (borrowedMotorcycle.remove(mot)) {
			result = true;
			addMotorcycleToHistory(mot);
		}
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((borrowedMotorcycle == null) ? 0 : borrowedMotorcycle.hashCode());
		result = prime * result + ((motorcycleHistory == null) ? 0 : motorcycleHistory.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RentalUser other = (RentalUser) obj;
		if (borrowedMotorcycle == null) {
			if (other.borrowedMotorcycle != null)
				return false;
		} else if (!borrowedMotorcycle.equals(other.borrowedMotorcycle))
			return false;
		if (motorcycleHistory == null) {
			if (other.motorcycleHistory != null)
				return false;
		} else if (!motorcycleHistory.equals(other.motorcycleHistory))
			return false;
		return true;
	}
	
	

}
