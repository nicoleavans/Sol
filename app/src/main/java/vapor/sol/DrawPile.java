package vapor.solitaire;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class contains the infrastructure for the draw pile.
 *
 */

 public class DrawPile{
	Queue<Card> q;
   /*
    * Constructor
    */
   public DrawPile(){
     q = new LinkedList<Card>();
   }
   /*
    * This method allows the user to flip through the draw pile.
    * This is for one card draw.
    */
   public void turnCard(){
     Card c = q.remove();
     q.add(c);
   }
   /*
    * This method allows the user to flip through the draw pile.
    * This is for three card draw.
    */
   public void turnCard3(){
     Card c1 = q.remove();
     Card c2 = q.remove();
     Card c3 = q.remove();
     q.add(c1);
     q.add(c2);
     q.add(c3);
   }
 }
