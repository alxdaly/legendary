package com.example.alxdaly.legendarysetuphelper;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.alxdaly.legendarysetuphelper.enums.Expansions;
import com.example.alxdaly.legendarysetuphelper.enums.Masterminds;
import com.example.alxdaly.legendarysetuphelper.enums.Schemes;

import java.util.ArrayList;
import java.util.List;

public class SpecificationsActivity extends AppCompatActivity {

    private int numPlayers;
    private Spinner mastermindOption;
    private Spinner schemeOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specifications);
        Bundle extra = getIntent().getExtras();
        this.numPlayers = extra.getInt("numberOfPlayers");
        this.mastermindOption = (Spinner) findViewById(R.id.mastermindOption);
        this.schemeOption = (Spinner) findViewById(R.id.schemeOption);
        setSubtitle(this.numPlayers);
        setMastermindSpinner();
        setSchemeSpinner();
    }

    public void goToSetup(View view){
        Intent intent = new Intent(this, SetupActivity.class);
        intent.putExtra("numberOfPlayers", this.numPlayers);
        intent.putExtra("mastermind", resetSpinnerItem((String) this.mastermindOption.getSelectedItem()));
        intent.putExtra("scheme", resetSpinnerItem((String) this.schemeOption.getSelectedItem()));
        intent.putExtra("expansions", this.gatherExpansions());
        startActivity(intent);
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
        mastermindOption.setOnItemSelectedListener(new SpinnerActiviity());
    }

    private void setSchemeSpinner() {
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
        schemeOption.setOnItemSelectedListener(new SpinnerActiviity());
    }

    private String[] removeSpaces(String[] stringArray) {
        for(int i = 0; i < stringArray.length; i++){
            stringArray[i] = stringArray[i].replace('_', ' ');
        }
        return stringArray;
    }

    private String resetSpinnerItem(String string) {
        return string.replace(' ', '_');
    }

    private ArrayList<Expansions> gatherExpansions() {
        ArrayList<Expansions> expansions = new ArrayList<>();
        CheckBox deadpoolCheckbox = (CheckBox) findViewById(R.id.deadpoolCheckbox);
        CheckBox noirCheckbox = (CheckBox) findViewById(R.id.noirCheckbox);
        CheckBox paintCheckbox = (CheckBox) findViewById(R.id.paintCheckbox);

        expansions.add(Expansions.BASE);
        if(deadpoolCheckbox.isChecked()){
            expansions.add(Expansions.DEADPOOL);
        }
        if(noirCheckbox.isChecked()){
            expansions.add(Expansions.NOIR);
        }
        if(paintCheckbox.isChecked()){
            expansions.add(Expansions.PAINT_TOWN_RED);
        }
        return expansions;
    }

    private class SpinnerActiviity extends Activity implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent){

        }
    }
}
