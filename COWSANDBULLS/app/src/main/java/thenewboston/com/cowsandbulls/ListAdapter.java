package thenewboston.com.cowsandbulls;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import thenewboston.com.cowsandbulls.R;
public class ListAdapter extends BaseAdapter {
    private Activity mContext;
    private List<String> mList;
    private LayoutInflater mLayoutInflater = null;
    public ListAdapter(Activity context, List<String> list) {
        mContext = context;
        mList = list;
        mLayoutInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return mList.size();
    }
    @Override
    public Object getItem(int pos) {
        return mList.get(pos);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        CompleteListViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater li = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.list_layout, null);
            viewHolder = new CompleteListViewHolder(v);
            v.setTag(viewHolder);
        } else {
            viewHolder = (CompleteListViewHolder) v.getTag();
        }
       // viewHolder.enter.setText(mList.get(position));
        return v;
    }
}
class CompleteListViewHolder {
    public TextView enter;
    public TextView cow;
    public ImageView imCow;
    public TextView bull;
    public ImageView imBull;
    public CompleteListViewHolder(View base) {
        enter = (TextView) base.findViewById(R.id.enter);
        cow=(TextView)base.findViewById(R.id.cow);
        bull=(TextView)base.findViewById(R.id.bull);
        imBull=(ImageView)base.findViewById(R.id.imBull);
        imCow=(ImageView)base.findViewById(R.id.imCow);
    }
}
