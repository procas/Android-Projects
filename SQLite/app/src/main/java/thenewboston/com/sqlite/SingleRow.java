package thenewboston.com.sqlite;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by HP on 10/5/2017.
 */
public class SingleRow extends AppCompatActivity {
    public static String textName;
    public static TextView lItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lItems = (TextView)findViewById(R.id.lItem);
        textName = lItems.getText().toString();
        registerForContextMenu(lItems);

    }
}
