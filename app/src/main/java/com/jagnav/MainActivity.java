package com.jagnav;

import android.app.Dialog;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String routeStart, routeEnd;
    EditText startInput, endInput;
    TextView route;
    Button submitButton, popUp, routeClose;
    Dialog dia;
    PopupMenu popUpMenu;

    ArrayList<Location> path;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dia = new Dialog(this);
        //popUpMenu = new PopupMenu();
        startInput = findViewById(R.id.startingLoc);
        endInput = findViewById(R.id.endLoc);
        submitButton = findViewById(R.id.button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                routeStart = startInput.getText().toString();
                routeEnd = endInput.getText().toString();

                AssetManager assetManager = getAssets();
                Map test = new Map();
                test.csvWrite();
                test.csvRead(assetManager);
                test.populateMap();
                test.printMap();

                PathFinder pf = new PathFinder(test);
                try {
                    //inputs should be in terms of room number or the equivalent cell in the csv x
                    path = pf.findPath(test.findLocation(routeStart), test.findLocation(routeEnd));

                }
                catch (Exception l) {
                    l.printStackTrace();
                }

            }
        });
        popUp = findViewById(R.id.popUp);
        popUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (path != null && path.size() > 0) {
                    showPopup(v, path);

                }
            }

        });
    }

    public void showPopup(View v, ArrayList<Location> arr) {

        route = findViewById(R.id.routeText);
        routeClose = findViewById(R.id.routeCloseButton);
        dia.setContentView(R.layout.route_popup);
        dia.show();
    }

}
