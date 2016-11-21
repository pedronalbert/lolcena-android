package com.pedronalbert.lolcena.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.pedronalbert.lolcena.R;
import com.pedronalbert.lolcena.api.models.SummonerData;
import com.pedronalbert.lolcena.presenters.HomePresenter;
import com.pedronalbert.lolcena.views.HomeView;

public class HomeActivity extends AppCompatActivity implements HomeView {
    private HomePresenter presenter;
    private EditText summonerNameET;
    private Button searchButton;
    private Spinner regionsSpinner;
    private MaterialDialog loadingDialog;
    private TextInputLayout summonerNameTIL;
    private RadioButton summonerSearchRB;
    private Snackbar snackbar;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.presenter = new HomePresenter(this);

        /*-- Widgets ---*/
        this.summonerNameET = (EditText) findViewById(R.id.summonerNameET);
        this.searchButton = (Button) findViewById(R.id.searchButton);
        this.regionsSpinner = (Spinner) findViewById(R.id.regionsSP);
        this.summonerNameTIL = (TextInputLayout) findViewById(R.id.summonerNameTIL);
        this.summonerSearchRB = (RadioButton) findViewById(R.id.summonerSearchRB);
        this.coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        setRegionsAdepter();

        this.loadingDialog = new MaterialDialog.Builder(this)
                .cancelable(false)
                .title(R.string.loading_information)
                .content(R.string.please_wait)
                .progress(true, 0)
                .build();


        this.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchSummoner();
            }
        });

        this.summonerNameET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH)
                    searchSummoner();

                return false;
            }
        });

    }

    @Override
    public void showLoadingDialog () {
        this.loadingDialog.show();
    }

    @Override
    public void hideLoadingDialog () {
        this.loadingDialog.dismiss();
    }

    private void setRegionsAdepter () {
        ArrayAdapter<CharSequence> regionsAdapter = ArrayAdapter.createFromResource(this, R.array.regions_abbr_array, android.R.layout.simple_spinner_dropdown_item);
        regionsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.regionsSpinner.setAdapter(regionsAdapter);
    }

    private void searchSummoner () {
        String summonerName = this.summonerNameET.getText().toString().trim();
        String regionSelected = this.regionsSpinner.getSelectedItem().toString().toLowerCase();

        if (summonerName.isEmpty()) {
            this.summonerNameTIL.setError(getString(R.string.summoner_name_required));
        } else {
            this.summonerNameTIL.setError(null);

            if (this.getSearchMode() == "SUMMONER") {
                this.presenter.searchSummoner(summonerName, regionSelected);
            }
        }

    }

    private String getSearchMode () {
        if (this.summonerSearchRB.isChecked()) {
            return "SUMMONER";
        } else {
            return "GAME";
        }
    }
    
    public void showError (String message) {
        this.snackbar.make(this.coordinatorLayout, message, Snackbar.LENGTH_LONG)
                .show();
    }
    
    public void goToSummonerProfile (SummonerData summonerData) {
        Intent intent = new Intent(this, SummonerProfileActivity.class);
        intent.putExtra("summonerData", summonerData);
        startActivity(intent);
    }

}
