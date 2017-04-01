import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;


public class AmortizationCalculator {
	private static Scanner in = new Scanner(System.in);
	private static double monthlyRate;

	private static double calculate(double p, int n) {
		double amortization = 0.00;
		if (monthlyRate > 0) {
			amortization = (p * monthlyRate * Math.pow(1 + monthlyRate, (double)n)) / 
					(Math.pow(1 + monthlyRate, (double)n) - 1);
		} else {
			amortization = p / n;
		}
		return amortization;
	}
	
	public static void printTable(double p, int n) {
		Object[] headers = {"Payment #", "Amount Due", "Interest Due", "Principal Due", "Amount Left"};
		System.out.println("\n=========================Your Mortgage Payoff Table==========================");
		System.out.println("=========================--------------------------==========================");
		System.out.format("%5s %12s %18s %18s %16s \n", headers);
		System.out.println("=============================================================================");
		
		double monthlyPayment = calculate(p, n);
		double interestPayment = 0.0;
		double principalDue = 0.0;
		double principalLeft = p;
		boolean loanPaid = false;
		
		Object[][] rows = new Object[n][];	
		
		for (int i = 0; i < n; i++) {
			interestPayment = monthlyRate * principalLeft;
			principalDue = monthlyPayment - interestPayment;
			principalLeft = Math.abs(principalLeft - principalDue);
			
			Object[] row = {i+1, monthlyPayment, interestPayment, principalDue, principalLeft};
			rows[i] = row;
			System.out.format("%5d%17.4f%19.4f%19.4f%17.4f\n", row);
		}
		promptToSaveCSV(rows);
	}
	
	private static void promptToSaveCSV(Object[][] rows) {
		System.out.println("\n Would you like to save results to CSV file? [Yes/No]: ");
		String ans = in.next();
		if ("yes".equalsIgnoreCase(ans)) {
			try {
				FileWriter fw = new FileWriter("AmortizationTable.csv");
				BufferedWriter bw = new BufferedWriter(fw);
				StringBuilder sb = new StringBuilder();
				
				for (Object[] row : rows) {
					for (Object col : row) {
						if (sb.length() != 0) {
							sb.append(',');
						}
						sb.append(col);
					}
					sb.append("\n");
					bw.write(sb.toString());
					sb.setLength(0);
				}
				bw.close();
				
				System.out.println("Results saved to AmortizationTable.csv");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Results will not be saved to CSV.");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Please enter your total loan amount: ");
		double principal = in.nextDouble();
		System.out.println("Please enter your APR interest rate (format is 00.00): ");
		double interest = in.nextDouble();
		System.out.println("Please enter the total amount of payments: ");
		int payments = in.nextInt();
		
		monthlyRate = (double) interest / 1200;
		double amortization = calculate(principal, payments);
		System.out.println("==================================");
		System.out.printf("Your periodic payment amount is %.4f\n", amortization);
		System.out.println("==================================");
		
		printTable(principal, payments);
	}
}
