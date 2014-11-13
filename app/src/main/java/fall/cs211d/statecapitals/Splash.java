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


public class Splash extends Activity
{

    Button start;
    Button score;
    Button quit;

    @Override
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        start = (Button) findViewById(R.id.startGameButton);
        score = (Button) findViewById(R.id.scoreButton);
        quit = (Button) findViewById(R.id.quitButton);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
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
/************** startGame ***********************************************************************/
    public void startGame(View view) {
        Log.e("STATE_CAP", "START button clicked");
        Intent game = new Intent(this, Game.class);
        startActivity(game);
    }

/************** viewScore ***********************************************************************/
    public void viewScore(View view) {
        Log.e("STATE_CAP", "SCORE button clicked");
    }

/************** quitGame ***********************************************************************/
    public void quitGame(View view) {
        Log.e("STATE_CAP", "QUIT button clicked");
    }
}
