package com.findword;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;

/**
 * Created by mkusen on 24.03.18..
 */

public class View extends AppCompatActivity{

    private EditText getLetters;
    private ImageButton search;
    private String letters;
    private Modell modell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        OnSearchPress();
    }



    public void OnSearchPress(){

        modell = new Modell();

        search = findViewById(R.id.btnSearch);
        search.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                getLetters = findViewById(R.id.txtLetters);
               letters = getLetters.getText().toString().trim();


                System.out.println(letters + " view");

                try {
                    modell.GetWords(letters);
                }catch (AuthFailureError ex){
                    Toast.makeText(View.this, "Greška", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
