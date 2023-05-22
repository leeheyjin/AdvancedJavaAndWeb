package chapter07;

public class Car {
	Tire frontLefTire = new Tire(6, "운전석");
	Tire frontRightTire = new Tire(2, "조수석");
	Tire backLeftTire = new Tire(3, "운전석 뒤");
	Tire backRightTire = new Tire(4, "조수석 뒤");

	public int run() {
		System.out.println("[자동차가 달립니다.]");
		if (frontLefTire.roll() == false) {
			stop();
			return 1;
		}
		if (frontRightTire.roll() == false) {
			stop();
			return 2;
		}
		if (backLeftTire.roll() == false) {
			stop();
			return 3;
		}
		if (backRightTire.roll() == false) {
			stop();
			return 4;
		}
		return 0;
	}

	public void stop() {
		System.out.println("[자동차가 멈춥니다.]");
	}

}
