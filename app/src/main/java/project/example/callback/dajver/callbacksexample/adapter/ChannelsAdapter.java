package project.example.callback.dajver.callbacksexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import project.example.callback.dajver.callbacksexample.rest.parser.model.ChannelsModel;

/**
 * Created by Admin on 05.10.2015.
 */
public class ChannelsAdapter extends ArrayAdapter<ChannelsModel> {
    private Context context;
    private ArrayList<ChannelsModel> model;
    public OnAdapterClickListener listener;

    public ChannelsAdapter(Context context, ArrayList<ChannelsModel> values) {
        super(context, android.R.layout.simple_list_item_1, values);
        this.context = context;
        this.model = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);

        final TextView textView = (TextView) rowView.findViewById(android.R.id.text1);
        textView.setText(model.get(position).getName());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCLick(textView.getText().toString());
            }
        });
        return rowView;
    }

    public ChannelsAdapter setOnClickListener(OnAdapterClickListener onAdapterClickListener) {
        this.listener = onAdapterClickListener;
        return this;
    }

    public interface OnAdapterClickListener {
        void onCLick(String name);
    }
}