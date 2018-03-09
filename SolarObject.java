import java.util.*;

public class SolarObject {
    /**
     * Creating my private variables
     */
    private double pDistanceFromSun = 0;
    private double pOrbitAngle = 0;
    private double size = 0;
    private String color = "";
    private double pSpeed = 0;
    private double mSpeed = 0;
    private String pName = "";
    private int astStartLocation = 0;

    /**
     * SolarObject constructor
     * @param  x        start position
     * @param  y        start position in terms of rotation
     * @param  diameter size of the asteroid
     * @param  col           object color
     * @param  name          object name
     * @return               No returns
    */
    public SolarObject(double x, double y, double diameter, String col, String name){
        this.pDistanceFromSun = x;
        this.pOrbitAngle = y;
        this.size = diameter;
        this.color = col;
        this.pName = name;

        setSpeed(pName);
    }

    /**
     * SolarObject constructor for asteroids
     * @param  x        start position
     * @param  y        start position in terms of rotation
     * @param  diameter size of the asteroid
     * @param  col           object color
     * @param  name          object name
     * @param  astLocation   Location for the asteroid
     * @return               No returns
    */
     public SolarObject(double x, double y, double diameter, String col, String name, int astLocation){
        this.pDistanceFromSun = x;
        this.pOrbitAngle = y;
        this.size = diameter;
        this.color = col;
        this.pName = name;
        this.astStartLocation = astLocation;

        setSpeed(pName);
    }
    /**
     * Draw sun onto the universe, which is parameter chosen when passed, must be SolarSystem Object
     * @param universe SolarSystem object
     */
    public void drawSun(SolarSystem universe){
    	universe.drawSolarObject(0,0,size,color);
    }

    /**
     * Call function in universe and draw planet object to universe
     * @param universe SolarSystem object
     */
    public void planetMove(SolarSystem universe){
        universe.drawSolarObject(pDistanceFromSun,pOrbitAngle+=pSpeed,size,color);
    }
    /**
     * Call function in universe and draw moon object to universe
     * @param universe SolarSystem object
     */
    public void moonMove(SolarSystem universe, SolarObject planet, int dist){
        double orbitDistance = planet.getLocation();
        double orbitAngle = planet.getAngle();

        universe.drawSolarObjectAbout(orbitDistance, orbitAngle, size, color, dist, pOrbitAngle+=mSpeed);
    }

    /**
     * Call function in universe and draw asteroid object to universe
     * @param universe SolarSystem object
     */
    public void astMove(SolarSystem universe, SolarObject planet){
        double orbitDistance = planet.getLocation();
        double orbitAngle = planet.getAngle();

        universe.drawSolarObjectAbout(orbitDistance, orbitAngle, size, color, astStartLocation, pOrbitAngle+=mSpeed);
    }

    /**
     * Returns object location
     * @return  
     */
    public double getLocation(){
        return pDistanceFromSun;
    }

    /**
     * Returns Angle
     * @return 
     */
    public double getAngle(){
        return pOrbitAngle;
    }

    /**
     * Sets Speed
     * @param name [description]
     */
    private void setSpeed(String name){
        if (pName == "mercury") {
            pSpeed = 4;
        }

        if (pName == "venus") {
            pSpeed = 2;
        }

        if (pName == "earth") {
            pSpeed = 1;
        }

        if (pName == "mars") {
            pSpeed = 0.5;
        }

        if (pName == "jupiter") {
            pSpeed = 0.25;
        }

        if (pName == "earthMoon") {
            mSpeed = 8;
        }



        if (pName == "juptMoon" || pName == "astBelt" || pName=="marsMoon") {
            Random rand = new Random();
            int  randSpeed = rand.nextInt(5) + 1;
        	mSpeed = randSpeed;
        }
    }
}
