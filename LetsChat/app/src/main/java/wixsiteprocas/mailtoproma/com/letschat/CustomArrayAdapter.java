package wixsiteprocas.mailtoproma.com.letschat;

import java.util.List;
//import com.theopentutorials.android.R;
//import com.theopentutorials.android.beans.RowItem;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomArrayAdapter extends ArrayAdapter<ListItem> {

    Context context;

    public CustomArrayAdapter(Context context, int resourceId) {
        super(context, resourceId);
        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView userImage;
        TextView userName;
      //  TextView txtDesc;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        ListItem listItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.single_list_item, null);
            holder = new ViewHolder();
          //  holder.txtDesc = (TextView) convertView.findViewById(R.id.desc);
            holder.userName = (TextView) convertView.findViewById(R.id.userName);
            holder.userImage = (ImageView) convertView.findViewById(R.id.userImage);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.userName.setText(listItem.getUser_name());
       // holder.txtTitle.setText(rowItem.getTitle());
       // holder.imageView.setImageResource(rowItem.getImageId());

        return convertView;
    }
}

