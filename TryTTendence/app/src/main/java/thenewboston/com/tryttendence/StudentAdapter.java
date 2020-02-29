package thenewboston.com.tryttendence;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.media.Image;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import thenewboston.com.tryttendence.R;

/**
 * Created by HP on 22-11-2016.
 */

class Student {
    String name;
    String reg;
    boolean selected = false;

    public Student(String name, String reg) {
        super();
        this.name = name;
        this.reg = reg;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    private static int lastContactId = 0;

   /** public static ArrayList<Student> createContactsList(int numContacts) {
        ArrayList<Student> students = new ArrayList<Student>();

        for (int i = 1; i <= numContacts; i++) {
            students.add(new Student("Person " , Integer.toString(lastContactId++)));
        }


        students.add(new Student("One", "Reg"));

        return students;
    }**/



}











public class StudentAdapter extends  RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private Context context_1;
    private ArrayList<Student>students_1;

    public StudentAdapter(Context context, ArrayList<Student> students)
    {
       // public TextView nameView;

        context_1=context;
        students_1=students;
    }

    private Context getContext()
    {
        return context_1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

              Context context=parent.getContext();
              LayoutInflater inflater=LayoutInflater.from(context);

        View studentView=inflater.inflate(R.layout.content_main, parent, false);
        ViewHolder viewHolder=new ViewHolder(studentView);
        return viewHolder;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public static TextView nameTextView;
        public static TextView regTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView= (TextView) itemView.findViewById(R.id.name);
            regTextView = (TextView) itemView.findViewById(R.id.reg);
        }


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        TextView nameView=ViewHolder.nameTextView;
        TextView regView=ViewHolder.regTextView;

    }
    @Override
    public int getItemCount()
    {
        return students_1.size();
    }

}
