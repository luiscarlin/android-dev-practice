package com.luchoc.retrofitoauth;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String clientId = "44cacdb40953320152d3";
    private String clientSecret = "1650b8cb5f58e2fbf8609ee2f964dd068a3e436d";
    private String redirectUri = "luisapp://callback";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/login/oauth/authorize" + "?client_id=" + clientId + "&scope=repo&redirect_uri=" + redirectUri));
        startActivity(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Uri uri = intent.getData();

        if (uri != null && uri.toString().startsWith(redirectUri)) {
            String code = uri.getQueryParameter("code");
            Toast.makeText(this, "auth code = " + code,Toast.LENGTH_SHORT).show();
        }
    }
}
