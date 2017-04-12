package vapor.sol;
import java.util.Stack;

/**
 * This class contains the methods and infrastructure for the four piles for collecting suits
 * to win.
 */

class SuitPile{
    //instance variables
    private String suit;
    Stack<Card> pile = new Stack<>();
    /*
     * Constructor
     * @param s	the suit of cards the pile will hold
     */
    SuitPile(String s){
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
            //else the pile does have cards, we peek
            else{
                val = pile.peek();
                //if the current value on the pile is one less than the card to be added
                if(val.getValue() == c.getValue() - 1){
                    pile.add(d.q.remove());
                }
            }
        }
    }

    /*
    public void addCard(DrawPile p, int i){
 	   Card c = null;
 	   Card lead = null;
 	   Card landing = p.q.peek();
 	   Stack<Card> s = new Stack<Card>();
 	   //so it takes the number of cards you want to move, and puts them into a temp stack
 	   for(int temp = i; temp > 0; temp--){
 		   c = p.q.remove();
 		   s.push(c);
 		   //this should capture the very last card here, which would be the top lead card
 		   lead = c;
 	   }
 	   //if the pile is empty and the lead card is a king or if it isn't empty but the card being moved is an opposite color and one value less than target
 	   if((pile.empty() && lead.getValue() == 1) || (!pile.empty() && landing.getValue() == lead.getValue() + 1)){
 		   for(int temp = i; temp > 0; temp--){
 			   p.q.add(s.pop());
 		   }
 	   }
 	   //else it doesn't fit, reverse what happened
 	   else{
 		   for(int temp = i; temp > 0; temp--){
 			   c = s.pop();
 			   p.q.add(c);
 		   }
 	   }
    }
    */
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
                //if the card to be added is greater by one
                if(val.getValue() == c.getValue() - 1){
                    pile.add(p.pile.pop());
                }
            }
        }
    }

   /*
    public void addCard(PlayPile p, int i){
  	   Card c = null;
  	   Card lead = null;
  	   Card landing = p.pile.peek();
  	   Stack<Card> s = new Stack<Card>();
  	   //so it takes the number of cards you want to move, and puts them into a temp stack
  	   for(int temp = i; temp > 0; temp--){
  		   c = p.pile.pop();
  		   s.push(c);
  		   //this should capture the very last card here, which would be the top lead card
  		   lead = c;
  	   }
  	   //if the pile is empty and the lead card is a king or if it isn't empty but the card being moved is an opposite color and one value less than target
  	   if((pile.empty() && lead.getValue() == 1) || (!pile.empty() && landing.getValue() == (lead.getValue() + 1))){
  		   for(int temp = i; temp > 0; temp--){
  			   p.pile.push(s.pop());
  		   }
  	   }
  	   //else it doesn't fit, reverse what happened
  	   else{
  		   for(int temp = i; temp > 0; temp--){
  			   c = s.pop();
  			   p.pile.push(c);
  		   }
  	   }
     }
     */
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

    /*
    public void addCard(SuitPile p, int i){
  	   Card c = null;
  	   Card lead = null;
  	   Card landing = p.pile.peek();
  	   Stack<Card> s = new Stack<Card>();
  	   //so it takes the number of cards you want to move, and puts them into a temp stack
  	   for(int temp = i; temp > 0; temp--){
  		   c = p.pile.pop();
  		   s.push(c);
  		   //this should capture the very last card here, which would be the top lead card
  		   lead = c;
  	   }
  	   //if the pile is empty and the lead card is a king or if it isn't empty but the card being moved is an opposite color and one value less than target
  	   if((pile.empty() && lead.getValue() == 1) || (!pile.empty() && landing.getValue() == (lead.getValue() + 1))){
  		   for(int temp = i; temp > 0; temp--){
  			   p.pile.push(s.pop());
  		   }
  	   }
  	   //else it doesn't fit, reverse what happened
  	   else{
  		   for(int temp = i; temp > 0; temp--){
  			   c = s.pop();
  			   p.pile.push(c);
  		   }
  	   }
     }
     */
    public String toString(){
        if(pile.isEmpty())
            return "Empty";
        else
            return pile.peek().toString();
    }

}