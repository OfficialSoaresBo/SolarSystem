/**
 * Asteroid Class that extends solar object and passes it's parameters to the solar object contructor
 */
public class Asteroid extends SolarObject {
	/**
	 * Asteroid constructor
	 * @param  startx        start position
	 * @param  starty        start position in terms of rotation
	 * @param  startdiameter size of the asteroid
	 * @param  col           asteroids color
	 * @param  name          asteroid name
	 * @param  astLocation   asteroid distance to the point of rotation
	 * @return               No returns
	 */
	public Asteroid(double startx, double starty, double startdiameter, String col, String name, int astLocation){
		super(startx, starty,startdiameter,col,name, astLocation);
	}
	
}