
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class SnakeLadderDataManager {
	private String players [];
	private Map<Integer, IPositionChanger> snakesAndLaddersMap;
	
	SnakeLadderDataManager(String fileName){
		try {
			snakesAndLaddersMap = getSnakesAndLadder(fileName);
		} catch (Exception e) {
			snakesAndLaddersMap = new HashMap();
			e.printStackTrace();
		}
	}
	
	private Map<Integer, IPositionChanger> getSnakesAndLadder(String fileName) throws Exception {
		
		File file = new File(fileName); 
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		Map<Integer, IPositionChanger> map = new HashMap<Integer, IPositionChanger>();
		
		//below code can be extracted to a Utility and an appropriate ENUM/Constant 
		//can be passed for deciding what to use just like in factory pattern.
		
		int numberOfSnakes = Integer.parseInt(br.readLine());

		for(int i=0;i< numberOfSnakes;i++) {
			String s = br.readLine();
			String[] data = s.split(" ");
			int start = Integer.parseInt(data[0]);
			int end =Integer.parseInt(data[1]);
			Snake snake = new Snake(start, end);
			map.put(start, snake);
		}
		
		int numberOfLadders = Integer.parseInt(br.readLine());
		
		for(int i = 0;i < numberOfLadders; i++) {
			String s = br.readLine();
			String[] data = s.split(" ");
			int start = Integer.parseInt(data[0]);
			int end =Integer.parseInt(data[1]);
			Ladder ladder = new Ladder(start, end);
			map.put(start, ladder);
		}
		
		int playerCount = Integer.parseInt(br.readLine());
		this.players = new String[playerCount];
		for(int i=0 ; i< playerCount;i++) {
			this.players[i] = br.readLine();
		}
		
		return map;
		
	}
	
	public String[] getPlayers() {
		return this.players;
	}
	
	public Map<Integer, IPositionChanger> getMap(){
		return this.snakesAndLaddersMap;
	}

}
