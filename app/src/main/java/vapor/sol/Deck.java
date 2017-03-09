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
    public Deck(){
        String backAdr = "";
        Random ran = new Random();
        //TODO handle how the back is chosen this is temp
        //TODO implement different image handling
        //for now the back is chosen pseudorandomly
        int s = ran.nextInt(5);
        if(s == 0){
          //backAdr = "cb1.png";
        }
        else if(s == 1){
          //backAdr = "cb2.png";
        }
        else if(s == 2){
          //backAdr = "cb3.png";
        }
        else if(s == 3){
          //backAdr = "cb4.png";
        }
        else if(s == 4){
          //backAdr = "cb5.png";
        }
        else if(s == 5){
          //backAdr = "cb6.png";
        }
        pile = new ArrayList<Card>();
        //4 suits, 4 loops
        for(int i = 4; i > 0; i--){
          //clubs
          if(i == 4){
            //ints go up to thirteen to cover number and face cards
            for(int j = 1; j <= 13; j++){
              Card c = new Card("clubs", "black", j);
              //this handles assigning the images to the cards
              /*
              if(j == 1){
                c.setFace("cluba.png");
                c.setBack(backAdr);
              }
              else if(j == 2){
                c.setFace("club2.png");
                c.setBack(backAdr);
              }
              else if(j == 3){
                c.setFace("club3.png");
                c.setBack(backAdr);
              }
              else if(j == 4){
                c.setFace("club4.png");
                c.setBack(backAdr);
              }
              else if(j == 5){
                c.setFace("club5.png");
                c.setBack(backAdr);
              }
              else if(j == 6){
                c.setFace("club6.png");
                c.setBack(backAdr);
              }
              else if(j == 7){
                c.setFace("club7.png");
                c.setBack(backAdr);
              }
              else if(j == 8){
                c.setFace("club8.png");
                c.setBack(backAdr);
              }
              else if(j == 9){
                c.setFace("club9.png");
                c.setBack(backAdr);
              }
              else if(j == 10){
                c.setFace("club10.png");
                c.setBack(backAdr);
              }
              else if(j == 11){
                c.setFace("clubj.png");
                c.setBack(backAdr);
              }
              else if(j == 12){
                c.setFace("clubq.png");
                c.setBack(backAdr);
              }
              else if(j == 13){
                c.setFace("clubk.png");
                c.setBack(backAdr);
								//debug
                //System.out.println("Expected color suit value "
                //+ c.getColor() + " " + c.getSuit() + " " + c.getValue());
              }
              */
              pile.add(c);
            }
          }
          //spades
          else if(i == 3){
            for(int j = 1; j <= 13; j++){
              Card c = new Card("spades", "black", j);
              /*
              if(j == 1){
                c.setFace("spadea.png");
                c.setBack(backAdr);
              }
              else if(j == 2){
                c.setFace("spade2.png");
                c.setBack(backAdr);
              }
              else if(j == 3){
                c.setFace("spade3.png");
                c.setBack(backAdr);
              }
              else if(j == 4){
                c.setFace("spade4.png");
                c.setBack(backAdr);
              }
              else if(j == 5){
                c.setFace("spade5.png");
                c.setBack(backAdr);
              }
              else if(j == 6){
                c.setFace("spade6.png");
                c.setBack(backAdr);
              }
              else if(j == 7){
                c.setFace("spade7.png");
                c.setBack(backAdr);
              }
              else if(j == 8){
                c.setFace("spade8.png");
                c.setBack(backAdr);
              }
              else if(j == 9){
                c.setFace("spade9.png");
                c.setBack(backAdr);
              }
              else if(j == 10){
                c.setFace("spade10.png");
                c.setBack(backAdr);
              }
              else if(j == 11){
                c.setFace("spadej.png");
                c.setBack(backAdr);
              }
              else if(j == 12){
                c.setFace("spadeq.png");
                c.setBack(backAdr);
              }
              else if(j == 13){
                c.setFace("spadek.png");
                c.setBack(backAdr);
              }
              */
              pile.add(c);
            }
          }
          //hearts
          else if(i == 2){
            for(int j = 1; j <= 13; j++){
              Card c = new Card("hearts", "red", j);
              /*
              if(j == 1){
                c.setFace("hearta.png");
                c.setBack(backAdr);
              }
              else if(j == 2){
                c.setFace("heart2.png");
                c.setBack(backAdr);
              }
              else if(j == 3){
                c.setFace("heart3.png");
                c.setBack(backAdr);
              }
              else if(j == 4){
                c.setFace("heart4.png");
                c.setBack(backAdr);
              }
              else if(j == 5){
                c.setFace("heart5.png");
                c.setBack(backAdr);
              }
              else if(j == 6){
                c.setFace("heart6.png");
                c.setBack(backAdr);
								//debug
                //System.out.println("Expected color suit value "
                //+ c.getColor() + " " + c.getSuit() + " " + c.getValue());
              }
              else if(j == 7){
                c.setFace("heart7.png");
                c.setBack(backAdr);
              }
              else if(j == 8){
                c.setFace("heart8.png");
                c.setBack(backAdr);
              }
              else if(j == 9){
                c.setFace("heart9.png");
                c.setBack(backAdr);
              }
              else if(j == 10){
                c.setFace("heart10.png");
                c.setBack(backAdr);
              }
              else if(j == 11){
                c.setFace("heartj.png");
                c.setBack(backAdr);
              }
              else if(j == 12){
                c.setFace("heartq.png");
                c.setBack(backAdr);
              }
              else if(j == 13){
                c.setFace("heartk.png");
                c.setBack(backAdr);
              }
              */
              pile.add(c);
            }
          }
          //diamonds
          else if(i == 1){
            for(int j = 1; j <= 13; j++){
              Card c = new Card("diamonds", "red", j);
              /*
              if(j == 1){
                c.setFace("diamonda.png");
                c.setBack(backAdr);
              }
              else if(j == 2){
                c.setFace("diamond2.png");
                c.setBack(backAdr);
              }
              else if(j == 3){
                c.setFace("diamond3.png");
                c.setBack(backAdr);
              }
              else if(j == 4){
                c.setFace("diamond4.png");
                c.setBack(backAdr);
              }
              else if(j == 5){
                c.setFace("diamond5.png");
                c.setBack(backAdr);
              }
              else if(j == 6){
                c.setFace("diamond6.png");
                c.setBack(backAdr);
              }
              else if(j == 7){
                c.setFace("diamond7.png");
                c.setBack(backAdr);
								//debug
                //System.out.println("Expected color suit value "
                //+ c.getColor() + " " + c.getSuit() + " " + c.getValue());
              }
              else if(j == 8){
                c.setFace("diamond8.png");
                c.setBack(backAdr);
              }
              else if(j == 9){
                c.setFace("diamond9.png");
                c.setBack(backAdr);
              }
              else if(j == 10){
                c.setFace("diamond10.png");
                c.setBack(backAdr);
              }
              else if(j == 11){
                c.setFace("diamondj.png");
                c.setBack(backAdr);
              }
              else if(j == 12){
                c.setFace("diamondq.png");
                c.setBack(backAdr);
              }
              else if(j == 13){
                c.setFace("diamondk.png");
                c.setBack(backAdr);
              }
              */
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
