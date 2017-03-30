package vapor.sol;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This method builds a 52 card deck.
 */

class Deck {
    ArrayList<Card> pile;
    final String clubs;
    final String diamonds;
    final String spades;
    final String hearts;

    /*
     * Constructor
     */
     Deck() {
         clubs = "clubs";
         diamonds = "diamonds";
         spades = "spades";
         hearts = "hearts";
         pile = new ArrayList<>();

        //4 suits, 4 loops
        for (int i = 4; i > 0; i--) {
            //clubs
            //ints go up to thirteen to cover number and face cards
            if(i == 4){
                for (int j = 1; j <= 13; j++) {
                    Card c = new Card(clubs, "black", j);
                    //these values correspond to the address of their face image
                    if(j == 1){
                        c.setImgadr("cluba");
                    }
                    else if(j == 2){
                        c.setImgadr("club2");
                    }
                    else if(j == 3){
                        c.setImgadr("club3");
                    }
                    else if(j == 4){
                        c.setImgadr("club4");
                    }
                    else if(j == 5){
                        c.setImgadr("club5");
                    }
                    else if(j == 6){
                        c.setImgadr("club6");
                    }
                    else if(j == 7){
                        c.setImgadr("club7");
                    }
                    else if(j == 8){
                        c.setImgadr("club8");
                    }
                    else if(j == 9){
                        c.setImgadr("club9");
                    }
                    else if(j == 10){
                        c.setImgadr("club10");
                    }
                    else if(j == 11){
                        c.setImgadr("clubj");
                    }
                    else if(j == 12){
                        c.setImgadr("clubq");
                    }
                    else{
                        c.setImgadr("clubk");
                    }
                    pile.add(c);
                }
            }
            else if (i == 3) {
                for (int j = 1; j <= 13; j++) {
                    Card c = new Card(spades, "black", j);
                    if(j == 1){
                        c.setImgadr("spadea");
                    }
                    else if(j == 2){
                        c.setImgadr("spade2");
                    }
                    else if(j == 3){
                        c.setImgadr("spade3");
                    }
                    else if(j == 4){
                        c.setImgadr("spade4");
                    }
                    else if(j == 5){
                        c.setImgadr("spade5");
                    }
                    else if(j == 6){
                        c.setImgadr("spade6");
                    }
                    else if(j == 7){
                        c.setImgadr("spade7");
                    }
                    else if(j == 8){
                        c.setImgadr("spade8");
                    }
                    else if(j == 9){
                        c.setImgadr("spade9");
                    }
                    else if(j == 10){
                        c.setImgadr("spade10");
                    }
                    else if(j == 11){
                        c.setImgadr("spadej");
                    }
                    else if(j == 12){
                        c.setImgadr("spadeq");
                    }
                    else{
                        c.setImgadr("spadek");
                    }
                    pile.add(c);
                }
            }
            //hearts
            else if (i == 2) {
                for (int j = 1; j <= 13; j++) {
                    Card c = new Card(hearts, "red", j);
                    if(j == 1){
                        c.setImgadr("hearta");
                    }
                    else if(j == 2){
                        c.setImgadr("heart2");
                    }
                    else if(j == 3){
                        c.setImgadr("heart3");
                    }
                    else if(j == 4){
                        c.setImgadr("heart4");
                    }
                    else if(j == 5){
                        c.setImgadr("heart5");
                    }
                    else if(j == 6){
                        c.setImgadr("heart6");
                    }
                    else if(j == 7){
                        c.setImgadr("heart7");
                    }
                    else if(j == 8){
                        c.setImgadr("heart8");
                    }
                    else if(j == 9){
                        c.setImgadr("heart9");
                    }
                    else if(j == 10){
                        c.setImgadr("heart10");
                    }
                    else if(j == 11){
                        c.setImgadr("heartj");
                    }
                    else if(j == 12){
                        c.setImgadr("heartq");
                    }
                    else{
                        c.setImgadr("heartk");
                    }
                    pile.add(c);
                }
            }
            //diamonds
            else if(i == 1){
                for(int j = 1; j <= 13; j++){
                    Card c = new Card(diamonds, "red", j);
                    if(j == 1){
                        c.setImgadr("diamonda");
                    }
                    else if(j == 2){
                        c.setImgadr("diamond2");
                    }
                    else if(j == 3){
                        c.setImgadr("diamond3");
                    }
                    else if(j == 4){
                        c.setImgadr("diamond4");
                    }
                    else if(j == 5){
                        c.setImgadr("diamond5");
                    }
                    else if(j == 6){
                        c.setImgadr("diamond6");
                    }
                    else if(j == 7){
                        c.setImgadr("diamond7");
                    }
                    else if(j == 8){
                        c.setImgadr("diamond8");
                    }
                    else if(j == 9){
                        c.setImgadr("diamond9");
                    }
                    else if(j == 10){
                        c.setImgadr("diamond10");
                    }
                    else if(j == 11){
                        c.setImgadr("diamondj");
                    }
                    else if(j == 12){
                        c.setImgadr("diamondq");
                    }
                    else{
                        c.setImgadr("diamondk");
                    }
                    pile.add(c);
                }
            }
        }
        //shuffles the deck after making it
        Collections.shuffle(pile);

    }
}
