package vapor.sol;
/**
 * This class stores necessary information about cards. Possibly we could phase out color in favor of suit and
 * just add a bit where it checks the suit to determine color? unsure how relevant it really is
 */

 class Card {
    //initial variables
    private String suit;
    private String color;
    private int value;
    private String imgadr;
    private boolean up;
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
         up = false;
    }
    /*
     * Getters and setters.
     */
    String getSuit(){
        return suit;
    }
    String getColor(){
        return color;
    }
    int getValue(){
        return value;
    }
    String getImgadr(){
        return imgadr;
    }
    void setImgadr(String s){
        imgadr = s;
    }
    boolean getUp(){
        return up;
    }
    void turnUp(){
        up = true;
    }
}
