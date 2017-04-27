package vapor.sol;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Intent myIntent = null;

    ImageView Corey, David, Kaleb, Nicole;

    TextView C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                myIntent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(myIntent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Corey = (ImageView) findViewById(R.id.Corey);
        David = (ImageView) findViewById(R.id.David);
        Kaleb = (ImageView) findViewById(R.id.Kaleb);
        Nicole = (ImageView) findViewById(R.id.Nicole);

        C = (TextView) findViewById(R.id.team_text);

        Corey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // assign images
                Corey.setImageResource(R.drawable.bio_corey);
                David.setImageResource(R.drawable.cb6);
                Kaleb.setImageResource(R.drawable.cb1);
                Nicole.setImageResource(R.drawable.cb5);

                C.setText(R.string.corey);
            }
        });

        David.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // assign images
                Corey.setImageResource(R.drawable.cb4);
                David.setImageResource(R.drawable.bio_david);
                Kaleb.setImageResource(R.drawable.cb1);
                Nicole.setImageResource(R.drawable.cb5);

                C.setText(R.string.david);
            }
        });

        Kaleb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // assign images
                Corey.setImageResource(R.drawable.cb4);
                David.setImageResource(R.drawable.cb6);
                Kaleb.setImageResource(R.drawable.bio_kaleb);
                Nicole.setImageResource(R.drawable.cb5);

                C.setText(R.string.kaleb);
            }
        });

        Nicole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // assign images
                Corey.setImageResource(R.drawable.cb4);
                David.setImageResource(R.drawable.cb6);
                Kaleb.setImageResource(R.drawable.cb1);
                Nicole.setImageResource(R.drawable.bio_nicole);

                C.setText(R.string.nicole);
            }
        });

    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            myIntent = new Intent(Main2Activity.this, SettingsActivity.class);
            startActivity(myIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        final int id = item.getItemId();


        if (id == R.id.nav_cups) {
            //cups logic
            myIntent = new Intent(Main2Activity.this, Cups.class);
            //startActivity(myIntent);
        } else if (id == R.id.nav_gallery) {
            myIntent = new Intent(Main2Activity.this, GameBoard.class);
        } else if (id == R.id.nav_slideshow) {
            //Toast.makeText(Main2Activity.this, "Area Currently Under Development.  ¯\\_(ツ)_/¯", Toast.LENGTH_SHORT).show();
            //myIntent = new Intent(Main2Activity.this, Main2Activity.class);
            Uri uri = Uri.parse("https://en.wikipedia.org/wiki/Klondike_(solitaire)#Rules"); // missing 'http://' will cause crashed
            myIntent = new Intent(Intent.ACTION_VIEW, uri);
        } else if (id == R.id.nav_manage) {
            Toast.makeText(Main2Activity.this, "Area Currently Under Development.  ¯\\_(ツ)_/¯", Toast.LENGTH_SHORT).show();
            myIntent = new Intent(Main2Activity.this, Main2Activity.class);
        } else if (id == R.id.nav_share) {
            Toast.makeText(Main2Activity.this, "Area Currently Under Development.  ¯\\_(ツ)_/¯", Toast.LENGTH_SHORT).show();
            myIntent = new Intent(Main2Activity.this, Main2Activity.class);
        } else if (id == R.id.nav_send) {
            Toast.makeText(Main2Activity.this, "Area Currently Under Development.  ¯\\_(ツ)_/¯", Toast.LENGTH_SHORT).show();
            myIntent = new Intent(Main2Activity.this, Main2Activity.class);
        }

        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //drawer.closeDrawer(GravityCompat.START);
        startActivity(myIntent);
        return true;
    }
}
