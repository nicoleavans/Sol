package vapor.sol;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This method builds a 52 card deck.
 */

class Deck {
	ArrayList<Card> pile;
    /*
     * Constructor
     */
     Deck() {
        final String clubs = "clubs";
        final String diamonds = "diamonds";
        final String spades = "spades";
        final String hearts = "hearts";

        //4 suits, 4 loops
        for (int i = 4; i > 0; i--) {
            //clubs
            //ints go up to thirteen to cover number and face cards
            if(i == 4){
                for (int j = 1; j <= 13; j++) {
                    Card c = new Card(clubs, "black", j);
                    pile.add(c);
                }
            }
            else if (i == 3) {
                for (int j = 1; j <= 13; j++) {
                    Card c = new Card(spades, "black", j);
                    pile.add(c);
                }
            }
            //hearts
            else if (i == 2) {
                for (int j = 1; j <= 13; j++) {
                    Card c = new Card(hearts, "red", j);
                    pile.add(c);
                }
            }
            //diamonds
            else if(i == 1){
                for(int j = 1; j <= 13; j++){
                    Card c = new Card(diamonds, "red", j);
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
