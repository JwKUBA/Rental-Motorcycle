package data;

import java.io.Serializable;

public class Motorcycle implements Serializable, Comparable<Motorcycle> {
	
	
	private static final long serialVersionUID = 5048483684183998732L;
	private String producer;
	private String model;
	private int engineCapacity;
	private int year;
	
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getEngineCapacity() {
		return engineCapacity;
	}
	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	protected Motorcycle(String producer, String model, int engineCapacity, int year) {
		setProducer(producer);
		setModel(model);
		setEngineCapacity(engineCapacity);
		setYear(year);
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + engineCapacity;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((producer == null) ? 0 : producer.hashCode());
		result = prime * result + year;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Motorcycle other = (Motorcycle) obj;
		if (engineCapacity != other.engineCapacity)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (producer == null) {
			if (other.producer != null)
				return false;
		} else if (!producer.equals(other.producer))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	 @Override
	public int compareTo(Motorcycle o) {
		return producer.compareTo(o.getProducer());
	 }

}
