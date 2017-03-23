package vapor.sol;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This method builds a 52 card deck.
 */

class Deck {
	ArrayList<Card> pile;
    Context ctx;
    /*
     * Constructor
     */
     Deck(Context ctx) {
        this.ctx = ctx.getApplicationContext();
        final String clubs = "clubs";
        final String diamonds = "diamonds";
        final String spades = "spades";
        final String hearts = "hearts";

        Bitmap cb1;
        Bitmap cb2;
        Bitmap cb3;
        Bitmap cb4;
        Bitmap cb5;
        Bitmap cb6;
        Bitmap cluba;
        Bitmap club2;
        Bitmap club3;
        Bitmap club4;
        Bitmap club5;
        Bitmap club6;
        Bitmap club7;
        Bitmap club8;
        Bitmap club9;
        Bitmap club10;
        Bitmap clubj;
        Bitmap clubq;
        Bitmap clubk;
        Bitmap diamonda;
        Bitmap diamond2;
        Bitmap diamond3;
        Bitmap diamond4;
        Bitmap diamond5;
        Bitmap diamond6;
        Bitmap diamond7;
        Bitmap diamond8;
        Bitmap diamond9;
        Bitmap diamond10;
        Bitmap diamondj;
        Bitmap diamondq;
        Bitmap diamondk;
        Bitmap hearta;
        Bitmap heart2;
        Bitmap heart3;
        Bitmap heart4;
        Bitmap heart5;
        Bitmap heart6;
        Bitmap heart7;
        Bitmap heart8;
        Bitmap heart9;
        Bitmap heart10;
        Bitmap heartj;
        Bitmap heartq;
        Bitmap heartk;
        Bitmap spadea;
        Bitmap spade2;
        Bitmap spade3;
        Bitmap spade4;
        Bitmap spade5;
        Bitmap spade6;
        Bitmap spade7;
        Bitmap spade8;
        Bitmap spade9;
        Bitmap spade10;
        Bitmap spadej;
        Bitmap spadeq;
        Bitmap spadek;

        cluba = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.cluba);
        club2 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.club2);
        club3 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.club3);
        club4 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.club4);
        club5 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.club5);
        club6 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.club6);
        club7 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.club7);
        club8 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.club8);
        club9 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.club9);
        club10 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.club10);
        clubj = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.clubj);
        clubq = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.clubq);
        clubk = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.clubk);

        hearta = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.hearta);
        heart2 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.heart2);
        heart3 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.heart3);
        heart4 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.heart4);
        heart5 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.heart5);
        heart6 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.heart6);
        heart7 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.heart7);
        heart8 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.heart8);
        heart9 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.heart9);
        heart10 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.heart10);
        heartj = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.heartj);
        heartq = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.heartq);
        heartk = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.heartk);

        diamonda = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.diamonda);
        diamond2 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.diamond2);
        diamond3 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.diamond3);
        diamond4 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.diamond4);
        diamond5 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.diamond5);
        diamond6 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.diamond6);
        diamond7 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.diamond7);
        diamond8 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.diamond8);
        diamond9 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.diamond9);
        diamond10 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.diamond10);
        diamondj = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.diamondj);
        diamondq = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.diamondq);
        diamondk = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.diamondk);

        spadea = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.spadea);
        spade2 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.spade2);
        spade3 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.spade3);
        spade4 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.spade4);
        spade5 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.spade5);
        spade6 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.spade6);
        spade7 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.spade7);
        spade8 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.spade8);
        spade9 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.spade9);
        spade10 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.spade10);
        spadej = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.spadej);
        spadeq = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.spadeq);
        spadek = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.spadek);

        cb1 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.cluba);
        cb2 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.club2);
        cb3 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.club3);
        cb4 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.club4);
        cb5 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.club5);
        cb6 = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.club6);

        Random ran = new Random();
        Bitmap back;
        int z = ran.nextInt(5);
        if(z == 0){
            back = cb1;
        }
        else if(z == 1){
            back = cb2;
        }
        else if(z == 2){
            back = cb3;
        }
        else if(z == 3){
            back = cb4;
        }
        else if(z == 4){
            back = cb5;
        }
        else{
            back = cb6;
        }

        //4 suits, 4 loops
        for (int i = 4; i > 0; i--) {
            //clubs
            //ints go up to thirteen to cover number and face cards
            if(i == 4){
                for (int j = 1; j <= 13; j++) {
                    Card c = new Card(clubs, "black", j);
                    if (j == 1) {
                        c.face = cluba;
                        c.back = back;
                    } else if (j == 2) {
                        c.face = club2;
                        c.back = back;
                    } else if (j == 3) {
                        c.face = club3;
                        c.back = back;
                    } else if (j == 4) {
                        c.face = club4;
                        c.back = back;
                    } else if (j == 5) {
                        c.face = club5;
                        c.back = back;
                    } else if (j == 6) {
                        c.face = club6;
                        c.back = back;
                    } else if (j == 7) {
                        c.face = club7;
                        c.back = back;
                    } else if (j == 8) {
                        c.face = club8;
                        c.back = back;
                    } else if (j == 9) {
                        c.face = club9;
                        c.back = back;
                    } else if (j == 10) {
                        c.face = club10;
                        c.back = back;
                    } else if (j == 11) {
                        c.face = clubj;
                        c.back = back;
                    } else if (j == 12) {
                        c.face = clubq;
                        c.back = back;
                    } else {
                        c.face = clubk;
                        c.back = back;
                    }
                    pile.add(c);
                }
            }
            else if (i == 3) {
                for (int j = 1; j <= 13; j++) {
                    Card c = new Card(spades, "black", j);
                    if(j == 1){
                        c.face = spadea;
                        c.back = back;
                    }
                    else if(j == 2){
                        c.face = spade2;
                        c.back = back;
                    }
                    else if(j == 3){
                        c.face = spade3;
                        c.back = back;
                    }
                    else if(j == 4){
                        c.face = spade4;
                        c.back = back;
                    }
                    else if(j == 5){
                        c.face = spade5;
                        c.back = back;
                    }
                    else if(j == 6){
                        c.face = spade6;
                        c.back = back;
                    }
                    else if(j == 7){
                        c.face = spade7;
                        c.back = back;
                    }
                    else if(j == 8){
                        c.face = spade8;
                        c.back = back;
                    }
                    else if(j == 9){
                        c.face = spade9;
                        c.back = back;
                    }
                    else if(j == 10){
                        c.face = spade10;
                        c.back = back;
                    }
                    else if(j == 11){
                        c.face = spadej;
                        c.back = back;
                    }
                    else if(j == 12){
                        c.face = spadeq;
                        c.back = back;
                    }
                    else{
                        c.face = spadek;
                        c.back = back;
                    }
                    pile.add(c);
                }
            }
            //hearts
            else if (i == 2) {
                for (int j = 1; j <= 13; j++) {
                    Card c = new Card(hearts, "red", j);
                    if(j == 1){
                        c.face = hearta;
                        c.back = back;
                    }
                    else if(j == 2){
                        c.face = heart2;
                        c.back = back;
                    }
                    else if(j == 3){
                        c.face = heart3;
                        c.back = back;
                    }
                    else if(j == 4){
                        c.face = heart4;
                        c.back = back;
                    }
                    else if(j == 5){
                        c.face = heart5;
                        c.back = back;
                    }
                    else if(j == 6){
                        c.face = heart6;
                        c.back = back;
                    }
                    else if(j == 7){
                        c.face = heart7;
                        c.back = back;
                    }
                    else if(j == 8){
                        c.face = heart8;
                        c.back = back;
                    }
                    else if(j == 9){
                        c.face = heart9;
                        c.back = back;
                    }
                    else if(j == 10){
                        c.face = heart10;
                        c.back = back;
                    }
                    else if(j == 11){
                        c.face = heartj;
                        c.back = back;
                    }
                    else if(j == 12){
                        c.face = heartq;
                        c.back = back;
                    }
                    else{
                        c.face = heartk;
                        c.back = back;
                    }
                    pile.add(c);
                }
            }
            //diamonds
            else if(i == 1){
                for(int j = 1; j <= 13; j++){
                    Card c = new Card(diamonds, "red", j);
                    if(j == 1){
                        c.face = diamonda;
                        c.back = back;
                    }
                    else if(j == 2){
                        c.face = diamond2;
                        c.back = back;
                    }
                    else if(j == 3){
                        c.face = diamond3;
                        c.back = back;
                    }
                    else if(j == 4){
                        c.face = diamond4;
                        c.back = back;
                    }
                    else if(j == 5){
                        c.face = diamond5;
                        c.back = back;
                    }
                    else if(j == 6){
                        c.face = diamond6;
                        c.back = back;
                    }
                    else if(j == 7){
                        c.face = diamond7;
                        c.back = back;
                    }else if(j == 8){
                        c.face = diamond8;
                        c.back = back;
                    }
                    else if(j == 9){
                        c.face = diamond9;
                        c.back = back;
                    }
                    else if(j == 10){
                        c.face = diamond10;
                        c.back = back;
                    }
                    else if(j == 11){
                        c.face = diamondj;
                        c.back = back;
                    }
                    else if(j == 12){
                        c.face = diamondq;
                        c.back = back;
                    }
                    else{
                        c.face = diamondk;
                        c.back = back;
                    }
                    pile.add(c);
                }
            }
        }
        //should theoretically shuffle the deck after making it
        Collections.shuffle(pile);
        //debug
        //System.out.println(pile);

    }
}
