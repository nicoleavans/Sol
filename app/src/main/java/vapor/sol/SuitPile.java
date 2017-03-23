package vapor.sol;
import java.util.Stack;

/**
 * This class contains the methods and infrastructure for the four piles for collecting suits
 * to win.
 */

 public class SuitPile{
   //instance variables
   private String suit;
   Stack<Card> pile = new Stack<>();
   /*
    * Constructor
    * @param s	the suit of cards the pile will hold
    */
   public SuitPile(String s){
     suit = s;
   }
   /*
    * The upcoming methods handle movement, using a target pile
    * as the source for a card to move to the play pile the method is called on. 
    * This method handles a draw pile target.
    * @param d	the target draw pile
    */
   public void addCard(DrawPile d){
     Card c = d.q.peek();
     Card val;
     //checks if the suit is correct
     if(c.getSuit().equals(this.suit)){
       //if the pile is empty, it does not peek and simply takes an ace
       if(pile.empty() && c.getValue() == 1){
         pile.add(d.q.remove());
       }
       //elseif the pile does have cards, we peek
       else if(!pile.empty()){
         val = pile.peek();
         //if the current value on the pile is one less than the card to be added
         if(val.getValue() == c.getValue() + 1){
           pile.add(d.q.remove());
         }
       }
     }
   }
   /*
    * This method handles a play pile target.
    * @param p	target play pile
    */
   public void addCard(PlayPile p){
     Card c = p.pile.peek();
     Card val;
     //checks if the suit is correct
     if(c.getSuit().equals(this.suit)){
       //if the pile is empty, it does not peek and simply takes an ace
       if(pile.empty() && c.getValue() == 1){
         pile.add(p.pile.pop());
       }
       //elseif the pile does have cards, we peek
       else if(!pile.empty()){
         val = pile.peek();
         //if the current value on the pile is one less than the card to be added
         if(val.getValue() == c.getValue() + 1){
           pile.add(p.pile.pop());
         }
       }
     }
   }
   /*
    * This method handles a suit pile target.
    * @param s	target suit pile
    */
   public void addCard(SuitPile s){
     Card c = s.pile.peek();
     Card val;
     //checks if the suit is correct
     if(c.getSuit().equals(this.suit)){
       //if the pile is empty, it does not peek and simply takes an ace
       if(pile.empty() && c.getValue() == 1){
         pile.add(s.pile.pop());
       }
       //elseif the pile does have cards, we peek
       else if(!pile.empty()){
         val = pile.peek();
         //if the current value on the pile is one less than the card to be added
         if(val.getValue() == c.getValue() + 1){
           pile.add(s.pile.pop());
         }
       }
     }
   }

 }
