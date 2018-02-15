package pl.pisze_czytam.piszeiczytam;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView fbTxt = findViewById(R.id.facebook_txt);
        fbTxt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent facebookIntent = getOpenFacebookIntent(MainActivity.this);
                startActivity(facebookIntent);
            }
        });
    }

    public void sendMail(View view) {
        Intent intentMail = new Intent(Intent.ACTION_SENDTO);
        intentMail.setData(Uri.parse("mailto:pisze.czytam@gmail.com"));
        if (intentMail.resolveActivity(getPackageManager()) != null) {
            startActivity(intentMail);
        }
    }

    public void dialPhoneNumber(View view) {
        String phoneNumber = getResources().getString(R.string.phone);
        Intent intentPhone = new Intent(Intent.ACTION_DIAL);
        intentPhone.setData(Uri.parse("tel:" + phoneNumber));
        if (intentPhone.resolveActivity(getPackageManager()) != null) {
            startActivity(intentPhone);
        }
    }

    public void openSite(View view) {
        String url = getResources().getString(R.string.full_www);
        Intent intentSite = new Intent(Intent.ACTION_VIEW);
        intentSite.setData(Uri.parse(url));
        startActivity(intentSite);
    }

    public static Intent getOpenFacebookIntent(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/1868900693353865"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/pisze.czytam"));
        }
    }

    public void openInstagram(View view) {
        Uri instaUri = Uri.parse("http://instagram.com/_u/przeczytane");
        Intent instaIntent = new Intent(Intent.ACTION_VIEW, instaUri);
        instaIntent.setPackage("com.instagram.android");
        try {
            startActivity(instaIntent);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.insta_address))));
        }
    }

    public void openMap(View view) {
        Uri mapsUri = Uri.parse("geo:52.3482174,21.2615066?q=kościelna+66");
        Intent intentMap = new Intent(Intent.ACTION_VIEW, mapsUri);
        intentMap.setPackage("com.google.android.apps.maps");
        if (intentMap.resolveActivity(getPackageManager()) != null) {
            startActivity(intentMap);
        }
    }
}