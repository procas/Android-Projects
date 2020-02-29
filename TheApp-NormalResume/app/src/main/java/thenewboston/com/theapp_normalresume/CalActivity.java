package thenewboston.com.theapp_normalresume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class CalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);
        WebView wc=(WebView)findViewById(R.id.webcal);
        wc.loadUrl("http://www.4shared.com/file/Z-aq0s7cce/Calculator.html");
    }
}
