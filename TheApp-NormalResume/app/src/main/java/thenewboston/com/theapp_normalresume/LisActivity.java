package thenewboston.com.theapp_normalresume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class LisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lis);
        WebView webView=(WebView)findViewById(R.id.lis);
        webView.loadUrl("https://www.4shared.com/mobile/7XomGbxKba/thenewbostoncomlistofitems.html");
    }
}
