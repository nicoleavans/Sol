package vapor.sol;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This method builds a 52 card deck.
 */

public class Deck {
	ArrayList<Card> pile;
    /*
     * Constructor
     */
    public Deck() {
        final String clubs = "clubs";
        final String diamonds = "diamonds";
        final String spades = "spades";
        final String hearts = "hearts";
        String backAdr = "";
        Random ran = new Random();
        //TODO handle how the back is chosen this is temp
        //TODO implement different image handling
        //for now the back is chosen pseudorandomly
        int s = ran.nextInt(5);
        if (s == 0) {
            backAdr = "cb1.png";
        } else if (s == 1) {
            backAdr = "cb2.png";
        } else if (s == 2) {
            backAdr = "cb3.png";
        } else if (s == 3) {
            backAdr = "cb4.png";
        } else if (s == 4) {
            backAdr = "cb5.png";
        } else {
            backAdr = "cb6.png";
        }
        pile = new ArrayList<Card>();
        //4 suits, 4 loops
        for (int i = 4; i > 0; i--) {
            //clubs
            if (i == 4) {
                //ints go up to thirteen to cover number and face cards
                for (int j = 1; j <= 13; j++) {
                    Card c = new Card(clubs, "black", j);
                    //this handles assigning the images to the cards
                    if (j == 1) {
                        c.face.createFromPath("cluba.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 2) {
                        c.face.createFromPath("club2.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 3) {
                        c.face.createFromPath("club3.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 4) {
                        c.face.createFromPath("club4.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 5) {
                        c.face.createFromPath("club5.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 6) {
                        c.face.createFromPath("club6.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 7) {
                        c.face.createFromPath("club7.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 8) {
                        c.face.createFromPath("club8.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 9) {
                        c.face.createFromPath("club9.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 10) {
                        c.face.createFromPath("club10.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 11) {
                        c.face.createFromPath("clubj.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 12) {
                        c.face.createFromPath("clubq.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 13) {
                        c.face.createFromPath("clubk.png");
                        c.back.createFromPath(backAdr);
                        //debug
                        //System.out.println("Expected color suit value "
                        //+ c.getColor() + " " + c.getSuit() + " " + c.getValue());
                        pile.add(c);
                    }
                }
            }
            //spades
            else if (i == 3) {
                for (int j = 1; j <= 13; j++) {
                    Card c = new Card(spades, "black", j);

                    if (j == 1) {
                        c.face.createFromPath("spadea.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 2) {
                        c.face.createFromPath("spade2.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 3) {
                        c.face.createFromPath("spade3.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 4) {
                        c.face.createFromPath("spade4.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 5) {
                        c.face.createFromPath("spade5.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 6) {
                        c.face.createFromPath("spade6.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 7) {
                        c.face.createFromPath("spade7.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 8) {
                        c.face.createFromPath("spade8.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 9) {
                        c.face.createFromPath("spade9.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 10) {
                        c.face.createFromPath("spade10.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 11) {
                        c.face.createFromPath("spadej.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 12) {
                        c.face.createFromPath("spadeq.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 13) {
                        c.face.createFromPath("spadek.png");
                        c.back.createFromPath(backAdr);
                    }
                    pile.add(c);
                }
            }
            //hearts
            else if (i == 2) {
                for (int j = 1; j <= 13; j++) {
                    Card c = new Card(hearts, "red", j);
                    if (j == 1) {
                        c.face.createFromPath("hearta.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 2) {
                        c.face.createFromPath("heart2.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 3) {
                        c.face.createFromPath("heart3.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 4) {
                        c.face.createFromPath("heart4.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 5) {
                        c.face.createFromPath("heart5.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 6) {
                        c.face.createFromPath("heart6.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 7) {
                        c.face.createFromPath("heart7.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 8) {
                        c.face.createFromPath("heart8.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 9) {
                        c.face.createFromPath("heart9.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 10) {
                        c.face.createFromPath("heart10.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 11) {
                        c.face.createFromPath("heartj.png");
                        c.back.createFromPath(backAdr);
                    } else if (j == 12) {
                        c.face.createFromPath("heartq.png");
                        c.back.createFromPath(backAdr);
                    }
                    c.face.createFromPath("heartk.png");
                    c.back.createFromPath(backAdr);

                    pile.add(c);
                }
            }
          //diamonds
          else if(i == 1){
            for(int j = 1; j <= 13; j++){
              Card c = new Card(diamonds, "red", j);
              if(j == 1){
                  c.face.createFromPath("diamonda.png");
                  c.back.createFromPath(backAdr);
              }
              else if(j == 2){
                  c.face.createFromPath("diamond2.png");
                  c.back.createFromPath(backAdr);
              }
              else if(j == 3){
                  c.face.createFromPath("diamond3.png");
                  c.back.createFromPath(backAdr);
              }
              else if(j == 4){
                  c.face.createFromPath("diamond4.png");
                  c.back.createFromPath(backAdr);
              }
              else if(j == 5){
                  c.face.createFromPath("diamond5.png");
                  c.back.createFromPath(backAdr);
              }
              else if(j == 6){
                  c.face.createFromPath("diamond6.png");
                  c.back.createFromPath(backAdr);
              }
              else if(j == 7){
                  c.face.createFromPath("diamond7.png");
                  c.back.createFromPath(backAdr);
              }
              else if(j == 8){
                  c.face.createFromPath("diamond8.png");
                  c.back.createFromPath(backAdr);
              }
              else if(j == 9){
                  c.face.createFromPath("diamond9.png");
                  c.back.createFromPath(backAdr);
              }
              else if(j == 10){
                  c.face.createFromPath("diamond10.png");
                  c.back.createFromPath(backAdr);
              }
              else if(j == 11){
                  c.face.createFromPath("diamondj.png");
                  c.back.createFromPath(backAdr);
              }
              else if(j == 12){
                  c.face.createFromPath("diamondq.png");
                  c.back.createFromPath(backAdr);
              }
              else if(j == 13){
                  c.face.createFromPath("diamondk.png");
                  c.back.createFromPath(backAdr);
              }
              pile.add(c);
            }
          }
        }
        //should theoretically shuffle the deck after making it
        Collections.shuffle(pile);
        //debug
        //System.out.println(pile);
    }
}
