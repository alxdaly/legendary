package com.example.alxdaly.legendarysetuphelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public void goToP1Setup(View view){
        Intent intent = new Intent(this, SetupActivity.class);
        intent.putExtra("numberOfPlayers", 1);
        startActivity(intent);
    }

    public void goToP2Setup(View view){
        Intent intent = new Intent(this, SetupActivity.class);
        intent.putExtra("numberOfPlayers", 2);
        startActivity(intent);
    }

    public void goToP3Setup(View view){
        Intent intent = new Intent(this, SetupActivity.class);
        intent.putExtra("numberOfPlayers", 3);
        startActivity(intent);
    }

    public void goToP4Setup(View view){
        Intent intent = new Intent(this, SetupActivity.class);
        intent.putExtra("numberOfPlayers", 4);
        startActivity(intent);
    }

    public void goToP5Setup(View view){
        Intent intent = new Intent(this, SetupActivity.class);
        intent.putExtra("numberOfPlayers", 5);
        startActivity(intent);
    }
}
