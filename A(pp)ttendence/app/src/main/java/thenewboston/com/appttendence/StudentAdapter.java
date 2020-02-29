package thenewboston.com.appttendence;

import android.content.Context;
import android.location.Location;
import android.media.Image;
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

/**
 * Created by HP on 22-11-2016.
 */

class Student
{
    String name;
    String reg;
    boolean selected=false;

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
}
public class StudentAdapter extends ArrayAdapter<Student>{

    public ArrayList<Student> studentList;
    private Context context;

    public StudentAdapter(ArrayList<Student> studentList, int resourceID, Context context)
    {
        super(context, resourceID, studentList);
        this.studentList=new ArrayList<Student>();
        this.studentList.addAll(studentList);
       // this.context=context;
    }

    private static class StudentHolder
    {
        public TextView studentName;
        public TextView regno;
        public CheckBox checkBox;
    }


    @Override
    public void add(Student object) {
        super.add(object);
        studentList.add(object);
       notifyDataSetChanged();


    }




    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        View v=convertView;

        StudentHolder holder=new StudentHolder();
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           v=inflater.inflate(R.layout.content_main, null);











                    holder.studentName=(TextView)v.findViewById(R.id.name);
            holder.regno=(TextView)v.findViewById(R.id.reg);
            holder.checkBox=(CheckBox)v.findViewById(R.id.check);
            v.setTag(holder);
            holder.checkBox.setOnCheckedChangeListener((MainActivity)context);
            holder.checkBox.setOnClickListener( new View.OnClickListener()
            {
                    public void onClick(View v)
            {
                CheckBox cb=(CheckBox)v;
                Student student=(Student)v.getTag();
                Toast.makeText(getContext(), cb.getText().toString()+"is"+ ( cb.isChecked()), Toast.LENGTH_LONG);
                student.setSelected(cb.isChecked());

            }
            });
        }
        else
        {
            holder=(StudentHolder)v.getTag();
        }
        Student s=studentList.get(position);
        holder.studentName.setText(s.getName());
        holder.regno.setText(s.getReg());
        holder.checkBox.setChecked(s.isSelected());
        holder.checkBox.setTag(s);

        return v;
    }
}
