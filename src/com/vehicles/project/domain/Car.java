package com.vehicles.project.domain;

import java.util.List;

/**
 * Clase de la capa de dominio. Extiende a la clase abstracte Vehicle
 */
public class Car extends Vehicle {

	public static final String VEHICLE_TYPE ="CAR";

	public Car(String plate, String brand, String color) {

		super(plate, brand, color);
	}

	/**
	 * Añade las ruedas delanteras y las ruedas traseras a sus correspodientes listados
	 * @param frontWheels, listado que contiene objetos de tipo Wheel, almacena las ruedas delanteras
	 * @param backWheels, listado que contiene objetos de tipo Wheel, almacena las ruedas traseras
	 * @throws Exception
	 */
	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}

	/**
	 * Añade 2 ruedas a un listado de objetos Wheel de dimension 2, una será la rueda de la dercha
	 * y la otra la de la izqda
	 * @param wheels, listado de objetos de tipo Wheel
	 * @throws Exception, si el tamaño del listado pasado como parametro es distinto a 2
	 */
	public void addTwoWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception();

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (!rightWheel.equals(leftWheel))
			throw new Exception();

		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}

	@Override
	public String toString() {
		return "Car {" +
				"matricula='" + plate + '\'' +
				", marca='" + brand + '\'' +
				", color='" + color + '\'' +
				", ruedas=" + wheels.toString() +
				'}';
	}
}
