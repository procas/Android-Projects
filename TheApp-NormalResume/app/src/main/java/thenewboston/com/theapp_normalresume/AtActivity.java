package thenewboston.com.theapp_normalresume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class AtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at);
        WebView webView=(WebView)findViewById(R.id.at);
        webView.loadUrl("https://www.4shared.com/mobile/0lhkqJwace/thenewbostoncomattempt.html");
    }
}
