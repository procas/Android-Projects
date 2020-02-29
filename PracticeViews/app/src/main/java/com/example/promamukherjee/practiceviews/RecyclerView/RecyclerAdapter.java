package com.example.promamukherjee.practiceviews.RecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.promamukherjee.practiceviews.R;
import com.example.promamukherjee.practiceviews.RecyclerView.CustomViewHolder;
import com.example.promamukherjee.practiceviews.RecyclerView.ItemObject;

import java.util.List;

public class RecyclerAdapter  extends RecyclerView.Adapter<CustomViewHolder> {

    protected List<ItemObject> itemList;
    private Context context;

    public RecyclerAdapter(Context context, List<ItemObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list, null);
        CustomViewHolder rcv = new CustomViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.countryName.setText(itemList.get(position).getCountryName());
        holder.countryPhoto.setImageResource(itemList.get(position).getResID());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
