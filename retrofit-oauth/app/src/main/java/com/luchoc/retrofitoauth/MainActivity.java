package com.luchoc.retrofitoauth;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        Log.d("URL FROM GITHUB", intent.getData().toString());

        Uri uri = intent.getData();

        if (uri != null && uri.toString().startsWith(redirectUri)) {
            String code = uri.getQueryParameter("code");
            Toast.makeText(this, "auth code = " + code,Toast.LENGTH_SHORT).show();

            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl("https://github.com/")
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.build();

            GithubClient client = retrofit.create(GithubClient.class);

            Call<AccessToken> accessTokenCall = client.getAccessToken(clientId, clientSecret, code);

            accessTokenCall.enqueue(new Callback<AccessToken>() {
                @Override
                public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                    AccessToken accessToken = response.body();

                    String accessTokenStr = accessToken.getAccessToken();

                    Toast.makeText(MainActivity.this, "access_token = " + accessTokenStr, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<AccessToken> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "something went wrong" , Toast.LENGTH_SHORT).show();
                }
            });


        }
    }
}
