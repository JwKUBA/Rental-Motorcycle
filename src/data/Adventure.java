package data;

public class Adventure extends Dual {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2263571276505209067L;
	private String equipment;

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public Adventure(String producer, String model, int engineCapacity, int year, int milage, String tires,
			String equipment) {
		super(producer, model, engineCapacity, year, milage, tires);
		setEquipment(equipment);
	}

	@Override
	public String toString() {
		StringBuilder print = new StringBuilder(32); // rozmiar bufora klasy 32
														
		print.append("Producent:");
		print.append(getProducer());
		print.append(", Model:");
		print.append(getModel());
		print.append(", Pojemnoœæ silnika:");
		print.append(getEngineCapacity());
		print.append(" ccm3 ");
		print.append(", Rok produkcji:");
		print.append(getYear());
		print.append(", Przebieg km:");
		print.append(getMilage());
		print.append(" km ");
		print.append(" Rodzaj opon :");
		print.append(getTires());
		print.append(" Dodatkowe wyposa¿enie :");
		print.append(getEquipment());
		return print.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((equipment == null) ? 0 : equipment.hashCode());
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
		Adventure other = (Adventure) obj;
		if (equipment == null) {
			if (other.equipment != null)
				return false;
		} else if (!equipment.equals(other.equipment))
			return false;
		return true;
	}

}
