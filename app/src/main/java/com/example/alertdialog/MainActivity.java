package com.example.alertdialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5;
    AlertDialog.Builder adb;
    Random rnd = new Random();
    View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }
    private void initViews() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        layout = (android.widget.LinearLayout) findViewById(R.id.layout);
    }

    /**
     * Generates a random color and updates the layout background color.
     */
    public void randomColor() {
        int color = android.graphics.Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        layout.setBackgroundColor(color);
    }

    /**
     * Displays a simple alert dialog with text only.
     *
     * @param view The view that triggered this method.
     */
    public void goBtn1(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("First example: only text");
        adb.setMessage("This is a simple alert");
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * Displays an alert dialog with a title, message, and icon.
     *
     * @param view The view that triggered this method.
     */
    public void goBtn2(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Alert!!!!");
        adb.setMessage("Skibidi Toilet");
        adb.setIcon(R.drawable.ic_launcher_foreground);
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * Displays an alert dialog with a negative button that closes the dialog.
     *
     * @param view The view that triggered this method.
     */
    public void goBtn3(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Alert!!!");
        adb.setMessage("hello kitty");
        adb.setIcon(R.drawable.ic_launcher_background);
        adb.setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * Displays an alert dialog with positive and negative buttons.
     * The positive button triggers the random color generator, while the negative button closes the dialog.
     *
     * @param view The view that triggered this method.
     */
    public void goBtn4(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Alert!!!");
        adb.setMessage("hello kitty");
        adb.setIcon(R.drawable.ic_launcher_background);

        adb.setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setPositiveButton("randomColor", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                randomColor();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * Displays an alert dialog with three buttons: positive, neutral, and negative.
     * The positive button triggers the random color generator,
     * the negative button resets the layout background to white,
     * and the neutral button closes the dialog.
     *
     * @param view The view that triggered this method.
     */
    public void goBtn5(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Alert!!!");
        adb.setMessage("3 buttons");
        adb.setIcon(R.drawable.ic_launcher_background);
        adb.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setPositiveButton("randomColor", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                randomColor();
            }
        });
        adb.setNegativeButton("resetLayoutBackground", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                layout.setBackgroundColor(Color.rgb(255, 255, 255));            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }
    /**
     * Inflates the options menu for the activity.
     *
     * @param menu The options menu in which items are placed.
     * @return True if the menu is to be displayed.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    /**
     * Handles item selection from the options menu.
     *
     * @param item The menu item that was selected.
     * @return True if the item was successfully handled.
     */
    @Override
    public boolean onOptionsItemSelected(@Nullable MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.credits) {
            Intent si = new Intent(this, Credits.class);
            startActivity(si);
        }
        return true;
    }
}