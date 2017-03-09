package vapor.sol;
//TODO implement something besides bufferedimage since android doesn't support it
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;

//import javax.imageio.ImageIO;

/**
 * This class stores necessary information about cards. Possibly we could phase out color in favor of suit and
 * just add a bit where it checks the suit to determine color? unsure how relevant it really is
 */

public class Card {
    //initial variables
    String suit;
    String color;
    int value;
    boolean faceUp;
    //BufferedImage face;
    //BufferedImage back;
    //BufferedImage visibleSide;
    /*
     * Constructor
     * @param s  suit
     * @param c  color
     * @param v  value
     */
    public Card(String s, String c, int v){
        suit = s;
        color = c;
        value = v;
        //face = null;
        //back = null;
        //visible will default to the back side
        faceUp = false;
        //visibleSide = back;
        //debug
        //System.out.println("Expected: suit, color, value" + suit + color + value);
    }
    /*
     * Getters and setters.
     */
    public String getSuit(){
        return suit;
    }
    public void setSuit(String s){
        suit = s;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String s){
        color = s;
    }
    public int getValue(){
        return value;
    }
    public void setValue(int v){
        value = v;
    }

    /*
     * These methods handle setting the images for the cards.

    public void setFace(String adr){
      //used almost exactly as it is in the documentation
      //https://docs.oracle.com/javase/tutorial/2d/images/loadimage.html
      try{
        this.face = ImageIO.read(new File(adr));
      } catch (IOException e) {}
    }
    public void setBack(String adr){
      try{
        this.back = ImageIO.read(new File(adr));
      } catch (IOException e){}
    }
    */
    /*
     * This method alternates a value saved as visible side between
     * the images for the front and back, to be used for UI support.

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
    */
}
