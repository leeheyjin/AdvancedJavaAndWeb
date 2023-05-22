package chapter06;

class Car {
	int gas;

	public void setGas(int gas) {
		this.gas = gas;
	}

	boolean isLeftGas() {
		if (gas == 0) {
			System.out.println("가스가 없습니다.");
			return false;
		}
		System.out.println("가스가 있습니다.");
		return true;
	}

	void run() {
		while (true) {
			if (gas > 0) {
				System.out.println("달립니다. (가스 잔량: " + gas + ")");
				gas--;
			} else {
				System.out.println("멈춥니다. (가스 잔량: " + gas + ")");
				return;
			}
		}
	}
}

public class CarExample {
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.setGas(5); // myCar.gas == 5

		boolean gasState = myCar.isLeftGas(); // true
		if (gasState) {
			System.out.println("출발합니다.");
			myCar.run();
		}

		if (myCar.isLeftGas()) {
			System.out.println("가스를 주입할 필요가 없습니다.");
		} else {
			System.out.println("가스를 주입하세요.");
		}
	}
	/*
	 * 가스가 있습니다.
	 * 달립니다. (가스 잔량: 5)
	 * 달립니다. (가스 잔량: 4)
	 * 달립니다. (가스 잔량: 3)
	 * 달립니다. (가스 잔량: 2)
	 * 달립니다. (가스 잔량: 1)
	 * 멈춥니다. (가스 잔량: 0)
	 * 가스가 없습니다.
	 * 가스를 주입하세요.이뿌니
	 */

}
