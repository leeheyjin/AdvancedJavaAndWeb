package chapter06.comfirm;

class Plane {
	private String manufacturer;
	private String model;
	private int maxNoOfPassengers;
	private static int noOfPlanes = 0;

	public Plane() {
		manufacturer = "0";
		model = "0";
		maxNoOfPassengers = 0;
		noOfPlanes++;
	}

	public Plane(String manufacturer, String model, int maxNoOfPassengers) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.maxNoOfPassengers = maxNoOfPassengers;
		noOfPlanes++;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMaxNoOfPassengers() {
		return maxNoOfPassengers;
	}

	public void setMaxNoOfPassengers(int maxNoOfPassengers) {
		if (maxNoOfPassengers < 0) {
			this.maxNoOfPassengers = 0;
		} else {
			this.maxNoOfPassengers = maxNoOfPassengers;
		}
	}

	public static int getNoOfPlanes() {
		return noOfPlanes;
	}

}

public class PlaneTest {
	public static void main(String[] args) {
		Plane plane1 = new Plane("보잉", "보잉 747", 450);
		System.out.println("제조사: " + plane1.getManufacturer());
		System.out.println("모델명: " + plane1.getModel());
		System.out.println("최대 승객수: " + plane1.getMaxNoOfPassengers());
		System.out.println();

		Plane plane2 = new Plane("보잉", "보잉 777", 500);
		System.out.println("제조사: " + plane2.getManufacturer());
		System.out.println("모델명: " + plane2.getModel());
		System.out.println("최대 승객수: " + plane2.getMaxNoOfPassengers());
		System.out.println();

		Plane plane3 = new Plane();
		plane3.setManufacturer("록히드 마틴");
		plane3.setModel("F-22");
		plane3.setMaxNoOfPassengers(-10);

		System.out.println("제조사: " + plane3.getManufacturer());
		System.out.println("모델명: " + plane3.getModel());
		System.out.println("최대 승객수: " + plane3.getMaxNoOfPassengers());
		System.out.println();

		System.out.println("생산된 비행기의 수:" + Plane.getNoOfPlanes());
	}

}
