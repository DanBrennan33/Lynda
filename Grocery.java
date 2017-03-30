import java.util.Scanner;
import java.util.ArrayList;

public class Grocery {
	private String item;
	private static String search;
	
	public Grocery(String i) {
		this.item = i;
	}
	
	public String toString() {
		return item;
	}
	
	public String getItem() {
		return item;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Grocery> gi = new ArrayList<Grocery>();
		
		System.out.println("Please add 5 items to Grocery List: ");
		for(int i = 0; i < 5; i ++) {
			Grocery g = new Grocery(in.next());
			gi.add(g);
		}
		
		System.out.println(gi.toString());
		System.out.println("Enter item to search for: ");
		search = in.next();
		
		for(int i = 0; i < 5; i++) {
			if(gi.equals(search)) {
				System.out.println(search + " is present in grocery list.");
				
			} else if (!gi.equals(search) && i == 4) {
				System.out.println(search + " is not present in grocery list.");
			}
			else {  }
		}
		
		in.close();
	}
}
