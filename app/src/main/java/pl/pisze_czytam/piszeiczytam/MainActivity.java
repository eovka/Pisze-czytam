package pl.pisze_czytam.piszeiczytam;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void openSite(View view) {
        String url = "http://pisze-czytam.pl";
        Intent intentSite = new Intent(Intent.ACTION_VIEW);
        intentSite.setData(Uri.parse(url));
        startActivity(intentSite);
    }
    public void openFB(View view) {
        String url = "http://facebook.com/pisze.czytam";
        Intent intentFB = new Intent(Intent.ACTION_VIEW);
        intentFB.setData(Uri.parse(url));
        startActivity(intentFB);
    }
    public void openInstagram(View view) {
        String url = "http://instagram.com/przeczytane";
        Intent intentInstagram = new Intent(Intent.ACTION_VIEW);
        intentInstagram.setData(Uri.parse(url));
        startActivity(intentInstagram);
    }
}