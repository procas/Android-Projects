package thenewboston.com.theapp_normalresume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Web_Sav extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web__sav);
        WebView webView=(WebView)findViewById(R.id.websav);
        webView.loadUrl("https://www.4shared.com/mobile/lebvHsP0ce/thenewbostoncomsavingthings.html");
    }
}
