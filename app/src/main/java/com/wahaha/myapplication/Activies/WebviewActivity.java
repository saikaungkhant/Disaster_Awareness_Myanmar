package com.wahaha.myapplication.Activies;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wahaha.myapplication.R;

public class WebviewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        WebView webView = (WebView) findViewById(R.id.webView);

        String url = getIntent().getExtras().getString("url");
        webView.loadUrl(url);

        webView.setWebViewClient(new WebViewClient());


    }
}
