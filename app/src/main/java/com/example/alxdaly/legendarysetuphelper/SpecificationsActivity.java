package com.example.alxdaly.legendarysetuphelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.alxdaly.legendarysetuphelper.enums.Masterminds;
import com.example.alxdaly.legendarysetuphelper.enums.Schemes;

public class SpecificationsActivity extends AppCompatActivity {

    private int numPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specifications);
        Bundle extra = getIntent().getExtras();
        this.numPlayers = extra.getInt("numberOfPlayers");
        setSubtitle(this.numPlayers);
        setMastermindSpinner();
        setSchemeSpinner();
    }

    private void setSubtitle(int numPlayers) {
        TextView numPlayersSubtitle = (TextView) findViewById(R.id.numPlayersSubtitle);
        switch (numPlayers) {
            case 1:
                numPlayersSubtitle.setText(R.string.P1);
                break;
            case 2:
                numPlayersSubtitle.setText(R.string.P2);
                break;
            case 3:
                numPlayersSubtitle.setText(R.string.P3);
                break;
            case 4:
                numPlayersSubtitle.setText(R.string.P4);
                break;
            case 5:
                numPlayersSubtitle.setText(R.string.P5);
                break;
        }

    }

    private void setMastermindSpinner() {
        Spinner mastermindOption = (Spinner) findViewById(R.id.mastermindOption);
        Masterminds[] masterminds = Masterminds.values();
        String[] mastermindOptions = new String[masterminds.length + 1];
        int i;
        mastermindOptions[0] = getResources().getString(R.string.random);
        for(i = 0; i < masterminds.length; i++){
            mastermindOptions[i+1] = masterminds[i].toString();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_spinner, removeSpaces(mastermindOptions));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mastermindOption.setAdapter(adapter);
    }

    private void setSchemeSpinner() {
        Spinner schemeOption = (Spinner) findViewById(R.id.schemeOption);
        Schemes[] schemes = Schemes.values();
        String[] schemeOptions = new String[schemes.length + 1];
        int i;
        schemeOptions[0] = getResources().getString(R.string.random);
        for(i = 0; i < schemes.length; i++){
            schemeOptions[i+1] = schemes[i].toString();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_spinner, removeSpaces(schemeOptions));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schemeOption.setAdapter(adapter);
    }

    private String[] removeSpaces(String[] stringArray) {
        for(int i = 0; i < stringArray.length; i++){
            stringArray[i] = stringArray[i].replace('_', ' ');
        }
        return stringArray;
    }
}
