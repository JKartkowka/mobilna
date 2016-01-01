package jkartkowka.jkartkwkamobile;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class JKListActivity extends JKActivity {

    protected ListView listView;
    protected TextView titleLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = (ListView) findViewById(R.id.listView);
        listView.setClickable(true);
        titleLabel = (TextView) findViewById(R.id.listTitleTextView);
    }
}
