package data;

public class Hard extends Motorcycle {

	
	private static final long serialVersionUID = -2966271019799373698L;
	private String engineType;
	private int milageMh;
	private int weight;

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public int getMilageMh() {
		return milageMh;
	}

	public void setMilageMh(int milageMh) {
		this.milageMh = milageMh;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Hard(String producer, String model, int engineCapacity, int year, String engineType, int milageMh,
			int weight) {
		super(producer, model, engineCapacity, year);
		setEngineType(engineType);
		setMilageMh(milageMh);
		setWeight(weight);

	}

	@Override
	public String toString() {
		StringBuilder print = new StringBuilder(32); //rozmiar bufora klasy 32 rozmiar napisów które zmieszcza sie w metodach append
		print.append("Producent:");
		print.append(getProducer());
		print.append(", Model:");
		print.append(getModel());
		print.append(", Pojemnoœæ silnika:");
		print.append(getEngineCapacity());
		print.append(" ccm3 ");
		print.append(", Rok produkcji:");
		print.append(getYear());
		print.append(", Przebieg mh(motohours):");
		print.append(getMilageMh());
		print.append(" mh ");
		print.append(", Waga:");
		print.append(getWeight());
		print.append(" kg ");
		return print.toString();
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((engineType == null) ? 0 : engineType.hashCode());
		result = prime * result + milageMh;
		result = prime * result + weight;
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
		Hard other = (Hard) obj;
		if (engineType == null) {
			if (other.engineType != null)
				return false;
		} else if (!engineType.equals(other.engineType))
			return false;
		if (milageMh != other.milageMh)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
	

}
