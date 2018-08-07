package com.luchoc.webview;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonPressed(View view) {

        final String TAG = "TOKENOID";


        final String OAUTH_URL = "https://github.com/login/oauth/authorize";
        final String OAUTH_ACCESS_TOKEN_URL = "https://github.com/login/oauth/access_token";

        final String CLIENT_ID = "44cacdb40953320152d3";
        final String CLIENT_SECRET = "1650b8cb5f58e2fbf8609ee2f964dd068a3e436d";
        final String CALLBACK_URL = "https://luiscarlin.github.io";


        String url = OAUTH_URL + "?client_id=" + CLIENT_ID;

        WebView webview = (WebView)findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                String accessTokenFragment = "access_token=";
                String accessCodeFragment = "code=";

                // We hijack the GET request to extract the OAuth parameters

                if (url.contains(accessTokenFragment)) {
                    // the GET request contains directly the token
                    String accessToken = url.substring(url.indexOf(accessTokenFragment));
                    Log.v(">>> Access Token = ", accessToken);


                } else if(url.contains(accessCodeFragment)) {
                    // the GET request contains an authorization code
                    String accessCode = url.substring(url.indexOf(accessCodeFragment));
                    Log.v(">>> Access Code = ", accessCode);


                    String query = "client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "&code=" + accessCode;
                    view.postUrl(OAUTH_ACCESS_TOKEN_URL, query.getBytes());
                }

            }



        });
        webview.loadUrl(url);

//
//        WebView myWebView = findViewById(R.id.webview);
//        myWebView.setWebViewClient(new myWebViewClient());
//        myWebView.getSettings().setJavaScriptEnabled(true);
//        myWebView.loadUrl("https://twitter.com");
//    }
//
//
//    class myWebViewClient extends WebViewClient {
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            Log.v(">>>>", "shouldOverrideUrlLoading " + url);
//            return false;
//        }
    }
}


//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_item_list);
//       ...
//
//        // check whether access token already saved
//        accessToken = getPreferences(Context.MODE_PRIVATE).getString(SHPREF_KEY_ACCESS_TOKEN, null);
//        if (accessToken == null) {
//
//            // need to get access token with OAuth2.0
//           ...
//            // set up webview for OAuth2 login
//            webview.setWebViewClient(new WebViewClient() {
//                @Override
//                public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                   ...
//                    if ( url.startsWith(REDIRECT_URI) ) {
//
//                        // extract OAuth2 access_token appended in url
//                        if ( url.indexOf("access_token=") != -1 ) {
//                            accessToken = mExtractToken(url);
//
//                            // store in default SharedPreferences
//                            Editor e = getPreferences(Context.MODE_PRIVATE).edit();
//                            e.putString(SHPREF_KEY_ACCESS_TOKEN, accessToken);
//                            e.commit();
//
//                            // spawn worker thread to do api calls to get list of contacts to display
//                            new MyWebservicesAsyncTask().execute(accessToken);
//                        }
//
//                        // don't go to redirectUri
//                        return true;
//                    }
//
//                    // load the webpage from url: login and grant access
//                    return super.shouldOverrideUrlLoading(view, url); // return false;
//                }
//            });
//
//            // do OAuth2 login
//            String authorizationUri = mReturnAuthorizationRequestUri();
//            webview.loadUrl(authorizationUri);
//
//        } else {
//
//            // have access token, so spawn worker thread to do api calls to get list of contacts to display
//            new MyWebservicesAsyncTask().execute(accessToken);
//        }
//    }