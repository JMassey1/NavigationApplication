package com.jagnav;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    String routeStart, routeEnd;
    EditText startInput, endInput;
    Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                    pf.findPath(test.findLocation(routeStart), test.findLocation(routeEnd));

                }
                catch (Exception l) {
                    l.printStackTrace();
                }

            }
        });






    }

}
