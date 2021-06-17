package com.example.menuproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_help) {
            openHelpActivity(item);
            return true;
        }
        if (id == R.id.menu_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void sendSms(View view) {
        Uri phoneNumber = Uri.parse("smsto:" + Uri.encode(getString(R.string.sms_number)));
        Intent intentSms = new Intent(Intent.ACTION_SENDTO, phoneNumber);
        intentSms.putExtra("sms_body", getString(R.string.sms_message));
        startActivity(intentSms);
    }

    public void openCaller(View view) {
        Uri phoneNumber = Uri.parse("tel:" + Uri.encode(getString(R.string.caller_number)));
        Intent intentCaller = new Intent(Intent.ACTION_DIAL, phoneNumber);
        startActivity(intentCaller);
    }

    public void openWebsite(View view) {
        Uri webpage = Uri.parse(getString(R.string.web_url));
        Intent intentWeb = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intentWeb);
    }

    public void openMap(View view) {
        Uri addressUri = Uri.parse("geo:0,0?q=" + getString(R.string.map_location));
        Intent intentMap = new Intent(Intent.ACTION_VIEW, addressUri);
        startActivity(intentMap);
    }

    public void shareMessage(View view) {
        ShareCompat.IntentBuilder
                .from(this)
                .setType("text/plain")
                .setChooserTitle(getString(R.string.share_message_title))
                .setText(getString(R.string.share_message))
                .startChooser();
    }

    public void openNewActivity(View view) {
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
    }

    public void openHelpActivity(MenuItem item) {
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }
}