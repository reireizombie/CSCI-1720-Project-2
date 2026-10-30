import edu.cymbal.graphics.CanvasAPI;
import edu.cymbal.graphics.Graphics;
import edu.cymbal.graphics.PainterAPI;
import java.awt.Color;
import java.util.random.*;


public class Aquarium {
   
    private static CanvasAPI canvas;
    private static PainterAPI painter;

    // varibles that will (most likely) be used in mulitple methods, including the main loop
    public String state;
    public int guySize;
    public Color guyColor;
    public  int decoAmount;
    

    public static String randomHandler(){
        // generates a random number that will be used to decide what the guy will do.
        // then uses said random number to set his state
        
       return null;
    }

    /*
    * @param ammount, allows the changeing of how many decoration items will be made
    */
    public static void makeDeco(int amount){
        // makes deco and the floor
        // not much to say here
    }   

    /* 
    * @param color, gives the guy his color
    * @param size, gives the guy his size
    */
    public static void setGuy(Color color, int size){
        // creates a new guy
        // will most likely will be placed in a while loop for "animation" purposes
        // will also use randomHandler often for states and whatever
    }

    public static void killScreen(){
        // simply clears the screen and calls the methods that creates the guy and floor/deco
        // will be called often for "animation" purposes
     }

    public static void randomEventShootingStar(){
        // a line on top of the screen shots by
        // will change guy's state to look up
    }

    public static void randomEventNothingIsWatching(){
        // rare event where nothing watches :)
    }

    public static void main(String[] args) {
        Color favColor = new Color(91, 99, 255);
        
        CanvasAPI canvas = Graphics.createCanvas(800, 800, "guy");
        PainterAPI painter = canvas.getPainter();
 
        painter.setSpeed(0); // needed to be 0 for "animation" purposes
    }
}