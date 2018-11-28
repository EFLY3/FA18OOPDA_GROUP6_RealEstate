package Agency;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A class to read Property records
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
	 * Reads data from specified file and turns it into a Property object
	 */
	public void retrievePropertyObject(File filename) throws IOException {

		propList = new ArrayList<>();
		Property prop;

		BufferedReader file = null;
		try {
			file = new BufferedReader(new FileReader(filename));
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
					double numBath = Double.parseDouble(numBathString);

					String backyardString = details[6];
					double backyard = Double.parseDouble(backyardString);

					String rentZoningString = details[7];
					if (rentZoningString.equals("yes")) {
						rentZoning = true;
					}

					String has_secSystemSring = details[8];
					if (has_secSystemSring.equals("yes")) {
						has_secSystem = true;
					}

					String has_poolString = details[9];
					if (has_poolString.equals("yes")) {
						has_pool = true;
					}

					String has_fireplaceString = details[10];
					if (has_fireplaceString.equals("yes")) {
						has_fireplace = true;
					}

					String has_garageString = details[11];
					if (has_garageString.equals("yes")) {
						has_secSystem = true;

					}

					prop = new Property(address, propertyType, built, squareFoot, numRooms, numBath, backyard,
							rentZoning, has_secSystem, has_pool, has_fireplace, has_garage);
					propList.add(prop);
				}
			}

		} catch (IOException e) {
			System.out.println("There was a problem: " + e);
			e.printStackTrace();

		} finally {

			try {
				file.close();

			} catch (Exception e) {
			}
		}
	}

	/**
	 * Returns an ArrayList of Properties from previous method
	 */
	public ArrayList<Property> returnProperties() {
		return propList;
	}
}
