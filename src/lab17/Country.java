package lab17;

public class Country {

	private int population;
	private String name;
	
	public Country(int population, String name) {
		super();
		this.population = population;
		this.name = name;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Country: " + name + " /// " + "Population: " + population;
	}	
}
