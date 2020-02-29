package thenewboston.com.theapp_normalresume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebMar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_mar);
        WebView webView=(WebView)findViewById(R.id.webmar);
        webView.loadUrl("https://www.4shared.com/file/klxLlTHOce/WELCOME_TO_SUPER_MARKETING.html");
    }
}
