package data;

public class Dual extends Motorcycle {

	
	private static final long serialVersionUID = 96614253268178389L;
	private int milage;
	private String tires;

	public int getMilage() {
		return milage;
	}

	public void setMilage(int milage) {
		this.milage = milage;
	}

	public String getTires() {
		return tires;
	}

	public void setTires(String tires) {
		this.tires = tires;
	}

	public Dual(String producer, String model, int engineCapacity, int year, int milage, String tires) {
		super(producer, model, engineCapacity, year);
		setMilage(milage);
		setTires(tires);
	}

	@Override
	public String toString() {
		StringBuilder print = new StringBuilder(32); //rozmiar bufora klasy 32 rozmiar napisów które zmieszcza sie w metodach append
		print.append("Producent:");
		print.append(getProducer());
		print.append(", Model:");
		print.append(getModel());
		print.append(", Pojemnoœæ silnika: ");
		print.append(getEngineCapacity());
		print.append(" ccm3 : ");
		print.append(", Rok produkcji :");
		print.append(getYear());
		print.append(", Przebieg km :");
		print.append(getMilage());
		print.append(" km ");
		print.append(", Rodzaj opon :");
		print.append(getTires());
		return print.toString();
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + milage;
		result = prime * result + ((tires == null) ? 0 : tires.hashCode());
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
		Dual other = (Dual) obj;
		if (milage != other.milage)
			return false;
		if (tires == null) {
			if (other.tires != null)
				return false;
		} else if (!tires.equals(other.tires))
			return false;
		return true;
	}

}
