
public abstract class BasePositionChanger implements IPositionChanger {
	private int startPosition;
	private int endPosition;
	
	public BasePositionChanger(int start, int end) {
		this.startPosition = start;
		this.endPosition = end;
		//System.out.println(getName() + " made with " +start + " " + end);
	}

     public int getNewPosition() {
		return endPosition;
	}
	
	public int getOldPosition() {
		return startPosition;
	}
     
     public abstract String getName(); // helps to print name of teleporter
}
