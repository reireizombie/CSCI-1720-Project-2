// reilly "pookster, the" quinn
// COMP SCI YEAAAAAAAHH!!!!
// PROJECT 2 YEAAAAAAAHHHHHH!!!!!!!!!!

// hello tech fellows/Brian
// i hope you enjoy my project
// i am so tired and happy to be done with this
// this project was a nightmare to put togther, but yeah, it was fun :)

// i am fully aware that this does not meet the project requirements, i relized while i was working on it that what i was trying to do clashed with them
// i was also unsure if i would be allowed to change what i was going to do AFTER the check in, especially as late as i relized
// so yeah im sorry and i guess my grade will suffer, but i did this to myself so whatever

// im so, so tired

import edu.cymbal.graphics.CanvasAPI;
import edu.cymbal.graphics.Graphics;
import edu.cymbal.graphics.PainterAPI;
import java.awt.Color;
import java.util.Random;

public class Aquarium {
   
    public static CanvasAPI canvas;
    public static PainterAPI painter;
    

    // public int guySize;
    public static Color guyColor;


    public static String randomHandler() throws InterruptedException{
        // generates a random number that will be used to decide what the guy will do.
        // then uses said random number to set his state
        
        String state = "";

        Random random = new Random();
        int min = 0;
        int max = 7;

        int randomStateNumber = random.nextInt(max - min + 1) + min;
        
        if (randomStateNumber == 0){
            state = "standing";
        } else if (randomStateNumber == 1){
            state = "lookingLeft";
        } else if (randomStateNumber == 2){
            state = "lookingRight";
        } else if (randomStateNumber == 3){
            state = "blink";
        } else if (randomStateNumber == 4){
            state = "winking";
        } else if (randomStateNumber == 5){
            state = "realStare";
        } else if (randomStateNumber == 6){
            int subMin = 0;
            int subMax = 50;
            int subRandomNum = random.nextInt(subMax - subMin + 1) + subMin;
            if (subRandomNum == 30){
                state = "NOTHINGISHERE";
            } else {
                state = "standing";
            }
        }
 
        System.out.println(state);

        return state;
    }

    public static void decoRedMass(PainterAPI painter){
        // creates a red mass of... somethin'
        // very cool!

        painter.liftPen();
        painter.moveTo(-300, -200);
        painter.lowerPen();

        painter.startFill(Color.RED);
        for (int i = 0; i < 25; i++){
            painter.forward(10);
            if ((i % 3) == 0){
                painter.turnLeft(45);
            } else {
                painter.turnRight(45);
            }
        }
        painter.turnRight(45);
        painter.finishFill();
    }

    public static void decoLittleDude(PainterAPI painter, Color color) throws InterruptedException{
        // makes a mini static guy with some wonderful, wonderful color
        painter.lowerPen();
            
        Color favColor = new Color(91, 99, 255);
        painter.liftPen();
        painter.moveTo(220, -230);
        painter.lowerPen();
        
        painter.startFill(favColor);
        
        // main body
        for (int i = 0; i < 4; i++){

            if ((i % 2) == 0){
                painter.forward(40);
                painter.turnLeft(90);
            } else {
                painter.forward(70);
                if (i != 3){
                    painter.turnLeft(90);
                }
            }
        }
        
        // legs
        painter.finishFill();
        painter.forward(30);
        painter.liftPen();
        painter.moveTo(260, -230);
        painter.lowerPen();
        painter.forward(30);

        // eyes
        painter.liftPen();
        painter.moveTo(230, -180);
        painter.lowerPen();
        painter.circle(1);

        painter.liftPen();
        painter.moveTo(247, -180);
        painter.lowerPen();
        painter.circle(1);

        // mouth
        painter.liftPen();
        painter.moveTo(242, -190);
        painter.lowerPen();
        painter.turnRight(90);
        painter.forward(6);
    }

    /* 
    * this is here to fix a bug. this whole project has been horid to make
    * the bug was that when Thread.sleep was used in a method, it just like, didn't work
    * maybe i just did it weird, but i would rather have this anyways for more presise wait times
    * speaking of that:
    * @param int time - sets the time waited in milliseconds. 
    */
    public static void sleepTime(int time) throws InterruptedException{
        // this will be used so guy doesn't just jump from one thing to another with out waiting
        Thread.sleep(time);
    }

    public static void makeDeco(PainterAPI painter) throws InterruptedException{
        // calls decoRedMass and decoBlueLittleDude
        decoRedMass(painter);
        decoLittleDude(painter, Color.RED);
    }   

