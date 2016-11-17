package creatingnew.kz.crazymathematician;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private static final String SHARED_PREFS_NAME = "creatingnew.kz.crazymathematician.sharedprefs";
    private static final String SHARED_PREFS_SCORE_KEY = "score";
    private static final int REQUEST_CODE_PLAY = 1;
    private TextView scoreTextView;
    private Button playButton;
    private int score = 0;
    private SharedPreferences sharedPreferences;
    private Button hsButton;
    private Button historyButton;
    private Button multiButton;

    private EditText etTextDb;

    private Realm realm;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        playButton = (Button) findViewById(R.id.playButton);
        realm = Realm.getInstance(getApplicationContext());
        historyButton = (Button)findViewById(R.id.historyButton);
        multiButton = (Button)findViewById(R.id.multiButton);

        hsButton = (Button) findViewById(R.id.hsButton);
        etTextDb = (EditText) findViewById(R.id.etTextDb);

        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onHistoryButtonClick();
            }
        });
        multiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMultiButtonClick();
            }
        });
        hsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onHsButtonClick();
            }
        });
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayButtonClick();
            }
        });
        sharedPreferences = getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        score = sharedPreferences.getInt(SHARED_PREFS_SCORE_KEY, 0);

        scoreTextView.setText("" + score);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void onMultiButtonClick() {
        Intent multiGame = new Intent(this,MultiGameLevel1.class);
        startActivity(multiGame);
    }

    private void onHistoryButtonClick() {
        Intent hisIntent = new Intent(this,HistoryActivity.class);
        startActivity(hisIntent);

    }

    private void onHsButtonClick() {


    }

    private void onPlayButtonClick() {
        Intent intent = new Intent(this, PlayActivity.class);
        startActivityForResult(intent, REQUEST_CODE_PLAY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PLAY) {
            if (resultCode == RESULT_OK) {

                int result = data.getIntExtra("result", 0);

                score += result;
                saveScore();


                if (result > 0) {
                    Snackbar.make(scoreTextView, "You are winner!", Snackbar.LENGTH_SHORT).show();
                } else {
                    Snackbar.make(scoreTextView, "You are loser!", Snackbar.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void saveScore() {
        scoreTextView.setText("" + score);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SHARED_PREFS_SCORE_KEY, score);
        editor.commit();

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://creatingnew.kz.crazymathematician/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://creatingnew.kz.crazymathematician/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
