package vapor.sol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView left, middle, right;

    Button new_game;

    List<Integer> cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        left = (ImageView) findViewById(R.id.left);
        middle = (ImageView) findViewById(R.id.middle);
        right = (ImageView) findViewById(R.id.right);

        new_game = (Button) findViewById(R.id.new_game);

        cards = new ArrayList<>();
        cards.add(101); // Ace of spades
        cards.add(208); // 8 of hearts
        cards.add(408); // 8 of diamonds

        // shuffle the cards
        Collections.shuffle(cards);

        new_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // shuffle the cards
                Collections.shuffle(cards);

                left.setImageResource(R.drawable.cb4);
                middle.setImageResource(R.drawable.cb4);
                right.setImageResource(R.drawable.cb4);

                Animation anim_left = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left);
                Animation anim_middle = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.middle);
                Animation anim_right = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right);

                left.startAnimation(anim_left);
                middle.startAnimation(anim_middle);
                right.startAnimation(anim_right);
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // assign images
                if (cards.get(0) == 101) {
                    left.setImageResource(R.drawable.spadea);
                    Toast.makeText(MainActivity.this, "Winner!", Toast.LENGTH_SHORT).show();
                } else if (cards.get(0) == 208) {
                    left.setImageResource(R.drawable.heart8);
                } else if (cards.get(0) == 408) {
                    left.setImageResource(R.drawable.diamond8);
                }

                if (cards.get(1) == 101) {
                    middle.setImageResource(R.drawable.spadea);
                } else if (cards.get(1) == 208) {
                    middle.setImageResource(R.drawable.heart8);
                } else if (cards.get(1) == 408) {
                    middle.setImageResource(R.drawable.diamond8);
                }

                if (cards.get(2) == 101) {
                    right.setImageResource(R.drawable.spadea);
                } else if (cards.get(2) == 208) {
                    right.setImageResource(R.drawable.heart8);
                } else if (cards.get(2) == 408) {
                    right.setImageResource(R.drawable.diamond8);
                }

            }
        });

        middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // assign images
                if (cards.get(1) == 101) {
                    middle.setImageResource(R.drawable.spadea);
                    Toast.makeText(MainActivity.this, "Winner!", Toast.LENGTH_SHORT).show();
                } else if (cards.get(1) == 208) {
                    middle.setImageResource(R.drawable.heart8);
                } else if (cards.get(1) == 408) {
                    middle.setImageResource(R.drawable.diamond8);
                }

                if (cards.get(0) == 101) {
                    left.setImageResource(R.drawable.spadea);
                } else if (cards.get(0) == 208) {
                    left.setImageResource(R.drawable.heart8);
                } else if (cards.get(0) == 408) {
                    left.setImageResource(R.drawable.diamond8);
                }

                if (cards.get(2) == 101) {
                    right.setImageResource(R.drawable.spadea);
                } else if (cards.get(2) == 208) {
                    right.setImageResource(R.drawable.heart8);
                } else if (cards.get(2) == 408) {
                    right.setImageResource(R.drawable.diamond8);
                }
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // assign images
                if (cards.get(2) == 101) {
                    right.setImageResource(R.drawable.spadea);
                    Toast.makeText(MainActivity.this, "Winner!", Toast.LENGTH_SHORT).show();
                } else if (cards.get(2) == 208) {
                    right.setImageResource(R.drawable.heart8);
                } else if (cards.get(2) == 408) {
                    right.setImageResource(R.drawable.diamond8);
                }

                if (cards.get(0) == 101) {
                    left.setImageResource(R.drawable.spadea);
                } else if (cards.get(0) == 208) {
                    left.setImageResource(R.drawable.heart8);
                } else if (cards.get(0) == 408) {
                    left.setImageResource(R.drawable.diamond8);
                }

                if (cards.get(1) == 101) {
                    middle.setImageResource(R.drawable.spadea);
                } else if (cards.get(1) == 208) {
                    middle.setImageResource(R.drawable.heart8);
                } else if (cards.get(1) == 408) {
                    middle.setImageResource(R.drawable.diamond8);
                }

            }
        });
    }


}
