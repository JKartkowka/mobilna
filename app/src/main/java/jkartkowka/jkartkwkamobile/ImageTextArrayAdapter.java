package jkartkowka.jkartkwkamobile;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by maciej on 31.12.15.
 */
public class ImageTextArrayAdapter extends ArrayAdapter<String> { //TODO image for marked and unmarked question
    private final Activity context;
    private final String[] answers;
    private final boolean[] marked;

    public ImageTextArrayAdapter(Activity context,
                                 String[] answers, boolean[] marked) {
        super(context, R.layout.layout_row_image_text, answers);
        this.context = context;
        this.answers = answers;
        this.marked = marked;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.layout_row_image_text, null, true);
        TextView popQuizRowQuestion = (TextView) rowView.findViewById(R.id.popQuizRowQuestion);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.PopQuizRowIndicator);
        popQuizRowQuestion.setText(answers[position]);
        if (marked[position])  //TODO change images
            imageView.setImageResource(R.drawable.abc_btn_check_material);
        else
            imageView.setImageResource(R.drawable.abc_btn_radio_material);
        return rowView;
    }
}
