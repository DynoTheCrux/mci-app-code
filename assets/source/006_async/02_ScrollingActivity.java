package edu.mci.lyrics4you;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.UnknownHostException;

import edu.mci.lyricsfetcher.LyricsFetcher;
import edu.mci.lyricsfetcher.LyricsNotFoundException;

public class ScrollingActivity extends AppCompatActivity {

    private TextView txtLyrics;

    // asynchronous task which takes String parameters as input (artist, title)
    private class AsyncLyricsTask extends AsyncTask<String, Void, String> {

        // set text AFTER execution finished
        @Override
        protected void onPostExecute(String s) {
            txtLyrics.setText(s);
        }

        // happens in background
        @Override
        protected String doInBackground(String... strings) {
            // Get artist, title from parameters
            String artist = strings[0];
            String title = strings[1];

            // Create object to fetch lyrics
            LyricsFetcher fetcher = new LyricsFetcher("https://api.lyrics.ovh/v1/");

            String text;
            try {
                // Fetch lyrics
                LyricsFetcher.Result result = fetcher.fetchLyrics(artist, title);

                Log.i("LYRICS", String.format("Lyrics found for '%s - %s'", artist, title));
                text = result.lyrics;
            } catch (LyricsNotFoundException lnfe) { // ERROR: No lyrics found
                Log.i("LYRICS", String.format("No lyrics found for '%s -%s'", artist, title));
                text = String.format("No lyrics found for '%s -%s'", artist, title);
            } catch (IllegalArgumentException iae) { // ERROR: Arguments null
                Log.e("LYRICS", iae.getMessage(), iae);
                text = String.format("Error: %s", iae.getMessage());
            } catch (UnknownHostException uhe) {  // ERROR: No connection to host (internet down?)
                Log.e("LYRICS", "No connection to server.", uhe);
                text = "Error: No connection to server.";
            } catch (IOException e) {  // ERROR: Some other connection error
                Log.e("LYRICS", "Unable to get lyrics", e);
                text = "Error: Unspecified.";
            }
            return text;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        txtLyrics = findViewById(R.id.txtLyrics);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInputDialog();
            }
        });
    }

    private void showInputDialog() {
        // create new dialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // configure button
        builder.setView(R.layout.input_dialog);

        builder.setPositiveButton("Get the lyrics", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AlertDialog alertDialog = (AlertDialog) dialog;

                // use findViewById of the dialog!
                TextView editArtist = alertDialog.findViewById(R.id.editArtist);
                TextView editTitle = alertDialog.findViewById(R.id.editTitle);

                // get artist and title
                String artist = editArtist.getText().toString();
                String title = editTitle.getText().toString();

                // execute background task
                new AsyncLyricsTask().execute(artist, title);

                // show information to user
                Snackbar.make(findViewById(R.id.txtLyrics), String.format("Fetching lyrics for '%s - %s'", artist,title), Snackbar.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ScrollingActivity.this, "Lookup cancelled", Toast.LENGTH_SHORT).show();
            }
        });

        // build actual dialog
        AlertDialog dialog = builder.create();

        // show the dialog to the user
        dialog.show();
    }
}