/*
 Author: Erik Cox
 Date  : 11/04/14
 Homework Assignment: US State Capital Game
 File Name: Splash.java
 Objective: This is a quiz game for U.S. state capitals.
            This activity is for the splash page.
*/

package fall.cs211d.statecapitals;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Splash extends Activity
{

    Button startBtn;
    Button scoreBtn;
    Button quitBtn;

    @Override
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        //parseStates();

        startBtn = (Button) findViewById(R.id.startGameButton);
        scoreBtn = (Button) findViewById(R.id.scoreButton);
        quitBtn = (Button) findViewById(R.id.quitButton);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /************** startGame() *******************************************************************/
    public void startGame(View view) {
        Log.e("STATE_CAP", "START button clicked");
        Intent game = new Intent(this, Game.class);
        startActivity(game);
        finish();
    }

    /************** viewScore() *******************************************************************/
    public void viewScore(View view) {
        Log.e("STATE_CAP", "SCORE button clicked");
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
