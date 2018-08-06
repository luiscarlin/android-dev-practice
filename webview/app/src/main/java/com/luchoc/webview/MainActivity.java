package com.luchoc.webview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        WebView myWebView = (WebView) findViewById(R.id.webview);
//        myWebView.loadUrl("https://www.facebook.com/login.php");

//        WebView myWebView = new WebView(activityContext);
//        setContentView(myWebView);
//
//        Uri uri = Uri.parse("https://www.facebook.com");
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//        startActivity(intent);

//        WebView webview = new WebView(this);
//        setContentView(webview);
////
//        webview.loadUrl("https://www.facebook.com/login.php");


        // Let's display the progress in the activity title bar, like the
        // browser app does.
//        getWindow().requestFeature(Window.FEATURE_PROGRESS);
//
//        webview.getSettings().setJavaScriptEnabled(true);
//
//        final Activity activity = this;
//        webview.setWebChromeClient(new WebChromeClient() {
//            public void onProgressChanged(WebView view, int progress) {
//                // Activities and WebViews measure progress with different scales.
//                // The progress meter will automatically disappear when we reach 100%
//                activity.setProgress(progress * 1000);
//            }
//        });
//        webview.setWebViewClient(new WebViewClient() {
//            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
//                Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        webview.loadUrl("https://developer.android.com/");


    }

    public void onButtonPressed(View view) {
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("https://gmail.com");
    }
}
