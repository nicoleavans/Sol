package vapor.sol;
import java.util.Stack;

/**
 * This class contains the methods and infrastructure for the 7
 * piles players move cards around within. It is distinguished
 * from suit pile because of move rules.
 */

class PlayPile{

    Stack<Card> pile;
    /*
     * Constructor
     */
    PlayPile(){
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
        if(pile.empty() && c.getValue() == 13){
            pile.add(p.pile.pop());
        }
        //else it has something to peek at and check
        else if(!pile.empty()){
            val = pile.peek();
            //if the colors are opposite and the value is less, add to the stack
            if(!val.getColor().equals(c.getColor()) && c.getValue() == val.getValue() - 1){
                pile.add(p.pile.pop());
            }
        }
    }
    public void addCard(PlayPile p, int i){
        //card c here is used as the lead card to be moved, it needs to be the one at the end
        Card c = null;
        Card val = pile.peek();
        Stack<Card> s = new Stack<Card>();
        //so it takes the number of cards you want to move, and puts them into a temp stack
        for(int temp = i; temp > 0; temp--){
            Card x = p.pile.pop();
            s.push(x);
            //this should capture the very last card here, which would be the top lead card
            c = x;
        }
        //if the pile is empty it can go there regardless
        if(pile.empty() && c.getValue() == 13 && c.getUp()){
            for(int temp = i; temp > 0; temp--){
                pile.add(s.pop());
            }
            //turns up the leftover card
            p.pile.peek().turnUp();
        }
        //if the colors are opposite and the value is less, add to the stack
        else if(!val.getColor().equals(c.getColor()) && c.getValue() == val.getValue() - 1 && c.getUp()){
            for(int temp = i; temp > 0; temp--){
                pile.add(s.pop());
            }
            p.pile.peek().turnUp();
        }
        else{
            for(int temp = i; temp > 0; temp--){
                Card x = s.pop();
                p.pile.push(x);
            }
        }
    }

   /*
   //THIS IS EXPERIMENTAL
   public void addCard(PlayPile p, int i){
	   Card c = null;
	   Card lead = null;
	   Card target = pile.peek();
	   Stack<Card> s = new Stack<Card>();
	   //so it takes the number of cards you want to move, and puts them into a temp stack
	   for(int temp = i; temp > 0; temp--){
		   c = p.pile.pop();
		   s.push(c);
		   //this should capture the very last card here, which would be the top lead card
		   lead = c;
	   }
	   //if the pile is empty and the lead card is a king or if it isn't empty but the card being moved is an opposite color and one value less than target
	   if((pile.empty() && lead.getValue() == 13) || (!pile.empty() && !lead.getColor().equals(target.getColor()) && (lead.getValue() == (target.getValue() - 1)))){
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
        //if the pile is empty it can go there regardless
        if(pile.empty() && c.getValue() == 13){
            pile.add(s.pile.pop());
        }
        //else it has something to peek at and check
        else if(!pile.empty()){
            val = pile.peek();
            //if the colors are opposite and the value is less, add to the stack
            if(!val.getColor().equals(c.getColor()) && c.getValue() == val.getValue() - 1){
                pile.add(s.pile.pop());
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
        if((pile.empty() && lead.getValue() == 13) || (!pile.empty() && !lead.getColor().equals(landing.getColor()) && lead.getValue() == (landing.getValue() - 1))){
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
    * This method handles a draw pile target.
    * @param d target draw pile
    */
    public void addCard(DrawPile d){
        Card c = d.q.peek();
        Card val;
        //if the pile is empty it can go there regardless
        if(pile.empty() && c.getValue() == 13){
            pile.add(d.q.remove());
        }
        //else it has something to peek at and check
        else if(!pile.empty()){
            val = pile.peek();
            //if the colors are opposite and the value is less, add to the stack
            if(!val.getColor().equals(c.getColor()) && c.getValue() == val.getValue() - 1){
                pile.add(d.q.remove());
            }
        }
    }
}
