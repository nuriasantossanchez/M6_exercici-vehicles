package com.vehicles.project.domain;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}

	@Override
	public String toString() {
		return "Wheel{" +
				"marca='" + brand + '\'' +
				", diametro=" + diameter +
				'}';
	}
}