    /*
    * @param double y - sets the eyes and mouths location on the y axis
    * @param double x - sets the eyes and mouths location on the x axis
    */
    public static void guyFace(double y, double x, PainterAPI painter, String type){
        // draws the mouth and eyes according to the guys pos.
       
        if (type.equals("normal")){
            // eyes
            painter.liftPen();
            painter.moveTo((x - 90), (y - 40));
            painter.lowerPen();
            painter.startFill(Color.BLACK);
            painter.circle(5);
            painter.finishFill();
            
            x = painter.getX();
            y = painter.getY();

            painter.liftPen();
            painter.moveTo((x + 70), y);
            painter.lowerPen();
            painter.startFill(Color.BLACK);
            painter.circle(5);
            painter.finishFill();
            
            x = painter.getX();
            y = painter.getY();

            // MOUTH!!
            painter.liftPen();
            painter.moveTo(x, (y - 20));
            painter.lowerPen();
            painter.turnLeft(90);
            painter.forward(80);
        } else if (type.equals("blink")){
            // eyes
            painter.liftPen();
            painter.moveTo((x - 90), (y - 40));
            painter.turnLeft(90);
            painter.lowerPen();
            painter.forward(10);
            
            x = painter.getX();
            y = painter.getY();

            painter.liftPen();
            painter.moveTo((x + 70), y);
            painter.lowerPen();
            painter.forward(10);
            painter.turnRight(90);
            
            x = painter.getX();
            y = painter.getY();

            // MOUTH!!
            painter.liftPen();
            painter.moveTo((x + 20), (y - 20));
            painter.lowerPen();
            painter.turnLeft(90);
            painter.forward(80);
        } else if (type.equals("wink")){
            // eyes
            painter.liftPen();
            painter.moveTo((x - 90), (y - 40));
            painter.lowerPen();
            painter.startFill(Color.BLACK);
            painter.circle(5);
            painter.finishFill();
            
            x = painter.getX();
            y = painter.getY();

            painter.liftPen();
            painter.moveTo((x + 70), y);
            painter.lowerPen();
            painter.turnLeft(90);
            painter.forward(10);
            painter.turnRight(90);
            
            x = painter.getX();
            y = painter.getY();

            // MOUTH!!
            painter.liftPen();
            painter.moveTo((x + 10), (y - 20));
            painter.lowerPen();
            painter.turnLeft(90);
            painter.forward(80);
        } else if (type.equals("real")){
            // eyes
            painter.liftPen();
            painter.moveTo((x - 65), (y - 40));
            painter.lowerPen();
            painter.startFill(Color.BLACK);
            painter.circle(30);
            painter.finishFill();
            
            x = painter.getX();
            y = painter.getY();

            painter.liftPen();
            painter.moveTo((x + 70), y);
            painter.lowerPen();
            painter.startFill(Color.BLACK);
            painter.circle(30);
            painter.finishFill();
            
            x = painter.getX();
            y = painter.getY();

            // MOUTH!!
            painter.liftPen();
            painter.moveTo((x - 20), (y - 40));
            painter.lowerPen();
            painter.turnLeft(90);
            painter.forward(80);
        }
    }

    /*
    * @param double y - helps set the leg location on the y axis
    * @param double x - helps set the leg location on the x axis
    * @param int guySize - tracks guy's size for leg pos and size
    */
    public static void guyLegs(double y, double x, PainterAPI painter){
        // draws the little legs he has while standing, jumping, sitting, ect.

        painter.turnRight(180);
        painter.forward(280);

        painter.liftPen();
        painter.moveTo((x - 120), y);
        painter.lowerPen();
        painter.forward(280);

        painter.liftPen();
        painter.moveTo(x, y);
        painter.turnLeft(180);
    }

