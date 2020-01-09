package com.example.bookanyhallcom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FiveColumn_ListAdapter extends ArrayAdapter<User> {

    private LayoutInflater mInflater;
    private ArrayList<User> users;
    private int mViewResourceId;

    public FiveColumn_ListAdapter(Context context, int textViewResourceId,ArrayList<User> users) {
        super(context,textViewResourceId,users);
        this.users = users;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parents) {
        convertView = mInflater.inflate(mViewResourceId,null);

        User user = users.get(position);

        if (user != null) {
            TextView hallId = (TextView) convertView.findViewById(R.id.firstId);
            TextView hallName = (TextView) convertView.findViewById(R.id.secondName);
            TextView hallStreet = (TextView) convertView.findViewById(R.id.thirdStreet);
            TextView hallPost = (TextView) convertView.findViewById(R.id.fourthPost);
            TextView hallCity = (TextView) convertView.findViewById(R.id.fifthCity);

            if (hallId != null) {
                hallId.setText((user.getHallid()));
            }
            if (hallName != null) {
                hallName.setText((user.getHallname()));
            }
            if (hallStreet != null) {
                hallStreet.setText((user.getHallstreet()));
            }
            if (hallPost != null) {
                hallPost.setText((user.getHallpost()));
            }
            if (hallCity != null) {
                hallCity.setText((user.getHallcity()));
            }
        }
        return convertView;
    }
}
