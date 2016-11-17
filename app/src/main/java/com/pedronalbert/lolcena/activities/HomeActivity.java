package com.pedronalbert.lolcena.activities;

import android.content.res.Configuration;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.pedronalbert.lolcena.R;
import com.pedronalbert.lolcena.presenters.HomePresenter;
import com.pedronalbert.lolcena.views.HomeView;

public class HomeActivity extends AppCompatActivity implements HomeView {
    private HomePresenter mPresenter;
    private EditText mSummonerNameET;
    private Button mSearchButton;
    private Spinner mRegionsSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mPresenter = new HomePresenter(this);

        mSummonerNameET = (EditText) findViewById(R.id.summonerNameET);
        mSearchButton = (Button) findViewById(R.id.searchButton);
        mRegionsSpinner = (Spinner) findViewById(R.id.regionsSP);

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchSummoner();
            }
        });

        mSummonerNameET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH)
                    searchSummoner();

                return false;
            }
        });

        setRegionsAdepter();
    }

    @Override
    public void disableSearchButton() {
        //TODO: Disable search button
    }

    private void setRegionsAdepter () {
        ArrayAdapter<CharSequence> regionsAdapter = ArrayAdapter.createFromResource(this, R.array.regions_abbr_array, android.R.layout.simple_spinner_dropdown_item);
        regionsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mRegionsSpinner.setAdapter(regionsAdapter);
    }

    private void searchSummoner () {
        String summonerName = mSummonerNameET.getText().toString();
        String regionSelected = mRegionsSpinner.getSelectedItem().toString().toLowerCase();

        mPresenter.searchSummoner(summonerName, regionSelected);
    }

}
