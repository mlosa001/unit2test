package org.pursuit.unit_02_assessment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private EditText inputEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        // TODO: Set an OnClickListener for the FloatingActionButton "fab" object, and in the onClick method, add an implicit intent to "send to" a mail app an email message to "mail.pursuit.org", with the subject "Email from Pursuit", and the body text of "This is my text!".

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // TODO: Create an instance of the RandomGame class, and a field of type "int" which will store a random number using a method from the RandomGame class. Set the OnClickListener for the Button "submitButton" object.
        // TODO: In the onClick method of the listener, use methods from the RandomGame class to check if the number in the EditText matches the number in the field above. If they match, send the winning phrase to the next activity called "SecondActivity", with an explicit intent, and an intent extra with the key "result", and the winning phrase as the value. If not, change the TextView "info_textview" text to display the losing phrase.
        // TODO: Create another activity called "SecondActivity", and add it to the Android Manifest, adding also the "MainActivity" as its parent activity. Add a TextView to "SecondActivity", with an id of "second_textView", set its height and width to "match_parent". Set its color to black, and set its font to "Cursive".
        // TODO: In the activity "SecondActivity", get the intent extra using the key "result", and use the String value it returns to set the value of the TextView "second_textView".
        // TODO: Use the "onSavedInstanceState" method to save the values of each of the TextViews/EditTexts of both activities prior to orientation change, and set their values in the onCreate method.
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_toast) {
            // TODO: Write code to handle the "Toast" Option click, and display a Toast to the screen with the text "Hello, Pursuit!".
                Toast toast = Toast.makeText(this, R.string.toast_message,
                        Toast.LENGTH_SHORT);
                toast.show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_map_location) {
            // Parse the location and create the intent.
            Uri addressUri = Uri.parse("geo:0,0?q=40.7429595,-73.94192149999998(Pursuit Android HQ)");
            Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
//            startActivity(intent);
             //Find an activity to handle the intent, and start that activity.
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Log.d("ImplicitIntents", "Can't handle this intent!");
            }

//            return true;

        }
          if(id == R.id.nav_phone){
            Uri phoneUri = Uri.parse("2125551212");
            Intent intent = new Intent(Intent.ACTION_DIAL, phoneUri);

              //Find an activity to handle the intent, and start that activity.
              if (intent.resolveActivity(getPackageManager()) != null) {
                  startActivity(intent);
              } else {
                  Log.d("ImplicitIntents", "Can't handle this intent!");
              }

              return true;        }

         if(id == R.id.nav_sms){

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            int textMessage = 2125551212;
            sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
            sendIntent.setType("text/plain");



        }

        // TODO: If the user selects the "nav_phone" view, add an implicit intent to "dial" the number "2125551212" in the phone app.
        // TODO: If the user selects the "nav_sms" view, add an implicit intent to "send to" the number "2125551212" in the sms text messaging app the message "Welcome to Pursuit!".
        // TODO: If the user selects the "nav_map_location" view, add an implicit intent to "view" the coordinates "0,0?q=40.7429595,-73.94192149999998(Pursuit Android HQ)" in the Google Maps app.
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
