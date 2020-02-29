package thenewboston.com.theapp_normalresume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebCal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_cal);
        WebView webView=(WebView)findViewById(R.id.webcal);
        webView.loadUrl("http://www.4shared.com/file/Z-aq0s7cce/Calculator.html");
    }
}
