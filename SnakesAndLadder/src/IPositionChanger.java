
/**
 * 
 * @author taahafahim
 *
 *The purpose of this interface is that any object implementing
 * this will be a position changer for the game player
 */
public interface IPositionChanger {
	int getNewPosition();
	int getOldPosition();
	String getName();
}
