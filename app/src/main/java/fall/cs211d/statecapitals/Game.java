/*
 Author: Erik Cox
 Date  : 11/04/14
 Homework Assignment: US State Capital Game
 File Name: Game.java
 Objective: This is a quiz game for U.S. state capitals.
            This activity is for the game page.
*/

package fall.cs211d.statecapitals;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;


public class Game extends Activity
{

    Button submitScoreBtn;
    Button homeBtn;
    Button quitBtn;

    @Override
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game);

        submitScoreBtn = (Button) findViewById(R.id.submitGameButton);
        homeBtn = (Button) findViewById(R.id.homeButton);
        quitBtn = (Button) findViewById(R.id.quitButton);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /************** homeScreen() ******************************************************************/
    public void homeScreen(View view) {
        Log.e("STATE_CAP", "HOME button clicked");
        // TODO: add validation / warning before leaving this page
        Intent splash = new Intent(this, Splash.class);
        startActivity(splash);
        finish();
    }

    /************** viewScore() *******************************************************************/
    public void viewScore(View view) {
        Log.e("STATE_CAP", "SCORE button clicked");
        // TODO: Add some logic to pass in the score & validate the input
        Intent score = new Intent(this, TopScores.class);
        startActivity(score);
        finish();
    }

    /************** quitGame() ********************************************************************/
    public void quitGame(View view) {
        Log.e("STATE_CAP", "QUIT button clicked");
        finish();
    }
}