    /* 
    * @param Color color, gives the guy his color
    * @param double x - sets the guys x location so more then one can be placed
    * @param double y - sets the y location. whatever
    */
    public static void guyHandler(Color color, double x, double y, PainterAPI painter, CanvasAPI canvas) throws InterruptedException{
        // draws the guy
        // will most likely will be placed in a while loop for "animation" purposes
        // will also use randomHandler often for states and whatever
        
        // Calls guyFace and guyLegs to finish him, body handeled and drawn within this method
        painter.liftPen();
        painter.moveTo(x, 0);
        painter.lowerPen();

        painter.startFill(Color.WHITE);
        for (int i = 0; i < 4; i++){

            if ((i % 2) == 0){
                painter.forward(120);
                painter.turnLeft(90);
            } else {
                painter.forward(210);
                if (i != 3){
                    painter.turnLeft(90);
                }
            }
        }
        painter.finishFill();

        String state = randomHandler();
        boolean inState = false;

        // these state things are placed arbitrarily. they were written in the order that i just kinda felt like.
        if (state.equals("lookingLeft") && inState == false){
            inState = true;
            killScreen(painter);
            guyLegs(painter.getY(), painter.getX(), painter);
            guyFace(painter.getY(), (painter.getX() - 70), painter, "normal");
            sleepTime(2000);
            killScreen(painter);
            inState = false;

        } else if (state.equals("lookingRight") && inState == false) {
            inState = true;
            killScreen(painter);
            guyLegs(painter.getY(), painter.getX(), painter);
            guyFace(painter.getY(), (painter.getX() + 70), painter, "normal");
            sleepTime(2000);
            killScreen(painter);
            inState = false;

        } else if (state.equals("blink") && inState == false){
            inState = true;
            killScreen(painter);
            guyLegs(painter.getY(), painter.getX(), painter);
            guyFace((painter.getY()), (painter.getX()), painter, "blink");
            sleepTime(500);            
            killScreen(painter);
            inState = false;
        } else if (state.equals("winking") && inState == false){
            inState = true;
            killScreen(painter);
            guyLegs(painter.getY(), painter.getX(), painter);
            guyFace((painter.getY()), (painter.getX()), painter, "wink");
            sleepTime(2000);            
            killScreen(painter);
            inState = false;
        } else if (state.equals("standing") && inState == false){
            inState = true;
            killScreen(painter);
            guyLegs(painter.getY(), painter.getX(), painter);
            guyFace(painter.getY(), (painter.getX() - 70), painter, "normal");
            sleepTime(7000);
            killScreen(painter);
            inState = false;
        
        } else if (state.equals("realStare") && inState == false){
            inState = true;
            killScreen(painter);
            guyLegs(painter.getY(), painter.getX(), painter);
            guyFace((painter.getY()), (painter.getX()), painter, "real");
            sleepTime(5000);            
            killScreen(painter);
            inState = false;
        } else if (state.equals("NOTHINGISHERE")){
            randomEventNothingIsWatching(painter, canvas);
        }
    }


    public static void killScreen(PainterAPI painter) throws InterruptedException{
        // simply clears the screen and calls the methods that creates the guy and floor/deco
        // will be called often for "animation" purposes
        painter.reset();
        painter.setPenWidth(6);
        painter.setSpeed(0);
        makeDeco(painter);
        guyHandler(guyColor, 50, 0, painter, canvas);
     }


    public static void randomEventNothingIsWatching(PainterAPI painter, CanvasAPI canvas) throws InterruptedException{
        // rare event where nothing watches :)
    
        Random random = new Random();

        int subMin = 2;
        int subMax = 90;
        int subRandomNum = random.nextInt(subMax - subMin + 1) + subMin;


        painter.reset();
        painter.lowerPen();
        painter.setPenWidth(20);
        for (int i = 0; i < 99999; i++){
            subRandomNum = random.nextInt(subMax - subMin + 1) + subMin;
            painter.forward(90);
            painter.turnLeft(subRandomNum);
        }
        painter.setPenWidth(1);
        painter.startFill(Color.BLACK);
        painter.moveTo(1200, 800);
        painter.moveTo(-1200, -800);
        painter.liftPen();
        painter.moveTo(100, 0);
        painter.startFill(Color.RED);
        painter.lowerPen();
        painter.circle(50);
        painter.finishFill();

        painter.liftPen();
        painter.moveTo(-100, 0);
        painter.startFill(Color.RED);
        painter.lowerPen();
        painter.circle(50);
        painter.finishFill();

        sleepTime(10000);
        System.exit(0);
    }

    public static void main(String[] args) throws InterruptedException {
        Color favColor = new Color(91, 99, 255);
        
        CanvasAPI canvas = Graphics.createCanvas(1200, 800, "guy");
        PainterAPI painter = canvas.getPainter();
 
        painter.setPenWidth(6);
        painter.setSpeed(2); // needed to be 0 for "animation" purposes
        // painter.circle(100);
        // painter.clear();

        killScreen(painter);


    }
}