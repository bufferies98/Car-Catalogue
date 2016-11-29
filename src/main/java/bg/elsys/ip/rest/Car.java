package bg.elsys.ip.rest;

import io.swagger.annotations.ApiModelProperty;

public class Car {

	@ApiModelProperty(required = true)
	private static int ID_COUNT = 1;
	private int id;
	private String model;
	private float topSpeed;
	private float horsePower;
	private int yearOfManufacture;

	public Car() {
		id = ID_COUNT++;
	}

	public Car(String model, float topSpeed, float horsePower, int yearOfManufacture) {
        this();
		this.model = model;
		this.topSpeed = topSpeed;
		this.horsePower = horsePower;
		this.yearOfManufacture = yearOfManufacture;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(float topSpeed) {
		this.topSpeed = topSpeed;
	}

	public float getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(float horsePower) {
		this.horsePower = horsePower;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
