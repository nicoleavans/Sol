package vapor.solitaire;
/**
 * This method exists to generate a play board instead of leaving it in the main method
 * both for simplicity and also for starting a new game. Also importantly, this can handle
 * shuffling the cards and populating the piles within the game.
 *
 * TODO add methods or buttons etc or additional user functionality
 */

 public class PlaySpace{
   /*
    * Constructor
    */
   public PlaySpace(){

     SuitPile hearts = new SuitPile("hearts");
     SuitPile spades = new SuitPile("spades");
     SuitPile diamonds = new SuitPile("diamonds");
     SuitPile clubs = new SuitPile("clubs");

     PlayPile one = new PlayPile();
     PlayPile two = new PlayPile();
     PlayPile three = new PlayPile();
     PlayPile four = new PlayPile();
     PlayPile five = new PlayPile();
     PlayPile six = new PlayPile();
     PlayPile seven = new PlayPile();

     DrawPile draw = new DrawPile();

     Deck d = new Deck();
     //this populates the play spaces.
     //probably a little clumsy, but it seems functional to me
     for(int i = 0; i < 52; i++){
       if(i == 0){
         one.pile.push(d.pile.get(i));
       }
       else if(i == 1 || i == 2){
         two.pile.push(d.pile.get(i));
       }
       else if(i > 2 && i < 6){
         three.pile.push(d.pile.get(i));
       }
       else if(i > 5 && i < 10){
         four.pile.push(d.pile.get(i));
       }
       else if(i > 9 && i < 15){
         five.pile.push(d.pile.get(i));
       }
       else if(i > 14 && i < 21){
         six.pile.push(d.pile.get(i));
       }
       else if(i > 20 && i < 28){
         seven.pile.push(d.pile.get(i));
       }
       else{
         draw.q.add(d.pile.get(i));
       }
     }
   }
 }
