package thenewboston.com.aphrodies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    public WebView aphro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aphro=(WebView)findViewById(R.id.aphro);
        WebSettings webSettings=aphro.getSettings();
        webSettings.setJavaScriptEnabled(true);
        aphro.loadUrl("http://aphrodies.com/");
    }
}
