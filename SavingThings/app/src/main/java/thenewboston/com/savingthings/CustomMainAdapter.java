package thenewboston.com.savingthings;

import android.widget.ArrayAdapter;

/**
 * Created by HP on 10/1/2017.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomMainAdapter extends ArrayAdapter {

    List list=new ArrayList();

    public CustomMainAdapter(Context context, int resource)
    {
        super(context, resource);
    }

    static  class LayoutHandler
    {
       TextView lItem;
        TextView lDate;

    }

    @Override
    public void add(Object object) {
        super.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        LayoutHandler layoutHandler;
        if(row == null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.single_row, parent, false);
            layoutHandler=new LayoutHandler();
            layoutHandler.lItem=(TextView) row.findViewById(R.id.lItem);

            layoutHandler.lDate=(TextView) row.findViewById(R.id.lDate);
            row.setTag(layoutHandler);
        }
        else
        {
            layoutHandler=(LayoutHandler) row.getTag();


        }
        thenewboston.com.ListItem object=(thenewboston.com.ListItem) this.getItem(position);
        layoutHandler.lItem.setText((object.getItemName()));
        layoutHandler.lDate.setText(object.getItemDate());
      //  layoutHandler.numstars.setRating(object.get_star());
        return row;
    }
}
