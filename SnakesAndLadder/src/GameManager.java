import java.util.Map;
import java.util.Random;

public class GameManager {
	Map<Integer, IPositionChanger> snakesAndLaddersMap;
	String names[];
	int position [];
	boolean isGameOver = false; //can be replaced by a method which actually
	//checks if number of game finishers = names.length -1;
	
	public GameManager(String names[], Map<Integer, IPositionChanger> snakesAndLaddersMap) {
		this.names = names;
		this.snakesAndLaddersMap = snakesAndLaddersMap;
		this.position = new int[names.length];
	}
	
	String playGame() {
		String winner = "";
		int turn = 0;
		while(!isGameOver) {
			
			int roll = rollADie();
			int finalPos = getFinalPos(position[turn] + roll, names[turn]);
			
			String message =  names[turn] + " rolled a "+ roll + " but nothing happened";
			
			if(finalPos <= 100) {
		     message = names[turn] + " rolled a "+ roll + " and moved from "+ position[turn] 
					+" to " + finalPos;
			position[turn] = finalPos;
			}
			
			print(message);
			
			if(finalPos == 100) { //this can be replaced by a util 
				//to decide if game continues for 3 players
				winner = names[turn];
				isGameOver = true;
			}
			
			turn = (turn + 1) % names.length;
			
			
		}
		
		return winner;
	}
	
	private int getFinalPos(int pos, String player) {
	  if(snakesAndLaddersMap.containsKey(pos)) {
		  IPositionChanger magicGuy =  snakesAndLaddersMap.get(pos);
		  System.out.println(magicGuy.getName() + " encountered by " + player );
		return magicGuy.getNewPosition(); 
	  }
		else
			return pos;
	}

	int rollADie() {
		Random random = new Random();
		int rand = 0;
		while (true){
		    rand = random.nextInt(7);
		    if(rand !=0) break;
		}
		return rand;
	}
	
	int getTurn(int t) {
		return t % names.length;
	}
	
	void print(String mes) {
		System.out.println(mes);
	}
	
}
