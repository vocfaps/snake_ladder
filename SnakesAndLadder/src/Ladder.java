
public class Ladder extends BasePositionChanger {

	public Ladder() {
		super(0,0);
	}
	
	public Ladder(int start, int end) {
		super(start, end);
	}

	public String getName() {
		return Ladder.class.getName();
	}

}
