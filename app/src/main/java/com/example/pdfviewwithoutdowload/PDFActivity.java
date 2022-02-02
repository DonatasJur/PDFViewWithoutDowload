package com.example.pdfviewwithoutdowload;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class PDFActivity extends AppCompatActivity {
    WebView webView;
    private ProgressBar progressBar;
    @SuppressLint("SetJavaScriptEndable")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfactivity);

        webView = findViewById(R.id.WV);
        progressBar = findViewById(R.id.pb);
        progressBar.setVisibility(View.VISIBLE);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.setWebChromeClient(new WebChromeClient());
        Intent intent = getIntent();
        final int position = intent.getIntExtra("position", 0);
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String Url) {
                webView.loadUrl("javaxcript : (function() {" +
                        "documents.querySelector('[role\"toolbar\"'0.remove();})()");
                progressBar.setVisibility(View.GONE);
            }
        });
    webView.loadUrl("https://docs.google.com/viewer?embedded=true&url="+MainActivity.list.get(position).getPdfUrl());

    }
}