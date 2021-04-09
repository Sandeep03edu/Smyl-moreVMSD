package com.example.smylmoreVMSD;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class test extends AppCompatActivity {

    String TAG = "MainActivity";
    Context context;
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_video);
        context = this;

        mWebView = (WebView) findViewById(R.id.youtube_web_view);
        mWebView.setWebViewClient(new MyWebViewClient());

        String ENROLLMENT_URL = "https://youtu.be/lcfcG31AgyE";
        mWebView.loadUrl(ENROLLMENT_URL);

    }

    public final class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            Intent i = new Intent(Intent.ACTION_VIEW, request.getUrl());
            startActivity(i);
            return true;
        }

    }
}