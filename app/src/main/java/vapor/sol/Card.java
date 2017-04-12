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
    //this adds in symbols to aid the toString()
    String toSymbol(){
        String temp = this.getSuit();
        String r;
        if(temp == "spades"){
            r = "♠";
        }
        else if(temp == "diamonds"){
            r = "♦";
        }
        else if(temp == "hearts"){
            r = "♥";
        }
        else{
            r = "♣";
        }
        return r;
    }
    //edited to string
    public String toString(){
        int v = this.value;
        String val;
        String s;
        if(v > 10){
            if(v == 11){
                val = "J";
            }
            else if(v == 12){
                val = "Q";
            }
            else{
                val = "K";
            }
            s = " " + val + " " + this.toSymbol();
        }
        else if(v == 1){
            s = " A " + this.toSymbol();
        }
        else{
            s = " " + this.value + " " + this.toSymbol();
        }
        return s;
    }
}
