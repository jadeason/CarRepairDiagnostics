package com.ubiquisoft.evaluation.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Map;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {

	private String year;
	private String make;
	private String model;

	private List<Part> parts;

	public Map<PartType, Integer> getMissingPartsMap() {
		/*
		 * Return map of the part types missing.
		 *
		 * Each car requires one of each of the following types:
		 *      ENGINE, ELECTRICAL, FUEL_FILTER, OIL_FILTER
		 * and four of the type: TIRE
		 *
		 * Example: a car only missing three of the four tires should return a map like this:
		 *
		 *      {
		 *          "TIRE": 3
		 *      }
		 */

		//initialize map to store missing parts
		Map<PartType, Integer> missingParts = new HashMap<>();

		//Check inventory for part needed
		// Checking for ENGINE
		int engineCount = inventory.getPartCount(PartType.ENGINE);
		if (engineCount < 1) { //
			missingParts.put(PartType.ENGINE, 1 - engineCount); //adding ENGINE to missing parts map
		}

		//check ELECTRICAL
		int electricalCount = inventory.getPartCount(PartType.ELECTRICAL);
		if (electricalCount < 1) { // If less than 1 electrical part is found in the inventory
			missingParts.put(PartType.ELECTRICAL, 1 - electricalCount); //adding  ELECTRICAL to missing parts map

		}
		// Check for FUEL_FILTER
		int fuelFilterCount = inventory.getPartCount(PartType.FUEL_FILTER);
		if (fuelFilterCount < 1) { // If less than 1 fuel filter is found in the inventory
			missingParts.put(PartType.FUEL_FILTER, 1 - fuelFilterCount); //adding FUEL_FILTER to missing parts map
		}

		// Check for OIL_FILTER
		int oilFilterCount = inventory.getPartCount(PartType.OIL_FILTER);
		if (oilFilterCount < 1) { // If less than 1 oil filter is found in the inventory
			missingParts.put(PartType.OIL_FILTER, 1 - oilFilterCount); //adding OIL_FILTER to missing parts map
		}

		// Check for TIRE
		int tireCount = inventory.getPartCount(PartType.TIRE);
		if (tireCount < 4) { // If less than 4 tires are found in the inventory
			missingParts.put(PartType.TIRE, 4 - tireCount); //adding TIRE to missing parts map
		}

		// Return the map of missing parts, if any
		if (missingParts.size() == 0)
			return null; // Return null if no missing parts are found
		else
			return missingParts; // Return the map of missing parts
	}

	@Override
	public String toString() {
		return "Car{" +
				       "year='" + year + '\'' +
				       ", make='" + make + '\'' +
				       ", model='" + model + '\'' +
				       ", parts=" + parts +
				       '}';
	}

	/* --------------------------------------------------------------------------------------------------------------- */
	/*  Getters and Setters *///region
	/* --------------------------------------------------------------------------------------------------------------- */

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<Part> getParts() {
		return parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}

	/* --------------------------------------------------------------------------------------------------------------- */
	/*  Getters and Setters End *///endregion
	/* --------------------------------------------------------------------------------------------------------------- */

}
