package vapor.sol;
//TODO implement something besides bufferedimage since android doesn't support it
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;

//import javax.imageio.ImageIO;


import android.graphics.Bitmap;

/**
 * This class stores necessary information about cards. Possibly we could phase out color in favor of suit and
 * just add a bit where it checks the suit to determine color? unsure how relevant it really is
 */

class Card {
    //initial variables
    private String suit;
    private String color;
    private int value;
    private boolean faceUp;
    private float cx;
    private float cy;
    static int width = 45;
    static int height = 64;
    Bitmap face;
    Bitmap back;
    Bitmap visibleSide;
    /*
     * Constructor
     * @param s  suit
     * @param c  color
     * @param v  value
     */
     Card(String s, String c, int v){
        suit = s;
        color = c;
        value = v;
        face = null;
        back = null;
        //visible will default to the back side
        faceUp = false;
        visibleSide = back;
        //debug
        //System.out.println("Expected: suit, color, value" + suit + color + value);
    }
    /*
     * Getters and setters.
     */
    String getSuit(){
        return suit;
    }
    public void setSuit(String s){
        suit = s;
    }
    String getColor(){
        return color;
    }
    public void setColor(String s){
        color = s;
    }
    int getValue(){
        return value;
    }
    public void setValue(int v){
        value = v;
    }
    public float getCx(){ return cx;}
    public void setCx(float x) {cx = x;}
    public float getCy() {return cy;}
    public void setCy(float y) {cy = y;}

    /*
     * This method alternates a value saved as visible side between
     * the images for the front and back, to be used for UI support.
     */
    public void flipCard(){
      if(faceUp){
        faceUp = false;
        visibleSide = back;
      }
      else{
        faceUp = true;
        visibleSide = face;
      }
    }
    /*
     * This method sets a cards position from a given x and y
     */
    public void setCard(float x, float y){
        cx = x;
        cy = y;
    }
    /*
     * This method moves a card's position a set
     * difference in x and y.
     */
    public void moveCard(float dx, float dy){
        cx -= dx;
        cy -= dy;
    }
}
