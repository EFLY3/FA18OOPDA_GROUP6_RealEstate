import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * FileHandler Handles all methods related to reading/writing property records
 * in txt files.
 * 
 * @version 2018.11.29
 * @author D.Pimentel
 */
public class FileHandler {

	ArrayList<Property> propList;

	String address;
	String propertyType;
	int built;
	int squareFoot;
	int numRooms;
	double numBath;
	double backyard;
	boolean rentZoning;
	boolean has_secSystem, has_pool, has_fireplace, has_garage = false;

	/**
	 * Write info into specified file
	 */
	public void writeFile(Property prop, File filename) throws IOException {

		BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
		writer.write(prop.propWrite() + System.getProperty("line.separator"));
		writer.close();
	}

	/**
	 * Reads data from specified file and turns it into a Property object by
	 * splitting each string at every whitespace.
	 * 
	 */
	public void retrievePropertyObject(File filename) throws IOException {

		propList = new ArrayList<>();
		Property prop;

		BufferedReader file = null;
		try {
			file = new BufferedReader(new FileReader(filename));
			file.readLine();
			String read = null;
			while ((read = file.readLine()) != null) {
				String[] details = read.split("\\s+");
				for (String part : details) {

					address = details[0];

					propertyType = details[1];

					String builtString = details[2];
					built = Integer.parseInt(builtString);

					String squareFootString = details[3];
					squareFoot = Integer.parseInt(squareFootString);

					String numRoomsString = details[4];
					numRooms = Integer.parseInt(numRoomsString);

					String numBathString = details[5];
					numBath = Double.parseDouble(numBathString);

					String backyardString = details[6];
					backyard = Double.parseDouble(backyardString);

					String rentZoningString = details[7];
					if (rentZoningString.equals("yes")) {
						rentZoning = true;
					} else {
						rentZoning = false;
					}

					String has_secSystemSring = details[8];
					if (has_secSystemSring.equals("yes")) {
						has_secSystem = true;
					} else {
						has_secSystem = false;
					}
					String has_poolString = details[9];
					if (has_poolString.equals("yes")) {
						has_pool = true;
					} else {
						has_pool = false;
					}

					String has_fireplaceString = details[10];
					if (has_fireplaceString.equals("yes")) {
						has_fireplace = true;
					} else {
						has_fireplace = false;
					}

					String has_garageString = details[11];
					if (has_garageString.equals("yes")) {
						has_garage = true;

					} else {
						has_garage = false;
					}
				}
				// Store split data as a property object
				prop = new Property(address, propertyType, built, squareFoot, numRooms, numBath, backyard, rentZoning,
						has_secSystem, has_pool, has_fireplace, has_garage);
				// Save property in ArrayList
				propList.add(prop);
			}

		} catch (IOException e) {
			System.out.println("There was a problem: " + e);
			e.printStackTrace();
		} finally {
			file.close();
		}
	}

	/**
	 * Returns an ArrayList of Properties from previous method
	 */
	public ArrayList<Property> returnProperties() {
		return propList;
	}
}
