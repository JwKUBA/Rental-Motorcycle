package app;

public class RentalApp {

	public static void main(String[] args) {
		final String appName = "Wypożyczalnia Motocykli v0,8";
		System.out.println(appName);
		RentalControl rentalcontrol = new RentalControl();
		rentalcontrol.controlLoop();
	}

}
