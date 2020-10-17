package com.example.vturefill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SpinnerAdapter extends ArrayAdapter {
    private String[] titles;
    private int[] images;
    private Context context;
    public SpinnerAdapter( Context context, String[] titles, int[] images) {
        super(context, R.layout.spinner_item);
        this.context = context;
        this.images = images;
        this.titles = titles;
    }
    public SpinnerAdapter(Context context,String[] titles){
        super(context,R.layout.spinner_item1);
        this.context = context;
        this.titles = titles;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.spinner_item,parent,false);
            mViewHolder.imageView = (ImageView)convertView.findViewById(R.id.spinner_image);
            mViewHolder.textView = convertView.findViewById(R.id.spinner_text);
            convertView.setTag(mViewHolder);
        }
        else{
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        if(images!=null) {
            mViewHolder.imageView.setImageResource(images[position]);
        }
        mViewHolder.textView.setText(titles[position]);
        return convertView;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public View getDropDownView(int position,View convertView, ViewGroup parent) {
        return getView(position,convertView,parent);
    }
    private static class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
