package vapor.sol;
/*
 * This activity comprises the main method.
 */
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

import static vapor.sol.R.id.heartpile;
import static vapor.sol.R.id.spadepile;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String cl = "clubs";
        final String di = "diamonds";
        final String sp = "spades";
        final String he = "hearts";

        Resources r = Resources.getSystem();
        Context ctx = getApplicationContext();
        Deck d = new Deck(ctx);

        /*
         * This creates the suitpiles.
         */
        SuitPile hearts = new SuitPile(he);
        SuitPile spades = new SuitPile(sp);
        SuitPile diamonds = new SuitPile(di);
        SuitPile clubs = new SuitPile(cl);

        /*
         * This block of code creates ImageButtons and BitmapDrawables to set
         * the ImageButton backgrounds. The if statements set it to a value for
         * the current card back if they're empty, otherwise they set to the
         * card face at the top of the stack.
         * TODO test if this continually updates, if it doesn't, change that
         * TODO expand ImageButton functionality
         */
        BitmapDrawable back = new BitmapDrawable(r, d.returnBack());
        //creates an image button and pulls either the card back or the current highest card
        //to set as the image
        ImageButton heartpile = (ImageButton)findViewById(R.id.heartpile);
        BitmapDrawable hc = new BitmapDrawable(r, hearts.getTopCard().face);
        if(hearts.isEmpty()){
            heartpile.setBackground(hc);
        }
        else{
            heartpile.setBackground(back);
        }
        ImageButton spadepile = (ImageButton)findViewById(R.id.spadepile);
        BitmapDrawable sc = new BitmapDrawable(r, spades.getTopCard().face);
        if(spades.isEmpty()){
            spadepile.setBackground(sc);
        }
        else{
            spadepile.setBackground(back);
        }
        ImageButton diamondpile = (ImageButton)findViewById(R.id.diamondpile);
        BitmapDrawable dc = new BitmapDrawable(r, diamonds.getTopCard().face);
        if(diamonds.isEmpty()){
            diamondpile.setBackground(dc);
        }
        else{
            diamondpile.setBackground(back);
        }
        ImageButton clubpile = (ImageButton)findViewById(R.id.clubpile);
        BitmapDrawable cc = new BitmapDrawable(r, clubs.getTopCard().face);
        if(clubs.isEmpty()){
            clubpile.setBackground(cc);
        }
        else{
            clubpile.setBackground(back);
        }

        /*
         * Creates playpiles.
         */
        PlayPile one = new PlayPile();
        PlayPile two = new PlayPile();
        PlayPile three = new PlayPile();
        PlayPile four = new PlayPile();
        PlayPile five = new PlayPile();
        PlayPile six = new PlayPile();
        PlayPile seven = new PlayPile();

        /*
         * Creates drawpile.
         */
        DrawPile draw = new DrawPile();

        /*
         * This populates the play spaces with the appropriate number of cards.
         */
        for (int i = 0; i < 52; i++) {
            if (i == 0) {
                one.pile.push(d.pile.get(i));
            } else if (i == 1 || i == 2) {
                two.pile.push(d.pile.get(i));
            } else if (i > 2 && i < 6) {
                three.pile.push(d.pile.get(i));
            } else if (i > 5 && i < 10) {
                four.pile.push(d.pile.get(i));
            } else if (i > 9 && i < 15) {
                five.pile.push(d.pile.get(i));
            } else if (i > 14 && i < 21) {
                six.pile.push(d.pile.get(i));
            } else if (i > 20 && i < 28) {
                seven.pile.push(d.pile.get(i));
            } else {
                draw.q.add(d.pile.get(i));
            }
        }


    }
}
