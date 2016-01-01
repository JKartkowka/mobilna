package jkartkowka.jkartkwkamobile.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import jkartkowka.jkartkwkamobile.R;
import jkartkowka.jkartkwkamobile.model.StudentListItem;

/**
 * Created by marian on 31.12.2015.
 */
public class StudentListAdapter extends ArrayAdapter<StudentListItem> {
    private final ArrayList<StudentListItem> data;
    private final Context context;
    private final int layoutResourceId;

    public StudentListAdapter(Context context, int resource, ArrayList<StudentListItem> objects) {
        super(context, resource, objects);
        this.data = objects;
        this.context = context;
        this.layoutResourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        StudentRowHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new StudentRowHolder();
            holder.checkBox = (CheckBox) row.findViewById(R.id.JKcheckBox);
            holder.txtTitle = (TextView) row.findViewById(R.id.txtTitle);

            row.setTag(holder);
        } else {
            holder = (StudentRowHolder) row.getTag();
        }

        final StudentListItem object = data.get(position);
        final StudentRowHolder finalHolder = holder;
        holder.txtTitle.setText(object.toString());
        holder.checkBox.setChecked(object.selected);

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                didSelectRow(object, finalHolder);
            }
        });

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                didSelectRow(object, finalHolder);

            }
        });

        return row;
    }

    private void didSelectRow(StudentListItem object, StudentRowHolder finalHolder) {
        object.selected = !object.selected;
        finalHolder.checkBox.setChecked(object.selected);
    }


    static class StudentRowHolder {
        CheckBox checkBox;
        TextView txtTitle;
    }
}
