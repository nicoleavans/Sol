package vapor.sol;
/*
 * This activity comprises the main method.
 */
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String cl = "clubs";
        final String di = "diamonds";
        final String sp = "spades";
        final String he = "hearts";

        //This creates the required piles
        SuitPile hearts = new SuitPile(he);
        SuitPile spades = new SuitPile(sp);
        SuitPile diamonds = new SuitPile(di);
        SuitPile clubs = new SuitPile(cl);

        PlayPile one = new PlayPile();
        PlayPile two = new PlayPile();
        PlayPile three = new PlayPile();
        PlayPile four = new PlayPile();
        PlayPile five = new PlayPile();
        PlayPile six = new PlayPile();
        PlayPile seven = new PlayPile();

        DrawPile draw = new DrawPile();

        Context ctx = getApplicationContext();
        Deck d = new Deck(ctx);
        //this populates the play spaces.
        //probably a little clumsy, but it seems functional to me
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
