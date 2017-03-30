import java.util.Scanner;

public class HospitalStay {
	public static void main(String[] args) {
		double totalCharge = 0;
		double onCharge = 0;
		double medCharge = 0;
		double serviceCharge = 0;
		String cont;
		
		Scanner in = new Scanner(System.in);
		
		for(int i = 0; ; i++) {
			if(i == 0) {
				System.out.println("Enter charges for patient. ");
			}
			else if (i >= 1) {
				System.out.println("Enter charges for next patient. Answer with Y/N to continue.");
				cont = in.next();
				cont.toUpperCase();
				if(cont.equals("N")) {
					in.close();
					System.exit(0);
				}
			}
			System.out.println("Enter overnight charge if applicable or 0 otherwise:");
			onCharge = in.nextDouble();
			System.out.println("Enter medical charge: ");
			medCharge = in.nextDouble();
			System.out.println("Enter service charge: ");
			serviceCharge = in.nextDouble();
			
			totalCharge += onCharge + medCharge + serviceCharge;
			
			System.out.println("Total charge for patient: "+ totalCharge);
		}
	}
}
