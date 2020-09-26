package com.vehicles.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();

	public Vehicle(String plate, String brand, String color) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public static String generaPlate() {
		//Letras validas para matrícula
		char[] array = {'A', 'B', 'C',
				'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
				'M', 'N', 'O' ,'P', 'Q', 'R', 'S', 'T', 'U',
				'V', 'W', 'X', 'Y', 'Z'};

		String plate = "";
		for (int i = 0; i < 7; i++) {
			Random rnd = new Random();
			int rndNumero = (int) (rnd.nextDouble() * 10);
			int rndLetra = (int) (rnd.nextDouble() * array.length);
			if (i < 4) {
				plate += rndNumero;
			} else {
				plate += array[rndLetra];
			}
		}

		return plate;

	}

	public static boolean checkPlate(String plate) {
		boolean plateOk = false;
		final String regex = "^[0-9]{1,6}[ABCDEFGHIJKLMNOPQRSTUVWXYZ]{1,6}";

		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(plate.toUpperCase());

		if (matcher.find()) {
			plateOk=true;

		}
		return plateOk;
	}
}