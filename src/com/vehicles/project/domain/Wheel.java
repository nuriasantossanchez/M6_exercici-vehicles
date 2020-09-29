package com.vehicles.project.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}

	/**
	 * Checkea si el diametro de una rueda tiene una valor superior a 0.4 e inferior a 4
	 * @param diameter, el valor a checkear
	 * @return, true si el valor esta dentro del rango, false si no esta dentro del rango
	 */
	public static boolean checkDiameter(String diameter) {
		double minimo=0.4;
		double maximo=4;
		boolean diameterOk = false;
		if(Double.parseDouble(diameter)>minimo && Double.parseDouble(diameter)<maximo){
			diameterOk=true;
		}
		return diameterOk;
	}

	@Override
	public String toString() {
		return "Wheel{" +
				"marca='" + brand + '\'' +
				", diametro=" + diameter +
				'}';
	}
}
