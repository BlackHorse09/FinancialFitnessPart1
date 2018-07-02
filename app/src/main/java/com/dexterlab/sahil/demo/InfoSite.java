package com.dexterlab.sahil.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.PopupMenu;

public class InfoSite extends AppCompatActivity {

    Button masterLogin, contactUs;
    WebView webView;
    String twitter, facebook, linkden, email;
    View v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_site);

        //Code for viewing website using internaet
        masterLogin = (Button) findViewById(R.id.masterLogin);
        webView = (WebView) findViewById(R.id.webView);
        contactUs = (Button) findViewById(R.id.contactUs);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.sudhirkhot.com");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        twitter = "https://twitter.com/connectsudhir";
        facebook = "https://www.facebook.com/FinancialFitness.org.in";
        linkden = "https://www.linkedin.com/in/sudhirkhot";
        email = "connect@sudhirkhot.com";

        masterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoSite.this, Login.class);
                startActivity(intent);
            }
        });

        contactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final PopupMenu popupMenu = new PopupMenu(InfoSite.this, contactUs);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.twitter:
                                Intent intentT = new Intent(InfoSite.this, SocialWebActivity.class);
                                intentT.putExtra("webLink", twitter);
                                startActivity(intentT);
                                break;
                            case R.id.facebook:
                                Intent intentF = new Intent(InfoSite.this, SocialWebActivity.class);
                                intentF.putExtra("webLink", facebook);
                                startActivity(intentF);
                                break;
                            case R.id.linkdn:
                                Intent intentL = new Intent(InfoSite.this, SocialWebActivity.class);
                                intentL.putExtra("webLink", linkden);
                                startActivity(intentL);
                                break;
                            case R.id.Email:
                                Intent intentE = new Intent(InfoSite.this, SocialWebActivity.class);
                                intentE.putExtra("webLink", twitter);
                                startActivity(intentE);
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();


            }
        });
    }



    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onMenuItemClick(MenuItem menuItem) {
//        switch (menuItem.getItemId()) {
//            case R.id.twitter:
//                Intent intentT = new Intent(InfoSite.this, SocialWebActivity.class);
//                intentT.putExtra("webLink", twitter);
//                startActivity(intentT);
//                break;
//            case R.id.facebook:
//                Intent intentF = new Intent(InfoSite.this, SocialWebActivity.class);
//                intentF.putExtra("webLink", facebook);
//                startActivity(intentF);
//                break;
//            case R.id.linkdn:
//                Intent intentL = new Intent(InfoSite.this, SocialWebActivity.class);
//                intentL.putExtra("webLink", linkden);
//                startActivity(intentL);
//                break;
//            case R.id.Email:
//                Intent intentE = new Intent(InfoSite.this, SocialWebActivity.class);
//                intentE.putExtra("webLink", twitter);
//                startActivity(intentE);
//                break;
//        }
//        return false;
//    }

}
