package vapor.sol;
//TODO implement something besides bufferedimage since android doesn't support it
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;

//import javax.imageio.ImageIO;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

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
    Bitmap getFace(){return face;}
    Bitmap getBack(){return back;}
    Bitmap getVisibleSide(){return visibleSide;}
    public void setFace(Bitmap b){face = b;}
    public void setBack(Bitmap b){back = b;}
    public void setVisibleSide(Bitmap b){visibleSide = b;}
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
}
