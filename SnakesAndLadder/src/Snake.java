
public class Snake extends BasePositionChanger {

	public Snake() {
		super(0,0);
	}
	
	public Snake(int start, int end) {
		super(start, end);
	}

	public String getName() {
		return Snake.class.getName();
	}

}
