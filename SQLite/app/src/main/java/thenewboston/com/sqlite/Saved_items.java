package thenewboston.com.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class Saved_items extends AppCompatActivity {
    DBHandler dbHandler;
    TextView lItem;
    TextView lDate;
   // RatingBar rater;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        lItem=(TextView)findViewById(R.id.lItem);
        lDate=(TextView)findViewById(R.id.lDate);
       // rater=(RatingBar)findViewById(R.id.ratingBar2);
        //rater.setNumStars(5);





        dbHandler=new DBHandler(this);
        String nameList="", dateList="", stars="";
        nameList=dbHandler.showName();
        dateList=dbHandler.showDates();
     //   stars=dbHandler.showStars();

       //rater.setNumStars(5);
       // rater.setRating(Float.parseFloat(stars));



        lItem.setText(nameList);
        lDate.setText(dateList);



    }


}
