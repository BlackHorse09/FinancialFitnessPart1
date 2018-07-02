package com.dexterlab.sahil.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SocialWebActivity extends AppCompatActivity {

    String link;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_web);

        link = getIntent().getStringExtra("webLink");

        webView = (WebView) findViewById(R.id.socialWebView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(link);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}
