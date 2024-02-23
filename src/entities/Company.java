package entities;

public class Company extends Payer{
	
	private Integer numberEmps;
	
	//Construtores

	public Company() {
		super();
	}

	public Company(String name, Double anualIncome, Integer numberEmps) {
		super(name, anualIncome);
		this.numberEmps = numberEmps;
	}

	public Integer getNumberEmps() {
		return numberEmps;
	}

	public void setNumberEmps(Integer numberEmps) {
		this.numberEmps = numberEmps;
	}

	@Override
	public double taxes() {
		if(numberEmps > 10) {
			return getAnualIncome() * 0.14;
		}
		else {
			return getAnualIncome() * 0.16;
		}
	}
	
	
}
