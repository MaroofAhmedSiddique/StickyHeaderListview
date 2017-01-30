package com.stickyheaderlistview.maroof;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by Maroof Ahmed Siddique on 1/23/2017.
 */
public class CountryAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    private List<Country> countries;
    private Activity mActivity;
    private String headerText = "";

    public CountryAdapter(Activity mActivity, List<Country> countries) {
        this.countries = countries;
        this.mActivity = mActivity;
    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public Object getItem(int position) {
        return countries.get(position);
    }

    @Override
    public long getItemId(int position) {
        ;
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) mActivity.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            convertView = inflater.inflate(R.layout.listview_row, null);

            holder = new ViewHolder();

            holder.name = (TextView) convertView.findViewById(R.id.country_name);
            holder.code = (TextView) convertView.findViewById(R.id.country_code);
            holder.language = (TextView) convertView.findViewById(R.id.country_language);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Country country = countries.get(position);

        holder.name.setText("Name --> " + country.getCountryName());
        holder.code.setText("Code --> " + country.getCountrycode());
        holder.language.setText("Language --> " + country.getCountryLanguage());

        return convertView;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder holder;
        LayoutInflater inflater = LayoutInflater.from(mActivity);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_view_header, parent, false);
            holder = new HeaderViewHolder();

            holder.header = (TextView) convertView.findViewById(R.id.header_text);

            convertView.setTag(holder);

        } else {
            holder = (HeaderViewHolder) convertView.getTag();
        }

        Country country = countries.get(position);
        headerText = country.getCountryName();
        holder.header.setText(headerText);

        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        return countries.get(position).getCountryName().subSequence(0, 1).charAt(0);
    }

    private class HeaderViewHolder {
        private TextView header;
    }

    private class ViewHolder {
        private TextView name;
        private TextView code;
        private TextView language;
    }

}
