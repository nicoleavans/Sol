package vapor.sol;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class GameBoard extends AppCompatActivity {

    ImageView drawPile, pile7_1, pile7_2, pile7_3, pile7_4, pile7_5, pile7_6, pile7_7,
            pile6_1, pile6_2, pile6_3, pile6_4, pile6_5, pile6_6,
            pile5_1, pile5_2, pile5_3, pile5_4, pile5_5,
            pile4_1, pile4_2, pile4_3, pile4_4,
            pile3_1, pile3_2, pile3_3,
            pile2_1, pile2_2,
            pile1_1;

    Context ctx = getApplicationContext();

    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_board);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mVisible = true;
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);


        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
            }
        });

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
        findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);

        drawPile = (ImageView) findViewById(R.id.drawPile);
        pile7_1 = (ImageView) findViewById(R.id.pile7_1);
        pile7_2 = (ImageView) findViewById(R.id.pile7_2);
        pile7_3 = (ImageView) findViewById(R.id.pile7_3);
        pile7_4 = (ImageView) findViewById(R.id.pile7_4);
        pile7_5 = (ImageView) findViewById(R.id.pile7_5);
        pile7_6 = (ImageView) findViewById(R.id.pile7_6);
        pile7_7 = (ImageView) findViewById(R.id.pile7_7);

        pile6_1 = (ImageView) findViewById(R.id.pile6_1);
        pile6_2 = (ImageView) findViewById(R.id.pile6_2);
        pile6_3 = (ImageView) findViewById(R.id.pile6_3);
        pile6_4 = (ImageView) findViewById(R.id.pile6_4);
        pile6_5 = (ImageView) findViewById(R.id.pile6_5);
        pile6_6 = (ImageView) findViewById(R.id.pile6_6);

        pile5_1 = (ImageView) findViewById(R.id.pile5_1);
        pile5_2 = (ImageView) findViewById(R.id.pile5_2);
        pile5_3 = (ImageView) findViewById(R.id.pile5_3);
        pile5_4 = (ImageView) findViewById(R.id.pile5_4);
        pile5_5 = (ImageView) findViewById(R.id.pile5_5);

        pile4_1 = (ImageView) findViewById(R.id.pile4_1);
        pile4_2 = (ImageView) findViewById(R.id.pile4_2);
        pile4_3 = (ImageView) findViewById(R.id.pile4_3);
        pile4_4 = (ImageView) findViewById(R.id.pile4_4);

        pile3_1 = (ImageView) findViewById(R.id.pile3_1);
        pile3_2 = (ImageView) findViewById(R.id.pile3_2);
        pile3_3 = (ImageView) findViewById(R.id.pile3_3);

        pile2_1 = (ImageView) findViewById(R.id.pile2_1);
        pile2_2 = (ImageView) findViewById(R.id.pile2_2);

        pile1_1 = (ImageView) findViewById(R.id.pile1_1);


        drawPile.setImageResource(R.drawable.cb4);
        final Animation anim_draw_pile = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.draw_pile);
        drawPile.startAnimation(anim_draw_pile);
        anim_draw_pile.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}
            @Override
            public void onAnimationEnd(Animation animation) {
                anim_draw_pile.setAnimationListener(null);
                // Start next animation
                pile7_1.setImageResource(R.drawable.cb4);
                final Animation anim_pile7_1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile7_1);
                pile7_1.startAnimation(anim_pile7_1);
                anim_pile7_1.setAnimationListener(new Animation.AnimationListener(){
                    @Override
                    public void onAnimationStart(Animation animation) { }
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        anim_pile7_1.setAnimationListener(null);
                        // Start next animation
                        pile7_2.setImageResource(R.drawable.cb4);
                        final Animation anim_pile7_2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile7_2);
                        pile7_2.startAnimation(anim_pile7_2);
                        anim_pile7_2.setAnimationListener(new Animation.AnimationListener(){
                            @Override
                            public void onAnimationStart(Animation animation) { }
                            @Override
                            public void onAnimationEnd(Animation animation) {
                                anim_pile7_2.setAnimationListener(null);
                                // Start next animation
                                pile6_1.setImageResource(R.drawable.cb4);
                                final Animation anim_pile6_1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile6_1);
                                pile6_1.startAnimation(anim_pile6_1);
                                anim_pile6_1.setAnimationListener(new Animation.AnimationListener(){
                                    @Override
                                    public void onAnimationStart(Animation animation) { }
                                    @Override
                                    public void onAnimationEnd(Animation animation) {
                                        anim_pile6_1.setAnimationListener(null);
                                        // Start next animation
                                        pile7_3.setImageResource(R.drawable.cb4);
                                        final Animation anim_pile7_3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile7_3);
                                        pile7_3.startAnimation(anim_pile7_3);
                                        anim_pile7_3.setAnimationListener(new Animation.AnimationListener(){
                                            @Override
                                            public void onAnimationStart(Animation animation) { }
                                            @Override
                                            public void onAnimationEnd(Animation animation) {
                                                anim_pile7_3.setAnimationListener(null);
                                                // Start next animation
                                                pile6_2.setImageResource(R.drawable.cb4);
                                                final Animation anim_pile6_2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile6_2);
                                                pile6_2.startAnimation(anim_pile6_2);
                                                anim_pile6_2.setAnimationListener(new Animation.AnimationListener(){
                                                    @Override
                                                    public void onAnimationStart(Animation animation) { }
                                                    @Override
                                                    public void onAnimationEnd(Animation animation) {
                                                        anim_pile6_2.setAnimationListener(null);
                                                        // Start next animation
                                                        pile5_1.setImageResource(R.drawable.cb4);
                                                        final Animation anim_pile5_1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile5_1);
                                                        pile5_1.startAnimation(anim_pile5_1);
                                                        anim_pile5_1.setAnimationListener(new Animation.AnimationListener(){
                                                            @Override
                                                            public void onAnimationStart(Animation animation) { }
                                                            @Override
                                                            public void onAnimationEnd(Animation animation) {
                                                                anim_pile5_1.setAnimationListener(null);
                                                                // Start next animation
                                                                pile7_4.setImageResource(R.drawable.cb4);
                                                                final Animation anim_pile7_4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile7_4);
                                                                pile7_4.startAnimation(anim_pile7_4);
                                                                anim_pile7_4.setAnimationListener(new Animation.AnimationListener(){
                                                                    @Override
                                                                    public void onAnimationStart(Animation animation) { }
                                                                    @Override
                                                                    public void onAnimationEnd(Animation animation) {
                                                                        anim_pile7_4.setAnimationListener(null);
                                                                        // Start next animation
                                                                        pile6_3.setImageResource(R.drawable.cb4);
                                                                        final Animation anim_pile6_3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile6_3);
                                                                        pile6_3.startAnimation(anim_pile6_3);
                                                                        anim_pile6_3.setAnimationListener(new Animation.AnimationListener(){
                                                                            @Override
                                                                            public void onAnimationStart(Animation animation) { }
                                                                            @Override
                                                                            public void onAnimationEnd(Animation animation) {
                                                                                anim_pile6_3.setAnimationListener(null);
                                                                                // Start next animation
                                                                                pile5_2.setImageResource(R.drawable.cb4);
                                                                                final Animation anim_pile5_2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile5_2);
                                                                                pile5_2.startAnimation(anim_pile5_2);
                                                                                anim_pile5_2.setAnimationListener(new Animation.AnimationListener(){
                                                                                    @Override
                                                                                    public void onAnimationStart(Animation animation) { }
                                                                                    @Override
                                                                                    public void onAnimationEnd(Animation animation) {
                                                                                        anim_pile5_2.setAnimationListener(null);
                                                                                        // Start next animation
                                                                                        pile4_1.setImageResource(R.drawable.cb4);
                                                                                        final Animation anim_pile4_1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile4_1);
                                                                                        pile4_1.startAnimation(anim_pile4_1);
                                                                                        anim_pile4_1.setAnimationListener(new Animation.AnimationListener(){
                                                                                            @Override
                                                                                            public void onAnimationStart(Animation animation) { }
                                                                                            @Override
                                                                                            public void onAnimationEnd(Animation animation) {
                                                                                                anim_pile4_1.setAnimationListener(null);
                                                                                                // Start next animation
                                                                                                pile7_5.setImageResource(R.drawable.cb4);
                                                                                                final Animation anim_pile7_5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile7_5);
                                                                                                pile7_5.startAnimation(anim_pile7_5);
                                                                                                anim_pile7_5.setAnimationListener(new Animation.AnimationListener(){
                                                                                                    @Override
                                                                                                    public void onAnimationStart(Animation animation) { }
                                                                                                    @Override
                                                                                                    public void onAnimationEnd(Animation animation) {
                                                                                                        anim_pile7_5.setAnimationListener(null);
                                                                                                        // Start next animation
                                                                                                        pile6_4.setImageResource(R.drawable.cb4);
                                                                                                        final Animation anim_pile6_4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile6_4);
                                                                                                        pile6_4.startAnimation(anim_pile6_4);
                                                                                                        anim_pile6_4.setAnimationListener(new Animation.AnimationListener(){
                                                                                                            @Override
                                                                                                            public void onAnimationStart(Animation animation) { }
                                                                                                            @Override
                                                                                                            public void onAnimationEnd(Animation animation) {
                                                                                                                anim_pile6_4.setAnimationListener(null);
                                                                                                                // Start next animation
                                                                                                                pile5_3.setImageResource(R.drawable.cb4);
                                                                                                                final Animation anim_pile5_3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile5_3);
                                                                                                                pile5_3.startAnimation(anim_pile5_3);
                                                                                                                anim_pile5_3.setAnimationListener(new Animation.AnimationListener(){
                                                                                                                    @Override
                                                                                                                    public void onAnimationStart(Animation animation) { }
                                                                                                                    @Override
                                                                                                                    public void onAnimationEnd(Animation animation) {
                                                                                                                        anim_pile5_3.setAnimationListener(null);
                                                                                                                        // Start next animation
                                                                                                                        pile4_2.setImageResource(R.drawable.cb4);
                                                                                                                        final Animation anim_pile4_2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile4_2);
                                                                                                                        pile4_2.startAnimation(anim_pile4_2);
                                                                                                                        anim_pile4_2.setAnimationListener(new Animation.AnimationListener(){
                                                                                                                            @Override
                                                                                                                            public void onAnimationStart(Animation animation) { }
                                                                                                                            @Override
                                                                                                                            public void onAnimationEnd(Animation animation) {
                                                                                                                                anim_pile4_2.setAnimationListener(null);
                                                                                                                                // Start next animation
                                                                                                                                pile3_1.setImageResource(R.drawable.cb4);
                                                                                                                                final Animation anim_pile3_1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile3_1);
                                                                                                                                pile3_1.startAnimation(anim_pile3_1);
                                                                                                                                anim_pile3_1.setAnimationListener(new Animation.AnimationListener(){
                                                                                                                                    @Override
                                                                                                                                    public void onAnimationStart(Animation animation) { }
                                                                                                                                    @Override
                                                                                                                                    public void onAnimationEnd(Animation animation) {
                                                                                                                                        anim_pile3_1.setAnimationListener(null);
                                                                                                                                        // Start next animation
                                                                                                                                        pile7_6.setImageResource(R.drawable.cb4);
                                                                                                                                        final Animation anim_pile7_6 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile7_6);
                                                                                                                                        pile7_6.startAnimation(anim_pile7_6);
                                                                                                                                        anim_pile7_6.setAnimationListener(new Animation.AnimationListener(){
                                                                                                                                            @Override
                                                                                                                                            public void onAnimationStart(Animation animation) { }
                                                                                                                                            @Override
                                                                                                                                            public void onAnimationEnd(Animation animation) {
                                                                                                                                                anim_pile7_6.setAnimationListener(null);
                                                                                                                                                // Start next animation
                                                                                                                                                pile6_5.setImageResource(R.drawable.cb4);
                                                                                                                                                final Animation anim_pile6_5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile6_5);
                                                                                                                                                pile6_5.startAnimation(anim_pile6_5);
                                                                                                                                                anim_pile6_5.setAnimationListener(new Animation.AnimationListener(){
                                                                                                                                                    @Override
                                                                                                                                                    public void onAnimationStart(Animation animation) { }
                                                                                                                                                    @Override
                                                                                                                                                    public void onAnimationEnd(Animation animation) {
                                                                                                                                                        anim_pile6_5.setAnimationListener(null);
                                                                                                                                                        // Start next animation
                                                                                                                                                        pile5_4.setImageResource(R.drawable.cb4);
                                                                                                                                                        final Animation anim_pile5_4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile5_4);
                                                                                                                                                        pile5_4.startAnimation(anim_pile5_4);
                                                                                                                                                        anim_pile5_4.setAnimationListener(new Animation.AnimationListener(){
                                                                                                                                                            @Override
                                                                                                                                                            public void onAnimationStart(Animation animation) { }
                                                                                                                                                            @Override
                                                                                                                                                            public void onAnimationEnd(Animation animation) {
                                                                                                                                                                anim_pile5_4.setAnimationListener(null);
                                                                                                                                                                // Start next animation
                                                                                                                                                                pile4_3.setImageResource(R.drawable.cb4);
                                                                                                                                                                final Animation anim_pile4_3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile4_3);
                                                                                                                                                                pile4_3.startAnimation(anim_pile4_3);
                                                                                                                                                                anim_pile4_3.setAnimationListener(new Animation.AnimationListener(){
                                                                                                                                                                    @Override
                                                                                                                                                                    public void onAnimationStart(Animation animation) { }
                                                                                                                                                                    @Override
                                                                                                                                                                    public void onAnimationEnd(Animation animation) {
                                                                                                                                                                        anim_pile4_3.setAnimationListener(null);
                                                                                                                                                                        // Start next animation
                                                                                                                                                                        pile3_2.setImageResource(R.drawable.cb4);
                                                                                                                                                                        final Animation anim_pile3_2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile3_2);
                                                                                                                                                                        pile3_2.startAnimation(anim_pile3_2);
                                                                                                                                                                        anim_pile3_2.setAnimationListener(new Animation.AnimationListener(){
                                                                                                                                                                            @Override
                                                                                                                                                                            public void onAnimationStart(Animation animation) { }
                                                                                                                                                                            @Override
                                                                                                                                                                            public void onAnimationEnd(Animation animation) {
                                                                                                                                                                                anim_pile3_2.setAnimationListener(null);
                                                                                                                                                                                // Start next animation
                                                                                                                                                                                pile2_1.setImageResource(R.drawable.cb4);
                                                                                                                                                                                final Animation anim_pile2_1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile2_1);
                                                                                                                                                                                pile2_1.startAnimation(anim_pile2_1);
                                                                                                                                                                                anim_pile2_1.setAnimationListener(new Animation.AnimationListener(){
                                                                                                                                                                                    @Override
                                                                                                                                                                                    public void onAnimationStart(Animation animation) { }
                                                                                                                                                                                    @Override
                                                                                                                                                                                    public void onAnimationEnd(Animation animation) {
                                                                                                                                                                                        anim_pile2_1.setAnimationListener(null);
                                                                                                                                                                                        // Start next animation
                                                                                                                                                                                        pile7_7.setImageResource(R.drawable.cb4);
                                                                                                                                                                                        final Animation anim_pile7_7 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile7_7);
                                                                                                                                                                                        pile7_7.startAnimation(anim_pile7_7);
                                                                                                                                                                                        anim_pile7_7.setAnimationListener(new Animation.AnimationListener(){
                                                                                                                                                                                            @Override
                                                                                                                                                                                            public void onAnimationStart(Animation animation) { }
                                                                                                                                                                                            @Override
                                                                                                                                                                                            public void onAnimationEnd(Animation animation) {
                                                                                                                                                                                                anim_pile7_7.setAnimationListener(null);
                                                                                                                                                                                                // Start next animation
                                                                                                                                                                                                pile6_6.setImageResource(R.drawable.cb4);
                                                                                                                                                                                                final Animation anim_pile6_6 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile6_6);
                                                                                                                                                                                                pile6_6.startAnimation(anim_pile6_6);
                                                                                                                                                                                                anim_pile6_6.setAnimationListener(new Animation.AnimationListener(){
                                                                                                                                                                                                    @Override
                                                                                                                                                                                                    public void onAnimationStart(Animation animation) { }
                                                                                                                                                                                                    @Override
                                                                                                                                                                                                    public void onAnimationEnd(Animation animation) {
                                                                                                                                                                                                        anim_pile6_6.setAnimationListener(null);
                                                                                                                                                                                                        // Start next animation
                                                                                                                                                                                                        pile5_5.setImageResource(R.drawable.cb4);
                                                                                                                                                                                                        final Animation anim_pile5_5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile5_5);
                                                                                                                                                                                                        pile5_5.startAnimation(anim_pile5_5);
                                                                                                                                                                                                        anim_pile5_5.setAnimationListener(new Animation.AnimationListener(){
                                                                                                                                                                                                            @Override
                                                                                                                                                                                                            public void onAnimationStart(Animation animation) { }
                                                                                                                                                                                                            @Override
                                                                                                                                                                                                            public void onAnimationEnd(Animation animation) {
                                                                                                                                                                                                                anim_pile5_5.setAnimationListener(null);
                                                                                                                                                                                                                // Start next animation
                                                                                                                                                                                                                pile4_4.setImageResource(R.drawable.cb4);
                                                                                                                                                                                                                final Animation anim_pile4_4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile4_4);
                                                                                                                                                                                                                pile4_4.startAnimation(anim_pile4_4);
                                                                                                                                                                                                                anim_pile4_4.setAnimationListener(new Animation.AnimationListener(){
                                                                                                                                                                                                                    @Override
                                                                                                                                                                                                                    public void onAnimationStart(Animation animation) { }
                                                                                                                                                                                                                    @Override
                                                                                                                                                                                                                    public void onAnimationEnd(Animation animation) {
                                                                                                                                                                                                                        anim_pile4_4.setAnimationListener(null);
                                                                                                                                                                                                                        // Start next animation
                                                                                                                                                                                                                        pile3_3.setImageResource(R.drawable.cb4);
                                                                                                                                                                                                                        final Animation anim_pile3_3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile3_3);
                                                                                                                                                                                                                        pile3_3.startAnimation(anim_pile3_3);
                                                                                                                                                                                                                        anim_pile3_3.setAnimationListener(new Animation.AnimationListener(){
                                                                                                                                                                                                                            @Override
                                                                                                                                                                                                                            public void onAnimationStart(Animation animation) { }
                                                                                                                                                                                                                            @Override
                                                                                                                                                                                                                            public void onAnimationEnd(Animation animation) {
                                                                                                                                                                                                                                anim_pile3_3.setAnimationListener(null);
                                                                                                                                                                                                                                // Start next animation
                                                                                                                                                                                                                                pile2_2.setImageResource(R.drawable.cb4);
                                                                                                                                                                                                                                final Animation anim_pile2_2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile2_2);
                                                                                                                                                                                                                                pile2_2.startAnimation(anim_pile2_2);
                                                                                                                                                                                                                                anim_pile2_2.setAnimationListener(new Animation.AnimationListener(){
                                                                                                                                                                                                                                    @Override
                                                                                                                                                                                                                                    public void onAnimationStart(Animation animation) { }
                                                                                                                                                                                                                                    @Override
                                                                                                                                                                                                                                    public void onAnimationEnd(Animation animation) {
                                                                                                                                                                                                                                        anim_pile2_2.setAnimationListener(null);
                                                                                                                                                                                                                                        // Start next animation
                                                                                                                                                                                                                                        pile1_1.setImageResource(R.drawable.cb4);
                                                                                                                                                                                                                                        final Animation anim_pile1_1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.pile1_1);
                                                                                                                                                                                                                                        pile1_1.startAnimation(anim_pile1_1);
                                                                                                                                                                                                                                        anim_pile1_1.setAnimationListener(new Animation.AnimationListener(){
                                                                                                                                                                                                                                            @Override
                                                                                                                                                                                                                                            public void onAnimationStart(Animation animation) { }
                                                                                                                                                                                                                                            @Override
                                                                                                                                                                                                                                            public void onAnimationEnd(Animation animation) {
                                                                                                                                                                                                                                                anim_pile1_1.setAnimationListener(null);
                                                                                                                                                                                                                                                // Start next animation
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                            @Override
                                                                                                                                                                                                                                            public void onAnimationRepeat(Animation animation) { }
                                                                                                                                                                                                                                        });
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                    @Override
                                                                                                                                                                                                                                    public void onAnimationRepeat(Animation animation) { }
                                                                                                                                                                                                                                });
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            @Override
                                                                                                                                                                                                                            public void onAnimationRepeat(Animation animation) { }
                                                                                                                                                                                                                        });
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    @Override
                                                                                                                                                                                                                    public void onAnimationRepeat(Animation animation) { }
                                                                                                                                                                                                                });
                                                                                                                                                                                                            }
                                                                                                                                                                                                            @Override
                                                                                                                                                                                                            public void onAnimationRepeat(Animation animation) { }
                                                                                                                                                                                                        });
                                                                                                                                                                                                    }
                                                                                                                                                                                                    @Override
                                                                                                                                                                                                    public void onAnimationRepeat(Animation animation) { }
                                                                                                                                                                                                });
                                                                                                                                                                                            }
                                                                                                                                                                                            @Override
                                                                                                                                                                                            public void onAnimationRepeat(Animation animation) { }
                                                                                                                                                                                        });
                                                                                                                                                                                    }
                                                                                                                                                                                    @Override
                                                                                                                                                                                    public void onAnimationRepeat(Animation animation) { }
                                                                                                                                                                                });
                                                                                                                                                                            }
                                                                                                                                                                            @Override
                                                                                                                                                                            public void onAnimationRepeat(Animation animation) { }
                                                                                                                                                                        });
                                                                                                                                                                    }
                                                                                                                                                                    @Override
                                                                                                                                                                    public void onAnimationRepeat(Animation animation) { }
                                                                                                                                                                });
                                                                                                                                                            }
                                                                                                                                                            @Override
                                                                                                                                                            public void onAnimationRepeat(Animation animation) { }
                                                                                                                                                        });
                                                                                                                                                    }
                                                                                                                                                    @Override
                                                                                                                                                    public void onAnimationRepeat(Animation animation) { }
                                                                                                                                                });
                                                                                                                                            }
                                                                                                                                            @Override
                                                                                                                                            public void onAnimationRepeat(Animation animation) { }
                                                                                                                                        });
                                                                                                                                    }
                                                                                                                                    @Override
                                                                                                                                    public void onAnimationRepeat(Animation animation) { }
                                                                                                                                });
                                                                                                                            }
                                                                                                                            @Override
                                                                                                                            public void onAnimationRepeat(Animation animation) { }
                                                                                                                        });
                                                                                                                    }
                                                                                                                    @Override
                                                                                                                    public void onAnimationRepeat(Animation animation) { }
                                                                                                                });
                                                                                                            }
                                                                                                            @Override
                                                                                                            public void onAnimationRepeat(Animation animation) { }
                                                                                                        });
                                                                                                    }
                                                                                                    @Override
                                                                                                    public void onAnimationRepeat(Animation animation) { }
                                                                                                });
                                                                                            }
                                                                                            @Override
                                                                                            public void onAnimationRepeat(Animation animation) { }
                                                                                        });
                                                                                    }
                                                                                    @Override
                                                                                    public void onAnimationRepeat(Animation animation) { }
                                                                                });
                                                                            }
                                                                            @Override
                                                                            public void onAnimationRepeat(Animation animation) { }
                                                                        });
                                                                    }
                                                                    @Override
                                                                    public void onAnimationRepeat(Animation animation) { }
                                                                });
                                                            }
                                                            @Override
                                                            public void onAnimationRepeat(Animation animation) { }
                                                        });
                                                    }
                                                    @Override
                                                    public void onAnimationRepeat(Animation animation) { }
                                                });
                                            }
                                            @Override
                                            public void onAnimationRepeat(Animation animation) { }
                                        });
                                    }
                                    @Override
                                    public void onAnimationRepeat(Animation animation) { }
                                });
                            }
                            @Override
                            public void onAnimationRepeat(Animation animation) { }
                        });

                    }
                    @Override
                    public void onAnimationRepeat(Animation animation) { }
                });

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        final String cl = "clubs";
        final String di = "diamonds";
        final String sp = "spades";
        final String he = "hearts";

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

        Deck d = new Deck(ctx);
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


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button.
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }
}
