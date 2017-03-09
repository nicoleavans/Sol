package vapor.sol;
import java.util.Stack;

/**
 * This class contains the methods and infrastructure for the 7
 * piles players move cards around within. It is distinguished 
 * from suit pile because of move rules.
 */

 public class PlayPile{
	 
	 Stack<Card> pile;
   /*
    * Constructor
    */
   public PlayPile(){
     pile = new Stack<Card>();
   }
   /*
    * The upcoming methods handle movement, using a target pile
    * as the source for a card to move to the play pile the method is called on. 
    * This method handles a play pile target.
    * @param p	the target play pile
    */
   public void addCard(PlayPile p){
     Card c = p.pile.peek();
     Card val;
     //if the pile is empty it can go there regardless
     if(pile.empty() == true && c.getValue() == 13){
       //TODO is it more efficient to use
       //pile.add(p.pile.pop());
       pile.add(c);
       p.pile.pop();
     }
     //else it has something to peek at and check
     else if(pile.empty() != true){
       val = pile.peek();
       //if the colors are opposite and the value is less, add to the stack
       if(val.getColor() != c.getColor() && c.getValue() == val.getValue() - 1){
         pile.add(c);
         p.pile.pop();
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
     //if the pile is empty it can go there regardless
     if(pile.empty() == true && c.getValue() == 13){
       //TODO evaluate if it would be more efficient to
       //pile.add(s.pile.pop());
       pile.add(c);
       s.pile.pop();
     }
     //else it has something to peek at and check
     else if(pile.empty() != true){
       val = pile.peek();
       //if the colors are opposite and the value is less, add to the stack
       if(val.getColor() != c.getColor() && c.getValue() == val.getValue() - 1){
         pile.add(c);
         s.pile.pop();
       }
     }
   }
   /*
    * This method handles a draw pile target.
    * @param d target draw pile
    */
   public void addCard(DrawPile d){
     Card c = d.q.peek();
     Card val;
     //if the pile is empty it can go there regardless
     if(pile.empty() == true && c.getValue() == 13){
       //TODO evaluate if I should just use pile.add(d.q.remove()); instead
       pile.add(c);
       d.q.remove();
     }
     //else it has something to peek at and check
     else if(pile.empty() != true){
       val = pile.peek();
       //if the colors are opposite and the value is less, add to the stack
       if(val.getColor() != c.getColor() && c.getValue() == val.getValue() - 1){
         pile.add(c);
         d.q.remove();
       }
     }
   }
 }
