package com.vehicles.project.domain;

import java.util.List;

/**
 * Clase de la capa de dominio. Extiende a la clase abstracte Vehicle
 */
public class Bike extends Vehicle {

	public static final String VEHICLE_TYPE ="BIKE";

	public Bike(String plate, String brand, String color) {

		super(plate, brand, color);
	}

	public void addWheels(List<Wheel> frontWheel, List<Wheel> backWheel) throws Exception {
		addOneWheel(frontWheel);
		addOneWheel(backWheel);
	}

	/**
	 * Añade 1 rueda a un listado de objetos Wheel de dimension 2, una será la rueda delantera
	 * y la otra la trasera
	 * @param wheels, listado de objetos de tipo Wheel
	 * @throws Exception, si el tamaño del listado pasado como parametro es distinto a 1
	 */
	public void addOneWheel(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 1)
			throw new Exception();

		Wheel wheel = wheels.get(0);
		this.wheels.add(wheel);
	}

	@Override
	public String toString() {
		return "Bike {" +
				"matricula='" + plate + '\'' +
				", marca='" + brand + '\'' +
				", color='" + color + '\'' +
				", ruedas=" + wheels.toString() +
				'}';
	}
}
