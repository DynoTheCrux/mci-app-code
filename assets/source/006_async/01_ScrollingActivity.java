package edu.mci.lyrics4you;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity {

    private TextView txtLyrics;

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

                // TODO execute background task

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