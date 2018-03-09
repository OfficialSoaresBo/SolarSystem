/**
 * This program will create a system and draw planets using the SolarSytem Class
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * This is the main class that initialize all the other classes and create an instance of the "SolarSystem" class
 *
 */
public class MilkyWay {

    /**
     * Main program, will create my instances and initialize them
     * @param args Nor arguments being passed
     */
    public static void main(String[] args) {

        /**
         * Creating my variables
         */
		int planetNum = 5;
		int moonNum = 3;
		int juptMooNum = 100;
        int astBeltNum = 200;

        //Creates milikiway object and initialises it
		SolarSystem milkyWay = new SolarSystem(1000,1000);
		milkyWay.setResizable(false);


        /**
         * Creating Sun object and passing arguments
         * @param  0        Location
         * @param  0        Rotation in regards to the lcation
         * @param  100      Size of the object
         * @param  "YELLOW" Color
         * @param  "sun"    Name of Object
         * @return          No return
         */
		Sun sun  = new Sun(0,0,100,"YELLOW","sun");

        /**
         * Creates my planet array and creates planets objects and adds them to the array
         */
		Planet planets[] = new Planet[planetNum];
    	for (int i = 0; i<planetNum; i++ ) {
    		if (i == 0) {
    			Planet mercury  = new Planet(100,0,5,"RED","mercury");
    			planets[i] = mercury;
    		}

    		if (i == 1) {
    			Planet venus  = new Planet(150,0,30,"ORANGE","venus");
    			planets[i] = venus;
    		}

    		if (i == 2) {
    			Planet earth  = new Planet(200,0,20,"BLUE","earth");
    			planets[i] = earth;
    		}

    		if (i == 3) {
    			Planet mars  = new Planet(250,0,50,"GREY","mars");
    			planets[i] = mars;
    		}

    		if (i == 4) {
    			Planet jupiter  = new Planet(450,0,100,"WHITE","jupiter");
    			planets[i] = jupiter;
    		}
    	}

        /**
         * Creates my moon array and my moon objects and adds them to the moon array
         */
    	Moon moons[] = new Moon[moonNum];
    	for (int j = 0; j<moonNum;j++) {
    		if ( j == 0) {
    			Moon earthMoon = new Moon(0,0,10,"GREY","earthMoon");
    			moons[j] = earthMoon;
    		}

    		if ( j == 1 ) {
    			Moon marsMoon = new Moon(0,0,10,"WHITE","marsMoon");
    			moons[j] = marsMoon;
    		}

            if ( j == 2 ) {
                Random rand = new Random();
                int  randPos = rand.nextInt(360) + 0;
                Moon marsMoon = new Moon(0,randPos,10,"WHITE","marsMoon");
                moons[j] = marsMoon;
            }
    	}

        /**
         * Creates the Jupiter Moons using an asteroid class because of their behaviour
         */
    	Asteroid juptMoons[] = new Asteroid[juptMooNum];
    	for (int z=0; z<juptMooNum; z++ ) {
    		//Creates and assigns random number to r variable
			Random rand = new Random();
			int  randLoc = rand.nextInt(30) + 60;
            int  randPos = rand.nextInt(360) + 0;

    		Asteroid juptMoon = new Asteroid(0,randPos,10,"GREY","juptMoon", randLoc);
    		juptMoons[z] = juptMoon;
    	}

        /**
         * Creates an asteroid belt
         */
        Asteroid astBelt[] = new Asteroid[astBeltNum];
        for (int y=0; y<astBeltNum;y++) {
            Random rand = new Random();
            int  n = rand.nextInt(50) + 300;

            Asteroid ast = new Asteroid(0,n*n,10,"GREY","astBelt", n);
            astBelt[y] = ast;
        }
    	
        /**
         * Draw all my objects onto the screen
         */
    	while(true)
    	{	
            sun.drawSun(milkyWay);
    		for (int i =0; i<juptMoons.length;i++) {
				juptMoons[i].astMove(milkyWay, planets[4]);
			}

            for (int j=0; j<planets.length;j++) {
                planets[j].planetMove(milkyWay);
                
            }

            for (int a=0; a<astBelt.length;a++) {
                astBelt[a].astMove(milkyWay, sun);
                
            }

            for (int h=0; h<moons.length;h++) {
                
            }

			moons[0].moonMove(milkyWay, planets[2], 20);
			moons[1].moonMove(milkyWay, planets[3], 40);
            moons[2].moonMove(milkyWay, planets[3], 50);

			milkyWay.finishedDrawing();
    	}

    }
}
