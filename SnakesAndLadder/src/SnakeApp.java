
public class SnakeApp {
	
	 public static void main(String[] args) {
		String fileName = "/Users/taahafahim/Desktop/test.txt";
		
		SnakeLadderDataManager datamanager = new SnakeLadderDataManager(fileName);
		//System.out.print(datamanager.getPlayers()[0] + datamanager.getPlayers()[1] );
		//System.out.print(datamanager.getMap());
		GameManager manager = new GameManager(datamanager.getPlayers(), datamanager.getMap());
		String winner = manager.playGame();
		System.out.print(winner + " wins the game");
	}

}
