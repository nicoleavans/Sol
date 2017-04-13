package vapor.sol;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Sol_lite extends AppCompatActivity {

    EditText commandInput;
    TextView gameOutput;
    TextView line01;
    TextView line02;
    TextView line03;
    TextView line04;
    TextView line05;
    TextView line06;
    TextView line07;
    TextView line08;
    TextView line09;
    TextView line10;
    TextView line11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sol_lite);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commandInput = (EditText) findViewById(R.id.commandInput);
                gameOutput = (TextView) findViewById(R.id.gameOutput);
                gameOutput.setText(commandInput.getText());
                commandInput.setText(null);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        line05 = (TextView) findViewById(R.id.line05);
        line05.setText("one " + p.one.pile.toString());
        line06 = (TextView) findViewById(R.id.line06);
        line06.setText("two " + p.two.pile.toString());
        line07 = (TextView) findViewById(R.id.line07);
        line07.setText("three " + p.three.pile.toString());
    }


        static boolean isRunning = true;
        Scanner sc = new Scanner(System.in);
        PlaySpaces p;

        public Sol_lite(){
            p = new PlaySpaces();
        }

        /*
         * Main method creates the launcher (and thus everything else)
         * displays the greeting message and the initial step
         * and starts the game sequence
         */
        public static void main(String[] args) {
            // TODO code application logic here
            Sol_lite l = new Sol_lite();
            l.greetingMessage();
            System.out.println("\n\nI N S T R U C T I O N S\n");
            System.out.println("To quit, type \"quit\". To draw a new card, type \"draw\".\n");
            System.out.println("To move, type the name of the target pile, followed by the name of the source pile, and the number of cards you would like to move if more than one.\n");
            System.out.println("For example \"seven spades 3\" or \"hearts one\" or \"seven three 2\"");
            l.printCurrentStep();
            l.startGame();
        }

        public void startGame(){
            while(isRunning){
                if(gameCommands(sc.nextLine())) {
                    if(isRunning){
                        printCurrentStep();
                    }
                }
                else{
                    System.err.println("Invalid. Try another option");
                    System.out.println("Next move");
                }
            }
            sc.close();
            System.exit(0);

        }

        public boolean gameCommands(String commands){
            Scanner ls = new Scanner(commands);
            String c1 = ls.next();
            String c2 = "";
            //defaults to one
            int c3 = 1;
            if(ls.hasNext()){
                c2 = ls.next();
            }
            if(ls.hasNextInt()){
                c3 = ls.nextInt();
            }
            if(c1.equalsIgnoreCase("quit")){
                isRunning = false;
                return true;
            }
            else if(c1.equalsIgnoreCase("draw")){
                p.draw.turnCard();
                return true;
            }
        /*
         * these handle moving from play piles
         */
            else if(c1.equalsIgnoreCase("seven")){
                if(c2.equalsIgnoreCase("seven")){
                    return true;
                }
                else if(c2.equalsIgnoreCase("six")){
                    p.seven.addCard(p.six, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("five")){
                    p.seven.addCard(p.five, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("four")){
                    p.seven.addCard(p.four, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("three")){
                    p.seven.addCard(p.three, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("two")){
                    p.seven.addCard(p.two, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("one")){
                    p.seven.addCard(p.one, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("spades")){
                    p.seven.addCard(p.spades);
                    return true;
                }
                else if(c2.equalsIgnoreCase("diamonds")){
                    p.seven.addCard(p.diamonds);
                    return true;
                }
                else if(c2.equalsIgnoreCase("hearts")){
                    p.seven.addCard(p.hearts);
                    return true;
                }
                else if(c2.equalsIgnoreCase("clubs")){
                    p.seven.addCard(p.clubs);
                    return true;
                }
                else if(c2.equalsIgnoreCase("draw")){
                    p.seven.addCard(p.draw);
                    return true;
                }
            }
            else if(c1.equalsIgnoreCase("six")){
                if(c2.equalsIgnoreCase("seven")){
                    p.six.addCard(p.seven, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("six")){
                    p.six.addCard(p.six, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("five")){
                    p.six.addCard(p.five, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("four")){
                    p.six.addCard(p.four, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("three")){
                    p.six.addCard(p.three, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("two")){
                    p.six.addCard(p.two, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("one")){
                    p.six.addCard(p.one, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("spades")){
                    p.six.addCard(p.spades);
                    return true;
                }
                else if(c2.equalsIgnoreCase("diamonds")){
                    p.six.addCard(p.diamonds);
                    return true;
                }
                else if(c2.equalsIgnoreCase("hearts")){
                    p.six.addCard(p.hearts);
                    return true;
                }
                else if(c2.equalsIgnoreCase("clubs")){
                    p.six.addCard(p.clubs);
                    return true;
                }
                else if(c2.equalsIgnoreCase("draw")){
                    p.six.addCard(p.draw);
                    return true;
                }
            }
            else if(c1.equalsIgnoreCase("five")){
                if(c2.equalsIgnoreCase("seven")){
                    p.five.addCard(p.seven, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("six")){
                    p.five.addCard(p.six, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("five")){
                    p.five.addCard(p.five, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("four")){
                    p.five.addCard(p.four, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("three")){
                    p.five.addCard(p.three, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("two")){
                    p.five.addCard(p.two, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("one")){
                    p.five.addCard(p.one, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("spades")){
                    p.five.addCard(p.spades);
                    return true;
                }
                else if(c2.equalsIgnoreCase("diamonds")){
                    p.five.addCard(p.diamonds);
                    return true;
                }
                else if(c2.equalsIgnoreCase("hearts")){
                    p.five.addCard(p.hearts);
                    return true;
                }
                else if(c2.equalsIgnoreCase("clubs")){
                    p.five.addCard(p.clubs);
                    return true;
                }
                else if(c2.equalsIgnoreCase("draw")){
                    p.five.addCard(p.draw);
                    return true;
                }
            }
            else if(c1.equalsIgnoreCase("four")){
                if(c2.equalsIgnoreCase("seven")){
                    p.four.addCard(p.seven, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("six")){
                    p.four.addCard(p.six, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("five")){
                    p.four.addCard(p.five, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("four")){
                    p.four.addCard(p.four, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("three")){
                    p.four.addCard(p.three, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("two")){
                    p.four.addCard(p.two, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("one")){
                    p.four.addCard(p.one, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("spades")){
                    p.four.addCard(p.spades);
                    return true;
                }
                else if(c2.equalsIgnoreCase("diamonds")){
                    p.four.addCard(p.diamonds);
                    return true;
                }
                else if(c2.equalsIgnoreCase("hearts")){
                    p.four.addCard(p.hearts);
                    return true;
                }
                else if(c2.equalsIgnoreCase("clubs")){
                    p.four.addCard(p.clubs);
                    return true;
                }
                else if(c2.equalsIgnoreCase("draw")){
                    p.four.addCard(p.draw);
                    return true;
                }
            }
            else if(c1.equalsIgnoreCase("three")){
                if(c2.equalsIgnoreCase("seven")){
                    p.three.addCard(p.seven, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("six")){
                    p.three.addCard(p.six, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("five")){
                    p.three.addCard(p.five, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("four")){
                    p.three.addCard(p.four, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("three")){
                    p.three.addCard(p.three, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("two")){
                    p.three.addCard(p.two, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("one")){
                    p.three.addCard(p.one, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("spades")){
                    p.three.addCard(p.spades);
                    return true;
                }
                else if(c2.equalsIgnoreCase("diamonds")){
                    p.three.addCard(p.diamonds);
                    return true;
                }
                else if(c2.equalsIgnoreCase("hearts")){
                    p.three.addCard(p.hearts);
                    return true;
                }
                else if(c2.equalsIgnoreCase("clubs")){
                    p.three.addCard(p.clubs);
                    return true;
                }
                else if(c2.equalsIgnoreCase("draw")){
                    p.three.addCard(p.draw);
                    return true;
                }
            }
            else if(c1.equalsIgnoreCase("two")){
                if(c2.equalsIgnoreCase("seven")){
                    p.two.addCard(p.seven, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("six")){
                    p.two.addCard(p.six, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("five")){
                    p.two.addCard(p.five, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("four")){
                    p.two.addCard(p.four, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("three")){
                    p.two.addCard(p.three, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("two")){
                    p.two.addCard(p.two, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("one")){
                    p.two.addCard(p.one, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("spades")){
                    p.two.addCard(p.spades);
                    return true;
                }
                else if(c2.equalsIgnoreCase("diamonds")){
                    p.two.addCard(p.diamonds);
                    return true;
                }
                else if(c2.equalsIgnoreCase("hearts")){
                    p.two.addCard(p.hearts);
                    return true;
                }
                else if(c2.equalsIgnoreCase("clubs")){
                    p.two.addCard(p.clubs);
                    return true;
                }
                else if(c2.equalsIgnoreCase("draw")){
                    p.two.addCard(p.draw);
                    return true;
                }
            }
            else if(c1.equalsIgnoreCase("one")){
                if(c2.equalsIgnoreCase("seven")){
                    p.one.addCard(p.seven, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("six")){
                    p.one.addCard(p.six, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("five")){
                    p.one.addCard(p.five, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("four")){
                    p.one.addCard(p.four, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("three")){
                    p.one.addCard(p.three, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("two")){
                    p.one.addCard(p.two, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("one")){
                    p.one.addCard(p.one, c3);
                    return true;
                }
                else if(c2.equalsIgnoreCase("spades")){
                    p.one.addCard(p.spades);
                    return true;
                }
                else if(c2.equalsIgnoreCase("diamonds")){
                    p.one.addCard(p.diamonds);
                    return true;
                }
                else if(c2.equalsIgnoreCase("hearts")){
                    p.one.addCard(p.hearts);
                    return true;
                }
                else if(c2.equalsIgnoreCase("clubs")){
                    p.one.addCard(p.clubs);
                    return true;
                }
                else if(c2.equalsIgnoreCase("draw")){
                    p.one.addCard(p.draw);
                    return true;
                }
            }
        /*
         * these handle moving from suit piles
         * CURRENTLY BREAKS CODE NEED OF REPAIR
         * (non vital b/c unlikely move)

            else if(c1.equalsIgnoreCase("spades")){
                if(c2.equalsIgnoreCase("seven")){
                    p.spades.addCard(p.seven);
                    return true;
                }
                else if(c2.equalsIgnoreCase("six")){
                    p.spades.addCard(p.six);
                    return true;
                }
                else if(c2.equalsIgnoreCase("five")){
                    p.spades.addCard(p.five);
                    return true;
                }
                else if(c2.equalsIgnoreCase("four")){
                    p.spades.addCard(p.four);
                    return true;
                }
                else if(c2.equalsIgnoreCase("three")){
                    p.spades.addCard(p.three);
                    return true;
                }
                else if(c2.equalsIgnoreCase("two")){
                    p.spades.addCard(p.two);
                    return true;
                }
                else if(c2.equalsIgnoreCase("one")){
                    p.spades.addCard(p.one);
                    return true;
                }
                else if(c2.equalsIgnoreCase("spades")){
                    p.spades.addCard(p.spades);
                    return true;
                }
                else if(c2.equalsIgnoreCase("diamonds")){
                    p.spades.addCard(p.diamonds);
                    return true;
                }
                else if(c2.equalsIgnoreCase("hearts")){
                    p.spades.addCard(p.hearts);
                    return true;
                }
                else if(c2.equalsIgnoreCase("clubs")){
                    p.spades.addCard(p.clubs);
                    return true;
                }
                else if(c2.equalsIgnoreCase("draw")){
                    p.spades.addCard(p.draw);
                    return true;
                }
            }
            else if(c1.equalsIgnoreCase("diamonds")){
                if(c2.equalsIgnoreCase("seven")){
                    p.diamonds.addCard(p.seven);
                    return true;
                }
                else if(c2.equalsIgnoreCase("six")){
                    p.diamonds.addCard(p.six);
                    return true;
                }
                else if(c2.equalsIgnoreCase("five")){
                    p.diamonds.addCard(p.five);
                    return true;
                }
                else if(c2.equalsIgnoreCase("four")){
                    p.diamonds.addCard(p.four);
                    return true;
                }
                else if(c2.equalsIgnoreCase("three")){
                    p.diamonds.addCard(p.three);
                    return true;
                }
                else if(c2.equalsIgnoreCase("two")){
                    p.diamonds.addCard(p.two);
                    return true;
                }
                else if(c2.equalsIgnoreCase("one")){
                    p.diamonds.addCard(p.one);
                    return true;
                }
                else if(c2.equalsIgnoreCase("spades")){
                    p.diamonds.addCard(p.spades);
                    return true;
                }
                else if(c2.equalsIgnoreCase("diamonds")){
                    p.diamonds.addCard(p.diamonds);
                    return true;
                }
                else if(c2.equalsIgnoreCase("hearts")){
                    p.diamonds.addCard(p.hearts);
                    return true;
                }
                else if(c2.equalsIgnoreCase("clubs")){
                    p.diamonds.addCard(p.clubs);
                    return true;
                }
                else if(c2.equalsIgnoreCase("draw")){
                    p.diamonds.addCard(p.draw);
                    return true;
                }
            }
            else if(c1.equalsIgnoreCase("hearts")){
                if(c2.equalsIgnoreCase("seven")){
                    p.hearts.addCard(p.seven);
                    return true;
                }
                else if(c2.equalsIgnoreCase("six")){
                    p.hearts.addCard(p.six);
                    return true;
                }
                else if(c2.equalsIgnoreCase("five")){
                    p.hearts.addCard(p.five);
                    return true;
                }
                else if(c2.equalsIgnoreCase("four")){
                    p.hearts.addCard(p.four);
                    return true;
                }
                else if(c2.equalsIgnoreCase("three")){
                    p.hearts.addCard(p.three);
                    return true;
                }
                else if(c2.equalsIgnoreCase("two")){
                    p.hearts.addCard(p.two);
                    return true;
                }
                else if(c2.equalsIgnoreCase("one")){
                    p.hearts.addCard(p.one);
                    return true;
                }
                else if(c2.equalsIgnoreCase("spades")){
                    p.hearts.addCard(p.spades);
                    return true;
                }
                else if(c2.equalsIgnoreCase("diamonds")){
                    p.hearts.addCard(p.diamonds);
                    return true;
                }
                else if(c2.equalsIgnoreCase("hearts")){
                    p.hearts.addCard(p.hearts);
                    return true;
                }
                else if(c2.equalsIgnoreCase("clubs")){
                    p.hearts.addCard(p.clubs);
                    return true;
                }
                else if(c2.equalsIgnoreCase("draw")){
                    p.hearts.addCard(p.draw);
                    return true;
                }
            }
            else if(c1.equalsIgnoreCase("clubs")){
                if(c2.equalsIgnoreCase("seven")){
                    p.clubs.addCard(p.seven);
                    return true;
                }
                else if(c2.equalsIgnoreCase("six")){
                    p.clubs.addCard(p.six);
                    return true;
                }
                else if(c2.equalsIgnoreCase("five")){
                    p.clubs.addCard(p.five);
                    return true;
                }
                else if(c2.equalsIgnoreCase("four")){
                    p.clubs.addCard(p.four);
                    return true;
                }
                else if(c2.equalsIgnoreCase("three")){
                    p.clubs.addCard(p.three);
                    return true;
                }
                else if(c2.equalsIgnoreCase("two")){
                    p.clubs.addCard(p.two);
                    return true;
                }
                else if(c2.equalsIgnoreCase("one")){
                    p.clubs.addCard(p.one);
                    return true;
                }
                else if(c2.equalsIgnoreCase("spades")){
                    p.clubs.addCard(p.spades);
                    return true;
                }
                else if(c2.equalsIgnoreCase("diamonds")){
                    p.clubs.addCard(p.diamonds);
                    return true;
                }
                else if(c2.equalsIgnoreCase("hearts")){
                    p.clubs.addCard(p.hearts);
                    return true;
                }
                else if(c2.equalsIgnoreCase("clubs")){
                    p.clubs.addCard(p.clubs);
                    return true;
                }
                else if(c2.equalsIgnoreCase("draw")){
                    p.clubs.addCard(p.draw);
                    return true;
                }
            }
            */
            else{
                return false;
            }
            return true;
        }

        public void restart(){
            Sol_lite la = new Sol_lite();
            la.printCurrentStep();
            la.startGame();
        }

        public void printCurrentStep(){
            System.out.println("\n" + "-------------Current Step----------------");
            System.out.println("Open Card:  " + p.draw.q.peek().toString() + "\n");
            System.out.printf("Card Stacks:  \n");
            if(!p.clubs.pile.empty()){
                System.out.println(p.clubs.pile.peek().toString()+ "\n");
            }
            else{
                System.out.println("♣\n");
            }
            if(!p.hearts.pile.empty()){
                System.out.println(p.hearts.pile.peek().toString()+ "\n");
            }
            else{
                System.out.println("♥\n");
            }
            if(!p.spades.pile.empty()){
                System.out.println(p.spades.pile.peek().toString()+ "\n");
            }
            else{
                System.out.println("♠\n");
            }
            if(!p.diamonds.pile.empty()){
                System.out.println(p.diamonds.pile.peek().toString() + "\n");
            }
            else{
                System.out.println("♦\n");
            }
            System.out.println("\n");
            System.out.println("Card Lists: ");
            System.out.println("one " + p.one.pile.toString() + "\n");
            System.out.println("two " + p.two.pile.toString() + "\n");
            System.out.println("three " + p.three.pile.toString() + "\n");
            System.out.println("four " + p.four.pile.toString() + "\n");
            System.out.println("five " + p.five.pile.toString() + "\n");
            System.out.println("six " + p.six.pile.toString() + "\n");
            System.out.println("seven " + p.seven.pile.toString() + "\n");
            System.out.print("\n" + "Your Next Move: ");

        }
        private void greetingMessage() {

            String greeting = "      	   	         _______  _______  ___      ___   _______  _______  ___   ______    _______" + "\n"
                    + "			|       ||       ||   |    |   | |       ||   _   ||   | |    _ |  |       |" + "\n"
                    + "			|  _____||   _   ||   |    |   | |_     _||  | |  ||   | |   | ||  |    ___|" + "\n"
                    + "			| |_____ |  | |  ||   |    |   |   |   |  |  |_|  ||   | |   |_||_ |   |___ " + "\n"
                    + "			|_____  ||  |_|  ||   |___ |   |   |   |  |       ||   | |    __  ||    ___|" + "\n"
                    + "			 _____| ||       ||       ||   |   |   |  |   _   ||   | |   |  | ||   |___ " + "\n"
                    + "			|_______||_______||_______||___|   |___|  |__| |__||___| |___|  |_||_______|";

            System.out.println(greeting);
        }



}




/*
 * TODO this build has issues: the cards are all revealed, not just the ones that are verified uncovered
 * this build doesn't support moving any more than the top card on a stack, but that should be possible (if annoying and tedious)
 * to implement. that said this is exciting progress I think!
 */


/**
 * This class stores necessary information about cards. Possibly we could phase out color in favor of suit and
 * just add a bit where it checks the suit to determine color? unsure how relevant it really is
 */

class Cards {
    //initial variables
    private String suit;
    private String color;
    private int value;
    private int cardID;
    private boolean up;
    /*
     * Constructor
     * @param s  suit
     * @param c  color
     * @param v  value
     */
    Cards(String s, String c, int v, int i){
        suit = s;
        color = c;
        value = v;
        cardID = i;
        up = false;

        //debug
        //System.out.println("Expected: suit, color, value" + suit + color + value);
    }
    /*
     * Getters and setters.
     */
    String getSuit(){
        return suit;
    }
    String getColor(){
        return color;
    }
    int getValue(){
        return value;
    }
    int getCardID(){return cardID;}
    boolean getUp(){return up;}
    void turnUp(){up = true;}

    String toSymbol(){
        String temp = this.getSuit();
        String r;
        if(temp == "spades"){
            r = "♠";
        }
        else if(temp == "diamonds"){
            r = "♦";
        }
        else if(temp == "hearts"){
            r = "♥";
        }
        else{
            r = "♣";
        }
        return r;
    }
    public String toString(){
        int v = this.value;
        String val;
        String s;
        if(v > 10){
            if(v == 11){
                val = "J";
            }
            else if(v == 12){
                val = "Q";
            }
            else{
                val = "K";
            }
            s = " " + val + " " + this.toSymbol();
        }
        else if(v == 1){
            s = " A " + this.toSymbol();
        }
        else{
            s = " " + this.value + " " + this.toSymbol();
        }
        return s;
    }
}


/**
 * This method builds a 52 card deck.
 */

class Decks {
    ArrayList<Cards> pile;
    /*
     * Constructor
     */
    Decks() {
        final String clubs = "clubs";
        final String diamonds = "diamonds";
        final String spades = "spades";
        final String hearts = "hearts";
        pile = new ArrayList<>();

        //4 suits, 4 loops
        for (int i = 4; i > 0; i--) {
            //clubs
            //ints go up to thirteen to cover number and face cards
            if(i == 4){
                for (int j = 1; j <= 13; j++) {
                    Cards c = new Cards(clubs, "black", j, i);
                    pile.add(c);
                }
            }
            else if (i == 3) {
                for (int j = 1; j <= 13; j++) {
                    Cards c = new Cards(spades, "black", j, i);
                    pile.add(c);
                }
            }
            //hearts
            else if (i == 2) {
                for (int j = 1; j <= 13; j++) {
                    Cards c = new Cards(hearts, "red", j, i);
                    pile.add(c);
                }
            }
            //diamonds
            else if(i == 1){
                for(int j = 1; j <= 13; j++){
                    Cards c = new Cards(diamonds, "red", j, i);
                    pile.add(c);
                }
            }
        }
        //shuffles the deck after making it
        Collections.shuffle(pile);

    }
}


/**
 * This class contains the infrastructure for the draw pile.
 *
 */

class DrawPiles{
    Queue<Cards> q;
    /*
     * Constructor
     */
    DrawPiles(){
        q = new LinkedList<>();
    }
    /*
     * This method allows the user to flip through the draw pile.
     * This is for one card draw.
     */
    public void turnCard(){
        Cards c = q.remove();
        q.add(c);
    }
    /*
     * This method allows the user to flip through the draw pile.
     * This is for three card draw.
     */
    public void turnCard3(){
        Cards c1 = q.remove();
        Cards c2 = q.remove();
        Cards c3 = q.remove();
        q.add(c1);
        q.add(c2);
        q.add(c3);
    }
}



/**
 * This class contains the methods and infrastructure for the 7
 * piles players move cards around within. It is distinguished
 * from suit pile because of move rules.
 */

class PlayPiles{

    Stack<Cards> pile;
    /*
     * Constructor
     */
    PlayPiles(){
        pile = new Stack<Cards>();
    }
   /*
    * The upcoming methods handle movement, using a target pile
    * as the source for a card to move to the play pile the method is called on.
    * This method handles a play pile target.
    * @param p  the target play pile
    */

    public void addCard(PlayPiles p){
        Cards c = p.pile.peek();
        Cards val;
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
    public void addCard(PlayPiles p, int i){
        //card c here is used as the lead card to be moved, it needs to be the one at the end
        Cards c = null;
        Cards val = pile.peek();
        Stack<Cards> s = new Stack<Cards>();
        //so it takes the number of cards you want to move, and puts them into a temp stack
        for(int temp = i; temp > 0; temp--){
            Cards x = p.pile.pop();
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
                Cards x = s.pop();
                p.pile.push(x);
            }
        }
    }

   /*
   //THIS IS EXPERIMENTAL
   public void addCard(PlayPiles p, int i){
       Cards c = null;
       Cards lead = null;
       Cards target = pile.peek();
       Stack<Cards> s = new Stack<Cards>();
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
    * @param s  target suit pile
    */

    public void addCard(SuitPiles s){
        Cards c = s.pile.peek();
        Cards val;
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
    public void addCard(SuitPiles p, int i){
        Cards c = null;
        Cards lead = null;
        Cards landing = p.pile.peek();
        Stack<Cards> s = new Stack<Cards>();
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
    public void addCard(DrawPiles d){
        Cards c = d.q.peek();
        Cards val;
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

    public String toString(){
        if(pile.empty()){
            return "empty";
        }
        else{
            Stack<Cards> temp = pile;
            StringBuilder s = new StringBuilder();
            for(Cards c : temp){
                if(c.getUp()){
                    s.append(c.toString() + " ");
                }
                else{
                    s.append("X");
                }
            }
            String r = s.toString();
            return r;
        }
    }
}



/**
 * This method exists to generate a play board instead of leaving it in the main method
 * both for simplicity and also for starting a new game. Also importantly, this can handle
 * shuffling the cards and populating the piles within the game.
 *
 * TODO add methods or buttons etc or additional user functionality
 */

class PlaySpaces{
    SuitPiles hearts;
    SuitPiles spades;
    SuitPiles diamonds;
    SuitPiles clubs;

    PlayPiles one;
    PlayPiles two;
    PlayPiles three;
    PlayPiles four;
    PlayPiles five;
    PlayPiles six;
    PlayPiles seven;

    DrawPiles draw;
    Decks d;

    /*
     * Constructor
     */
    public PlaySpaces(){

        final String cl = "clubs";
        final String di = "diamonds";
        final String sp = "spades";
        final String he = "hearts";

        hearts = new SuitPiles(he);
        spades = new SuitPiles(sp);
        diamonds = new SuitPiles(di);
        clubs = new SuitPiles(cl);

        one = new PlayPiles();
        two = new PlayPiles();
        three = new PlayPiles();
        four = new PlayPiles();
        five = new PlayPiles();
        six = new PlayPiles();
        seven = new PlayPiles();

        draw = new DrawPiles();

        d = new Decks();
        //this populates the play spaces.
        //probably a little clumsy, but it seems functional to me
        for(int i = 0; i < 52; i++){
            if(i == 0){
                one.pile.push(d.pile.get(i));
                one.pile.peek().turnUp();
            }
            else if(i == 1 || i == 2){
                two.pile.push(d.pile.get(i));
                if(i == 2){
                    two.pile.peek().turnUp();
                }
            }
            else if(i > 2 && i < 6){
                three.pile.push(d.pile.get(i));
                if(i == 5){
                    three.pile.peek().turnUp();
                }
            }
            else if(i > 5 && i < 10){
                four.pile.push(d.pile.get(i));
                if(i == 9){
                    four.pile.peek().turnUp();
                }
            }
            else if(i > 9 && i < 15){
                five.pile.push(d.pile.get(i));
                if(i == 14){
                    five.pile.peek().turnUp();
                }
            }
            else if(i > 14 && i < 21){
                six.pile.push(d.pile.get(i));
                if(i == 20){
                    six.pile.peek().turnUp();
                }
            }
            else if(i > 20 && i < 28){
                seven.pile.push(d.pile.get(i));
                if(i == 27){
                    seven.pile.peek().turnUp();
                }
            }
            else{
                Cards temp = d.pile.get(i);
                temp.turnUp();
                draw.q.add(temp);
            }
        }
    }
}



/**
 * This class contains the methods and infrastructure for the four piles for collecting suits
 * to win.
 */

class SuitPiles{
    //instance variables
    private String suit;
    Stack<Cards> pile = new Stack<>();
    /*
     * Constructor
     * @param s  the suit of cards the pile will hold
     */
    SuitPiles(String s){
        suit = s;
    }
   /*
    * The upcoming methods handle movement, using a target pile
    * as the source for a card to move to the play pile the method is called on.
    * This method handles a draw pile target.
    * @param d  the target draw pile
    */

    public void addCard(DrawPiles d){
        Cards c = d.q.peek();
        Cards val;
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
    public void addCard(DrawPiles p, int i){
       Cards c = null;
       Cards lead = null;
       Cards landing = p.q.peek();
       Stack<Cards> s = new Stack<Cards>();
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
    * @param p  target play pile
    */

    public void add(PlayPiles p){
        Cards c = p.pile.peek();
        Cards val;
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
    public void addCard(PlayPiles p, int i){
       Cards c = null;
       Cards lead = null;
       Cards landing = p.pile.peek();
       Stack<Cards> s = new Stack<Cards>();
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
    * @param s  target suit pile
    */

    public void addCard(SuitPiles s){
        Cards c = s.pile.peek();
        Cards val;
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
    public void addCard(SuitPiles p, int i){
       Cards c = null;
       Cards lead = null;
       Cards landing = p.pile.peek();
       Stack<Cards> s = new Stack<Cards>();
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