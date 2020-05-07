package lab17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountriesApp {

	private static FileHelper<Country> helper = new FileHelper<>("country.txt", new CountryLineConverter());

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int x = 1;
		do {
			int userInput = ValidatorHelper.getInt(kbd, " 1 : Display Countries. \n 2 : Add a Country. "
					+ "\n 3 : Remove a Country. \n 4 : Change population of a country. \n 5 : Sort by population. \n 6 : Quit\n");
			if (userInput == 1) {
				List<Country> allCountries = helper.readAll();
				for (Country c : allCountries) {
					System.out.println(c);
				}
			} else if (userInput == 2) {
				System.out.println("Enter a country: ");
				String countryToAdd = kbd.next();

				System.out.println("Enter the population: ");
				int populationToAdd = kbd.nextInt();

				helper.append(new Country(populationToAdd, countryToAdd));

			} else if (userInput == 3) {
				System.out.println("Enter a country you wish to remove: ");
				String countryToRemove = kbd.next();

				List<Country> allCountries2 = helper.readAll();
				for (Country c : allCountries2) {
					if (c.getName().equals(countryToRemove)) {
						allCountries2.remove(c);
					}
					// helper.rewrite(allCountries2);
				}
				helper.rewrite(allCountries2);
			} else if (userInput == 4) {
				System.out.println("Enter a country you wish to change the population of: ");
				String countryToPopulate = kbd.next();
				System.out.println("Enter the population: ");
				int newPopulation = kbd.nextInt();

				List<Country> allCountries3 = helper.readAll();
				for (Country c : allCountries3) {
					if (c.getName().equals(countryToPopulate)) {
						c.setPopulation(newPopulation);
					}
				}
				helper.rewrite(allCountries3);
			} else if (userInput == 5) {
				List<Country> allCountries3 = helper.readAll();
				List<Country> sorted_countries = allCountries3.stream()
						.sorted((e1, e2) -> Integer.compare(e1.getPopulation(), e2.getPopulation()))
						.collect(Collectors.toList());
				helper.rewrite(sorted_countries);

			}else if (userInput == 6) {
				System.out.println("Thanks for expanding our collective knowledge of the world. Goodbye!");
				break;
			} else
				System.out.println("Looks like you entered something invalid, Try again!");

		} while (x > 0);

	}

}
