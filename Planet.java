public class Planet extends SolarObject {
	/**
	 * Planet constructor
	 * @param  startx        start position
	 * @param  starty        start position in terms of rotation
	 * @param  startdiameter size of the asteroid
	 * @param  col           object color
	 * @param  name          object name
	 * @param  astLocation   object distance to the point of rotation
	 * @return               No returns
	*/

	public Planet(double startx, double starty, double startdiameter, String col, String name){
		super(startx, starty,startdiameter,col,name);
	}
	
}