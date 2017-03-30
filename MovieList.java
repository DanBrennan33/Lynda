
public class MovieList {
	private String title;
	private double rating;
	private int yearMade;
	private int runtimeMins;
	
	public MovieList(String n, double r) {
		this.title = n;
		this.rating = r;
		yearMade = 0;
		runtimeMins = 0;
	}
	
	public MovieList(String n, double r, int yM, int rtM) {
		this.title = n;
		this.rating = r;
		this.yearMade = yM;
		this.runtimeMins = rtM;
	}
	
	public String toString() {
		return "Title:     " + title + 
			   "\nRating:    " + rating + 
			   "\nYear Made: " + yearMade +   
			   "\nRuntime:   " + runtimeMins;
	}
	
	public void setRating(double r) {
		rating = r;
	}
	
	public static void main(String[] args) {
		MovieList shaw = new MovieList("Shawshank Redemption", 9.1);
		MovieList alien = new MovieList("Alien", 8.7, 1979, 116);
		System.out.println(shaw.toString());
		System.out.println(alien.toString());
		alien.setRating(8.8);
		System.out.println(alien.toString());
	}
	
}
