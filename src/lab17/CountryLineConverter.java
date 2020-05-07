package lab17;

public class CountryLineConverter implements LineConverter<Country>{

	@Override
	public String toLine(Country object) {
		return object.getName()+","+object.getPopulation();
	}

	@Override
	public Country fromLine(String line) {

		String[] parts = line.split(",");
		String name = parts[0];
		int population = Integer.parseInt(parts[1]);		
	
		return new Country(population, name);
	}

}