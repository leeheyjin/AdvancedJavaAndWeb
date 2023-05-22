package chapter07;

public class HanKookTire extends Tire{

	public HanKookTire(int maxRotation, String location) {
		super(maxRotation, location);
	}
	
	@Override
	public boolean roll() {
		++accumulateRotation;
		if(accumulateRotation < maxRotation) {
			System.out.println(location + " Han");
		}
	}
	
	

}
