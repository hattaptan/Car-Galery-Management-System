package CarGallery.Domain;

public class BuyCarDomain {

	private int id;
	private String plaque; // define variable for cars info
	private String color;
	private String brand;
	private String model;
	private String gear;
	private String fuel;
	private String type;
	private String engine;
	private int door;
	private int price;



	 // define set and get methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaque() {
		return plaque;
	}

	public void setPlaque(String plaque) {
		this.plaque = plaque;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getGear() {
		return gear;
	}

	public void setGear(String gear) {
		this.gear = gear;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public int getDoor() {
		return door;
	}

	public void setDoor(int door) {
		if (door!=5) {
			door=5;
		}
		this.door = door;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return   plaque + " * " + color + " * " + brand + " * "
				+ model + " * " + gear + " * " + fuel + " * " + type + " * " + engine + " * "
				+ door + " * " + price ;
	}

}
