package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebPageActivity extends AppCompatActivity {

    WebView wvRP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);

        wvRP = findViewById(R.id.WebViewRP);

        wvRP.getSettings().setJavaScriptEnabled(true);
        wvRP.getSettings().setBuiltInZoomControls(true);

        wvRP.setWebViewClient(new WebViewClient());

        Intent intentReceived = getIntent();
        String url = intentReceived.getStringExtra("link");
        wvRP.loadUrl(url);
    }
}