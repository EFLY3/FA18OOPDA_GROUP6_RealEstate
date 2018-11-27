package agency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A class to read CSV-style records of animal sighting reports.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class FileReader {
	// How many fields are expected.
	private static final int PROPERTIES = 11;
	// Index values for the fields in each record.
	private static final int FIELDS = 0, ADDRESS = 1, PROPERTY_TYPE = 2, BUILT_IN = 3, SQUARE_FOOT = 4, NUM_ROOMS = 5,
			NUM_BATH = 6, NUM_FLOORS = 7, BACKYARD = 8, RENT_ZONING = 9, HAS_SEC_SYSTEM = 10, HAS_POOL = 11,
			HAS_FIREPLACE = 12, HAS_GARAGE = 13;

	/**
	 * Create a SightingReader.
	 */
	public FileReader() {
	}

	/**
	 * Read sightings in CSV format from the given file. Return an ArrayList of
	 * Sighting objects created from the information in the file.
	 * 
	 * @param filename The file to be read - should be in CSV format.
	 * @return A list of Sightings.
	 */
	public ArrayList<Property> getPropertiesToBeSold(String filename) {
		// Create a Sighting from a CSV input line.
		Function<String, Property> createPropertyList = record -> {
			String[] parts = record.split(",");
			if (parts.length == FIELDS) {
				try {

					String address = parts[ADDRESS].trim();
					String propertyType = parts[PROPERTY_TYPE].trim();
					int builtIn = Integer.parseInt(parts[BUILT_IN].trim());
					int squareFoot = Integer.parseInt(parts[SQUARE_FOOT].trim());
					int numRooms = Integer.parseInt(parts[NUM_ROOMS].trim());
					double numBath = Double.parseDouble(parts[NUM_BATH].trim());
					int num_floors = Integer.parseInt(parts[NUM_FLOORS].trim());
					double backyard = Double.parseDouble(parts[BACKYARD].trim());
					boolean rentZoning = Boolean.parseBoolean(parts[RENT_ZONING].trim());
					boolean has_secSystem = Boolean.parseBoolean(parts[HAS_SEC_SYSTEM].trim());
					boolean has_pool = Boolean.parseBoolean(parts[HAS_POOL].trim());
					boolean has_fireplace = Boolean.parseBoolean(parts[HAS_FIREPLACE].trim());
					boolean has_garage = Boolean.parseBoolean(parts[HAS_GARAGE].trim());

					return new Property(address, propertyType, builtIn, squareFoot, numRooms, numBath, num_floors,
							backyard, rentZoning, has_secSystem, has_pool, has_fireplace, has_garage);

				} catch (NumberFormatException e) {
					System.out.println("Property record has a malformed integer: " + record);
					return null;
				}
			} else {
				System.out.println("Property record has the wrong number of fields: " + record);
				return null;
			}
		};
		ArrayList<Property> properties;
		try {
			properties = Files.lines(Paths.get(filename))
					.filter(record -> record.length() > 0 && record.charAt(0) != '#').map(createPropertyList)
					.filter(property -> property != null).collect(Collectors.toCollection(ArrayList::new));

		} catch (IOException e) {
			System.out.println("Unable to open " + filename);
			properties = new ArrayList<>();
		}
		return properties;
	}
}
