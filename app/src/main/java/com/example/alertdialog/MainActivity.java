package com.example.alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
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

    public void randomColor() {
        int color = android.graphics.Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        layout.setBackgroundColor(color);
    }

    public void goBtn1(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("First example: only text");
        adb.setMessage("This is a simple alert");
        AlertDialog ad = adb.create();
        ad.show();
    }

    public void goBtn2(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Alert!!!!");
        adb.setMessage("Skibidi Toilet");
        adb.setIcon(R.drawable.ic_launcher_foreground);
        AlertDialog ad = adb.create();
        ad.show();
    }

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

    public void goBtn5(View view) {

    }
}