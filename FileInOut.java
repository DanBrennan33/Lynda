import java.io.*;
import java.util.Scanner;

public class FileInOut {
	public static void main(String[] args) {
		File menuItems = new File(args[0]);
		File menuPrices = new File("menu-prices.txt");
		String menuItem;
		double price;
		try {
			Scanner input = new Scanner(menuItems);
			PrintWriter out = new PrintWriter(menuPrices);
			Scanner in = new Scanner(System.in);
			while (input.hasNextLine()) {
				menuItem = input.nextLine();
				System.out.println("Price for this item: " + menuItem);
				price = in.nextDouble();
				in.nextLine();
				out.print(menuItem);
				out.print("/t");
				out.println(price);
			}
			out.close();
		}
		catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}
	}
}
