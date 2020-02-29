package thenewboston.com.theapp_normalresume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mar);
        WebView webView=(WebView)findViewById(R.id.mar);
        webView.loadUrl("https://www.4shared.com/file/klxLlTHOce/WELCOME_TO_SUPER_MARKETING.html");
    }
}
