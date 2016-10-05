package ex_3_10;

public class PayLogic1 implements PayLogic {

	@Override
	public int Calculate(int workingHours, int overtimeHours) {
		
		return 10*workingHours + 15*overtimeHours;
	}

}
