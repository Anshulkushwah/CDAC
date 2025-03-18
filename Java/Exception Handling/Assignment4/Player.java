
public class Player {
	
	
	String name;
	int total_run;
	int no_of_wicket;
	int no_of_matches;
	String country;
	int no_of_century;
	String category;
	
	public Player(String name,int total_run,int no_of_wicket,
							int no_of_matches,String country,int no_of_century,String category) {
		
		this.name = name;
        this.total_run = total_run;
        this.no_of_wicket = no_of_wicket;
        this.no_of_matches = no_of_matches;
        this.country = country;
        this.no_of_century = no_of_century;
        this.category = category;
		
	}
	
	public void displayInfo() {
        System.out.println("Player Name: " + name);
        System.out.println("Total Runs: " + total_run);
        System.out.println("Number of Wickets: " + no_of_wicket);
        System.out.println("Number of Matches: " + no_of_matches);
        System.out.println("Country: " + country);
        System.out.println("Number of Centuries: " + no_of_century);
        System.out.println("Category: " + category);
    }

}
