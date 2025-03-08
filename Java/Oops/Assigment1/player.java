
public class player {
	// Instance variables
    String name;
    int age;
    String country;
    int totalRun;

    // Constructor to initialize Player object
    public player(String name, int age, String country, int totalRun) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.totalRun = totalRun;
    }

    // Instance method to display details of players with more than 5000 runs
    public void displayPlayerDetails() {
        if (totalRun > 5000) {
            System.out.println("Player Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Country: " + country);
            System.out.println("Total Runs: " + totalRun);
            System.out.println("-------------------------");
        }
    }

}
