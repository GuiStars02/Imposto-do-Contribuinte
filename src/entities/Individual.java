package entities;

public class Individual extends Payer{
	
	private Double healthExpenses;
	
	//Construtores
	public Individual() {
		super();
	}
	
	public Individual(String name, Double anualIncome, Double healthExpenses) {
		super(name, anualIncome);
		this.healthExpenses = healthExpenses;
	}

	public Double getHealthExpenses() {
		return healthExpenses;
	}

	public void setHealthExpenses(Double healthExpenses) {
		this.healthExpenses = healthExpenses;
	}

	@Override
	public double taxes() {
		double tax;
		if(getAnualIncome() < 20000.00) {
			tax = getAnualIncome() * 0.15;
		}
		else {
			tax = getAnualIncome() * 0.25;
		}
		///////////
		if(healthExpenses > 0) {
			tax -= healthExpenses * 0.5;
		}
		
		return tax;
		
	}
	
}
