
public class PlayerMain {

	public static void main(String[] args) {
		player player1 = new player("Sachin Tendulkar", 47, "India", 18426);
        player player2 = new player("Ricky Ponting", 46, "Australia", 13704);
        player player3 = new player("Virat Kohli", 31, "India", 12000);
        player player4 = new player("AB de Villiers", 36, "South Africa", 9000);
        player player5 = new player("Chris Gayle", 41, "West Indies", 10480);

        // Displaying details of players with more than 5000 total runs
        System.out.println("Players with more than 5000 runs:");
        player1.displayPlayerDetails();
        player2.displayPlayerDetails();
        player3.displayPlayerDetails();
        player4.displayPlayerDetails();
        player5.displayPlayerDetails();
    
	}

}
