package project.sqlite.hamdan.ashraf.sqlite_project.entities;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import project.sqlite.hamdan.ashraf.sqlite_project.R;

/**
 * Created by ashraf on 12/14/2016.
 */

public class Adapter extends BaseAdapter {

    Context c;
    ArrayList<InEntity> list;

    public Adapter(Context c, ArrayList<InEntity> list) {
        this.c = c;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = inflater.inflate(R.layout.model,null);
        }
        TextView name = (TextView) convertView.findViewById(R.id.txt_Model_name);
        TextView price = (TextView) convertView.findViewById(R.id.txt_Model_price);
        TextView number = (TextView) convertView.findViewById(R.id.txt_Model_number);
        TextView category = (TextView) convertView.findViewById(R.id.txt_Model_category);


        name.setText(list.get(position).getName());
        price.setText(list.get(position).getPrice());
        number.setText(list.get(position).getNumber());
        category.setText(list.get(position).getCategory());

        if(position % 2 == 1){
            convertView.setBackgroundColor(Color.BLUE);
        }else{
            convertView.setBackgroundColor(Color.RED);

        }

        return convertView;
    }
}
