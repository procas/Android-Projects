package thenewboston.com.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShowFileContent extends AppCompatActivity {


    private TextView fileName;
    private TextView fileContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_file_content);

         fileName = (TextView)findViewById(R.id.fileName);

         fileContent = (TextView)findViewById(R.id.fileContent);

        String cont = Score_list._init;

        String nm = Score_list.file;

        fileContent.setText(cont);

        fileName.setText(nm);


    }
}
