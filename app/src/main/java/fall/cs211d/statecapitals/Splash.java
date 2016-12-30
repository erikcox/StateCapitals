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
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Splash extends Activity
{

    Button startBtn;
    Button scoreBtn;
    Button quitBtn;
    SQLiteDatabase stateDb;

    @Override
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        parseStates();

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

    /**
     * *********** startGame() ******************************************************************
     */
    public void startGame(View view)
    {
        Log.e("STATE_CAP", "START button clicked");
        Intent game = new Intent(this, Game.class);
        startActivity(game);
        finish();
    }

    /**
     * *********** viewScore() ******************************************************************
     */
    public void viewScore(View view)
    {
        Log.e("STATE_CAP", "SCORE button clicked");
        Intent score = new Intent(this, TopScores.class);
        startActivity(score);
        finish();
    }

    /**
     * *********** quitGame() *******************************************************************
     */
    public void quitGame(View view)
    {
        Log.e("STATE_CAP", "QUIT button clicked");
        finish();
    }

    /**
     * *********** parseStates() ****************************************************************
     */
    public void parseStates()
    {
        stateDb = openOrCreateDatabase("states.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        File dbloc = this.getDatabasePath("states.db");

        if (dbloc.exists())
        {
            // nothing to do, just load it
            Log.d("STATE_CAP", "dbloc exists"); // For debug
        }else
        {
            try
            {
                Log.d("STATE_CAP", "dbloc doesn't exist"); // For debug
                String states[] = new String[50];
                String capitals[] = new String[50];
                Scanner sc = new Scanner(getResources().openRawResource(R.raw.us_states));
                String line;
                int i = 0;

                sc.nextLine();
                sc.nextLine(); // skip over couple of headers

                while (sc.hasNext())
                {
                    line = sc.nextLine();
                    String temp[] = line.split("\\s\\s+");
                    if (temp.length >= 2)
                    {
                        if (temp.length == 2)
                        {
                            states[i] = temp[0];
                            capitals[i++] = temp[1];
                        } else
                        {
                            states[i] = temp[0] + " " + temp[1];
                            capitals[i++] = temp[2];
                        }
                    }
                    sc.close();
                }
                // Create a hash map
                Map<String, String> map = new HashMap<String, String>();

                for (i = 0; i < states.length; i++)
                {
                    map.put(states[i], capitals[i]);
                }
                Log.e("STATE_CAP", map.toString()); // For debug
                // Create table
                stateDb.execSQL("CREATE TABLE States(P_Id int NOT NULL, State varchar(255) +" +
                        "NOT NULL, Capital varchar(255) NOT NULL, PRIMARY KEY (P_Id));");
                // Add values
                String InsertQuery = "INSERT INTO States (P_Id, State, Capital) " +
                        "VALUES(NULL, '" + map.get(states) + "', '" + map.get(capitals) + "');'";
                stateDb.execSQL(InsertQuery);
            } catch (Exception exc)
            {
                Log.e("STATE_CAP", "File Not Found: us_states" + exc);
            }
        }
    }
}
