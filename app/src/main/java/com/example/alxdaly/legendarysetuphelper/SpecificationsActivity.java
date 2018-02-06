package com.example.alxdaly.legendarysetuphelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.alxdaly.legendarysetuphelper.enums.Masterminds;
import com.example.alxdaly.legendarysetuphelper.pojo.Mastermind;

import java.util.ArrayList;
import java.util.Arrays;

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
        for(i = 0; i < masterminds.length; i++){
            mastermindOptions[i] = masterminds[i].toString();
        }
        mastermindOptions[i] = getResources().getString(R.string.random);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_selectable_list_item, mastermindOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mastermindOption.setAdapter(adapter);
    }
}
