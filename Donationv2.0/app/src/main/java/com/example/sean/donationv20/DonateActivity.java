package com.example.sean.donationv20;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.app.Activity;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.util.Log;
import android.content.res.Resources;
import android.content.Intent;


import android.widget.Toast;


public class DonateActivity extends ActionBarActivity {


    private Button donateButton;
    private RadioGroup paymentMethod;
    private ProgressBar progressBar;
    private NumberPicker amountPicker;

    private int totalDonated =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        donateButton = (Button) findViewById(R.id.donateButton);
        paymentMethod = (RadioGroup) findViewById(R.id.paymentMethod);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        amountPicker = (NumberPicker) findViewById(R.id.amountPicker);


        amountPicker.setMinValue(0);
        amountPicker.setMaxValue(1000);
        progressBar.setMax(10000);

        Log.v("Donate", "Got the Donate Button. Shots Fired!");

        if(donateButton!=null)
        {
            Log.v("Donate", "But seriously. We HAVE the Donate Button in protective custody.");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_donate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
       // int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        /* if (id == R.id.action_settings)
         {
            return true;
         }*/
        switch(item.getItemId())
        {
            case R.id.menuReport:
              //  Toast toast = Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT);
              //  toast.show();

                startActivity(new Intent(this, ReportActivity.class));
                break;
        }

        return true;

       // return super.onOptionsItemSelected(item);
    }

    public void donateButtonPressed(View view)

    {
        int amount = amountPicker.getValue();
        int radioId = paymentMethod.getCheckedRadioButtonId();
        String method ="";

        totalDonated = totalDonated+amount;
        progressBar.setProgress(totalDonated);

        if(radioId==R.id.payPal)
        {
            method = "Paypal";
        }
        else
        {
            method = "Direct";
        }
        Log.v("Donate", "Donate Button Pressed! You donated €"+amount+  ".00. Woot!");
        Log.v("Donate","Mr. Fung Shway donated with a " + method + " payment");
        Log.v("Donate","Current earnings: €" +totalDonated+".00.");
    }
}
