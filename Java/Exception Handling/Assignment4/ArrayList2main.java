import java.util.ArrayList;

public class ArrayList2main {
	
	public static void PrintAllPlayer(ArrayList<Player>PlayerArr) {
		for(Player p : PlayerArr) {
		p.displayInfo();
		
		System.out.println("--------------------------------------------------");
		
	}
	}

	
	public static void max_scor_player(ArrayList<Player>PlayerArr) {
		int max = 0 ;
		Player max_scor_p = null;
		
		for(Player p : PlayerArr) {
			if(p.total_run > max) {
				max = p.total_run;
				max_scor_p = p;
			}
		}
		System.out.println("the player details who has scored maximum no of runs :");
		max_scor_p.displayInfo();

	}
	
	public static void Update_Category(ArrayList<Player>PlayerArr) {
		for (Player p : PlayerArr) {
          if (p.no_of_century >= 10) {
              p.category = "A";  // Update category to 'A' if player has 10 or more centuries
          } else {
              p.category = "B";  // Update category to 'B' if player has less than 10 centuries
          }
      }
	}
	
	public static void Remove_player_less_than_100_runs(ArrayList<Player>PlayerArr) {
	  // Remove players who have scored less than 100 runs
      PlayerArr.removeIf(player -> player.total_run < 100);
		
		//		or

				 // Using an Iterator to remove players with less than 100 runs
		//      Iterator<Player> iterator = PlayerArr.iterator();
		//      while (iterator.hasNext()) {
		//          Player player = iterator.next();
		//          if (player.total_run < 100) {
		//              iterator.remove();  // Remove the player if total_run is less than 100
		//          }
		//      }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player p1 = new Player("Ramesh", 50, 150, 35, "India", 0, "ODI");  
		Player p2 = new Player("Virat", 80, 200, 45, "India", 0, "Test");  
		Player p3 = new Player("Dhoni", 10000, 350, 50, "India", 38, "T20");  
		Player p4 = new Player("Kohli", 12000, 250, 55, "India", 3, "ODI");  
		Player p5 = new Player("Hardik", 3000, 100, 40, "India", 27, "T20");
		
		ArrayList<Player>PlayerArr = new ArrayList<>();
		PlayerArr.add(p1);
		PlayerArr.add(p2);
		PlayerArr.add(p3);
		PlayerArr.add(p4);
		PlayerArr.add(p5);
		
		
		
//		max_scor_player(PlayerArr);	
//		Update_Category(PlayerArr);
		Remove_player_less_than_100_runs(PlayerArr);
		PrintAllPlayer(PlayerArr);
        

	}

}
