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

        StudentListItem object = data.get(position);
        holder.txtTitle.setText(object.toString());
        holder.checkBox.setChecked(false);

        return row;
    }

    static class StudentRowHolder {
        CheckBox checkBox;
        TextView txtTitle;
    }
}
